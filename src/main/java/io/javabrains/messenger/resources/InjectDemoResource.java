package io.javabrains.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/demo")
public class InjectDemoResource {

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getParams(@QueryParam("qParam") String qParam, 
							@HeaderParam("hParam") String hParam) {
		String myStr = "";
		if (qParam != null) {
			myStr = "query: " + qParam;
		}
		if (hParam != null) {
				myStr += ", header: " + hParam;
		}
		return myStr;
	}
	
	@GET
	@Path("context")
	public String getContextParams(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		
		return ("Path: " + path + ", Cookies: " + cookies);
	}
	
}
