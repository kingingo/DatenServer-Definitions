package eu.epicpvp.datenserver.definitions.dataserver.ban;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

public class BanEntity {
	/*
	 * Sun Feb 21 17:10:53 CET 2016 -> "EEE MMM dd HH:mm:ss zzz yyyy"
	 */
	private static final SimpleDateFormat MYSQL_OLD_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	private static final SimpleDateFormat MYSQL_SECOND_OLD_DATE_FORMAT = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

	@Getter
	private String ip;
	@Getter
	private ArrayList<String> usernames = new ArrayList<>();
	@Getter
	private ArrayList<UUID> uuids = new ArrayList<>();
	@Getter
	private String reson;

	@Getter
	private String banner;
	@Getter
	private String bannerIp;
	@Getter
	private UUID bannerUUID;

	@Getter
	private Date bannedUntil;

	@Getter
	private int level;
	@Getter
	private long end;

	@Getter
	private long date;

	private boolean needSave = false;

	@Setter
	private boolean active = true;

	@Getter
	@Setter
	private int banId = -1;

	public BanEntity(String ip, String username, String uuid, String banner, String bannerUUID, String date, String reson, int level) {
		this(ip, username, uuid, banner, bannerUUID, date, reson, level, -1);
	}

	public BanEntity(String ip, String username, String uuid, String banner, String bannerUUID, String date, String reson, int level, long end) {
		this.end = end;
		this.ip = ip;
		if (username != null && username.length() != 0 && !username.equalsIgnoreCase("null"))
			this.usernames.add(username);
		if (uuid != null && uuid.length() != 0 && !uuid.equalsIgnoreCase("null"))
			this.uuids.add(UUID.fromString(uuid));
		this.banner = banner;
		if (bannerUUID != null && bannerUUID.matches("[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}"))
			this.bannerUUID = UUID.fromString(bannerUUID);
		if(date != null)
			if (StringUtils.isNumeric(date))
				bannedUntil = new Date(Long.parseLong(date));
			else
				try {
					this.bannedUntil = MYSQL_OLD_DATE_FORMAT.parse(date);
				} catch (ParseException e1) {
					try {
						this.bannedUntil = MYSQL_SECOND_OLD_DATE_FORMAT.parse(date);
					} catch (Exception e) {
						this.bannedUntil = new Date(2012, 01, 01);
					}
				}
		this.level = level;
		this.reson = reson;
		try {
			this.date = Long.parseLong(date);
		} catch (Exception e) {
			this.date = System.currentTimeMillis();
			needSave = true;
		}
		if (!isActive())
			needSave = true;
	}

	public BanEntity(String ip, String username, String uuid, String banner, String bannerUUID, String bannerIp, String date, String reson, int level, long end) {
		this.end = end;
		this.ip = ip;
		this.bannerIp = bannerIp;
		if (username != null && username.length() != 0 && !username.equalsIgnoreCase("null"))
			this.usernames.add(username);
		if (uuid != null && uuid.length() != 0 && !uuid.equalsIgnoreCase("null"))
			this.uuids.add(UUID.fromString(uuid));
		this.banner = banner;
		if (bannerUUID != null && bannerUUID.matches("[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}"))
			this.bannerUUID = UUID.fromString(bannerUUID);
		if(date != null)
			if (StringUtils.isNumeric(date))
				bannedUntil = new Date(Long.parseLong(date));
			else
				try {
					this.bannedUntil = MYSQL_OLD_DATE_FORMAT.parse(date);
				} catch (ParseException e1) {
					try {
						this.bannedUntil = MYSQL_SECOND_OLD_DATE_FORMAT.parse(date);
					} catch (Exception e) {
						this.bannedUntil = new Date(2012, 01, 01);
					}
				}
		this.level = level;
		this.reson = reson;
		try {
			this.date = Long.parseLong(date);
		} catch (Exception e) {
			this.date = System.currentTimeMillis();
			needSave = true;
		}
	}

	public boolean isTempBanned() {
		return end != -1;
	}

	public boolean isActive() {
		return (end == -1 || System.currentTimeMillis() < end) && active;
	}

	public int matchPlayer(String ip, String name, UUID uuid) {
		int value = 0;
		if (this.ip != null)
			if (!this.ip.equalsIgnoreCase("undefined") && !(this.ip.equalsIgnoreCase("")) && !(this.ip.equalsIgnoreCase("null")))
				if (this.ip.equalsIgnoreCase(ip))
					value++;
		for (String u : usernames)
			if (u.equalsIgnoreCase(name)) {
				value++;
				break;
			}
		if (uuids.contains(uuid))
			value++;
		return value;
	}

	public boolean needSave() {
		return needSave;
	}

	@Override
	public String toString() {
		return "BanEntity [ip=" + ip + ", usernames=" + usernames + ", uuids=" + uuids + ", reson=" + reson + ", banner=" + banner + ", bannerUUID=" + bannerUUID + ", bannedUntil=" + bannedUntil + ", level=" + level + ", end=" + end + ",banned=" + isActive() + "]";
	}

	public void setActive(boolean flag) {
		active = flag;
		needSave = true;
	}

	public void setReson(String reson) {
		this.reson = reson;
		needSave = true;
	}

	public void setLevel(int level) {
		this.level = level;
		needSave = true;
	}

	public void setTime(long end) {
		this.end = end;
	}

	public void saved() {
		needSave = false;
	}
}
