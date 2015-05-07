package timesheet.process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PDFBoxClient {
	
	public static String parsePdf(String file, String outputFileName) throws IOException {
		File myFile = new File(file);

		PDDocument pdDoc = null;
		String output = null;
		try {
			// Load PDF
			pdDoc = PDDocument.load(myFile);
			// Create extractor
			PDFTextStripper pdf = new PDFTextStripper();
			// Extract text
			output = pdf.getText(pdDoc);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return output; 
	}

}
