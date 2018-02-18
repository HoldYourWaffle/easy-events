package com.pploder.events.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.pploder.events.interfaces.ABaseListEvent;

public class SimpleRunnableEvent extends ABaseListEvent<Runnable> {
	
	public SimpleRunnableEvent() {
		super(new ArrayList<>());
	}
	
	public SimpleRunnableEvent(List<Runnable> list) {
		super(list);
	}

	@Override
	public void trigger() {
		listeners.forEach(Runnable::run);
	}
	
	public static SimpleRunnableEvent createThreadSafe() {
		return new SimpleRunnableEvent(new CopyOnWriteArrayList<>());
	}
	
}
