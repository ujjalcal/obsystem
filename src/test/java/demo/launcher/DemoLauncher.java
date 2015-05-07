package demo.launcher;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.naming.resources.VirtualDirContext;

public class DemoLauncher {

	private static final int TOMCAT_DEFAULT_PORT = 8080;
	private static final String WEB_APP_DIR = "src/main/webapp";
	private static final String WEB_APP_CONTEXT ="/demo";
	private static final String TOMCAT_CONTEXT = "tomcat-context.xml";
	private Tomcat tomcat;
	public static void main(String[] args) throws LifecycleException, ServletException, IOException {
		int port =TOMCAT_DEFAULT_PORT;
		
		if (args !=null && args.length >0)
		{
			try
			{
				port = Integer.parseInt(args[0]);
			}
			catch(Exception e)
			{
				port =TOMCAT_DEFAULT_PORT;
			}
		}
		new DemoLauncher().start(port);
	}
	
	public void start(int port) throws LifecycleException, ServletException, IOException
	{
		startServer(port);
		String appBaseUrl = "http://localhost:" + port + WEB_APP_CONTEXT;
		Desktop.getDesktop().browse(URI.create(appBaseUrl));
		tomcat.getServer().await();
	}

	private void startServer(int port) throws LifecycleException, ServletException
	{
		tomcat = new Tomcat();
		tomcat.enableNaming();
		tomcat.setPort(port);
		File file = new File(WEB_APP_DIR);
		if (!file.exists())
		{
			file = new File("tsapp");
		}
		
			Context appContext = tomcat.addWebapp(WEB_APP_CONTEXT, file.getAbsolutePath());
			URL contextXml = this.getClass().getClassLoader().getResource(TOMCAT_CONTEXT);
			appContext.setConfigFile(contextXml);
			
		tomcat.start();
		
	}
}


