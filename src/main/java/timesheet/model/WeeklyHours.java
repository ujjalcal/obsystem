package timesheet.model;

public class WeeklyHours {
	
	private int sun;
	private int mon;
	private int tue;
	private int wed;
	private int thurs;
	private int fri;
	private int sat;
	
	private int total;
	
	public boolean validateHours()
	{
		return total==(sun+mon+tue+wed+thurs+fri+sat)?true:false;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getSun() {
		return sun;
	}
	public void setSun(int sun) {
		this.sun = sun;
	}
	public int getMon() {
		return mon;
	}
	public void setMon(int mon) {
		this.mon = mon;
	}
	public int getTue() {
		return tue;
	}
	public void setTue(int tue) {
		this.tue = tue;
	}
	public int getWed() {
		return wed;
	}
	public void setWed(int wed) {
		this.wed = wed;
	}
	public int getThurs() {
		return thurs;
	}
	public void setThurs(int thurs) {
		this.thurs = thurs;
	}
	public int getFri() {
		return fri;
	}
	public void setFri(int fri) {
		this.fri = fri;
	}
	public int getSat() {
		return sat;
	}
	public void setSat(int sat) {
		this.sat = sat;
	}
	
	@Override
	public String toString() {
		String str = "Sun-"+sun+", Mon-"+mon+", Tues-"+tue+", Wed-"+wed+", Thurs-"+thurs+", Fri-"+fri+", Sat-"+sat+", Total - "+total;
		return str;
	}

}
