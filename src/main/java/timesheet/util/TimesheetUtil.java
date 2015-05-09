package timesheet.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class TimesheetUtil {
	private static final String clName = "TimesheetUtil";
	
	public static HashMap<String, String> splitBasedOnPatternList(String data, String pattern[])
	{
		String mtName = clName+".splitBasedOnPatternList-";
		System.out.println(mtName+"data - "+data);
		
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < pattern.length; i++) {
			System.out.println(mtName+"for - "+i);
			String strPattern = pattern[i];
			int index= data.indexOf(strPattern);
			System.out.println(mtName+"strPattern - "+strPattern+", index-"+index);
			if(index == -1)
				continue;
		
			if(true)
				break;
			
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
	
	public static HashMap<String, String> splitBasedOnPattern(String data, List<String> pattern)
	{
		String mtName = clName+".splitBasedOnPattern-";
		System.out.println(mtName+"data - "+data.length()+"\n"+data);
		System.out.println(mtName+"pattern-"+pattern);
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		
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
					System.out.println(mtName+"after remove .. pattern-"+pattern);
					map.put(key, line.substring(key.length()+1));
					System.out.println(mtName+"map-"+map);
					break;
				}
			}
			
			//break out of the while loop - if all the pattern has been searched for.
			if(pattern.size()<=0)
			{
				System.out.println(mtName+"no mroe pattern - break");
				break;
			}
			
		}
		return map;
	}


}
