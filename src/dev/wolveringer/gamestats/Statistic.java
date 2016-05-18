package dev.wolveringer.gamestats;

import java.util.HashMap;

import dev.wolveringer.dataserver.gamestats.StatsKey;
import lombok.Setter;

public class Statistic {
	public static final HashMap<Class<?>, Integer> types = new HashMap<>();

	static {
		types.put(int.class, 0);
		types.put(Integer.class, 0);
		types.put(double.class, 1);
		types.put(Double.class, 1);
		types.put(String.class, 2);
	}

	private StatsKey stat;
	@Setter
	private Object output;
	private boolean needSave = false;

	public Statistic(StatsKey stat, Object output) {
		this.stat = stat;
		if (output != null)
			switch (types.get(stat.getType())) {
			case 0:
				this.output = (int) Integer.valueOf(output.toString());
				break;
			case 1:
				this.output = (double) Double.valueOf(output.toString());
				break;
			case 2:
				this.output = output;
				break;
			default:
				throw new RuntimeException("No class found");
			}
		else {
			switch (types.get(stat.getType())) {
			case 0:
				this.output = (int) 0;
				break;
			case 1:
				this.output = (double) 0D;
				break;
			case 2:
				this.output = "";
				break;
			default:
				throw new RuntimeException("No class found");
			}
		}
	}

	public int asInt() {
		return (int) Integer.valueOf(output.toString());
	}
	
	public double asDouble() {
		return (double) Double.valueOf(output.toString());
	}

	public String asString() {
		return (String) output;
	}

	public int getTypeId() {
		return types.get(stat.getType());
	}

	public StatsKey getStatsKey() {
		return stat;
	}

	public Object getValue() {
		return output;
	}

	public void setNeedSave(boolean needSave) {
		this.needSave = needSave;
	}
	
	public boolean needSave() {
		return needSave;
	}
}