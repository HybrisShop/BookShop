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
package de.hybris.platform.warehousing.util.models;

import de.hybris.platform.commerceservices.model.PickUpDeliveryModeModel;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.OrderEntryModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.util.TaxValue;
import de.hybris.platform.warehousing.util.builder.OrderEntryModelBuilder;
import de.hybris.platform.warehousing.util.builder.OrderModelBuilder;
import de.hybris.platform.warehousing.util.dao.WarehousingDao;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.Date;


public class Orders extends AbstractItems<OrderModel>
{
	public static final String CODE_CAMERA_SHIPPED = "camera-shipped";
	public static final String CODE_MEMORYCARD_SHIPPED = "memorycard-shipped";
	public static final String CODE_CAMERA_PICKUP_MONTREAL = "camera-pickup-montreal";
	public static final String CODE_CAMERA_AND_MEMORY_CARD_PICKUP_MONTREAL = "camera-and-memory-card-pickup-montreal";
	public static final String CODE_CAMERA_AND_MEMORY_CARD_SHIPPED = "camera-and-memory-card-shipped";
	public static final String CODE_PICKUP = "pickupTest";
	public static final String CODE_CAMERA_AND_MEMORY_CARD_AND_LENS_SHIPPED = "camera-and-memory-card-and-lens-shipped";

	public static final Double BASE_PRICE = 50.00;
	public static final String CODE_TAX = "camera-tax";
	public static final Double Tax_Value = 10.00;
	private static final String PAYMENT_CODE = "CODE_PAYMENT";

	private WarehousingDao<OrderModel> warehousingOrderDao;
	private DeliveryModes deliveryModes;
	private Currencies currencies;
	private BaseStores baseStores;
	private Products products;
	private Units units;
	private Users users;
	private PointsOfService pointsOfService;
	private Addresses addresses;
	private PaymentInfos paymentInfos;

	public OrderModel Camera_Shipped(final Long quantity)
	{
		return getOrSaveAndReturn(() -> getWarehousingOrderDao().getByCode(CODE_CAMERA_SHIPPED), () -> {
			final AbstractOrderEntryModel entry = Camera(quantity);
			final OrderModel order = OrderModelBuilder.aModel().withCode(CODE_CAMERA_SHIPPED)
					.withCurrency(getCurrencies().AmericanDollar()).withStore(getBaseStores().NorthAmerica()).withDate(new Date())
					.withUser(getUsers().Nancy()).withEntries(entry).withDeliveryAddress(getAddresses().MontrealNancyHome())
					.withPaymentInfo(getPaymentInfos().PaymentInfoForNancy(PAYMENT_CODE)).build();
			entry.setOrder(order);
			return order;
		});
	}

	public OrderModel MemoryCard_Shipped(final Long quantity)
	{
		return getOrSaveAndReturn(() -> getWarehousingOrderDao().getByCode(CODE_MEMORYCARD_SHIPPED), () -> {
			final AbstractOrderEntryModel entry = MemoryCard(quantity);
			final OrderModel order = OrderModelBuilder.aModel().withCode(CODE_MEMORYCARD_SHIPPED)
					.withCurrency(getCurrencies().AmericanDollar()).withStore(getBaseStores().NorthAmerica()).withDate(new Date())
					.withUser(getUsers().Nancy()).withEntries(entry).withDeliveryAddress(getAddresses().MontrealNancyHome())
					.withPaymentInfo(getPaymentInfos().PaymentInfoForNancy(PAYMENT_CODE)).build();
			entry.setOrder(order);
			return order;
		});
	}

	public OrderModel Camera_PickupInMontreal(final Long quantity)
	{
		return getOrSaveAndReturn(() -> getWarehousingOrderDao().getByCode(CODE_CAMERA_PICKUP_MONTREAL), () -> {
			final PickUpDeliveryModeModel pickUpDeliveryMode = new PickUpDeliveryModeModel();
			pickUpDeliveryMode.setCode(CODE_PICKUP);
			final AbstractOrderEntryModel entry = Camera_PickupMontreal(quantity);
			final OrderModel order = OrderModelBuilder.aModel().withCode(CODE_CAMERA_PICKUP_MONTREAL)
					.withCurrency(getCurrencies().AmericanDollar()).withStore(getBaseStores().NorthAmerica()).withDate(new Date())
					.withUser(getUsers().Nancy()).withEntries(entry).withDeliveryAddress(getAddresses().MontrealDeMaisonneuvePos())
					.withPaymentInfo(getPaymentInfos().PaymentInfoForNancy(PAYMENT_CODE)).build();
			order.setDeliveryMode(pickUpDeliveryMode);
			entry.setOrder(order);
			return order;
		});
	}

