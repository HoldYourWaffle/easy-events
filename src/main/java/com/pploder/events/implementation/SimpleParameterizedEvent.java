package com.pploder.events.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

import com.pploder.events.interfaces.ABaseListEvent;
import com.pploder.events.interfaces.IParameterizedEvent;

public class SimpleParameterizedEvent<P> extends ABaseListEvent<Consumer<P>> implements IParameterizedEvent<Consumer<P>, P> {
	
	public SimpleParameterizedEvent() {
		super(new ArrayList<>());
	}
	
	public SimpleParameterizedEvent(List<Consumer<P>> list) {
		super(list);
	}
	
	@Override
	public void trigger(P param) {
		listeners.forEach(c->c.accept(param));
	}
	
	public static <P> SimpleParameterizedEvent<P> createThreadSafe() {
		try {
			//return new SimpleParameterizedEvent<P>(new CopyOnWriteArrayList()) <-- Doesn't compile, workaround
			return new SimpleParameterizedEvent<P>().getClass().getConstructor(List.class).newInstance(new CopyOnWriteArrayList<>());
		} catch (ReflectiveOperationException e) { //TODO unit test
			throw new Error("The constructor SimpleParameterizedEvent(List) is broken/doesn't exist", e);
		}
	}
	
}
