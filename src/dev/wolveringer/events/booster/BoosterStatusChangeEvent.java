package dev.wolveringer.events.booster;

import dev.wolveringer.booster.BoosterType;
import dev.wolveringer.dataserver.protocoll.DataBuffer;
import dev.wolveringer.events.Event;
import dev.wolveringer.events.EventType;
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