	protected OrderEntryModel MemoryCard_PickupMontreal(final Long quantity)
	{
		return OrderEntryModelBuilder.fromModel(MemoryCard(quantity)) //
				.withDeliveryPointOfService(getPointsOfService().Montreal_Downtown()) //
				.build();
	}

	public OrderModel CameraAndMemoryCard_PickupInMontreal(final Long cameraQty, final Long memoryCardQty)
	{
		return getOrSaveAndReturn(() -> getWarehousingOrderDao().getByCode(CODE_CAMERA_AND_MEMORY_CARD_PICKUP_MONTREAL), //
				() -> {
					final PickUpDeliveryModeModel pickUpDeliveryMode = new PickUpDeliveryModeModel();
					pickUpDeliveryMode.setCode(CODE_PICKUP);
					final AbstractOrderEntryModel camera = Camera_PickupMontreal(cameraQty);
					final AbstractOrderEntryModel memoryCard = MemoryCard_PickupMontreal(memoryCardQty);
					final OrderModel order = OrderModelBuilder.aModel() //
							.withCode(CODE_CAMERA_AND_MEMORY_CARD_PICKUP_MONTREAL) //
							.withCurrency(getCurrencies().AmericanDollar()) //
							.withStore(getBaseStores().NorthAmerica()) //
							.withDate(new Date()) //
							.withUser(getUsers().Nancy()) //
							.withEntries(camera, memoryCard).build();
					order.setDeliveryMode(pickUpDeliveryMode);
					camera.setOrder(order);
					memoryCard.setOrder(order);
					return order;
				});
	}

	public OrderModel CameraAndMemoryCard_Shipped(final Long cameraQty, final Long memoryCardQty)
	{
		return getOrSaveAndReturn(() -> getWarehousingOrderDao().getByCode(CODE_CAMERA_AND_MEMORY_CARD_SHIPPED), () -> {
			final AbstractOrderEntryModel camera = Camera(cameraQty);
			final AbstractOrderEntryModel memoryCard = MemoryCard(memoryCardQty);
			final OrderModel order = OrderModelBuilder.aModel().withCode(CODE_CAMERA_AND_MEMORY_CARD_SHIPPED)
					.withCurrency(getCurrencies().AmericanDollar()).withStore(getBaseStores().NorthAmerica()).withDate(new Date())
					.withUser(getUsers().Nancy()).withEntries(camera, memoryCard)
					.withDeliveryAddress(getAddresses().MontrealNancyHome())
					.withPaymentInfo(getPaymentInfos().PaymentInfoForNancy(PAYMENT_CODE)).build();
			camera.setOrder(order);
			memoryCard.setOrder(order);
			return order;
		});
	}

	public OrderModel CameraAndMemoryCardAndLens_Shipped(Long cameraQty, Long memoryCardQty, Long lensQty)
	{
		return getOrSaveAndReturn(() -> getWarehousingOrderDao().getByCode(CODE_CAMERA_AND_MEMORY_CARD_AND_LENS_SHIPPED), () -> {
			final AbstractOrderEntryModel camera = Camera(cameraQty);
			final AbstractOrderEntryModel memoryCard = MemoryCard(memoryCardQty);
			final AbstractOrderEntryModel lens = Lens(lensQty);
			final OrderModel order = OrderModelBuilder.aModel().withCode(CODE_CAMERA_AND_MEMORY_CARD_AND_LENS_SHIPPED)
					.withCurrency(getCurrencies().AmericanDollar()).withStore(getBaseStores().NorthAmerica())
					.withDate(new Date()).withUser(getUsers().Nancy()).withEntries(camera, memoryCard, lens)
					.withDeliveryAddress(getAddresses().MontrealNancyHome())
					.withPaymentInfo(getPaymentInfos().PaymentInfoForNancy(PAYMENT_CODE)).build();
			camera.setOrder(order);
			memoryCard.setOrder(order);
			lens.setOrder(order);
			return order;
		});
	}


