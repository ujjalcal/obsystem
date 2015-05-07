set echo off;
set CLASSPATH=%CLASSPATH%;launch-env
set CLASSPATH=%CLASSPATH%;lib/tomcat-embed-core-7.0.29.jar
set CLASSPATH=%CLASSPATH%;lib/tomcat-servlet-api-7.0.29.jar
set CLASSPATH=%CLASSPATH%;lib/tomcat-embed-logging-juli-7.0.29.jar
set CLASSPATH=%CLASSPATH%;lib/tomcat-embed-jasper-7.0.29.jar
set CLASSPATH=%CLASSPATH%;lib/tomcat-dbcp-7.0.29.jar

mode con:cols=100 lines=2000

java -Xmx1024M -XX:MaxPermSize=256M -classpath "%CLASSPATH%" demo.launcher.DemoLauncher %*