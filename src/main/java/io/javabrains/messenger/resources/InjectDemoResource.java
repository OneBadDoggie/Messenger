package io.javabrains.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
	
}
