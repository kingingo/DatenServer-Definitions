package eu.epicpvp.datenserver.definitions.events;

import eu.epicpvp.datenserver.definitions.events.booster.BoosterStatusChangeEvent;
import eu.epicpvp.datenserver.definitions.events.gilde.GildeMoneyChangeEvent;
import eu.epicpvp.datenserver.definitions.events.gilde.GildePermissionEvent;
import eu.epicpvp.datenserver.definitions.events.gilde.GildePlayerEvent;
import eu.epicpvp.datenserver.definitions.events.gilde.GildePropertiesUpdate;
import eu.epicpvp.datenserver.definitions.events.gilde.GildeUpdateEvent;
import eu.epicpvp.datenserver.definitions.events.player.PlayerServerSwitchEvent;
import eu.epicpvp.datenserver.definitions.events.teamspeak.TeamspeakLinkRequestEvent;
import lombok.Getter;

public enum EventType {
	SERVER_SWITCH(PlayerServerSwitchEvent.class,EventConditions.SERVER_NAME_ARRAY,EventConditions.CLIENT_TYPE_ARRAY,EventConditions.GAME_TYPE_ARRAY,EventConditions.PLAYERS_BACKLIST,EventConditions.PLAYERS_WHITELIST),
	BOOSTER_SWITCH(BoosterStatusChangeEvent.class,EventConditions.BOOSTER_TYPE),
	GILDE_PLAYER_UPDATE(GildePlayerEvent.class,EventConditions.GILDE_UUID),
	GILDE_PERMISSION_UPDATE(GildePermissionEvent.class,EventConditions.GILDE_UUID),
	GILDE_PROPERTIES_UPDATE(GildePropertiesUpdate.class,EventConditions.GILDE_UUID),
	GILDE_UPDATE(GildeUpdateEvent.class,EventConditions.GILDE_UUID),
	GILDE_MONEY_UPDATE(GildeMoneyChangeEvent.class,EventConditions.GILDE_UUID),
	TEAMSPEAK_LINK_REQUEST(TeamspeakLinkRequestEvent.class,EventConditions.PLAYERS_BACKLIST,EventConditions.PLAYERS_WHITELIST);
	
	@Getter
	private EventConditions[] avariableConditions;
	@Getter
	private Class<? extends Event> eventClass;
	private EventType(Class<? extends Event> eventClass,EventConditions... conditions) {
		this.avariableConditions = conditions;
		this.eventClass = eventClass;
	}
}
