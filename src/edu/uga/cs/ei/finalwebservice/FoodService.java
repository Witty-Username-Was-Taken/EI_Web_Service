package edu.uga.cs.ei.finalwebservice;

import org.apache.jena.rdf.model.ResourceFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    public Response getMainCourses()
            //@QueryParam("dish") String dish) {
    {

        List<Food> list = new ArrayList<>();

        System.out.println("In the getMainCourses method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectlabel " +
                "WHERE { " +
                    "?class a owl:Class. " +
                    "?class rdfs:label ?classlabel." +
                    "?class rdfs:subClassOf ?parent." +
                    "?parent rdfs:label \"Main_Course\"." +
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
    @Path("/side_dish")
    @Produces(MediaType.APPLICATION_XML)
    public Response getSideDishes(
            @QueryParam("dish") String dish) {

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

    /*@GET
    @Path("/side_dish/gravy_dish")
    @Produces(MediaType.APPLICATION_XML)
    public Response getGravyDishes() {


        ArrayList<Food> results = runQuery(query);

        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }*/



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
