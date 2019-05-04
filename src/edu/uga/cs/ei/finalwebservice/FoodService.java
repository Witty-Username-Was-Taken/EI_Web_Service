package edu.uga.cs.ei.finalwebservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/food")
public class FoodService {

    private static final String ENDPOINT = "http://localhost:3030/Food/query";
    private static final String RDFS = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>";
    private static final String OWL = "PREFIX owl: <http://www.w3.org/2002/07/owl#>";

    @GET
    @Path("/main_course")
    @Produces(MediaType.APPLICATION_XML)
    public Response getMainCourses() {
        System.out.println("In the getMainCourses method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectlabel " +
                "WHERE { " +
                    "?class a owl:Class. " +
                    "?class rdfs:label ?classlabel." +
                    "?class rdfs:subClassOf ?parent." +
                    "?parent rdfs:label \"Main_Course\"." +
                    "?subject a ?class." +
                    "?subject rdfs:label ?subjectlabel." +
                "}";

        ArrayList<Food> results = runQuery(query);
        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/main_course/{course}/mustContain")
    @Produces(MediaType.APPLICATION_XML)
    public Response courseMustContain( @PathParam("course") String course ) {
        System.out.println("In the courseMustContain method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?ingredient " +
                " WHERE {" +
                "?subject ?predicate ?object." +
                "?predicate rdfs:label \"mustContain\"." +
                "?subject rdfs:label \"" + course + "\")." +
                "?object rdfs:label ?ingredient" +
                "}";

        ArrayList<Food> results = runQuery(query);
        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/main_course/{course}/consistsOf")
    @Produces(MediaType.APPLICATION_XML)
    public Response courseConsistsOf( @PathParam("course") String course ) {
        System.out.println("In the courseConsistsOf method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?ingredient " +
                " WHERE {" +
                "?subject ?predicate ?object." +
                "?predicate rdfs:label \"consists_of\"." +
                "?subject rdfs:label \"" + course + "\")." +
                "?object rdfs:label ?ingredient" +
                "}";

        ArrayList<Food> results = runQuery(query);
        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/main_course/{course}/goesWith")
    @Produces(MediaType.APPLICATION_XML)
    public Response courseGoesWith(@PathParam("course") String course) {
        System.out.println("In the courseGoesWith method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?objectlabel " +
            "WHERE { " +
                    "?subject rdfs:label \"" + course + "\"." +
                    "?subject ?predicate ?object." +
                    "?predicate rdfs:label \"goesWith\"." +
                    "?object rdfs:label ?objectlabel." +
            "}";

        ArrayList<Food> results = runQuery(query);
        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/side_dish")
    @Produces(MediaType.APPLICATION_XML)
    public Response getSideDishes() {

        List<Food> list = new ArrayList<>();

        System.out.println("In the getSideDishes method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectlabel " +
                "WHERE { " +
                "?class a owl:Class. " +
                "?class rdfs:label ?classlabel." +
                "?class rdfs:subClassOf ?parent." +
                "?parent rdfs:label \"Side_Dish\"." +
                "?subject a ?class." +
                "?subject rdfs:label ?subjectlabel" +
                "}";

        ArrayList<Food> results = runQuery(query);

        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/main_course/gravy_dish")
    @Produces(MediaType.APPLICATION_XML)
    public Response getGravyDishes() {


        List<Food> list = new ArrayList<>();

        System.out.println("In the getGravyDishes method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectlabel " +
                "WHERE { " +
                "?class a owl:Class. " +
                "?class rdfs:label \"Gravy_Dish\"." +
                "?subject rdfs:label ?subjectlabel." +
                "?subject a ?class." +
                "}";

        ArrayList<Food> results = runQuery(query);

        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }


    @GET
    @Path("/main_course/dry_dish")
    @Produces(MediaType.APPLICATION_XML)
    public Response getDryDishes() {


        List<Food> list = new ArrayList<>();

        System.out.println("In the getDryDishes method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectlabel " +
                "WHERE { " +
                "?class a owl:Class. " +
                "?class rdfs:label \"Dry_Dish\"." +
                "?subject rdfs:label ?subjectlabel." +
                "?subject a ?class." +
                "}";

        ArrayList<Food> results = runQuery(query);

        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/side_dish/fried_side_dish")
    @Produces(MediaType.APPLICATION_XML)
    public Response getFriedSideDishes() {

        System.out.println("In the getFriedSideDishes method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectlabel " +
                "WHERE { " +
                "?class a owl:Class. " +
                "?class rdfs:label \"Fried_SIde_Dish\"." +
                "?subject rdfs:label ?subjectlabel." +
                "?subject a ?class." +
                "}";

        ArrayList<Food> results = runQuery(query);

        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/side_dish/steamed_side_dish")
    @Produces(MediaType.APPLICATION_XML)
    public Response getSteamedSideDishes() {

        System.out.println("In the getSteamed method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectlabel " +
                "WHERE { " +
                "?class a owl:Class. " +
                "?class rdfs:label \"Steamed_Side_Dish\"." +
                "?subject rdfs:label ?subjectlabel." +
                "?subject a ?class." +
                "}";

        ArrayList<Food> results = runQuery(query);

        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/side_dish/sauteed_side_dish")
    @Produces(MediaType.APPLICATION_XML)
    public Response getSauteedSideDishes() {

        System.out.println("In the getSauteedSideDishes method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectlabel " +
                "WHERE { " +
                "?class a owl:Class. " +
                "?class rdfs:label \"Sauteed_Side_Dish\"." +
                "?subject rdfs:label ?subjectlabel." +
                "?subject a ?class." +
                "}";

        ArrayList<Food> results = runQuery(query);

        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/soup")
    @Produces(MediaType.APPLICATION_XML)
    public Response getSoups() {

        System.out.println("In the getSoups method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectlabel " +
                "WHERE { " +
                "?class a owl:Class. " +
                "?class rdfs:label \"Soup\"." +
                "?subject rdfs:label ?subjectlabel." +
                "?subject a ?class." +
                "}";

        ArrayList<Food> results = runQuery(query);

        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/beverage")
    @Produces(MediaType.APPLICATION_XML)
    public Response getBeverages() {
        List<Food> list = new ArrayList<>();

        System.out.println("In the getBeverages method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectlabel " +
                "WHERE { " +
                "?class a owl:Class. " +
                "?class rdfs:label \"Beverage\"." +
                "?subject rdfs:label ?subjectlabel." +
                "?subject a ?class." +
                "}";

        ArrayList<Food> results = runQuery(query);

        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/dessert")
    @Produces(MediaType.APPLICATION_XML)
    public Response getDesserts() {

        System.out.println("In the getDesserts method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectlabel " +
                "WHERE { " +
                "?class a owl:Class. " +
                "?class rdfs:label \"Dessert\"." +
                "?subject rdfs:label ?subjectlabel." +
                "?subject a ?class." +
                "}";

        ArrayList<Food> results = runQuery(query);

        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/snack")
    @Produces(MediaType.APPLICATION_XML)
    public Response getSnacks() {
        List<Food> list = new ArrayList<>();

        System.out.println("In the getSnacks method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectlabel " +
                "WHERE { " +
                "?class a owl:Class. " +
                "?class rdfs:label \"Snack\"." +
                "?subject rdfs:label ?subjectlabel." +
                "?subject a ?class." +
                "}";

        ArrayList<Food> results = runQuery(query);

        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }


    private ArrayList<Food> runQuery(String query) {
        ArrayList<Food> results = new ArrayList<Food>();

        try {
            results = QueryRunner.executeQuery(ENDPOINT, query);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        return results;
    }
}
