package eu.epicpvp.datenserver.definitions.report;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Getter
@AllArgsConstructor
public class ReportEntity {
	private int reportId;
	private int reporter;
	private String reporterIp;
	private int target;
	private String reson;
	private String infos;
	private long time;
	@Setter
	private int state = 1;
	private ArrayList<ReportWorker> workers;

	public boolean isOpen(){
		return state == 1;
	}
}
