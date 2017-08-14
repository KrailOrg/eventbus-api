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

import java.lang.annotation.Inherited
import kotlin.reflect.KClass

/**
 * Overrides default behaviour for subscribing a [Listener] to an Event Bus of a specific scope (see EventBusModule in the implementation package} for description of default
 * behaviour).  The only valid values in the base implementation is [GlobalMessageBus].  Any other values are silently ignored.
 *
 *
 * Because this annotation overrides default behaviour, if this annotation has no values, then the [Listener] will not be subscribed to any bus.
 *
 *
 * Created by David Sowerby on 09/03/15.
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention(AnnotationRetention.RUNTIME)
@Inherited
annotation class SubscribeTo(vararg val value: KClass<out Annotation> = arrayOf())
