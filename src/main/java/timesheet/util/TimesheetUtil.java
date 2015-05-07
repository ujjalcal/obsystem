package timesheet.util;

import java.util.HashMap;

public class TimesheetUtil {
	private static final String clName = "TimesheetUtil";
	
	public static HashMap<String, String> splitBasedOnPatternList(String data, String pattern[])
	{
		String mtName = clName+".splitBasedOnPatternList-";
		
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < pattern.length; i++) {
			System.out.println(mtName+"for - "+i);
			String strPattern = pattern[i];
			int index= data.indexOf(strPattern);
			System.out.println(mtName+"strPattern - "+strPattern+", index-"+index);
			if(index == -1)
				continue;
			
			String strPattern2 = null;
			int index2 = -1;
			int j=i;
			while(true)
			{
				j=i+1;
				if(j<pattern.length)
				{
					strPattern2= pattern[j];
					index2 = data.indexOf(strPattern2);
					System.out.println(mtName+"strPattern - "+strPattern2+", index-"+index2);
					if(index2 == -1)
						continue;
					else
						break;
				}
				else
					break;
			}
			
			String str = null;
			if(index2==-1)
			{
				str = data.substring(index+strPattern.length());
			}
			else
			{
				System.out.println(mtName+"..data-"+data+", index-"+index+", index2-"+index2);
				str = data.substring(index+strPattern.length(), index2);
			}
			System.out.println(mtName+"***"+strPattern+"-"+str);
			map.put(strPattern, str);
			
		}
		System.out.println(mtName+"out of for loop");
		return map;
	}


}
