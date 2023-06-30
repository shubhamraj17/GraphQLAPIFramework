package tests;

import dataProvider.QueryVariableDP;
import io.restassured.response.Response;
import model.Query;
import org.testng.annotations.Test;

import java.io.IOException;

public class GraphQLTest extends BaseTest{

    @Test(alwaysRun = true,dataProvider = "GraphQLSchemaDP",dataProviderClass = QueryVariableDP.class)
    public void validateGraphQLSchema(String blockchain,Integer limit,String address_eq,String cursor,String queryInput){
        Query query = new Query();
        Response response = helper.graphQLHelper(query,blockchain,limit,address_eq,cursor, queryInput );
        validations.validateJsonSchemaResponse(response);
    }

    @Test(alwaysRun = true,dataProvider = "sampleReqDP",dataProviderClass = QueryVariableDP.class)
    public void validatePartialRequestGraphqlRequest(String blockchain,Integer limit,String address_eq,String cursor,String queryInput)   {
        Query query = new Query();
        Response response = helper.graphQLHelper(query,blockchain,limit,address_eq,cursor, queryInput );
        validations.validateApiResponse(response,address_eq);
    }

    @Test(alwaysRun = true,dataProvider = "negativeQueryVarDPWrongInputs",dataProviderClass = QueryVariableDP.class)
    public void validateNegativeScenarioWrongInputs(String blockchain,Integer limit,String address_eq,String cursor,String queryInput)  {
        Query query = new Query();
        Response response = helper.graphQLHelper(query,blockchain,limit,address_eq,cursor, queryInput);
        validations.validateNegativeScenarios(response,blockchain);
    }

    @Test(alwaysRun = true,dataProvider = "negativeQueryVarDPInvalidChar",dataProviderClass = QueryVariableDP.class)
    public void validateNegativeScenarioInvalidCharacters(String blockchain,Integer limit,String address_eq,String cursor,String queryInput)  {
        Query query = new Query();
        Response response = helper.graphQLHelper(query,blockchain,limit,address_eq,cursor, queryInput);
        validations.validateNegativeScenarios(response,blockchain);
    }

    @Test(alwaysRun = true,dataProvider = "negativeQueryVarDPInvalidCursorInputs",dataProviderClass = QueryVariableDP.class)
    public void validateNegativeScenarioCursorInputs(String blockchain,Integer limit,String address_eq,String cursor,String queryInput)  {
        Query query = new Query();
        Response response = helper.graphQLHelper(query,blockchain,limit,address_eq,cursor, queryInput);
        validations.validateInvalidCursorInputs(response);
    }

    @Test(alwaysRun = true,dataProvider = "negativeQueryVarDPInvalidCursorInputs",dataProviderClass = QueryVariableDP.class)
    public void validateNegativeScenarioWithInvalidQueryBody(String blockchain,Integer limit,String address_eq,String cursor,String queryInput)  {
        Query query = new Query();
        Response response = helper.graphQLHelper(query,blockchain,limit,address_eq,cursor, queryInput);
        validations.validateInvalidCursorInputs(response);
    }
}
