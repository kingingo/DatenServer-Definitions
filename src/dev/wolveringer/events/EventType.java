package dev.wolveringer.events;

import dev.wolveringer.events.player.PlayerServerSwitchEvent;
import lombok.Getter;

public enum EventType {
	SERVER_SWITCH(PlayerServerSwitchEvent.class,EventConditions.SERVER_NAME_ARRAY,EventConditions.CLIENT_TYPE_ARRAY,EventConditions.GAME_TYPE_ARRAY,EventConditions.PLAYERS_BACKLIST,EventConditions.PLAYERS_WHITELIST);
	
	@Getter
	private EventConditions[] avariableConditions;
	@Getter
	private Class<? extends Event> eventClass;
	private EventType(Class<? extends Event> eventClass,EventConditions... conditions) {
		this.avariableConditions = conditions;
		this.eventClass = eventClass;
	}
}
