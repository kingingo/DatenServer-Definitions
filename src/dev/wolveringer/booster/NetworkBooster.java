package dev.wolveringer.booster;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class NetworkBooster {
	public static class NotActiveBooster extends NetworkBooster {
		public NotActiveBooster(BoosterType type) {
			super(-1, -1, -2, type, false);
		}
		public NotActiveBooster(BoosterType type,int player,int time) {
			super(-1, time, player, type, false);
		}
	}

	@Getter
	private long start;
	@Getter
	private int time;
	@Getter
	private int player;
	@Getter
	private BoosterType type;
	private boolean active;
	
	public boolean isActive(){
		return active && start+time>System.currentTimeMillis();
	}
}
