/*
 *  
 * [y] hybris Platform
 *  
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *  
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *  
 */
package de.hybris.platform.warehousing.process;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.task.TaskEvent;
import de.hybris.platform.task.TaskService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class AbstractOmsBusinessProcessServiceTest
{
	private static final String CHOICE = "CHOICE";
	private static final String EVENT_NAME = "EVENT_NAME";
	private static final String CODE = "CODE";

	@InjectMocks
	private final Stub omsBusinessProcessService = new Stub();

	@Mock
	private ItemModel item;
	@Mock
	private TaskService taskService;

	@Before
	public void setUp()
	{
		when(taskService.triggerEvent(Mockito.any(TaskEvent.class))).thenReturn(Boolean.TRUE);
	}

	@Test
	public void shouldTriggerSimpleEvent()
	{
		omsBusinessProcessService.triggerSimpleEvent(item, EVENT_NAME);
		verify(taskService).triggerEvent(Mockito.any(TaskEvent.class));
	}

	@Test
	public void shouldTriggerChoiceEventSuccessfully()
	{

		omsBusinessProcessService.triggerChoiceEvent(item, EVENT_NAME, CHOICE);
		verify(taskService).triggerEvent(Mockito.any(TaskEvent.class));
	}

	@Test(expected = BusinessProcessException.class)
	public void shouldFailTriggerChoiceEvent()
	{
		when(taskService.triggerEvent(Mockito.any(TaskEvent.class))).thenReturn(Boolean.FALSE);
		omsBusinessProcessService.triggerChoiceEvent(item, EVENT_NAME, CHOICE);

		verify(taskService).triggerEvent(Mockito.any(TaskEvent.class));
	}

	@Test(expected = BusinessProcessException.class)
	public void shouldFailTriggerChoiceEvent_IllegalStateExceptionThrown()
	{
		when(taskService.triggerEvent(Mockito.any(TaskEvent.class))).thenThrow(new IllegalStateException());
		omsBusinessProcessService.triggerChoiceEvent(item, EVENT_NAME, CHOICE);

		verify(taskService).triggerEvent(Mockito.any(TaskEvent.class));
	}

	private static class Stub extends AbstractWarehousingBusinessProcessService<ItemModel>
	{
		@Override
		public String getProcessCode(final ItemModel item) throws BusinessProcessException
		{
			return CODE;
		}
	}
}
