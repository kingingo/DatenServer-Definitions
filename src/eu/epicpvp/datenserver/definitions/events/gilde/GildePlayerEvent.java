package eu.epicpvp.datenserver.definitions.events.gilde;

import java.util.UUID;

import eu.epicpvp.datenserver.definitions.dataserver.protocoll.DataBuffer;
import eu.epicpvp.datenserver.definitions.events.Event;
import eu.epicpvp.datenserver.definitions.events.EventType;
import eu.epicpvp.datenserver.definitions.gilde.GildeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GildePlayerEvent extends Event{
	public static enum Action {
		ADD,
		CHANGE,
		REMOVE;
	}
	private UUID gilde;
	private Action action;
	private Integer player;
	private GildeType gildenType;
	private String rank;

	@Override
	public void read(DataBuffer buff) {
		gilde = buff.readUUID();
		action = buff.readEnum(Action.class);
		player = buff.readInt();
		gildenType = buff.readEnum(GildeType.class);
		rank = buff.readString();
	}

	@Override
	public void write(DataBuffer buff) {
		buff.writeUUID(gilde);
		buff.writeEnum(action);
		buff.writeInt(player);
		buff.writeEnum(gildenType);
		buff.writeString(rank);
	}

	@Override
	public EventType getType() {
		return EventType.GILDE_PLAYER_UPDATE;
	}
}
