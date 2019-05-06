package edu.uga.cs.ei.finalwebservice;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


/**
 * URI path List                                     =======================================================================================
 * /food                                             GET -> list of all food resources in ontology
 * /food/main_course                                 GET -> list of all main courses in ontology
 * /food/main_course/{course}/mustContain            GET -> list of main ingredients a given main course
 * /food/main_course/{course}/consistsOf             GET -> list of other ingredients in a given main course
 * /food/main_course/{course}/goesWith               GET -> list of other dishes that go with given main course
 * /food/main_course/is_of_diet/{diet}               GET -> list of dishes that are of a particular diet (Vegan, Vegetarian, Non-Vegetarian)
 * /food/side_dish                                   GET -> list of side dish resources in ontology
 * /food/main_course/gravy_dish                      GET -> list of gravy dish resources in ontology
 * /food/main_course/dry_dish                        GET -> list of dry dish resources in ontology
 * /food/side_dish/fried_side_dish                   GET -> list of fried side dish resources in ontology
 * /food/side_dish/steamed_side_dish                 GET -> list of steamed side dish resources in ontology
 * /food/side_dish/sauteed_side_dish                 GET -> list of sauteed side dish resources in ontology
 * /food/soup                                        GET -> list of soup resources in ontology
 * /food/beverage                                    GET -> list of beverage resources in ontology
 * /food/dessert                                     GET -> list of dessert resources in ontology
 * /food/snack                                       GET -> list of snack resources in ontology
 */

@Path("/food")
public class FoodService {

    private static final String RDFS = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>";
    private static final String OWL = "PREFIX owl: <http://www.w3.org/2002/07/owl#>";

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getFood() {
        System.out.println("In the getIngredients method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?class rdfs:label \"Food\"." +
                "?subclass rdfs:subClassOf* ?class." +
                "?subject a ?subclass." +
                "?subject rdfs:label ?subjectLabel" +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);
        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/main_course")
    @Produces(MediaType.APPLICATION_XML)
    public Response getMainCourses() {
        System.out.println("In the getMainCourses method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectlabel " +
                "WHERE { " +
                "?class rdfs:label \"Main_Course\"." +
                "?subclass rdfs:subClassOf* ?class." +
                "?subject a ?subclass." +
                "?subject rdfs:label ?subjectLabel" +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);
        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/main_course/search")
    @Produces(MediaType.APPLICATION_XML)
    public Response searchMainCourses(@QueryParam("dish") String dish) {
        System.out.println("In the getMainCourses method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectlabel " +
                "WHERE { " +
                "?class a owl:Class. " +
                "?class rdfs:label ?classlabel." +
                "?class rdfs:subClassOf ?parent." +
                "?parent rdfs:label \"Main_Course\"." +
                "?subject a ?class." +
                "?subject rdfs:label ?subjectlabel." +
                "filter contains(?subjectlabel, \"" + dish + "\")" +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);
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

        ArrayList<Food> results = QueryRunner.runQuery(query);
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

        ArrayList<Food> results = QueryRunner.runQuery(query);
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

        ArrayList<Food> results = QueryRunner.runQuery(query);
        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/main_course/is_of_diet/{diet}")
    @Produces(MediaType.APPLICATION_XML)
    public Response courseIsOfDiet(@PathParam("diet") String diet) {
        System.out.println("In the courseIsOfDiet method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?subject rdfs:label ?subjectLabel" +
                "?subject ?predicate ?object." +
                "?predicate rdfs:label \"isOfDiet\"." +
                "?object rdfs:label \"" + diet + "\"." +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);
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
                "?class rdfs:label \"Side_Dish\"." +
                "?subclass rdfs:subClassOf* ?class." +
                "?subject a ?subclass." +
                "?subject rdfs:label ?subjectLabel" +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);

        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

    @GET
    @Path("/side_dish/search")
    @Produces(MediaType.APPLICATION_XML)
    public Response searchSideDishes( @QueryParam("dish") String dish) {
        System.out.println("In the searchSideDishes method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectlabel " +
                "WHERE { " +
                "?class rdfs:label \"Side_Dish\"." +
                "?subclass rdfs:subClassOf* ?class." +
                "?subject a ?subclass." +
                "?subject rdfs:label ?subjectlabel." +
                "filter contains(?subjectlabel, \"" + dish + "\")" +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);
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
                "?class rdfs:label \"Gravy_Dish\"." +
                "?subclass rdfs:subClassOf* ?class." +
                "?subject a ?subclass." +
                "?subject rdfs:label ?subjectLabel" +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);

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
                "?class rdfs:label \"Dry_Dish\"." +
                "?subclass rdfs:subClassOf* ?class." +
                "?subject a ?subclass." +
                "?subject rdfs:label ?subjectLabel" +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);

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
                "?class rdfs:label \"Fried_SIde_Dish\"." +
                "?subclass rdfs:subClassOf* ?class." +
                "?subject a ?subclass." +
                "?subject rdfs:label ?subjectLabel" +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);

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
                "?class rdfs:label \"Steamed_Side_Dish\"." +
                "?subclass rdfs:subClassOf* ?class." +
                "?subject a ?subclass." +
                "?subject rdfs:label ?subjectLabel" +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);

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
                "?class rdfs:label \"Sauteed_Side_Dish\"." +
                "?subclass rdfs:subClassOf* ?class." +
                "?subject a ?subclass." +
                "?subject rdfs:label ?subjectLabel" +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);

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
                "?class rdfs:label \"Soup\"." +
                "?subclass rdfs:subClassOf* ?class." +
                "?subject a ?subclass." +
                "?subject rdfs:label ?subjectLabel" +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);

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
                "?class rdfs:label \"Beverage\"." +
                "?subclass rdfs:subClassOf* ?class." +
                "?subject a ?subclass." +
                "?subject rdfs:label ?subjectLabel" +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);

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
                "?class rdfs:label \"Dessert\"." +
                "?subclass rdfs:subClassOf* ?class." +
                "?subject a ?subclass." +
                "?subject rdfs:label ?subjectLabel" +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);

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
                "?class rdfs:label \"Snacks\"." +
                "?subclass rdfs:subClassOf* ?class." +
                "?subject a ?subclass." +
                "?subject rdfs:label ?subjectLabel" +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);

        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }

}
