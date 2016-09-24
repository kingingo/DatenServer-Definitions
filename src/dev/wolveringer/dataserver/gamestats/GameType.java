package dev.wolveringer.dataserver.gamestats;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameType {
	
	TEAMSTATS_ACARDE(false,"teams_acarde","teams_acarde",ServerType.GAME,new StatsKey[] {StatsKey.KILLS,StatsKey.DEATHS,StatsKey.WIN,StatsKey.LOSE,StatsKey.MONEY},false, null),
	TEAMSTATS_VERSUS(false,"teams_versus","teams_versus",ServerType.GAME,new StatsKey[] {StatsKey.KILLS,StatsKey.DEATHS,StatsKey.WIN,StatsKey.LOSE,StatsKey.MONEY},false, null),
	TEAMSTATS_PVP(false,"teams_pvp","teams_pvp",ServerType.PVP,new StatsKey[] {StatsKey.KILLS,StatsKey.DEATHS,StatsKey.MONEY},false, null),
	TEAMSTATS_SKYBLOCK(false,"teams_skyblock","teams_skyblock",ServerType.SKYBLOCK,new StatsKey[] {StatsKey.KILLS,StatsKey.DEATHS,StatsKey.MONEY},false, null),
	TEAMSTATS_WARZ(false,"teams_warz","teams_warz",ServerType.WARZ,new StatsKey[] {StatsKey.KILLS,StatsKey.DEATHS,StatsKey.MONEY, StatsKey.ANIMAL_KILLS, StatsKey.ANIMAL_DEATHS, StatsKey.MONSTER_KILLS, StatsKey.MONSTER_DEATHS },false, null),
	
	GUNGAME(true, "GunGame-Server", "GunGame", ServerType.GUNGAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.LEVEL },true, TEAMSTATS_ACARDE),
	SurvivalGames1vs1(false, "SurvivalGames1vs1", "SG1vs1", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true, TEAMSTATS_VERSUS),
	BedWars1vs1(false, "BedWars1vs1", "BW1vs1", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE, StatsKey.BEDWARS_ZERSTOERTE_BEDs },true, TEAMSTATS_VERSUS),
	SkyWars1vs1(false, "SkyWars1vs1", "SkyWars1vs1", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.LOSE, StatsKey.WIN },true, TEAMSTATS_VERSUS),
	Versus(false, "VERSUS", "VS", ServerType.GAME, new StatsKey[] { StatsKey.KIT_RANDOM, StatsKey.KIT_ID, StatsKey.TEAM_MAX, StatsKey.TEAM_MIN, StatsKey.ELO, StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true, TEAMSTATS_VERSUS),
	SkyWars(true, "SkyWars", "SkyWars", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.LOSE, StatsKey.WIN },true, TEAMSTATS_ACARDE),
	QuickSurvivalGames(true, "QuickSurvivalGames", "QSG", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true, TEAMSTATS_ACARDE),
	SurvivalGames(true, "SurvivalGames", "SG", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true, TEAMSTATS_ACARDE),
	OneInTheChamber(true, "OneInTheChamber", "OITC", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true, TEAMSTATS_ACARDE),
	SkyPvP(true, "SkyPvP", "SK", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true, TEAMSTATS_ACARDE),
	Falldown(true, "Falldown", "FD", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.POWER, StatsKey.WIN, StatsKey.LOSE },true, TEAMSTATS_ACARDE),
	TroubleInMinecraft(true, "TroubleInMinecraft", "TTT", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE, StatsKey.TTT_KARMA, StatsKey.TTT_PAESSE, StatsKey.TTT_TESTS, StatsKey.TTT_TRAITOR_PUNKTE, StatsKey.TTT_DETECTIVE_PUNKTE },true, TEAMSTATS_ACARDE),
	DeathGames(true, "DeathGames", "DG", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true, TEAMSTATS_ACARDE),
	BedWars(true, "BedWars", "BW", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE, StatsKey.BEDWARS_ZERSTOERTE_BEDs },true, TEAMSTATS_ACARDE),
	SheepWars(true, "SheepWars", "SW", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE, StatsKey.SHEEPWARS_KILLED_SHEEPS },true, TEAMSTATS_ACARDE),
	PVP(true, "PvP-Server", "PvP", ServerType.PVP, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.MONEY, StatsKey.ELO, StatsKey.TIME_ELO, StatsKey.TIME },true,TEAMSTATS_PVP),
	SKYBLOCK(true, "SkyBlock", "Sky", ServerType.SKYBLOCK, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.MONEY },true, TEAMSTATS_SKYBLOCK),
	WARZ(true, "WarZ-Server", "WarZ", ServerType.WARZ, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.ANIMAL_KILLS, StatsKey.ANIMAL_DEATHS, StatsKey.MONSTER_KILLS, StatsKey.MONSTER_DEATHS },true,TEAMSTATS_WARZ),
	CaveWars(true, "CaveWars", "CW", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE, StatsKey.SHEEPWARS_KILLED_SHEEPS },true, TEAMSTATS_ACARDE),
	Masterbuilders(true, "MasterBuilders", "MB", ServerType.GAME, new StatsKey[] { StatsKey.LOSE, StatsKey.WIN},true, TEAMSTATS_ACARDE),
	Money(true, "Money", "MONEY", ServerType.BUNGEECORD, new StatsKey[] { StatsKey.COINS, StatsKey.GEMS,StatsKey.MYSTERY_SHARPS},false, null),
	NONE(true, "NONE", "FAIL", ServerType.GAME, null,false, null),
	ALL(true, "NONE", "FAIL", ServerType.GAME, null,false, null),
	VERSUS_KITS(false,"vs_kits_error","VS_kits",ServerType.GAME,new StatsKey[] { StatsKey.VERSUS_ID, StatsKey.VERSUS_CONTENT,StatsKey.VERSUS_ARMOR_CONTENT},false, null),
	PROPERTIES(false,"properties","properties",ServerType.GAME,new StatsKey[]{StatsKey.PROPERTIES}, false, null),
	BOOSTER(false,"boosters","boosters",ServerType.ALL,new StatsKey[]{StatsKey.BOOSTER_TIME}, false, null),
	TIME(false,"time","time",ServerType.ALL,new StatsKey[]{StatsKey.SKY_TIME,StatsKey.PVP_TIME,StatsKey.GUNGAME_TIME,StatsKey.GAME_TIME,StatsKey.CREATIVE_TIME,StatsKey.WARZ_TIME},false,null),
	SideWar(false,"SideWar","SWAR",ServerType.GAME,new StatsKey[]{StatsKey.KILLS,StatsKey.DEATHS,StatsKey.WIN,StatsKey.LOSE},true, TEAMSTATS_ACARDE),
	CREATIVE(true, "Creative-Server", "Creative", ServerType.CREATIVE, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.LEVEL },true, null),
	TEAMSPEAK(false, "Teamspeak", "teamspeak", ServerType.TEAMSPEAK, new StatsKey[] { StatsKey.TEAMSPEAK_IDENTITY, StatsKey.TEAMSPEAK_PROPERTIES },true, null);

	private boolean solo = true;
	private String typ;
	private String shortName;
	private ServerType serverType;
	private StatsKey[] stats;
	private boolean arcade;
	private GameType teamType;

	public static GameType get(String g) {
		for(GameType t : values())
			if(t.name().equalsIgnoreCase(g))
				return t;
		return null;
	}
	
	public boolean isMySQL(){
		return stats != null;
	}

}