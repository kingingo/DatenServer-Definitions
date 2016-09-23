package dev.wolveringer.gilde;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
public enum GildePermissions {
	UNDEFINED(
			new GildeType[0],
			"undefined",
			"display.§cError. Permission not found!",
			new DisplayItem(166, 0, "§cPermission not found",null)),
	MEMBER_EDIT(
			new GildeType[] { GildeType.ALL },
			"gild.member.edit",
			"display.Member editieren",
			new DisplayItem(278, 0, "§aMember editieren", null)),
	BANK_DEPOSIT(
			new GildeType[] { GildeType.ALL },
			"gild.bank.deposit",
			"display.Geld auf die Bank aufgeben",
			new DisplayItem(371, 0, "§aGeld auf die Bank aufgeben", null)),
	BANK_WITHDRAW(
			new GildeType[] { GildeType.ALL },
			"gild.bank.withdraw",
			"display.Geld von der Bank abheben",
			new DisplayItem(388, 0, "§aGeld von der Bank abheben", null));

	@AllArgsConstructor
	@Getter
	@Builder
	public static class DisplayItem {
		private int id;
		private int durbility;
		private String name;
		private String[] lore;
	}

	@Getter
	private GildeType[] types;
	@Getter
	private String permission;
	@Getter
	private String displayMapping;
	@Getter
	private DisplayItem displayItem;

	public String getDisplayName() {
		if (displayMapping.startsWith("display."))
			return displayMapping.substring("display.".length());
		return displayMapping; //TODO handle translations :)
	}

	public static List<GildePermissions> getAvariablePermission(GildeType type) {
		List<GildePermissions> out = new ArrayList<GildePermissions>();
		for (GildePermissions p : values())
			for (GildeType t : p.types)
				if (t == GildeType.ALL || t == type) {
					out.add(p);
					break;
				}
		return out;
	}

	public static GildePermissions getPermission(String perm) {
		for (GildePermissions p : values())
			if (p.permission.equalsIgnoreCase(perm))
				return p;
		return GildePermissions.UNDEFINED;
	}
}
