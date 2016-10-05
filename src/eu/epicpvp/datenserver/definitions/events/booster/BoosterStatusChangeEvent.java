package eu.epicpvp.datenserver.definitions.events.booster;

import eu.epicpvp.datenserver.definitions.booster.BoosterType;
import eu.epicpvp.datenserver.definitions.dataserver.protocoll.DataBuffer;
import eu.epicpvp.datenserver.definitions.events.Event;
import eu.epicpvp.datenserver.definitions.events.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BoosterStatusChangeEvent extends Event{
	private BoosterType boosterType;
	private boolean active;

	@Override
	public void read(DataBuffer buff) {
		boosterType = buff.readEnum(BoosterType.class);
		active = buff.readBoolean();
	}
	@Override
	public void write(DataBuffer buff) {
		buff.writeEnum(boosterType);
		buff.writeBoolean(active);
	}
	@Override
	public EventType getType() {
		return EventType.BOOSTER_SWITCH;
	}
}
