package timesheet.process;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import timesheet.model.VendorModels;
import timesheet.model.WeeklyHours;
import timesheet.vendors.ESystems;
import timesheet.vendors.Vendor;
import timesheet.vendors.VendorFactory;

public class ProcessTimesheet {
	
	private static boolean prod = true;
	private static final String clName = "ProcessTimesheet";

	
	public static String process(String companyName, String inputFileName, String outputFileName)throws Exception
	{
		String mtName = clName+".process - ";
		System.out.println(mtName+"start");
		System.out.println(mtName+"companyName - "+companyName+"-"+inputFileName+"-"+outputFileName);
		
		Vendor vendor = VendorFactory.getVendor(companyName);
		System.out.println(mtName+"vendorname - "+vendor.getVendorName());
		
		//call OCR Client
        //String text = (prod==true?OCRWebserviceClient.callOCR(inputFileName, outputFileName):vendor.getSample());
		
		//call PDFBox Impl
		String text = (prod==true?PDFBoxClient.parsePdf(inputFileName, outputFileName):vendor.getSample());
		text = (text != null?text.trim():null);
		//System.out.println(mtName+"text-"+text.length()+"-"+text);
		
		VendorModels wh = null;
		if(text != null && text.length()>0)
		{
			System.out.println(mtName+"text retrived from PDF is not null or blank ... start processing");
			wh = vendor.process(text);
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(wh);
			return json;
		}
		else
		{
			System.out.println(mtName+"text retrived from PDF is null or blank");
			return null;
		}
	}

/*	public String processByte(String companyName, byte[] inputFile, String outputFileName)throws Exception
	{
		String mtName = "processByte";
		System.out.println(mtName+" - vendorname - "+companyName+"-"+outputFileName);		
		Vendor vendor = VendorFactory.getVendor(companyName);
		System.out.println(mtName+" - vendorname - "+vendor.getVendorName());
		System.out.println(mtName+" - start");
        String text = (prod==true?OCRWebserviceClient.callOCRBytes(inputFile, outputFileName):vendor.getSample());
		System.out.println(mtName+" - text-"+text.length()+"-"+text);
		
		WeeklyHours wh = vendor.process(text);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(wh);
		return json;
	}
*/
	public static void main(String[] args)throws Exception {
		System.out.println("ProcessTimesheet.main - start1");
		ProcessTimesheet pt = new ProcessTimesheet();
		//System.out.println(pt.process(AmtexSystems.vendorName, "amtex.pdf", "abc1.pdf"));
		System.out.println(pt.process(ESystems.vendorName, "esystems1.pdf", "abc1.pdf"));
	}
}
