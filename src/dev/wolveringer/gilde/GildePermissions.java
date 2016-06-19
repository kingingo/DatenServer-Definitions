package dev.wolveringer.gilde;

import lombok.Getter;

public enum GildePermissions {
	MEMBER_EDIT("gild.member.edit");
	
	@Getter
	private String permission;

	private GildePermissions(String permission) {
		this.permission = permission;
	}
}
