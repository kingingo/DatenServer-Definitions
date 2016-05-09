package dev.wolveringer.booster;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NetworkBooster {
	public static class NotActiveBooster extends NetworkBooster {
		public NotActiveBooster(BoosterType type) {
			super(-1, -1, -2, type, false);
		}
		public NotActiveBooster(BoosterType type,int player,int time) {
			super(-1, time, player, type, false);
		}
	}

	private long start;
	private int time;
	private int player;
	private BoosterType type;
	private boolean active;
}
