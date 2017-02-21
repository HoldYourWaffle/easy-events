package com.pploder.events;

import java.util.function.Consumer;

/**
 * A minimalistic event.
 * Listeners can be added and removed. When the event is triggered all listeners will be executed
 * with the argument passed to {@link #trigger(T)}. Duplicate listeners are not supported.
 *
 * @param <T> The argument type to be passed to the listeners.
 * @author Philipp Ploder
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Event<T> {

    /**
     * Subscribed a listener to this event.
     *
     * @param listener The listener to add.
     * @throws NullPointerException     If the given reference is {@code null}.
     * @throws IllegalArgumentException If the given listener is already subscribed.
     */
    void addListener(Consumer<T> listener) throws NullPointerException, IllegalArgumentException;

    /**
     * Unsubscribes the given listener from this event if it is subscribed.
     * If the listener is not found nothing happens.
     *
     * @param listener The listener to remove.
     * @throws NullPointerException If the given reference is {@code null}.
     */
    void removeListener(Consumer<T> listener) throws NullPointerException;

    /**
     * Triggers the event.
     * The order of execution is implementation dependant.
     *
     * @param t The event argument for the listeners (may be {@code null}).
     */
    void trigger(T t);

    /**
     * Triggers the event with the argument {@code null}.
     * The effect should be identical to calling {@link #trigger(T)} with the argument {@code null}.
     */
    default void trigger() {
        trigger(null);
    }

}
