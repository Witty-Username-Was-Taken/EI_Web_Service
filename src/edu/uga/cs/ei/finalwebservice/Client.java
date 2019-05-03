package edu.uga.cs.ei.finalwebservice;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.w3c.dom.Element;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.StringReader;
import java.net.URI;

public class Client {

    static URI link;

    public static void main(String[] args) {

        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/main_course");
            Response response;

            // === Retrieve all movies using a GET request and XML representation ===
            // =========================================================================
            System.out.println();
            System.out.println("Retrieving all food (XML representation)");

            // perform a GET request, asking for an XML representation
            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                System.out.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                System.out.println(prettyPrintXML(p));
            }
            response.close();

        }

        catch( Exception e ) {
            System.out.println( e );
            e.printStackTrace();
        }

    }

    public static String prettyPrintXML(String input)
    {
        try
        {
            final InputSource src = new InputSource(new StringReader(input));
            final Element document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();

            final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            final DOMImplementationLS impl = (DOMImplementationLS) registry
                    .getDOMImplementation("LS");
            final LSSerializer writer = impl.createLSSerializer();

            writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
            writer.getDomConfig().setParameter("xml-declaration", true);

            return writer.writeToString(document);
        } catch (Exception e) {
            e.printStackTrace();
            return input;
        }
    }
}
