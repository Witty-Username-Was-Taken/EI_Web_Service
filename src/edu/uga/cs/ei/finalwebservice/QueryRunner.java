package edu.uga.cs.ei.finalwebservice;

import org.apache.jena.query.*;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;

import java.util.ArrayList;
import java.util.Iterator;

public class QueryRunner {

    private static final String ENDPOINT = "http://localhost:3030/Food/query";


    public static ArrayList<Food> executeQuery(String endpoint, String query) {
        ArrayList<Food> results = new ArrayList<Food>();

        try {
            System.out.println("Endpoint: " + endpoint);
            // Create a Query with the given String
            Query newQuery = QueryFactory.create(query);

            // Create the Execution Factory using the given Endpoint
            QueryExecution qexec = QueryExecutionFactory.sparqlService(
                    endpoint, query);

            // Set Timeout
            ((QueryEngineHTTP) qexec).addParam("timeout", "10000");


            // Execute Query
            int iCount = 0;
            ResultSet rs = qexec.execSelect();

            while (rs.hasNext()) {
                // Get Result
                QuerySolution qs = rs.next();

                // Get Variable Names
                Iterator<String> itVars = qs.varNames();

                // Count
                iCount++;
                System.out.println("Result " + iCount + ": ");

                // Display Result
                while (itVars.hasNext()) {
                    String variable = itVars.next().toString();
                    String value = qs.get(variable).toString();
                    Food f = new Food(value);
                    results.add(f);

                    System.out.println("[" + variable + "]: " + value);
                }
            }
            qexec.close();
        }

        catch (Exception e) {
            System.out.println("Exception");
            System.out.println(e.toString());
        }

        return results;
    }

    public static ArrayList<Food> runQuery(String query) {
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
