package eu.epicpvp.datenserver.definitions.dataserver.gamestats;

import lombok.Getter;

public enum ServerType {
	GUNGAME("gungame"),
	PVP("pvp"),
	WARZ("warz"),
	SKYBLOCK("skyblock"),
	BUNGEECORD("bungeecord"),
	GAME("game"),
	ALL("all"),
	CREATIVE("creative"),
	TEAMSPEAK("teamspeak"),
	TWITTER("twitter");

	@Getter
	private String name;

	private ServerType(String name){
		this.name=name;
	}

	public static ServerType get(String name){
		for(ServerType type : ServerType.values()){
			if(type.getName().equalsIgnoreCase(name))return type;
		}
		return null;
	}
}
