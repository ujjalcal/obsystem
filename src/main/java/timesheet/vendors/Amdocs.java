package timesheet.vendors;

import timesheet.model.VendorModels;
import timesheet.model.WeeklyHours;

public class Amdocs implements Vendor {

	public static final String vendorName = "AMDOCS";
	private final String startPattern = "";
	private final String endPattern = "";
	
	@Override
	public String getVendorName() {
		return vendorName;
	}

	@Override
	public java.util.List<String> getSearchPatternList() {
		return null;
	};
	
	@Override
	public VendorModels process(String data) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getSample() {
		// TODO Auto-generated method stub
		return null;
	}
}
