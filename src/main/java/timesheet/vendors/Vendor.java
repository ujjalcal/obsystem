package timesheet.vendors;

import java.util.List;

import timesheet.model.VendorModels;
import timesheet.model.WeeklyHours;

public interface Vendor {
	
	public String getVendorName();
	public List<String> getSearchPatternList();
	public String getSample();
	
	public VendorModels process(String data) throws Exception; 

}
