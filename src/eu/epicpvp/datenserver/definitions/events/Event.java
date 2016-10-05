package eu.epicpvp.datenserver.definitions.events;

import eu.epicpvp.datenserver.definitions.dataserver.protocoll.DataBuffer;

public abstract class Event {
	public abstract void read(DataBuffer buff);
	public abstract void write(DataBuffer buff);
	public abstract EventType getType();
}
