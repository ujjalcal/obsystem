package myservlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayFile
 */
public class DisplayFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sourceDir = request.getParameter("sourceDir");
		PrintWriter pw = response.getWriter();

		File file = new File(sourceDir);
		File[] files = file.listFiles();
		pw.println("<html> \n" + "<body> \n" + "<UL>");
		for (int i = 0; i < files.length; i++) 
		{
			if (!files[i].isDirectory()) 
			{
				pw.println("<LI><A HREF=file:\\\\" + files[i].getAbsolutePath()
						+ ">" + files[i].getName() + "</A>" + "("
						+ files[i].length() + " bytes long ");

			}
		}
		pw.println("</UL> \n" + "</body> \n" + "</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
