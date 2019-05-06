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

@Path("/ingredient")
public class IngredientService {

    private static final String RDFS = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>";
    private static final String OWL = "PREFIX owl: <http://www.w3.org/2002/07/owl#>";

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getIngredients() {
        System.out.println("In the getIngredients method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?class rdfs:label \"Ingredient\"." +
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
    @Path("/{ingredient}/is_used_in")
    @Produces(MediaType.APPLICATION_XML)
    public Response getFoodUsedIn(@PathParam("ingredient") String ingredient) {
        System.out.println("In the getFoodUsedIn method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?objectLabel " +
                "WHERE { " +
  			        "?subject ?predicate ?object." +
                    "?predicate rdfs:label \"isUsedIn\"." +
                    "?subject rdfs:label \"" + ingredient + "\"." +
                    "?object rdfs:label ?objectLabel." +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);
        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }
}
