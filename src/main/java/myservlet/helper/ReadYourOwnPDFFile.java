package myservlet.helper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfReader;

public class ReadYourOwnPDFFile {
	public static void main(String[] args) {
		try {
			parsePdf("C:\\jsproj\\data\\Firozuddin_Mohammed_Timesheet_WE_01042014.pdf", "c:\\temp\\output.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void pdfUsingPOI(String file) {
		try {
			PdfReader reader = new PdfReader(file);
			int n = reader.getNumberOfPages();
			// we retrieve the size of the first page
			Rectangle psize = reader.getPageSize(1);
			System.out.println(reader.getPageContent(1));

			System.out.println(reader.getPdfVersion());
			System.out.println(reader.getFileLength());
			System.out.println(psize.height());
			System.out.println(psize.width());

		} catch (Exception de) {
			de.printStackTrace();
		}
	}

	public static String parsePdf(String file, String outputFileName) throws IOException {
		// Initialise file
		File myFile = new File(file);
		FileWriter fileWriter = null;
		if (outputFileName !=null && outputFileName.length() >0)
		{
			fileWriter  = new FileWriter(outputFileName);
		}
		StringBuffer sb = new StringBuffer();
            
		PDDocument pdDoc = null;
		try {
			// Load PDF
			pdDoc = PDDocument.load(myFile);
			// Create extractor
			PDFTextStripper pdf = new PDFTextStripper();
			// Extract text
			String output = pdf.getText(pdDoc);
			
			/*
			int i= output.indexOf("Worked")-1;
			String start = output.substring(i, "\n");
			*/
			String[] lines = output.split("\n");
			boolean  flag = true;
			for (int i=1; i<lines.length; i++)
			{
				
				if(lines[i].toLowerCase().startsWith("hours ")||
						lines[i].toLowerCase().startsWith("week ") ||
						lines[i].toLowerCase().startsWith("total:"))
				{
					if (fileWriter != null)
						   fileWriter.append(lines[i] + "\n");
						sb.append(lines[i]);
						sb.append("<br/>");
				}
				/*
				int idx = lines[i].toLowerCase().indexOf("worked")-1;
				
				if (flag && idx>=0)
				{
					if (fileWriter != null)
					   fileWriter.append(lines[i] + "\n");
					sb.append(lines[i]);
					sb.append("<br/>");
					idx = 0;
					flag = false;
				}
				
				int kdx = lines[i].toLowerCase().indexOf("hour")-1;
				if (flag && kdx>=0)
				{
					if (fileWriter != null)
					fileWriter.append(lines[i] +"\n");
					sb.append(lines[i]);
					sb.append("<br/>");
					kdx=0;
					flag = false;
				}
				else
				{
					kdx = lines[i].toLowerCase().indexOf("hr")-1;
					if (flag && kdx>=0)
					{
						if (fileWriter != null)
						fileWriter.append(lines[i] + "\n");
						sb.append(lines[i]);
						sb.append("<br/>");
						kdx=0;
						flag = false;
					}
				}
				int l= lines[i].toLowerCase().indexOf("week")-1;
				if (flag && l>=0)
				{
					if (fileWriter != null)
					fileWriter.append(lines[i] + "\n");
					sb.append(lines[i] );
					sb.append("<br/>");
					l=0;
					flag = false;
				}
				l= lines[i].toLowerCase().indexOf("total")-1;
				if (flag && l>=0)
				{
					if (fileWriter != null)
					fileWriter.append(lines[i] + "\n");
					sb.append(lines[i] );
					sb.append("<br/>");
					l=0;
					flag = false;
				}
				idx=0;
				kdx=0;
				l=0;
				flag = true;
				*/
			}
			if (fileWriter !=null)
			{
				fileWriter.flush();
				fileWriter.close();
			}
			
			System.out.println(output);
			//System.out.println(lines[0]);
		} finally {
			if (pdDoc != null)
				// Close document
				pdDoc.close();
		}
		return sb.toString();
	}

}
