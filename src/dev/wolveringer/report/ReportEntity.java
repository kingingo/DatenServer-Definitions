package dev.wolveringer.report;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;



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
	private boolean open;
	private ArrayList<ReportWorker> workers;
}
