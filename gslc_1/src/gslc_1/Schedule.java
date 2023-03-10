package gslc_1;

import java.util.Date;

public class Schedule implements Comparable<Schedule> {
	private String taskName;
	private Date taskDeadline;
	
	
	public Schedule(String taskName, Date taskDeadline) {
		this.taskName = taskName;
		this.taskDeadline = taskDeadline;
	}
	

	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public Date getTaskDeadline() {
		return taskDeadline;
	}


	public void setTaskDeadline(Date taskDeadline) {
		this.taskDeadline = taskDeadline;
	}


	@Override
	public int compareTo(Schedule o) {
		return getTaskDeadline().compareTo(o.getTaskDeadline());
	}
}
