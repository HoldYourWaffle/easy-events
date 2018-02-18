package com.pploder.events;

import java.util.function.Consumer;

/**
 * A simple implementation of an event using the default {@link Consumer}. Duplicate occurrences of listeners are supported.
 *
 * @param <P> The parameter type to be passed to the {@link Consumer Consumers}
 * @author Philipp Ploder
 * @since 1.0.0
 */
public class SimpleEvent<P> extends BaseEvent<Consumer<P>, P> {
	
}
