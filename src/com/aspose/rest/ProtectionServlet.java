package com.aspose.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.aspose.words.Document;
import com.aspose.words.ProtectionType;

@Path("/words/{name}/protection")
public class ProtectionServlet {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String postProtection(@Context HttpServletRequest request,
			@PathParam("name") String name) throws Exception {
		
		String fileToProtect=request.getServletContext().getInitParameter("directory") + name ;
		
		Document d=new Document(fileToProtect);
		d.protect(ProtectionType.READ_ONLY, "password");
		String proctedFileName=request.getServletContext().getInitParameter("directory") + stripExtension(name) +"_protected.doc"; 
		d.save(proctedFileName);
		return "{\"status\":200,\"protected_file_name\":" +proctedFileName + ",\"protectionType\":\"ReadOnly\"}"; 
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getProtection(@Context HttpServletRequest request,
			@PathParam("name") String name) throws Exception {
		
		String fileToProtect=request.getServletContext().getInitParameter("directory") + name ;
		Document doc = new Document(fileToProtect);
		int protectionType = doc.getProtectionType();
		
		return "{\"status\":200,\"protection_type\":" + protectionType + "}";
	}
	
	
	
	 private static String stripExtension (String str) {
	        if (str == null) return null;
	        int pos = str.lastIndexOf(".");
	        if (pos == -1) return str;

	        return str.substring(0, pos);
	    }

}
