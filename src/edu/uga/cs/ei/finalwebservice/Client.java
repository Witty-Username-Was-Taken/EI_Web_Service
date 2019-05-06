package edu.uga.cs.ei.finalwebservice;

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
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URI;

public class Client {

    static URI link;

    public static PrintWriter output;

    public static void main(String[] args) throws IOException {
        Client c = new Client();
        c.printThings();
        
    }
    
    public void printThings() throws IOException {
        output = new PrintWriter("result.txt");

        output.println("\n\n\nAll Food");
        output.println("================================================");
        getAllFood();
        output.println("================================================");
        output.println("\n\n\nMAIN COURSES");
        output.println("================================================");
        getMainDishes();
        output.println("================================================");
        getGravyDishes();
        output.println("================================================");
        getDryDishes();
        output.println("================================================");
        queryMainDishes("Rasam");
        output.println("================================================");
        getMustContain("Biryani");
        output.println("================================================");
        getConsistsOf("Buttermilk");
        output.println("================================================");
        getGoesWith("Cashew Momo");
        output.println("================================================");
        output.println("================================================");
        getIsOfDiet("Vegeterian");
        output.println("================================================");
        getSoups();
        output.println("================================================");
        getBeverages();
        output.println("================================================");
        getDesserts();
        output.println("================================================");
        getSnack();

        output.println("\n\n\nSide Dishes");
        output.println("================================================");
        getSideDishes();
        output.println("================================================");
        querySideDishes("Fish");
        output.println("================================================");
        getFriedSideDishes();
        output.println("================================================");
        getSteamedSideDishes();
        output.println("================================================");
        getSauteedSideDishes();
        output.println("================================================");

        output.println("\n\n\nIngredients");
        output.println("================================================");
        getAllIngredients();
        output.println("================================================");
        getIngredientsIsUsedIn("Carrot");

        output.close();
    }
    

    public static void getAllFood() {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food");

            output.println("\nRetrieving all food resources (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();


            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getMainDishes() {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/main_course");
            Response response;

            // === Retrieve all movies using a GET request and XML representation ===
            // =========================================================================
            output.println();
            output.println("Retrieving all main_course (XML representation)");

            // perform a GET request, asking for an XML representation
            output.println("Making response");
            response = target.request(MediaType.APPLICATION_XML).get();
            output.println("getMainDishes response made");


            if (response.getStatus() != 200) {
                output.println("Status is not 200");
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
            output.println("getMainDishes response closed");

        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getGravyDishes() {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/main_course/gravy_dish");

            output.println("\nRetrieving all gravy dishes (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getDryDishes() {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/main_course/dry_dish");

            output.println("\nRetrieving all dry dishes (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void queryMainDishes(String s) {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/main_course/search?dish=" + s);
            Response response;

            // === Retrieve all movies using a GET request and XML representation ===
            // =========================================================================
            output.println();
            output.println("Retrieving main course query (XML representation)");

            // perform a GET request, asking for an XML representation
            output.println("Making response");
            response = target.request(MediaType.APPLICATION_XML).get();
            output.println("queryMainDishes response made");


            if (response.getStatus() != 200) {
                output.println("Status is not 200");
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
            output.println("queryMainDishes response closed");
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getMustContain(String s) {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/main_course/" + s + "/mustContain");

            output.println("\nRetrieving what ingredients " + s + " must contain (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getConsistsOf(String s) {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/main_course/" + s + "/consistsOf");

            output.println("\nRetrieving what ingredients " + s + " consists of (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getGoesWith(String s) {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/main_course/" + s + "/goesWith");

            output.println("\nRetrieving what dishes " + s + " goes with best (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getIsOfDiet(String s) {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/main_course/is_of_diet/" + s);

            output.println("\nRetrieving what dishes are of diet: " + s + " (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getSideDishes() {

        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/side_dish");

            output.println("\nRetrieving all side_dish (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();
            output.println("getSideDisehes response made");


            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
            output.println("getSideDisehes response closed");
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void querySideDishes(String s) {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/side_dish/search?dish=" + s);

            output.println("\nRetrieving all side dishes that contain the search term: " + s + " (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();


            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getFriedSideDishes() {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/side_dish/fried_side_dish");

            output.println("\nRetrieving all fried side dishes (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getSteamedSideDishes() {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/side_dish/steamed_side_dish");

            output.println("\nRetrieving all steamed side dishes (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getSauteedSideDishes() {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/side_dish/sauteed_side_dish");

            output.println("\nRetrieving all sauteed side dishes (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getSoups() {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/soup");

            output.println("\nRetrieving all soups (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getBeverages() {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/beverage");

            output.println("\nRetrieving all beverages (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getDesserts() {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/dessert");

            output.println("\nRetrieving all desserts (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        }
        catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getSnack() {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/snack");

            output.println("\nRetrieving all snacks (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        } catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getAllIngredients() {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/ingredient");

            output.println("\nRetrieving all ingredients (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        } catch (Exception e) {
            output.println(e.toString());
        }
    }

    public static void getIngredientsIsUsedIn(String s) {
        try {

            ResteasyClient client = new ResteasyClientBuilder().build();
            Response response;

            ResteasyWebTarget target = client.target("http://localhost:8080/ei_web_service/api/food/" + s +"/is_used_in");

            output.println("\nRetrieving everything ingredient " + s + " is used in (XML representation)");

            response = target.request(MediaType.APPLICATION_XML).get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("GET Request failed: HTTP code: " + response.getStatus());
            } else {
                output.println("Response status: " + response.getStatus());

                String p = response.readEntity(String.class);
                output.println(prettyPrintXML(p));
            }
            response.close();
        } catch (Exception e) {
            output.println(e.toString());
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
