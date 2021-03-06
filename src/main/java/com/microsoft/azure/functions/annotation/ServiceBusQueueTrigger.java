/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.functions.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Place this on a parameter whose value would come from a Service Bus queue, and causing the method to run when a
 * new item is pushed. The parameter type can be one of the following:</p>
 *
 * <ul>
 *     <li>Any native Java types such as int, String, byte[]</li>
 *     <li>Nullable values using Optional&lt;T&gt;</li>
 *     <li>Any POJO type</li>
 * </ul>
 *
 * <p>The following example shows a service bus queue trigger which logs the queue message:</p>
 *
 * <pre>{@literal @}FunctionName("sbprocessor")
 * public void serviceBusProcess(
 *    {@literal @}ServiceBusQueueTrigger(name = "msg",
 *                             queueName = "myqueuename",
 *                             connection = "myconnvarname") String message,
 *     final ExecutionContext context
 * ) {
 *     context.getLogger().info(message);
 * }</pre>
 *
 * @since 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ServiceBusQueueTrigger {
    /**
     * The variable name used in function.json.
     * @return The variable name used in function.json.
     */
    String name();

    /**
     * <p>Defines how Functions runtime should treat the parameter value. Possible values are:</p>
     * <ul>
     *     <li>"": get the value as a string, and try to deserialize to actual parameter type like POJO</li>
     *     <li>string: always get the value as a string</li>
     *     <li>binary: get the value as a binary data, and try to deserialize to actual parameter type byte[]</li>
     * </ul>
     * @return The dataType which will be used by the Functions runtime.
     */
    String dataType() default "";

    /**
     * Defines the name of the Service Bus queue to which to bind.
     * @return The Service Bus queue string.
     */
    String queueName();

    /**
     * Defines the app setting name that contains the Service Bus connection string.
     * @return The app setting name of the connection string.
     */
    String connection();

    /**
     * Defines the permission of the Service Bus queue to which to bind.
     * @return The Service Bus queue permission.
     */
    AccessRights access() default AccessRights.MANAGE;
}
