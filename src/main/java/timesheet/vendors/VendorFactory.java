package timesheet.vendors;

public class VendorFactory {
	
	private static final String clName = "VendorFactory";
	
	public static Vendor getVendor(String companyName){
		String mtName = clName+".getVendor - ";
		
		System.out.println(mtName+"start-companyName-"+companyName);
		 
	      if(companyName == null){
	    	 System.out.println(mtName+" - return null");
	         return null;
	      }		
	      if(companyName.equalsIgnoreCase(Amdocs.vendorName)){
	    	 System.out.println(mtName+" - amdocs");
	         return new Amdocs();
	         
	      } else if(companyName.equalsIgnoreCase(AmtexSystems.vendorName)){
	    	 System.out.println(mtName+" - amtex systems");
	         return new AmtexSystems();
	         
	      } else if(companyName.equalsIgnoreCase(ESystems.vendorName)){
	    	 System.out.println(mtName+" - esystems");
	         return new ESystems();
	      }
	      
	      else if(companyName.equalsIgnoreCase(OffspringSystems.vendorName)){
	    	  System.out.println(mtName+" - offspring");	    	  
	    	  return new OffspringSystems();
	      }
	      
	      else{
	    	  System.out.println(mtName+" - company name does not match");
	    	  return null;  
	      }
	      
	   }

}
