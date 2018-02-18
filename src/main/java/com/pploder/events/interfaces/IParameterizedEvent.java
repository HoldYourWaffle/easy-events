package com.pploder.events.interfaces;

import java.util.function.Consumer;

/**
 * A minimalistic event. Listeners can be added and removed. When the event is triggered all listeners will be executed with the argument passed to {@link #trigger(Object)}. Duplicate listeners are supported.
 *
 * @param <L> Listener type. Must be a {@link Consumer} of type P
 * @param <P> Parameter type. The type of the argument passed to the listening {@link Consumer Consumers}
 */
public interface IParameterizedEvent<L extends Consumer<P>, P> extends IEvent<L> {
	
	/**
	 * Triggers the event for all listeners.
	 * 
	 * @param param The event argument for the listeners
	 */
	public abstract void trigger(P param);
	
	/** Triggers the event with the argument {@code null}. The effect should be identical to calling {@link #trigger(Object) trigger(null)} */
	@Override
	public default void trigger() {
		trigger(null);
	}
	
}
