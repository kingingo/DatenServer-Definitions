package dev.wolveringer.events.teamspeak;

import java.util.UUID;

import eu.epicpvp.datenserver.definitions.dataserver.protocoll.DataBuffer;
import dev.wolveringer.events.Event;
import dev.wolveringer.events.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TeamspeakLinkRequestEvent extends Event{

	private String targetName;
	private String teamspeakName;
	private String teamspeakIp;
	private String teamspeakPlatform;
	private UUID token;

	@Override
	public void read(DataBuffer buff) {
		targetName = buff.readString();
		teamspeakName = buff.readString();
		teamspeakIp = buff.readString();
		teamspeakPlatform = buff.readString();
		token = buff.readUUID();
	}

	@Override
	public void write(DataBuffer buff) {
		buff.writeString(targetName);
		buff.writeString(teamspeakName);
		buff.writeString(teamspeakIp);
		buff.writeString(teamspeakPlatform);
		buff.writeUUID(token);
	}

	@Override
	public EventType getType() {
		return EventType.TEAMSPEAK_LINK_REQUEST;
	}

}
