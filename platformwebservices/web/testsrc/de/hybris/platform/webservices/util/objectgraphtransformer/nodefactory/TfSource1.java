/*
 * [y] hybris Platform
 * 
 * Copyright (c) 2000-2016 SAP SE
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of SAP 
 * Hybris ("Confidential Information"). You shall not disclose such 
 * Confidential Information and shall use it only in accordance with the 
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.platform.webservices.util.objectgraphtransformer.nodefactory;

import de.hybris.platform.webservices.util.objectgraphtransformer.GraphNode;


@GraphNode(target = TfTarget1.class)
public class TfSource1
{
	private int value;
	private TfSource2 dto2;
	private TfSource3 dto3;

	/**
	 * @return the dto3
	 */
	public TfSource3 getDto3()
	{
		return dto3;
	}

	/**
	 * @param dto3
	 *           the dto3 to set
	 */
	public void setDto3(final TfSource3 dto3)
	{
		this.dto3 = dto3;
	}

	/**
	 * @return the dto2
	 */
	public TfSource2 getDto2()
	{
		return dto2;
	}

	/**
	 * @param dto2
	 *           the dto2 to set
	 */
	public void setDto2(final TfSource2 dto2)
	{
		this.dto2 = dto2;
	}

	public TfSource1()
	{ //
	}

	public TfSource1(final int value)
	{
		super();
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *           the value to set
	 */
	public void setValue(final int value)
	{
		this.value = value;
	}
}