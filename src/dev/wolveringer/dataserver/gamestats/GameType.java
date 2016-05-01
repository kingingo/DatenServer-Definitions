package dev.wolveringer.dataserver.gamestats;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameType {
	TEAMS_ACARDE(false,"teams_acarde","teams_acarde",ServerType.GAME,new StatsKey[] {StatsKey.TEAM_ID, StatsKey.TEAM_NAME, StatsKey.TEAM_PREFIX},false, null),
	TEAMS_PVP(false,"teams_pvp","teams_pvp",ServerType.GAME,new StatsKey[] {StatsKey.TEAM_ID, StatsKey.TEAM_NAME, StatsKey.TEAM_PREFIX, StatsKey.WORLD, StatsKey.LOC_X, StatsKey.LOC_Y, StatsKey.LOC_Z},false, null),
	TEAMS_SKYBLOCK(false,"teams_skyblock","teams_skyblock",ServerType.GAME,new StatsKey[] {StatsKey.TEAM_ID, StatsKey.TEAM_NAME, StatsKey.TEAM_PREFIX, StatsKey.WORLD, StatsKey.LOC_X, StatsKey.LOC_Z},false, null),
	TEAMS_WARZ(false,"teams_warz","teams_warz",ServerType.GAME,new StatsKey[] {StatsKey.TEAM_ID, StatsKey.TEAM_NAME, StatsKey.TEAM_PREFIX},false, null),
	GUNGAME(true, "GunGame-Server", "GunGame", ServerType.GUNGAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.LEVEL },true, null),
	SurvivalGames1vs1(false, "SurvivalGames1vs1", "SG1vs1", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true, null),
	BedWars1vs1(false, "BedWars1vs1", "BW1vs1", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE, StatsKey.BEDWARS_ZERSTOERTE_BEDs },true, null),
	SkyWars1vs1(false, "SkyWars1vs1", "SkyWars1vs1", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.LOSE, StatsKey.WIN },true, null),
	Versus(false, "VERSUS", "VS", ServerType.GAME, new StatsKey[] { StatsKey.KIT_RANDOM, StatsKey.KIT_ID, StatsKey.TEAM_MAX, StatsKey.TEAM_MIN, StatsKey.ELO, StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true, null),
	SkyWars(true, "SkyWars", "SkyWars", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.LOSE, StatsKey.WIN },true, TEAMS_ACARDE),
	QuickSurvivalGames(true, "QuickSurvivalGames", "QSG", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true, TEAMS_ACARDE),
	SurvivalGames(true, "SurvivalGames", "SG", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true, TEAMS_ACARDE),
	OneInTheChamber(true, "OneInTheChamber", "OITC", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true, TEAMS_ACARDE),
	SkyPvP(true, "SkyPvP", "SK", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true, TEAMS_ACARDE),
	Falldown(true, "Falldown", "FD", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.POWER, StatsKey.WIN, StatsKey.LOSE },true, TEAMS_ACARDE),
	TroubleInMinecraft(true, "TroubleInMinecraft", "TTT", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE, StatsKey.TTT_KARMA, StatsKey.TTT_PAESSE, StatsKey.TTT_TESTS, StatsKey.TTT_TRAITOR_PUNKTE, StatsKey.TTT_DETECTIVE_PUNKTE },true, TEAMS_ACARDE),
	DeathGames(true, "DeathGames", "DG", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true, TEAMS_ACARDE),
	BedWars(true, "BedWars", "BW", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE, StatsKey.BEDWARS_ZERSTOERTE_BEDs },true, TEAMS_ACARDE),
	SheepWars(true, "SheepWars", "SW", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE, StatsKey.SHEEPWARS_KILLED_SHEEPS },true, TEAMS_ACARDE),
	PVP(true, "PvP-Server", "PvP", ServerType.PVP, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.MONEY, StatsKey.ELO, StatsKey.TIME_ELO, StatsKey.TIME },true, TEAMS_PVP),
	SKYBLOCK(true, "SkyBlock", "Sky", ServerType.SKYBLOCK, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.MONEY },true, TEAMS_SKYBLOCK),
	WARZ(true, "WarZ-Server", "WarZ", ServerType.WARZ, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.ANIMAL_KILLS, StatsKey.ANIMAL_DEATHS, StatsKey.MONSTER_KILLS, StatsKey.MONSTER_DEATHS },true, TEAMS_WARZ),
	CaveWars(true, "CaveWars", "CW", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE, StatsKey.SHEEPWARS_KILLED_SHEEPS },true, TEAMS_ACARDE),
	Masterbuilders(true, "Master Builders", "MB", ServerType.GAME, new StatsKey[] { StatsKey.LOSE, StatsKey.WIN},true, TEAMS_ACARDE),
	Money(true, "Money", "MONEY", ServerType.BUNGEECORD, new StatsKey[] { StatsKey.COINS, StatsKey.GEMS },false, null),
	NONE(true, "NONE", "FAIL", ServerType.GAME, null,false, null),
	ALL(true, "NONE", "FAIL", ServerType.GAME, null,false, null),
	VERSUS_KITS(false,"vs_kits_error","VS_kits",ServerType.GAME,new StatsKey[] { StatsKey.VERSUS_ID, StatsKey.VERSUS_CONTENT,StatsKey.VERSUS_ARMOR_CONTENT},false, null);
	
	/*
	GUNGAME_TEAMS(true, "GunGame-Server", "teams_GunGame", ServerType.GUNGAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.LEVEL },true),
	SurvivalGames1vs1_TEAMS(false, "SurvivalGames1vs1", "teams_SG1vs1", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true),
	BedWars1vs1_TEAMS(false, "BedWars1vs1", "teams_BW1vs1", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE, StatsKey.BEDWARS_ZERSTOERTE_BEDs },true),
	SkyWars1vs1_TEAMS(false, "SkyWars1vs1", "teams_SkyWars1vs1", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.LOSE, StatsKey.WIN },true),
	Versus_TEAMS(false, "VERSUS", "teams_VS", ServerType.GAME, new StatsKey[] { StatsKey.KIT_RANDOM, StatsKey.KIT_ID, StatsKey.TEAM_MAX, StatsKey.TEAM_MIN, StatsKey.ELO, StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true),
	SkyWars_TEAMS(true, "SkyWars", "teams_SkyWars", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.LOSE, StatsKey.WIN },true),
	QuickSurvivalGames_TEAMS(true, "QuickSurvivalGames", "teams_QSG", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true),
	SurvivalGames_TEAMS(true, "SurvivalGames", "teams_SG", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true),
	OneInTheChamber_TEAMS(true, "OneInTheChamber", "teams_OITC", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true),
	SkyPvP_TEAMS(true, "SkyPvP", "teams_SK", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true),
	Falldown_TEAMS(true, "Falldown", "teams_FD", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.POWER, StatsKey.WIN, StatsKey.LOSE },true),
	TroubleInMinecraft_TEAMS(true, "TroubleInMinecraft", "teams_TTT", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE, StatsKey.TTT_KARMA, StatsKey.TTT_PAESSE, StatsKey.TTT_TESTS, StatsKey.TTT_TRAITOR_PUNKTE, StatsKey.TTT_DETECTIVE_PUNKTE },true),
	DeathGames_TEAMS(true, "DeathGames", "teams_DG", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE },true),
	BedWars_TEAMS(true, "BedWars", "teams_BW", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE, StatsKey.BEDWARS_ZERSTOERTE_BEDs },true),
	SheepWars_TEAMS(true, "SheepWars", "teams_SW", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE, StatsKey.SHEEPWARS_KILLED_SHEEPS },true),
	PVP_TEAMS(true, "PvP-Server", "teams_PvP", ServerType.PVP, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.MONEY, StatsKey.ELO, StatsKey.TIME_ELO, StatsKey.TIME },true),
	SKYBLOCK_TEAMS(true, "SkyBlock", "teams_Sky", ServerType.SKYBLOCK, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.MONEY },true),
	WARZ_TEAMS(true, "WarZ-Server", "teams_WarZ", ServerType.WARZ, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.ANIMAL_KILLS, StatsKey.ANIMAL_DEATHS, StatsKey.MONSTER_KILLS, StatsKey.MONSTER_DEATHS },true),
	//CaveWars_TEAMS(true, "CaveWars", "teams_CW", ServerType.GAME, new StatsKey[] { StatsKey.KILLS, StatsKey.DEATHS, StatsKey.WIN, StatsKey.LOSE, StatsKey.SHEEPWARS_KILLED_SHEEPS },true),
	Masterbuilders_TEAMS(true, "Master Builders", "teams_MB", ServerType.GAME, new StatsKey[] { StatsKey.LOSE, StatsKey.WIN},true),
	Money_TEAMS(true, "Money", "teams_MONEY", ServerType.BUNGEECORD, new StatsKey[] { StatsKey.COINS, StatsKey.GEMS },false),
	NONE_TEAMS(true, "NONE", "teams_FAIL", ServerType.GAME, null,false),
	ALL_TEAMS(true, "NONE", "teams_FAIL", ServerType.GAME, null,false),
	VERSUS_KITS_TEAMS(false,"vs_kits_error","teams_VS_kits",ServerType.GAME,new StatsKey[] { StatsKey.VERSUS_ID, StatsKey.VERSUS_CONTENT,StatsKey.VERSUS_ARMOR_CONTENT},false);
	*/

	private boolean solo = true;
	private String typ;
	private String shortName;
	private ServerType serverType;
	private StatsKey[] stats;
	private boolean arcade;
	private GameType teamType;

	public static GameType get(String g) {
		g = g.replaceAll("-", "");
		g = g.replaceAll(" ", "");
		for (GameType t : GameType.values()) {
			if (t.getTyp().replaceAll(" ", "").replaceAll("-", "").equalsIgnoreCase(g))
				return t;
		}

		for (GameType t : GameType.values()) {
			if (t.getShortName().replaceAll(" ", "").replaceAll("-", "").equalsIgnoreCase(g))
				return t;
		}
		return null;
	}
	
	public boolean isMySQL(){
		return stats != null;
	}

}