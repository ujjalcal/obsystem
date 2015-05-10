package timesheet.vendors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import timesheet.model.VendorModels;
import timesheet.model.WeeklyHours;
import timesheet.util.TimesheetUtil;

public class OffspringSystems implements Vendor {
	private static final String clName = "OffspringSystems";

	public static final String vendorName = "OffspringSystems";
	
	@Override
	public String getVendorName() {
		return vendorName;
	}

	@Override
	public java.util.List<String> getSearchPatternList() {
		List<String> list = new ArrayList<String>();

		list.add("Duration Eillable");
		return list;
	};
	
	@Override
	public String getSample() {
		return null;
	}

	@Override
	public VendorModels process(String data) throws Exception{
		String mtName = clName+".process - ";
		
		VendorModels model = new VendorModels();
		WeeklyHours wh = new WeeklyHours();
		model.setWeek(wh);
		
		//impl
		System.out.println(mtName+"start");
		HashMap<String, String> map = new HashMap<String, String>();
		
		List<String> pattern = getSearchPatternList();
		
		StringTokenizer stk = new StringTokenizer(data,"\n");
		while(stk.hasMoreTokens())
		{
			//System.out.println(mtName+"in the while loop");
			String line = stk.nextToken().trim();
			System.out.println(mtName+" line -"+line);
			
			
			for (Iterator<String> iterator = pattern.iterator(); iterator.hasNext();) 
			{
				String key = (String) iterator.next().trim();
				
				System.out.println(mtName+"key -"+key);
				if(line.toLowerCase().startsWith(key.toLowerCase()))
				{
					System.out.println(mtName+"match .. pattern-"+pattern);
					//remove the key from the list - so that it is not searched any more
					
					iterator.remove();
					
					int i=0;
					while(stk.hasMoreTokens())
					{
						i++;
						String tk = (stk.hasMoreTokens()?stk.nextToken():null);

						try
						{
							if(tk.indexOf(':')!=-1)
							{
								System.out.println(mtName+"replace");
								tk = tk.replace(':', '.');
							}
							if(tk.indexOf(" Yes")!=-1)
								tk = tk.substring(0, tk.length()-4);
							
							System.out.println(mtName+"tk - "+tk);
							float d = Float.parseFloat(tk);
							switch(i)
							{
								case 1:	wh.setMon(Math.round(d)); break;
								case 2: wh.setTue(Math.round(d));break;
								case 3: wh.setWed(Math.round(d));break;
								case 4: wh.setThurs(Math.round(d));break;
								case 5: wh.setFri(Math.round(d));break;
							}
						}
						catch(NumberFormatException e)
						{
							//check for something else
							System.out.println(mtName+"Numberformat exception -"+tk);
							break;
						}
					}
					
					//break out of this for loop and continue with the while
					break;
				}
			}
			
			//break out of the while loop - if all the pattern has been searched for.
			if(pattern.size()<=0)
			{
				System.out.println(mtName+"no more pattern - break");
				break;
			}
			
		}


		return model;
	}
	
}
