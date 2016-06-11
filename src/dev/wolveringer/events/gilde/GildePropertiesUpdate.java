package dev.wolveringer.events.gilde;

import java.util.UUID;

import dev.wolveringer.dataserver.protocoll.DataBuffer;
import dev.wolveringer.events.Event;
import dev.wolveringer.events.EventType;
import dev.wolveringer.gilde.GildeType;
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
