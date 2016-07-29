package dev.wolveringer.events;

import java.lang.reflect.Constructor;

import dev.wolveringer.dataserver.protocoll.DataBuffer;
import dev.wolveringer.events.booster.BoosterStatusChangeEvent;
import dev.wolveringer.events.gilde.GildePermissionEvent;
import dev.wolveringer.events.gilde.GildePlayerEvent;
import dev.wolveringer.events.gilde.GildePropertiesUpdate;
import dev.wolveringer.events.player.PlayerServerSwitchEvent;
import dev.wolveringer.events.teamspeak.TeamspeakLinkRequestEvent;

public class EventRegistry {
	@SuppressWarnings("unchecked")
	private static Constructor<? extends Event> events[] = new Constructor[256];
	
	public static boolean client = false;
	private static int idsIndex = 0;
	
	public static Event createEvent(int id, DataBuffer buffer) {
		try {
			Constructor<? extends Event> c = events[id];
			if (c != null) {
				Event packet = c.newInstance();
				packet.read(buffer);
				return packet;
			} else
				System.out.println("Event 0x" + (Integer.toHexString(id).toUpperCase()) + " not found");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int getEventId(Event packet) {
		int i = 0;
		for (Constructor<?> c : events) {
			if (c != null)
				if (c.getDeclaringClass().equals(packet.getClass()))
					return i;
			i++;
		}
		return -1;
	}
	
	protected static void registerEvent(Class<? extends Event> packet){
		try {
			events[idsIndex++] = packet.getConstructors().length == 1 ? (Constructor<? extends Event>) packet.getConstructors()[0] : packet.getConstructor();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	static {
		registerEvent(PlayerServerSwitchEvent.class);
		registerEvent(BoosterStatusChangeEvent.class);
		registerEvent(GildePermissionEvent.class);
		registerEvent(GildePlayerEvent.class);
		registerEvent(GildePropertiesUpdate.class);
		registerEvent(TeamspeakLinkRequestEvent.class);
	}
}
