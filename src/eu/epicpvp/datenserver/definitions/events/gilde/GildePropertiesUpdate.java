package eu.epicpvp.datenserver.definitions.events.gilde;

import java.util.UUID;

import eu.epicpvp.datenserver.definitions.dataserver.protocoll.DataBuffer;
import eu.epicpvp.datenserver.definitions.events.Event;
import eu.epicpvp.datenserver.definitions.events.EventType;
import eu.epicpvp.datenserver.definitions.gilde.GildeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GildePropertiesUpdate extends Event{
	public static enum Property {
		NAME,
		SHORT_NAME,
		DELETE,
		CREATE,
		COSTUM_DATA,
		ACTIVE_GILD_SECTION,
		DEACTIVE_GILD_SECTION;
	}

	private UUID gilde;
	private GildeType gildenType;
	private Property property;

	@Override
	public void read(DataBuffer buff) {
		gilde = buff.readUUID();
		gildenType = buff.readEnum(GildeType.class);
		property = buff.readEnum(Property.class);
	}

	@Override
	public void write(DataBuffer buff) {
		buff.writeUUID(gilde);
		buff.writeEnum(gildenType);
		buff.writeEnum(property);
	}

	@Override
	public EventType getType() {
		return EventType.GILDE_PROPERTIES_UPDATE;
	}
}
