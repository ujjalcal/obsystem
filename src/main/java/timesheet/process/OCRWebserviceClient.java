package timesheet.process;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*import com.ocrwebservice.client.ArrayOfArrayOfString;
import com.ocrwebservice.client.ArrayOfString;
import com.ocrwebservice.client.OCRWSInputImage;
import com.ocrwebservice.client.OCRWSLanguage;
import com.ocrwebservice.client.OCRWSOutputFormat;
import com.ocrwebservice.client.OCRWSResponse;
import com.ocrwebservice.client.OCRWSSettings;
import com.ocrwebservice.client.OCRWebService;
import com.ocrwebservice.client.OCRWebServiceSoap;
*/
public class OCRWebserviceClient {
/*	private static final String clName = "OCRWebserviceClient";

	
	//public static final String USER_NAME = "UJJALB";
	//public static final String LICENSE = "99C527DF-B092-4BE5-8967-0977B44352BC";

	public static final String USER_NAME = "seemab";
	public static final String LICENSE = "642922BA-D24D-4A1E-8FC4-B0510625AF30";
	//public static final String PATH = "abc.pdf";
	//public static final String FILE_NAME = "abc1.pdf";


	public static String callOCR(String inputFileName, String outputFileName)
	{
		String mtName = clName+".callOCR - "; 
		System.out.println(mtName+"start- input-"+inputFileName+",output - "+outputFileName);
		
        Path path = Paths.get(inputFileName);
        System.out.println(mtName+"read file - "+path.getFileName());
        byte[] data = null;
        try {
			data = Files.readAllBytes(path);
		} catch (IOException e) {
			System.out.println(mtName+"Exception occured:" + e.getMessage());
			e.printStackTrace();
			return null;
		}
        
        System.out.println(mtName+"data - "+data.length);
        return callOCRBytes(data, outputFileName);
        
	}
	
	public static String callOCRBytes(byte[] data, String outputFileName)
	{
		String mtName = clName+".callOCRBytes -";
	    OCRWebService OCRservice = new OCRWebService();
		
	    OCRWebServiceSoap soap = OCRservice.getOCRWebServiceSoap();

	    // Input image
	    OCRWSInputImage input_image = new OCRWSInputImage();


        // Set file name
        input_image.setFileName(outputFileName);
        
        // Set file data
        input_image.setFileData(data);
        
        // OCR Settings
        OCRWSSettings ocrwsSetting = new OCRWSSettings();
        
        // Convert to Black/White. May be set TRUE for color images or photos 
        ocrwsSetting.setConvertToBW(false);

        // Return extracted text
        ocrwsSetting.setGetOCRText(true);

        // Set recognition language
        List<OCRWSLanguage> langs =  ocrwsSetting.getOcrLanguages();
        langs.add(OCRWSLanguage.ENGLISH);
        
        // Create and return output file
        ocrwsSetting.setCreateOutputDocument(true);
        
        // Output document format
        ocrwsSetting.setOutputDocumentFormat(OCRWSOutputFormat.DOC);
        
        // Convert image Provide your username and license code
        OCRWSResponse response = soap.ocrWebServiceRecognize(USER_NAME, LICENSE, input_image, ocrwsSetting);
        
        // If error occurred
        if (response.getErrorMessage() != null && response.getErrorMessage().length()>0) {
        	
        	System.out.println(mtName+"Error from OCRWebService: " + response.getErrorMessage());
        	System.out.println(mtName+"Error from OCRWebService: " + response.getFileName());
        	System.out.println(mtName+"Error from OCRWebService: " + response.getFileData());
        	System.out.println(mtName+"Error from OCRWebService: " + ((response.getOcrText()!=null)?response.getOcrText().getArrayOfString():""));
        	System.out.println(mtName+"Error from OCRWebService: " + ((response.getOcrWSWords()!=null)?response.getOcrWSWords().getArrayOfOCRWSWord():""));
        	return null;
        }
        
        ArrayOfArrayOfString OCRedText = response.getOcrText();
		System.out.println("OCRWebserviceClient.callOCR - calledOCR");

        
        // Get converter output file
        if (response.getFileData() != null && response.getFileData().length > 0)  {
        	
        	Path output_path = Paths.get(response.getFileName());
  			try {
				Files.write(output_path, response.getFileData());
				System.out.println("OCRWebserviceClient.callOCR - writeFile");

  			} catch (IOException e)	{
				System.out.println("Exception occured:" + e.getMessage());
				e.printStackTrace();
			}
        }

        // Get extracted text
		System.out.println("OCRWebserviceClient.callOCR - array of string - "+OCRedText.getArrayOfString().size());
        
        int i=0;
        List<ArrayOfString> arrayOfStringList = OCRedText.getArrayOfString();
        String text = null;
        for (ArrayOfString arrayOfString : arrayOfStringList) {
        	i++;
        	int j=0;
			List<String> stringList = arrayOfString.getString();
			for (String string : stringList) {
				j++;
				System.out.println(i+"-"+j+":"+string);
				text = string;
			}
		}	
        return text;

	}
*/	
}
