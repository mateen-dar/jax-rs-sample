Example: Aspose for Cloud Demo Project 
======================================

In Eclipse
	File -> Import -> Maven -> Existing Maven Project

Open your web browser to:

    http://localhost:8080/Aspose     

Requirements:

	Requires Maven 3.X.X
	Requires JAVA 8 +
	Requires Tomcat 7+
	Requires Eclispe for JAVA Developers

Working with the Demo:

	Modify web.xml. Change the value of the context param "folder" to point to a path on a filesystem like "c:/uploads/" or "/user/mateen/upload/". Please terminate the path using a "/" . The application will read and write files for the protection services from this directory. 

	Browser to localhost:8080/Aspose in any browser. Code tested with Chrome on a Mac OS X machine.
	Provides examples for the following services
		1) PUT /words/convert
		2) POST /words/{name}/protection
		3) GET /words/{name}/protection

	For example 1 select any word document to convert to PDF
	For example 2 and 3 enter filename for a file in your uploads directory. This will and check protection on the File.