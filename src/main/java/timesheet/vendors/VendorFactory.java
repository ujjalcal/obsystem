package timesheet.vendors;

public class VendorFactory {
	
	 public static Vendor getVendor(String companyName){
	      if(companyName == null){
	         return null;
	      }		
	      if(companyName.equalsIgnoreCase(Amdocs.vendorName)){
	         return new Amdocs();
	         
	      } else if(companyName.equalsIgnoreCase(AmtexSystems.vendorName)){
	         return new AmtexSystems();
	         
	      } else if(companyName.equalsIgnoreCase(ESystems.vendorName)){
	         return new ESystems();
	      }
	      
	      else if(companyName.equalsIgnoreCase(OffspringSystems.vendorName)){
	    	  return new OffspringSystems();
	      }
	      return null;
	   }

}
