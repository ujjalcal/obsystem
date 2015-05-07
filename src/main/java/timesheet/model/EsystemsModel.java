package timesheet.model;

import java.util.Date;

public class EsystemsModel {
	
	String consultant;
	String client;
	String workPhone;
	String email;
	String project;
	Date cycleBegin;
	String weeklyStatus;
	WeeklyHours week;
	
	public String getConsultant() {
		return consultant;
	}
	public void setConsultant(String consultant) {
		this.consultant = consultant;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public Date getCycleBegin() {
		return cycleBegin;
	}
	public void setCycleBegin(Date cycleBegin) {
		this.cycleBegin = cycleBegin;
	}
	public WeeklyHours getWeek() {
		return week;
	}
	public void setWeek(WeeklyHours week) {
		this.week = week;
	}
	public String getStatus() {
		return weeklyStatus;
	}
	public void setStatus(String status) {
		this.weeklyStatus = status;
	}
	
	@Override
	public String toString() {
		String str = "consultant-"+consultant+", client-"+client+", workPhone-"+workPhone+", email-"+email+", project-"+project+", cycleBegins-"+cycleBegin+", status-"+weeklyStatus;
		return str+week;
	}

}
