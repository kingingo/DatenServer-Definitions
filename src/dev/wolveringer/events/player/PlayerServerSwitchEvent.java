package dev.wolveringer.events.player;

import java.util.UUID;

import dev.wolveringer.dataserver.protocoll.DataBuffer;
import dev.wolveringer.events.Event;
import dev.wolveringer.events.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PlayerServerSwitchEvent extends Event{
	private UUID player;
	private String from;
	private String to;
	
	@Override
	public void read(DataBuffer buff) {
		player = buff.readUUID();
		from = buff.readString();
		to = buff.readString();
	}
	@Override
	public void write(DataBuffer buff) {
		buff.writeUUID(player);
		buff.writeString(from);
		buff.writeString(to);
	}
	
	@Override
	public EventType getType() {
		return EventType.SERVER_SWITCH;
	}
}
