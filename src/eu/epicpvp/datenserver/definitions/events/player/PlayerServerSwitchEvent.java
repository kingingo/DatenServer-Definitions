package eu.epicpvp.datenserver.definitions.events.player;

import eu.epicpvp.datenserver.definitions.dataserver.protocoll.DataBuffer;
import eu.epicpvp.datenserver.definitions.events.Event;
import eu.epicpvp.datenserver.definitions.events.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PlayerServerSwitchEvent extends Event{
	private int playerId;
	private String from;
	private String to;

	@Override
	public void read(DataBuffer buff) {
		playerId = buff.readInt();
		from = buff.readString();
		to = buff.readString();
	}
	@Override
	public void write(DataBuffer buff) {
		buff.writeInt(playerId);
		buff.writeString(from);
		buff.writeString(to);
	}

	@Override
	public EventType getType() {
		return EventType.SERVER_SWITCH;
	}
}
