package edu.uga.cs.ei.finalwebservice;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * Created by Isai B. Cicourel
 */
public class RDF_Test {


    /**
     * Query an Endpoint using the given SPARQl query
     * @param szQuery
     * @param szEndpoint
     * @throws Exception
     */
    public void queryEndpoint(String szQuery, String szEndpoint)
            throws Exception
    {
        // Create a Query with the given String
        Query query = QueryFactory.create(szQuery);

        // Create the Execution Factory using the given Endpoint
        QueryExecution qexec = QueryExecutionFactory.sparqlService(
                szEndpoint, query);

        // Set Timeout
        ((QueryEngineHTTP)qexec).addParam("timeout", "10000");


        // Execute Query
        int iCount = 0;
        ResultSet rs = qexec.execSelect();
        //String s = prettyPrintXML(ResultSetFormatter.asXMLString(rs));
        //System.out.println(s);

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
                String szVar = itVars.next().toString();
                String szVal = qs.get(szVar).toString();
                Resource r = ResourceFactory.createProperty(szVal);
                //System.out.println("Resource: " + r.toString());
                Model m = r.getModel();

                System.out.println("[" + szVar + "]: " + szVal);
            }
        }


    } // End of Method: queryEndpoint()

    public static void main(String[] args) throws IOException {
        // SPARQL Query
        String szQuery = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "select distinct ?label where {?Subject rdfs:label ?label} LIMIT 100";

        // Arguments
        if (args != null && args.length == 1) {
            szQuery = new String(
                    Files.readAllBytes(Paths.get(args[0])),
                    Charset.defaultCharset());
        }

        // Food Ontology Endpoint
        String szEndpoint = "http://localhost:3030/Food/query";

        // Query DBPedia
        try {
            RDF_Test q = new RDF_Test();
            q.queryEndpoint(szQuery, szEndpoint);
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
