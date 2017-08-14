package uk.q3c.krail.eventbus

import java.util.concurrent.TimeUnit


/**
 * Provides a common interface for implementations which use an untyped event
 */
interface EventBus : GeneralEventBus<Any>

/**
 * Provides a common interface for implementations which use events of type [BusMessage]
 */
interface MessageBus : GeneralEventBus<BusMessage>

/**
 * Created by David Sowerby on 22 Oct 2017
 *
 * @param T the message type
 */
interface GeneralEventBus<in T> {

    /**
     * The id of the bus instance as reported by the underlying implementation
     */
    fun busId(): String

    /**
     * The scope of the bus as described by the underlying implementation
     */
    fun scope(): String

    /**
     * The index of the bus (just a count of how many instances of the same scope have been created)
     */
    fun index(): Int

    /**
     * Return the name of the implementation provider (for example 'MBassador')
     */
    fun implementationName(): String

    /**
     * Return the underlying implementation
     */
    fun implementation(): Any

    /**
     * Publish [message] synchronously.  This call publishes the message in the current thread
     * and returns after every matching handler has been invoked
     */
    fun publishSync(message: T): MessageStatus

    /**
     * Execute the message publication asynchronously. Generally, this means that the call returns immediately, but if the
     * implementation allows different queueing strategies, a bounded queue might block until the message can be placed
     * in the queue
     *
     * @return An implementation dependent record of the state of publication
     */
    fun publishASync(message: T): MessageStatus

    fun publishASync(timeout: Long, timeUnit: TimeUnit, message: T): MessageStatus

    /**
     * Subscribe all handlers of the given listener. Any listener is only subscribed once, and subsequent subscriptions
     * of an already subscribed listener will be silently ignored
     */
    fun subscribe(listener: Any)


    /**
     * Immediately remove all registered message handlers (if any) of the given [listener]. When this call returns all
     * handlers have been removed and will not receive any messages, provided publications in other threads
     * have not yet obtained a reference to the listener
     * <p/>
     * If [listener] is not subscribed, the call will have no effect and false is returned
     *
     * @param listener
     * @return true, if the listener was found and successfully removed false otherwise
     */
    fun unsubscribe(listener: Any): Boolean

    /**
     * Check whether any asynchronous message publications are waiting to be processed
     *
     * @return true if any unfinished message publications are found
     */
    fun hasPendingMessages(): Boolean
}

/**
 * A common interface for event bus messages - use is optional.
 * Used by [MessageBus] and [MessageBusProvider].
 * Alternatively, [EventBus] and [EventBusProvider], will accept Any
 */
interface BusMessage


/**
 * Returns a bus instance.  It is expected that an implementation will return a "Global" bus by default, as that is what is
 * usually required, but an instance can be scoped to whatever is appropriate.
 *
 * @param T the message type
 */
interface GeneralEventBusProvider<in T> {
    fun get(): GeneralEventBus<T>
}

interface EventBusProvider : GeneralEventBusProvider<Any> {
    override fun get(): EventBus
}

interface MessageBusProvider : GeneralEventBusProvider<BusMessage> {
    override fun get(): MessageBus
}

/**
 * Wrapper for implementation specific message status object
 */
data class MessageStatus(val status: Any)

