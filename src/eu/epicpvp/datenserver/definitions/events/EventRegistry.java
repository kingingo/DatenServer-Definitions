package eu.epicpvp.datenserver.definitions.events;

import java.lang.reflect.Constructor;

import eu.epicpvp.datenserver.definitions.dataserver.protocoll.DataBuffer;
import eu.epicpvp.datenserver.definitions.events.booster.BoosterStatusChangeEvent;
import eu.epicpvp.datenserver.definitions.events.gilde.GildeMoneyChangeEvent;
import eu.epicpvp.datenserver.definitions.events.gilde.GildePermissionEvent;
import eu.epicpvp.datenserver.definitions.events.gilde.GildePlayerEvent;
import eu.epicpvp.datenserver.definitions.events.gilde.GildePropertiesUpdate;
import eu.epicpvp.datenserver.definitions.events.gilde.GildeUpdateEvent;
import eu.epicpvp.datenserver.definitions.events.player.PlayerServerSwitchEvent;
import eu.epicpvp.datenserver.definitions.events.teamspeak.TeamspeakLinkRequestEvent;

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
		registerEvent(GildeUpdateEvent.class);
		registerEvent(TeamspeakLinkRequestEvent.class);
		registerEvent(GildeMoneyChangeEvent.class);
	}
}
/*
#ifdef TARGET_ARCH_x86
# include "jni_x86.h"
#endif
#ifdef TARGET_ARCH_sparc
# include "jni_sparc.h"
#endif
#ifdef TARGET_ARCH_zero
# include "jni_zero.h"
#endif
#ifdef TARGET_ARCH_arm
# include "jni_arm.h"
#endif
#ifdef TARGET_ARCH_ppc
# include "jni_ppc.h"
#endif
*/
