package com.core.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
/**
 * Root resource (exposed at "ps" path)
 */
@Path("ps")
public class PrestashopService {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
		
//		 URL url;
//		 String output="";
//        try {
//            // get URL content
//
//            String a="http://arretranco.esy.es/tienda/";
//            url = new URL(a);
//            URLConnection conn = url.openConnection();
//
//            // open the stream and put it into BufferedReader
//            BufferedReader br = new BufferedReader(
//                               new InputStreamReader(conn.getInputStream()));
//
//            String linea="";
//            while ((linea = br.readLine()) != null) {
//            	output=output+linea;
//            }
//            br.close();
//
//            
////            TTM72JHL6SXXDSEUKVGGUNI9HBXR6IGW@
//            
//            System.out.println("Done");
//
//            
//            
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		
		
		
		 
		String output = "";
		Client client = Client.create();

//		String url="http://emiliosmoreno.netai.net/tienda/api/categories";
//		String user="48BB0ISNOYE9U7F7S06SYK0XB15VUVIA";
//		
		String url="http://arretranco.esy.es/tienda/api";
		String user="TTM72JHL6SXXDSEUKVGGUNI9HBXR6IGW";

		System.out.println("Url: "+url);
		
		WebResource webResource = client.resource(url);
		
		
		String password="";
		client.addFilter(new HTTPBasicAuthFilter(user, password));
		ClientResponse response = webResource.get(
				ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		output = response.getEntity(String.class);

		output=output.substring(0,output.indexOf("</prestashop>")+"</prestashop>".length());
		System.out.println("Output from Server .... \n");
		System.out.println(output);
		 
		return output;
    }
}
