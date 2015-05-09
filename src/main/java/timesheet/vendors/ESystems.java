package timesheet.vendors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import timesheet.model.EsystemsModel;
import timesheet.model.WeeklyHours;
import timesheet.util.TimesheetUtil;

public class ESystems implements Vendor {
	
	private static final String clName = "ESystems";

	public static final String vendorName = "ESystems";

	String pattern[] = {"Consultant: ", "Work Phone: ", "Client: ", "Project: ","Cycle Begins: ","Email: ","Date ","Week Day ","Hours Worked ","Total Hours: ","TOTAL: ","Weekly Status Report ","Consultant Signature"};
	
	private final String sample = "Consultant: Ujjal Bhattacharjee Work Phone: 469-274-2327 Client: HP Project: Interface Cycle Begins: October 12, 2014 Email:  ujjalaesems-inc.com  (Sunday)  (Cycle begins on   7 Date 10/12/14 10/13/14 10/14/14 10/15/14 10/16/14 Week Day Sun Mon Tue Wed Thu Hours Worked 8.00 8.00 8.00 8.00 Total Hours: 40.00 10/17/14 Fri 10/18/14 Sat 8.00 TOTAL: 40.00 Weekly Status Report 1. Interface 271 - fixed Autosys Failing 2. Intf 355 - creating zip file 3. Defect #6104, #6108, #6133, #6168, #6108, #6106 4. Package name change for Interface 248, 249 and 4 more 5. Configuration for Intf 390, 276, 191, 204, 387, 390, 123 6. NCOA091, DRSV350, TANF432, PSPX371 - delete records '-tct—ifie-5,6( Consultant Signature eSystems Supervisor Signature Client Manager Signature eSystems Inc., 103 Carnegie Center, Suite 305, Princeton, NJ 08540 Tel: (609) 945-7437 Fax: (908) 325-0477 ";
	//private final String sample="Consultant: Ujjal Bhattacharjee Client: HP  Project: Interface  Cycle Begins: November 2, 2014 (Sunday)  (Cycle begins on Work Phone: 469-274-2327 Email: ujjal@esystems-inc.com Date 11/02/14 11/03/14 11/04/14 11/05/14 11/06/14 11/07/14 11/08/14 Week Day Sun Mon Tue Wed Thu Fri Sat Hours Worked 8.00 8.00 8.00 TOTAL: 24.00 Total Hours: 24.00 Weekly Status Report Last working day ";
	
	//private static final String startPattern = "Worked ";
	//private static final String endPattern = " Weekly ";

	@Override
	public String getVendorName() {
		return vendorName;
	}

	@Override
	public String[] getSearchPattern() {
		return null;//new String[] { startPattern, endPattern };
	}
	

	public List<String> getSearchPatternList() {
		List<String> list = new ArrayList<String>();

		//list.add("Consultant: ");
		//list.add("Work Phone: ");
		//list.add("Client: ");
		//list.add("Project: ");
		//list.add("Cycle Begins: ");
		//list.add("Email: ");
		list.add("Date");
		list.add("Week Day");
		list.add("Hours Worked");
		//list.add("Total Hours: ");
		list.add("TOTAL:");
		//list.add("Weekly Status Report ");
		//list.add("Consultant Signature");
		
		return list;
	}

	@Override
	public WeeklyHours process(String data) throws Exception{
		String mtName = clName+".process - ";
		
		System.out.println(mtName+"start");
		HashMap<String, String> map = TimesheetUtil.splitBasedOnPattern(data, getSearchPatternList());
		if(map== null)
		{
			System.out.println(mtName+"map is null - exit");
			return null;
		}
		System.out.println(mtName+"AfterSplit - "+map);
		
		EsystemsModel model = new EsystemsModel();

		//hours
		WeeklyHours wh = new WeeklyHours();
		String pattern2 = getSearchPatternList().get(2);
		System.out.println(mtName+"hrsWorked pattern-"+pattern2);
		String hrsWorked = map.get(pattern2);
		System.out.println(mtName+"hrsWorked-"+hrsWorked);
		if(hrsWorked == null || hrsWorked.length()==0)
		{
			return null;
		}
		
		StringTokenizer stk = new StringTokenizer(hrsWorked," ");
		if(stk.hasMoreElements() && stk.countTokens()>=6)
			wh.setSun(Math.round(Float.parseFloat(stk.nextToken())));
		if(stk.hasMoreTokens())
			wh.setMon(Math.round(Float.parseFloat(stk.nextToken())));
		if(stk.hasMoreTokens())
			wh.setTue(Math.round(Float.parseFloat(stk.nextToken())));
		if(stk.hasMoreTokens())
			wh.setWed(Math.round(Float.parseFloat(stk.nextToken())));
		if(stk.hasMoreTokens())
			wh.setThurs(Math.round(Float.parseFloat(stk.nextToken())));
		if(stk.hasMoreTokens())
			wh.setFri(Math.round(Float.parseFloat(stk.nextToken())));
		

		//total hours
		String totHrs = map.get(getSearchPatternList().get(3));
		wh.setTotal(Math.round(Float.parseFloat(totHrs)));

		System.out.println(mtName+model);
		

		// validate whether the hours in the week matches the total hours
		if (!wh.validateHours()) {
			// TODO - log the text in Fault queue for analysis
			throw new Exception(mtName+"Weekly work validation failed. Processing error of vendor " + vendorName+ "'s Timesheet. Requires manual intervention");
		}

		return wh;
	}
	

	@Override
	public String getSample() {
		return sample;
	}
}
