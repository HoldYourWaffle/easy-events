package com.pploder.events.interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * A simple base-implementation of an event using a {@link List}. Does not implement triggering behavior.
 *
 * @see IEvent
 * @see CopyOnWriteArrayList
 * @param <L> Listener type
 */
public abstract class ABaseListEvent<L> implements IEvent<L> {
	protected final List<L> listeners;
	
	public ABaseListEvent(List<L> list) {
		listeners = list;
	}
	
	@Override
	public void addListener(L listener) throws NullPointerException {
		if (listener == null) throw new NullPointerException("The listener to add may not be null");
		listeners.add(listener);
	}
	
	@Override
	public void addAllListeners(Collection<L> listeners) throws NullPointerException {
		if (listeners == null) throw new NullPointerException("The listeners collection is a null-reference");
		if (listeners.isEmpty()) return;
		if (listeners.stream().anyMatch(Objects::isNull)) throw new NullPointerException("At least one of the given listeners is a null-reference");
		
		this.listeners.addAll(listeners);
	}
	
	@Override
	public void removeListener(L listener) throws NullPointerException {
		if (listener == null) throw new NullPointerException("The listener to remove may not be null");
		listeners.remove(listener);
	}
	
	@Override
	public void removeAllOccurrences(L listener) throws NullPointerException {
		if (listener == null) throw new NullPointerException("The listener to remove may not be null");
		listeners.removeIf(listener::equals);
	}
	
}
