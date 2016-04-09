package dev.wolveringer.dataserver.player;

import lombok.Getter;

public enum LanguageType {
	DUTCH("nl",null), ITALIAN("it",null), JAPANESE("ja",null), SPANISH("es-Es",null), GERMAN("de","GERMAN"), ENGLISH("en","ENGLISH"), FRENCH("fr",null), TURKISH("tr",null);

	@Getter
	private String shortName;
	@Getter
	private String mysQLOldName;
	
	private LanguageType(String shortName,String mySQLOldName) {
		this.shortName = shortName;
		this.mysQLOldName = mySQLOldName;
	}

	public static LanguageType getLanguageFromName(String def) {
		for (LanguageType type : LanguageType.values())
			if (type.getShortName().equalsIgnoreCase(def))
				return type;
			else if(type.getMysQLOldName() != null && type.getMysQLOldName().equalsIgnoreCase(def))
				return type;
		return LanguageType.GERMAN;
	}

}