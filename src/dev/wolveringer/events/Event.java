package dev.wolveringer.events;

import dev.wolveringer.dataserver.protocoll.DataBuffer;
import io.netty.buffer.ByteBuf;

public abstract class Event {
	public abstract void read(DataBuffer buff);
	public abstract void write(DataBuffer buff);
	public abstract EventType getType();
}
