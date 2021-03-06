package org.cispaces.nlg;
/**
 * Copyright (c) 2017 Federico Cerutti <CeruttiF@cardiff.ac.uk>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */


import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

/**
 * Servlet to receive as input the same request to ERS
 * but it produces the NLG out of it
 * 
 * **WARNING** the URL for the ERSService is hardcoded in it!
 * **TODO** Fix this by passing the URL as input as well
 * 
 * @author Federico Cerutti <CeruttiF@cardiff.ac.uk>
 *
 */
@Path("/NLG")
public class NLG {

	//public static final String ERSService = "http://localhost:8080/ers/rest/WriteRules";
	public static Logger log = null;
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.WILDCARD)
	public String EE(String input) throws UnsupportedEncodingException{
		
		log = Logger.getLogger(getClass().getName());
		log.log(Level.INFO, "NLG Accessed");
		
		/*Client client = ClientBuilder.newClient();
		WebTarget target = client.target(ERSService);
		String evaluation = target.request(MediaType.APPLICATION_JSON)
		                        .accept(MediaType.TEXT_PLAIN_TYPE)
		                        .post(Entity.json(input), String.class);*/
		
		return (new ExtensionsBulletPoints(input)).getText();
	}
	
}
