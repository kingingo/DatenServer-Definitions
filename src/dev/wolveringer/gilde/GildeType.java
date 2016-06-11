package dev.wolveringer.gilde;

public enum GildeType {
	VERSUS,
	ARCADE,
	SKY,
	PVP,
	ALL;
	
	public static GildeType[] getPossibleValues(){
		return new GildeType[]{VERSUS,ARCADE,SKY,PVP};
	}
}
