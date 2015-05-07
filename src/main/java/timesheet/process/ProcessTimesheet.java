package timesheet.process;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import timesheet.model.WeeklyHours;
import timesheet.vendors.ESystems;
import timesheet.vendors.Vendor;
import timesheet.vendors.VendorFactory;

public class ProcessTimesheet {
	
	private boolean prod = false;
	private static final String clName = "ProcessTimesheet";

	
	public String process(String companyName, String inputFileName, String outputFileName)throws Exception
	{
		String mtName = "process";
		System.out.println(clName+mtName+" - vendorname - "+companyName+"-"+inputFileName+"-"+outputFileName);
		
		Vendor vendor = VendorFactory.getVendor(companyName);
		System.out.println(clName+mtName+" - vendorname - "+vendor.getVendorName());
		System.out.println(clName+mtName+" - start");
        String text = (prod==true?OCRWebserviceClient.callOCR(inputFileName, outputFileName):vendor.getSample());
		System.out.println(clName+mtName+" - text-"+text.length()+"-"+text);
		
		WeeklyHours wh = vendor.process(text);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(wh);
		return json;
	}

	public String processByte(String companyName, byte[] inputFile, String outputFileName)throws Exception
	{
		String mtName = "processByte";
		System.out.println(clName+mtName+" - vendorname - "+companyName+"-"+outputFileName);		
		Vendor vendor = VendorFactory.getVendor(companyName);
		System.out.println(clName+mtName+" - vendorname - "+vendor.getVendorName());
		System.out.println(clName+mtName+" - start");
        String text = (prod==true?OCRWebserviceClient.callOCRBytes(inputFile, outputFileName):vendor.getSample());
		System.out.println(clName+mtName+" - text-"+text.length()+"-"+text);
		
		WeeklyHours wh = vendor.process(text);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(wh);
		return json;
	}

	public static void main(String[] args)throws Exception {
		System.out.println("ProcessTimesheet.main - start1");
		ProcessTimesheet pt = new ProcessTimesheet();
		//System.out.println(pt.process(AmtexSystems.vendorName, "amtex.pdf", "abc1.pdf"));
		System.out.println(pt.process(ESystems.vendorName, "esystems1.pdf", "abc1.pdf"));
	}
}
