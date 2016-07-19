package com.aspose.rest;

/**
 * @author Crunchify.com
 */

import java.io.FileInputStream;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.aspose.words.Document;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/words/convert")
@Produces("application/pdf")
public class Convertor {
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response convertFile(
			@FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetai) throws Exception {
		
		Document doc = new Document( uploadedInputStream);
		doc.save("convertor.pdf");
		
		 InputStream targetStream = new FileInputStream("convertor.pdf");
		
		ResponseBuilder responseBuilder =Response.ok((Object) targetStream);
		responseBuilder.type("application/pdf");
		responseBuilder.header("Content-Disposition", "filename=test.pdf");
		return responseBuilder.build(); 
	}

}