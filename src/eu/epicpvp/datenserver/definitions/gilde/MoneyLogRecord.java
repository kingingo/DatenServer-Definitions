package dev.wolveringer.gilde;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MoneyLogRecord {
	private final long date;
	private final int playerId;
	private final int amount;
	private final String message;
}