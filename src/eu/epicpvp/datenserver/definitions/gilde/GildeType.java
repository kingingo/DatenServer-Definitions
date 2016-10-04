package dev.wolveringer.gilde;

import eu.epicpvp.datenserver.definitions.dataserver.gamestats.GameType;

public enum GildeType {
	VERSUS("Versus",GameType.TEAMSTATS_VERSUS),
	ARCADE("Arcade",GameType.TEAMSTATS_ACARDE),
	SKY("Sky",GameType.TEAMSTATS_SKYBLOCK),
	PVP("PvP",GameType.TEAMSTATS_PVP),
	WARZ("WarZ",GameType.TEAMSTATS_WARZ),
	ALL("All[ERROR]",null);



	private String displayName;
	private GameType types;

	private GildeType(String displayName, GameType types) {
		this.displayName = displayName;
		this.types = types;
	}

	public String getDisplayName() {
		return displayName;
	}

	public GameType getStatsType() {
		return types;
	}

	public static GildeType[] getPossibleValues(){
		return new GildeType[]{VERSUS,ARCADE,SKY,PVP,WARZ};
	}
}
