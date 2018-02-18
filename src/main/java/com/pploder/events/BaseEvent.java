package com.pploder.events;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/**
 * A simple implementation of an event using a {@link CopyOnWriteArrayList}
 *
 * @param <L> Listener type. Must be a {@link Consumer} of type P
 * @param <P> Parameter type. The type of the argument passed to the listeners
 * @author Philipp Ploder
 * @since 1.0.0
 */
public class BaseEvent<L extends Consumer<P>, P> implements IEvent<L, P> {
	private final List<L> listeners = new CopyOnWriteArrayList<>();
	
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
	
	@Override
	public void trigger(P parameter) {
		listeners.forEach(listener -> listener.accept(parameter));
	}
	
}
