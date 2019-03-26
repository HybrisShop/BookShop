/*
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
 *
 */
angular.module('removeComponentService', ['removeComponentServiceInterfaceModule', 'gatewayProxyModule'])

.factory('removeComponentService', function($q, $log, extend, gatewayProxy, RemoveComponentServiceInterface) {

    var REMOVE_COMPONENT_CHANNEL_ID = "RemoveComponent";

    var removeComponentService = function(gatewayId) {
        this.gatewayId = gatewayId;

        gatewayProxy.initForService(this, ["removeComponent"]);
    };

    removeComponentService = extend(RemoveComponentServiceInterface, removeComponentService);

    return new removeComponentService(REMOVE_COMPONENT_CHANNEL_ID);

});
