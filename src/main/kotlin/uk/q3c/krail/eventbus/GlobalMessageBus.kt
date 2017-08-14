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

import com.google.inject.BindingAnnotation

/**
 * Binding annotations to identify an bus with "Global" scope.  This is only required where an implementation provides
 * buses with different scopes - the [EventBusAutoSubscriber] would process an empty [SubscribeTo] as requiring
 * subscription to the default, 'global' bus.  But in order to subscribe to multiple buses,this identifier is needed
 *
 *
 * Note that the meaning of 'global' will depend on the implementation.  In a standard Java environment, it would be
 * a bus of Singleton scope - effectively a single JVM.  In a distributed environment it would mean the full scope of that
 * environment (for example the Vert.x bus)
 *
 * Created by David Sowerby on 06/02/15.
 */
@BindingAnnotation
@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
annotation class GlobalMessageBus


@BindingAnnotation
@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
annotation class GlobalEventBus
