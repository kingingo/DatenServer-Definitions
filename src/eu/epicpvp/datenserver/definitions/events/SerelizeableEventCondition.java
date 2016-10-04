package dev.wolveringer.events;

import eu.epicpvp.datenserver.definitions.dataserver.protocoll.DataBuffer;

public abstract class SerelizeableEventCondition<T>  extends EventCondition<T>{
	public abstract void read(DataBuffer buffer);
	public abstract void write(DataBuffer buffer);
}
