package eu.epicpvp.datenserver.definitions.dataserver.gamestats;

public enum GameState {
	Laden,
	LobbyPhase,
	SchutzModus,
	DeathMatch,
	StartDeathMatch,
	StartGame,
	InGame,
	Restart,
	MultiGame,
	NONE;

	public String string() {
		return toString();
	}

}
