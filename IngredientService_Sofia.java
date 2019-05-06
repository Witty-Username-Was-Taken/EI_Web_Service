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

/**
 * URI path List                                     =======================================================================================
 * /Ingredient                                       GET -> list of subclasses of Ingredient resources in ontology
 * /Ingredient/subClasses                            GET -> list of individuals of Ingredient resources in ontology
 * /Ingredient/Main_Ingredient                       GET -> list of individuals of Main Ingredient resources in Ontology
 * /Ingredient/Main_Ingrdient/subClasses             GET -> list of subclasses of Main Ingredient resources in Ontology
 * /Ingredient/Main_Ingredient/Fish/subClasses       GET -> list of subclasses of Fish Class in ontology
 * /Ingredient/Main_Ingredient/Fish                  GET -> list of individuals of Fish resources in Ontology
 * /Ingredient/Main_Ingredient/Meat                  GET -> list of individuals of Meat resources in Ontology
 * /Ingredient/Main_Ingredient/Vegetables            GET -> list of individuals of Vegetables resources in Ontology
 * /Ingredient/Main_Ingredient/Cereals               GET -> list of individuals of Cereals resources in Ontology
 * /Ingredient/Side_Ingredient/subClasses            GET -> list of subclasses of Side Ingredient in Ontology
 * /Ingredient/Side_Ingredient                       GET -> list of all individuals of Side Ingredient in Ontology
 * /Ingredient/Side_Ingredient/Herbs                 GET -> list of all individuals of Herbs resources in Ontology
 * /Ingredient/Side_Ingredient/Oil                   GET -> list of all individuals of Oil resources in Ontology
 * /Ingredient/Side_Ingredient/Masala                GET -> list of all individuals of Masala resources in Ontology
 * /Ingredient/Side_Ingredient/Spices                GET -> list of all individuals of Spices resources in Ontology
 * /Ingredient/Main_Ingredient/Fish/Fresh_Water_Fish GET -> list of all individuals of Fresh Water Fish resources in ontology
 * /Ingredient/Main_Ingredient/Fish/Sea_Fish         GET -> list of all individuals of Sea Fish resources in Ontology
 * /Ingredient/Main_Ingredient/Fish/Shell_Fish       GET -> list of all individuals of Shell Fish resources in Ontology
 * /Ingredient/isUsedIn                              GET -> list of all individuals the ingredient is used in Ontology
*/


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
@Path("/ingredient/main_ingredient")
public class IngredientService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getIngredients() {
        System.out.println("In the getIngredients method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?class rdfs:label \"Main_Ingredient\"." +
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

@Path("/ingredient/main_ingredient/fish")
public class IngredientService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getIngredients() {
        System.out.println("In the getIngredients method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?class rdfs:label \"Fish\"." +
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
@Path("/ingredient/main_ingredient/meat")
public class IngredientService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getIngredients() {
        System.out.println("In the getIngredients method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?class rdfs:label \"Meat\"." +
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

@Path("/ingredient/main_ingredient/Vegetables")
public class IngredientService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getIngredients() {
        System.out.println("In the getIngredients method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?class rdfs:label \"Vegetables\"." +
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

@Path("/ingredient/main_ingredient/Cereals")
public class IngredientService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getIngredients() {
        System.out.println("In the getIngredients method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?class rdfs:label \"Cereals\"." +
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

@Path("/ingredient/side_ingredient")
public class IngredientService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getIngredients() {
        System.out.println("In the getIngredients method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?class rdfs:label \"Side_Ingredient\"." +
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

@Path("/ingredient/side_ingredient/herbs")
public class IngredientService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getIngredients() {
        System.out.println("In the getIngredients method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?class rdfs:label \"Herbs\"." +
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

@Path("/ingredient/side_ingredient/oil")
public class IngredientService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getIngredients() {
        System.out.println("In the getIngredients method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?class rdfs:label \"Oil\"." +
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

@Path("/ingredient/side_ingredient/masala")
public class IngredientService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getIngredients() {
        System.out.println("In the getIngredients method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?class rdfs:label \"Masala\"." +
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

@Path("/ingredient/side_ingredient/spices")
public class IngredientService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getIngredients() {
        System.out.println("In the getIngredients method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?class rdfs:label \"Spices\"." +
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

@Path("/ingredient/main_ingredient/fish/fresh_water_fish")
public class IngredientService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getIngredients() {
        System.out.println("In the getIngredients method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?class rdfs:label \"Fresh_Water_Fish\"." +
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

@Path("/ingredient/main_ingredient/fish/shell_fish")
public class IngredientService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getIngredients() {
        System.out.println("In the getIngredients method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?class rdfs:label \"Shell_Fish\"." +
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

@Path("/ingredient/main_ingredient/fish/sea_fish")
public class IngredientService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getIngredients() {
        System.out.println("In the getIngredients method");

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
                "?class rdfs:label \"Sea_Fish\"." +
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

        String query = RDFS +  " " + OWL + " SELECT DISTINCT ?subjectLabel " +
                "WHERE { " +
  			        "?subject ?predicate ?object." +
                    "?predicate rdfs:label \"isUsedIn\"." +
                    "?subject rdfs:label ?subjectLabel." +
                    "?object rdfs:label \"" + ingredient + "\"." +
                "}";

        ArrayList<Food> results = QueryRunner.runQuery(query);
        GenericEntity<List<Food>> entity;
        entity = new GenericEntity<List<Food>>(results){};
        Response response = Response.ok(entity).build();

        return response;
    }
}
