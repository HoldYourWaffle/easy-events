package com.pploder.events.interfaces;

import java.util.Collection;

/**
 * A minimalistic event. Listeners can be added and removed. When the event is triggered all listeners will be executed with the argument passed to {@link #trigger(Object)}. Duplicate listeners are supported.
 *
 * @param <L> Listener type. Up to the implementation what type of listener this is.
 */
public interface IEvent<L> {
	
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
	 * Removes all occurrences of the given listener from this event. If the listener is not found nothing happens.
	 *
	 * @param listener The listener to remove.
	 * @throws NullPointerException If the given reference is {@code null}.
	 */
	public abstract void removeAllOccurrences(L listener) throws NullPointerException;
	
	/** Trigger all listeners of this event */
	public abstract void trigger();
}
