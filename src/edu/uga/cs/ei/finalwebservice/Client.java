package edu.uga.cs.ei.finalwebservice;

import org.apache.jena.base.Sys;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.w3c.dom.Element;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.net.URI;

public class Client {

    static URI link;

    public static void main(String[] args) {
        try {
            getMainDishes();
        }
        catch (Exception e) {

        }
        System.out.println("================================================");
        try {
            getSideDishes();
        }
        catch (Exception e) {

        }
        System.out.println("================================================");
        try {
            queryMainDishes("Rasam");
        }
        catch (Exception e) {

        }

    }

    public static void getMainDishes() {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/main_course");
            Response response;

            // === Retrieve all movies using a GET request and XML representation ===
            // =========================================================================
            System.out.println();
            System.out.println("Retrieving all main_course (XML representation)");

            // perform a GET request, asking for an XML representation
            System.out.println("Making response");
            response = target.request(MediaType.APPLICATION_XML).get();
            System.out.println("getMainDishes response made");


            if (response.getStatus() != 200) {
                System.out.println("Status is not 200");
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                System.out.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                //System.out.println(prettyPrintXML(p));
            }
            response.close();
            System.out.println("getMainDishes response closed");

        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void queryMainDishes(String s) {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/main_course?course=" + s);
            Response response;

            // === Retrieve all movies using a GET request and XML representation ===
            // =========================================================================
            System.out.println();
            System.out.println("Retrieving main course query (XML representation)");

            // perform a GET request, asking for an XML representation
            System.out.println("Making response");
            response = target.request(MediaType.APPLICATION_XML).get();
            System.out.println("queryMainDishes response made");


            if (response.getStatus() != 200) {
                System.out.println("Status is not 200");
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                System.out.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                //System.out.println(prettyPrintXML(p));
            }
            response.close();
            System.out.println("queryMainDishes response closed");
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void getSideDishes() {

        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/side_dish");

            System.out.println("\nRetrieving all side_dish (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();
            System.out.println("getSideDisehes response made");


            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                System.out.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                //System.out.println(prettyPrintXML(p));
            }
            response.close();
            System.out.println("getSideDisehes response closed");
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static String prettyPrintXML(String input) {
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
