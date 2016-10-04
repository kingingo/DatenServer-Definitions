package eu.epicpvp.datenserver.definitions.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class ReportWorker {
	private int reportId;
	private int playerId;
	private long start;
	@Setter
	private long end;
}
