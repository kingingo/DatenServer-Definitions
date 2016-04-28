package dev.wolveringer.report;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ReportWorker {
	private int reportId;
	private int playerId;
	private long start;
	private long end;
}
