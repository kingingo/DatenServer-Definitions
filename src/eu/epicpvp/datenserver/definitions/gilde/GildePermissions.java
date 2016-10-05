package eu.epicpvp.datenserver.definitions.gilde;

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
	MEMBER_ACCEPT(
			new GildeType[] { GildeType.ALL },
			"gild.member.accept",
			"display.Accept a membership request",
			new DisplayItem(278, 0, "§aAccept a membership request", null)),
	MEMBER_KICK(
			new GildeType[] { GildeType.ALL },
			"gild.member.kick",
			"display.Kick a member",
			new DisplayItem(278, 0, "§aKick a member", null)),
	MEMBER_GROUP_CHANGE(
			new GildeType[] { GildeType.ALL },
			"gild.member.group.change",
			"display.Change mebers group",
			new DisplayItem(278, 0, "§aChange mebers group", null)),
	GROUP_EDIT_PERMISSIONS(
			new GildeType[] { GildeType.ALL },
			"gild.group.change.permission",
			"display.Change group permissions",
			new DisplayItem(278, 0, "§aChange group permissions", null)),
	GROUP_CREATE_NEW(
			new GildeType[] { GildeType.ALL },
			"gild.group.create",
			"display.Create a new group",
			new DisplayItem(278, 0, "§aCreate a new group", null)),
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
		System.err.println("Cant find permission "+perm);
		return GildePermissions.UNDEFINED;
	}
}
