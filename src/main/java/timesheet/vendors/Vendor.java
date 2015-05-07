package timesheet.vendors;

import timesheet.model.WeeklyHours;

public interface Vendor {
	
	public String getVendorName();
	public String[] getSearchPattern();
	public String getSample();
	
	public WeeklyHours process(String data) throws Exception; 

}
