package com.pploder.events;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * A minimalistic event. Listeners can be added and removed. When the event is triggered all listeners will be executed with the argument passed to {@link #trigger(Object)}. Duplicate listeners are supported.
 *
 * @param <L> Listener type. Must be a {@link Consumer} of type P
 * @param <P> Parameter type. The type of the argument passed to the listening {@link Consumer}
 * @author Philipp Ploder
 * @since 1.0.0
 */
public interface IEvent<L extends Consumer<P>, P> {
	
	/**
	 * Subscribes a listener to this event. Duplicate listeners are supported.
	 *
	 * @param listener The listener to add.
	 * @throws NullPointerException If the given reference is {@code null}.
	 */
	public abstract void addListener(L listener) throws NullPointerException;
	
	/**
	 * Subscribes all given listeners to this event. Duplicate listeners are supported.
	 *
	 * @param listeners The listeners to add.
	 * @throws NullPointerException If the given collection or any of its contained references is {@code null}.
	 */
	public abstract void addAllListeners(Collection<L> listeners) throws NullPointerException;
	
	/**
	 * Unsubscribes the first occurrence of the given listener from this event. If the listener is not found nothing happens.
	 *
	 * @param listener The listener to remove.
	 * @throws NullPointerException If the given reference is {@code null}.
	 */
	public abstract void removeListener(L listener) throws NullPointerException;
	
	/**
	 * Unsubscribes all occurrences of the given listener from this event. If the listener is not found nothing happens.
	 *
	 * @param listener The listener to remove.
	 * @throws NullPointerException If the given reference is {@code null}.
	 */
	public abstract void removeAllOccurrences(L listener) throws NullPointerException;
	
	/**
	 * Triggers the event. The order of execution is implementation dependant.
	 *
	 * @param t The event argument for the listeners (may be {@code null}).
	 */
	public abstract void trigger(P param);
	
	/** Triggers the event with the argument {@code null}. The effect should be identical to calling {@link #trigger(Object)} with the argument {@code null}. */
	public default void trigger() {
		trigger(null);
	}
	
}
