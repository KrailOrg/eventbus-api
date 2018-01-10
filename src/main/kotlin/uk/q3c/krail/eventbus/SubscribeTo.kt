/*
 * Copyright (c) 2015. David Sowerby
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package uk.q3c.krail.eventbus

import com.google.inject.spi.InjectionListener
import java.lang.annotation.Inherited
import kotlin.reflect.KClass

/**
 * Overrides default behaviour for subscribing a [Listener] to an Event Bus of a specific scope or message type, if provided.
 * Subscription is provided by an implementation of [EventBusAutoSubscriber], a Guice [InjectionListener]
 *
 * Default subscription annotations provided by this interface are [GlobalMessageBus] and [GlobalEventBus].
 *
 * The behaviour expected of an implementation is:
 *
 * - A **@Listener** without any **@SubscribeTo** will cause the Listener to be subscribed to the default, [GlobalMessageBus]
 * - A **@Listener** with an empty **@SubscribeTo()** will not be subscribed to any bus, and therefore cause any inherited annotation to be ignored.
 * - A **@Listener** with a specified **@SubscribeTo(XBus.class)** will be subscribed only to XBus, ignoring any inherited annotation.
 *
 * Invalid parameters to **@SubscribeTo** (that is, they are not recognised as bus annotations) are silently ignored.
 *
 *
 *
 * Created by David Sowerby on 09/03/15.
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention(AnnotationRetention.RUNTIME)
@Inherited
annotation class SubscribeTo(vararg val value: KClass<out Annotation> = arrayOf())
