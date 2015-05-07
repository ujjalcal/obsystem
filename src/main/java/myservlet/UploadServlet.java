package myservlet;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myservlet.helper.ReadYourOwnPDFFile;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

import timesheet.process.ProcessTimesheet;

public class UploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5880446237600745558L;
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 1000 * 1024;
	private int maxMemSize = 1000 * 1024;
	private File file;

	public void init() {
		// Get the file location where it would be stored.
		filePath = getServletContext().getInitParameter("file-upload");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		// Check that we have a file upload request
		isMultipart = ServletFileUpload.isMultipartContent(request);
	    String companyName = (String)request.getSession(false).getAttribute("CompanyName");
	    String outputFileName = (String)request.getSession(false).getAttribute("outputFile");
	    
		System.out.println("-----" + companyName + "------");
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		if (!isMultipart) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>No file uploaded</p>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);
		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File(" C:/Users/nghosh/Downloads/"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);

		try {
			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					// Write the file
					if (fileName.lastIndexOf("\\") >= 0) {
						file = new File(
								filePath
										+ fileName.substring(fileName
												.lastIndexOf("\\")));
					} else {
						file = new File(
								filePath
										+ fileName.substring(fileName
												.lastIndexOf("\\") + 1));
					}
					fi.write(file);
					out.println("Uploaded Filename: " + filePath + fileName + "<br>");
					// out.println("File Content: " +
					// PDFTextParser.pdftoText(filePath +"/"+fileName) +
					// "<br>");
/*
					File f = new File(filePath, fileName);
					InputStream is = new FileInputStream(f);
					
					ProcessTimesheet sheet = new ProcessTimesheet();
							byte[] bytes = IOUtils.toByteArray(is);
				*/			
//							Files.readAllBytes(Paths.get(filePath + "/"
//							+ fileName));
//					System.out.println("output" + bytes);
							/*
					out.println("File Content: "
							+ sheet.processByte(
									companyName,
									bytes, "c:\\nemai\\del.txt")
							+ "<br>");
					*/
					/*
				      ContentHandler contenthandler = new BodyContentHandler();
				      Metadata metadata = new Metadata();
				      PDFParser pdfparser = new PDFParser();
				      pdfparser.parse(fi.getInputStream(), contenthandler, metadata, new ParseContext());
				      */
					String output = ProcessTimesheet.process(companyName, filePath + "/"+ fileName, outputFileName);
				  	  request.setAttribute("Output", output);
				  	  
				  	RequestDispatcher requestDispatcher = request
		                    .getRequestDispatcher("/Home2.jsp");
		            requestDispatcher.forward(request, response);

//				      out.println("File Content: " +
//				  			contenthandler.toString()
//							+ "<br>");
//				      out.println("Metadata of the PDF:<p>\n");
//				      String[] metadataNames = metadata.names();
//				      
//				      for(String name : metadataNames) {
//				         out.println(name+ " : " + metadata.get(name) +"<p>\n");
//				      }
				}
			}
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		throw new ServletException("GET method used with "
				+ getClass().getName() + ": POST method required.");
	}
}