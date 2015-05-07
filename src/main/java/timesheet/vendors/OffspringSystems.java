package timesheet.vendors;

import timesheet.model.WeeklyHours;

public class OffspringSystems implements Vendor {

	public static final String vendorName = "OffspringSystems";
	private static final String startPattern = "";
	private static final String endPattern = "Yes";
	
	@Override
	public String getVendorName() {
		return vendorName;
	}

	@Override
	public String[] getSearchPattern() {
		return new String[]{startPattern, endPattern};
	}
	@Override
	public String getSample() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public WeeklyHours process(String data) throws Exception{
		System.out.println("data - "+data);
		System.out.println("endPattern - "+endPattern);
		String[] dataStr = data.split(endPattern);
		int tokens = dataStr.length;
		
		//StringTokenizer stk = new StringTokenizer(data, endPattern);
		//int tokens = stk.countTokens();
		//System.out.println("token - "+tokens);
		
		
		if(tokens == 0)
			throw new Exception("Timesheet does not match "+vendorName+" pattern. Please upload manually and submit for review");
		
		//while(stk.hasMoreTokens())
		for (int i = 0; i < dataStr.length-1; i++) {
			//String token = stk.nextToken();
			String token = dataStr[i];
			//System.out.println(token);
			String hours = token.substring(token.length()-5);
			hours = hours.replace(",", ".").replace(":", ".");
			System.out.println(Integer.parseInt(hours.trim()));
		}

		return null;
	}
	
	public static void main(String[] args) throws Exception{
		
		String data = "Report: Time Activities by Employee Detail Palle 1 of 1 Offspring Solutions, LLC Time Activities by Employee Detail Activity: December 29, 2013 - January 4, 2014 Activity Date Client Product/Service Memo/Description Duration Billable Firoz Mohammed 12'3012013 DHHS.DHIHS- HHS - HRIT - HRIT Technical Support and 8•00 Yes HRIT Engineering SME Development 12/31/2013 DHHS:DHHS- HHS - HRIT - HRIT Technical Support and 8,00 Yes HRIT Engineering SME Development 01102/2014 DHHS:DHHS- HHS - HRIT - HRIT Technical Support and 8:00 Yes HRIT Engineering SME Development 01'03/2014 DHHS:DHHS- HHS - HRIT - HRIT Technical Support and 8:00 Yes HRIT Engineering SME Development Tot1 for Firoz Mohammed r 32:00 Saturday, Jan 04 2014 06 27:11 PM PST GMT-5 P v9 j- ot/of/IA0/4 littps:l7q1.)o. i ntti it.com 'cibo27.'reports.'103779.45. 09:exec uterptid-1037794.509-TI M E ACT1... 1:4.2014 General Page 2 ";
		WeeklyHours week = (new OffspringSystems().process(data));
	}
}
