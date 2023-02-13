package application;

public class Status {
	public Boolean status;
	public String report;
	
	public Status() {
		super();
	}
	public Status(Boolean status, String report) {
		super();
		this.status = status;
		this.report = report;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	
}
