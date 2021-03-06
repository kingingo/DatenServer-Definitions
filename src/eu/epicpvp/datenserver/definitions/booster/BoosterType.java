package eu.epicpvp.datenserver.definitions.booster;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BoosterType {
	SKY("Sky"),
	ARCADE("Arcade"),
	NONE("None");
	
	private String displayName;
}
