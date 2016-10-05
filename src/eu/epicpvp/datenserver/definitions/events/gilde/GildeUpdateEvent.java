package eu.epicpvp.datenserver.definitions.events.gilde;

import java.util.UUID;

import eu.epicpvp.datenserver.definitions.dataserver.protocoll.DataBuffer;
import eu.epicpvp.datenserver.definitions.events.Event;
import eu.epicpvp.datenserver.definitions.events.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GildeUpdateEvent extends Event{
	public static enum Action {
		CREATE,
		DELETE,
		UPDATE_NAME_SHORT,
		UPDATE_NAME_LONG;
	}
	private UUID uuid;
	private Action action;
	private String value;

	@Override
	public void read(DataBuffer buff) {
		this.uuid = buff.readUUID();
		this.action = Action.values()[buff.readByte()];
		this.value = buff.readString();
	}

	@Override
	public void write(DataBuffer buff) {
		buff.writeUUID(uuid);
		buff.writeByte(action.ordinal());
		buff.writeString(value);
	}

	@Override
	public EventType getType() {
		return EventType.GILDE_UPDATE;
	}

}
