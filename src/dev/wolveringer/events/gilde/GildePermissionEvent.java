package dev.wolveringer.events.gilde;

import java.util.UUID;

import dev.wolveringer.dataserver.protocoll.DataBuffer;
import dev.wolveringer.events.Event;
import dev.wolveringer.events.EventType;
import dev.wolveringer.gilde.GildeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GildePermissionEvent extends Event{
	public static enum Action {
		ADD,
		REMOVE,
		GROUP_ADD,
		GROUP_REMOVE;
	}
	
	private UUID gilde;
	private GildeType gildenType;
	private Action action;
	private String group;
	private String permission;
	
	@Override
	public void read(DataBuffer buff) {
		gilde = buff.readUUID();
		gildenType = buff.readEnum(GildeType.class);
		action = buff.readEnum(Action.class);
		group = buff.readString();
		permission = buff.readString();
	}
	
	@Override
	public void write(DataBuffer buff) {
		buff.writeUUID(gilde);
		buff.writeEnum(gildenType);
		buff.writeEnum(action);
		buff.writeString(group);
		buff.writeString(permission);
	}
	
	@Override
	public EventType getType() {
		return EventType.GILDE_PERMISSION_UPDATE;
	}
}
