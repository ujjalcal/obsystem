package timesheet.vendors;

import timesheet.model.VendorModels;
import timesheet.model.WeeklyHours;

public class AmtexSystems implements Vendor {
	public static final String vendorName = "AmtexSystems";
	public final String sample = "Amtex Systems Employee Name (Printed): BRANCH OFFICE TIMESHEET BRANCH OFFICE PHONE: CHARGEABLE HOURS: Ujjal Bhattacharjee Pay Period Endin Consultant's Work Ph 4/4/2015 FAX: 212-269-6458 212-269-6448 609-455-0028 Client Name Project Num Hours Type Activity Code Client Bill Rate Type Week 1 Week 2 Total Hours Client Approval P&L Client Proj Sat Sun Mon Tue Wed Thu Fri Sat Sun Mon Tue Wed Thu Fri C S 8 8 8 8 8 40 C 0 C 0 C 0 C 0 C 0 C 0 C 0 C 0 TOTAL CHARGEABLE 0 0 8 8 8 8 8 0 0 0 0 0 0 0 40 NON-CHARGEABLE HOURS: N/A 0 N/A 0 N/A 0 N/A 0 N/A 0 N/A 0 TOTAL NON-CHARGEABLE 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 GRAND TOTAL 0 0 8 8 8 8 8 0 0 0 0 0 0 0 40 Hours Types - Chargeable Hours Types - Non-Chargeable Activity Codes - Non-Chargeable * 10 Standard 10 Standard B Bench For Branch Management Use: 11 EWW * / Paid Overtime (Approval 11 Paid Overtime (Approval Required) T Training 21 Non-Billable (Approval Required) 31 Vacation A Administrative 0/T Approval: 22 Client Short Hours 32 Sick Leave S Sales & Marketing Activity Codes - Chargeable 33 Holidays R Recruiting ";
	private static final String startPattern = "TOTAL CHARGEABLE";
	private static final String endPattern = "NON-CHARGEABLE";

	@Override
	public String getVendorName() {
		return vendorName;
	}

	@Override
	public java.util.List<String> getSearchPatternList() {
		return null;
		
	};
	
	@Override
	public String getSample() {
		return sample;
	}

	@Override
	public VendorModels process(String data) throws Exception {
		System.out.println("AmtexSystems.process - start - "+data);

		int start = data.indexOf(startPattern);
		int end = data.indexOf(endPattern);

		if (start == -1 || end == -1)
			throw new Exception("AmtexSystems.process -Timesheet does not match " + vendorName+ " pattern. Please upload manually and submit for review");

		String hours = data.substring(start + 16, end);
		System.out.println(hours);

		VendorModels model = new VendorModels();
		// set hrs in WeeklyHours
		WeeklyHours wh = new WeeklyHours();
		String[] hoursArray = hours.split(" ");

		int count = 1;
		for (String string2 : hoursArray) {
			String str = string2.trim();
			//System.out.println("String - " + str+".."+str.length());
			if (str != null && str.length() > 0) {
				int hr = Integer.parseInt(str);
				switch (count++) {
				case 1:
					wh.setSat(hr);
					break;
				case 2:
					wh.setSun(hr);
					break;
				case 3:
					wh.setMon(hr);
					break;
				case 4:
					wh.setTue(hr);
					break;
				case 5:
					wh.setWed(hr);
					break;
				case 6:
					wh.setThurs(hr);
					break;
				case 7:
					wh.setFri(hr);
					break;
				case 15:
					wh.setTotal(hr);
					break;
				}
			}
		}

		// validate whether the hours in the week matches the total hours
		if (!wh.validateHours()) {
			// TODO - log the text in Fault queue for analysis
			throw new Exception("AmtexSystems.process -Processing error of vendor " + vendorName+ "'s Timesheet. Requires manual intervention");
		}

		model.setWeek(wh);
		return model;
	}
}