	protected OrderEntryModel Default(final Long quantity)
	{
		return OrderEntryModelBuilder.aModel().withQuantity(quantity).withUnit(units.Unit()).withGiveAway(Boolean.FALSE)
				.withRejected(Boolean.FALSE).build();
	}

	protected OrderEntryModel Camera(final Long quantity)
	{
		ArrayList<TaxValue> taxes = new ArrayList<TaxValue>();
		taxes.add(new TaxValue(CODE_TAX, Tax_Value, Boolean.TRUE, getCurrencies().AmericanDollar().getIsocode()));
		return OrderEntryModelBuilder.fromModel(Default(quantity)).withBasePrice(BASE_PRICE).withTotalPrice(quantity * BASE_PRICE)
				.withProduct(getProducts().Camera()).withTaxes(taxes).withCalculated(Boolean.TRUE).build();
	}

	protected OrderEntryModel MemoryCard(final Long quantity)
	{
		ArrayList<TaxValue> taxes = new ArrayList<TaxValue>();
		taxes.add(new TaxValue(CODE_TAX, Tax_Value, Boolean.TRUE, getCurrencies().AmericanDollar().getIsocode()));
		return OrderEntryModelBuilder.fromModel(Default(quantity)).withBasePrice(BASE_PRICE).withTotalPrice(quantity * BASE_PRICE)
				.withProduct(getProducts().MemoryCard()).withTaxes(taxes).withCalculated(Boolean.TRUE).build();
	}

	protected OrderEntryModel Lens(final Long quantity)
	{
		ArrayList<TaxValue> taxes = new ArrayList<TaxValue>();
		taxes.add(new TaxValue(CODE_TAX, Tax_Value, Boolean.TRUE, getCurrencies().AmericanDollar().getIsocode()));
		return OrderEntryModelBuilder.fromModel(Default(quantity)).withBasePrice(BASE_PRICE).withTotalPrice(quantity * BASE_PRICE)
				.withProduct(getProducts().Lens()).withTaxes(taxes).withCalculated(Boolean.TRUE).build();
	}

	protected OrderEntryModel Camera_PickupMontreal(final Long quantity)
	{
		return OrderEntryModelBuilder.fromModel(Camera(quantity))
				.withDeliveryPointOfService(getPointsOfService().Montreal_Downtown()).build();
	}

	public WarehousingDao<OrderModel> getWarehousingOrderDao()
	{
		return warehousingOrderDao;
	}

	@Required
	public void setWarehousingOrderDao(final WarehousingDao<OrderModel> warehousingOrderDao)
	{
		this.warehousingOrderDao = warehousingOrderDao;
	}

	public DeliveryModes getDeliveryModes()
	{
		return deliveryModes;
	}

	@Required
	public void setDeliveryModes(final DeliveryModes deliveryModes)
	{
		this.deliveryModes = deliveryModes;
	}

	public Currencies getCurrencies()
	{
		return currencies;
	}

	@Required
	public void setCurrencies(final Currencies currencies)
	{
		this.currencies = currencies;
	}

	public BaseStores getBaseStores()
	{
		return baseStores;
	}

	@Required
	public void setBaseStores(final BaseStores baseStores)
	{
		this.baseStores = baseStores;
	}

	public Products getProducts()
	{
		return products;
	}

	@Required
	public void setProducts(final Products products)
	{
		this.products = products;
	}

	public Units getUnits()
	{
		return units;
	}

	@Required
	public void setUnits(final Units units)
	{
		this.units = units;
	}

	public Users getUsers()
	{
		return users;
	}

	@Required
	public void setUsers(final Users users)
	{
		this.users = users;
	}

	public PointsOfService getPointsOfService()
	{
		return pointsOfService;
	}

	@Required
	public void setPointsOfService(final PointsOfService pointsOfService)
	{
		this.pointsOfService = pointsOfService;
	}

	public Addresses getAddresses()
	{
		return addresses;
	}

	@Required
	public void setAddresses(final Addresses addresses)
	{
		this.addresses = addresses;
	}

	public PaymentInfos getPaymentInfos()
	{
		return paymentInfos;
	}

	@Required
	public void setPaymentInfos(final PaymentInfos paymentInfos)
	{
		this.paymentInfos = paymentInfos;
	}

}
