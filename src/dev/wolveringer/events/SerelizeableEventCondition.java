package dev.wolveringer.events;

import dev.wolveringer.dataserver.protocoll.DataBuffer;

public abstract class SerelizeableEventCondition<T>  extends EventCondition<T>{
	public abstract void read(DataBuffer buffer);
	public abstract void write(DataBuffer buffer);
}
