package validation;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import model.Responses.GraphqlApiResponse;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.File;

import static constant.Constants.BLOCKCHAIN;
import static constant.Constants.GraphQLJSON_SCHEMA_FILE;

public class Validations {

   public void validateApiResponse(Response response,String address_eq){
       Assert.assertEquals(response.statusCode(),HttpStatus.SC_OK);
       ResponseBody body= response.getBody();
       GraphqlApiResponse responseBody= body.as(GraphqlApiResponse.class);
        Assert.assertEquals(responseBody.getData().getTokens().getToken().get(0).getAddress(),address_eq);
        Assert.assertFalse(responseBody.getData().getTokens().getToken().get(0).getId().isEmpty());
   }
    public void validateNegativeScenarios(Response response,String Blockchain){
       if(Blockchain.equals(BLOCKCHAIN)){
           Assert.assertEquals(response.statusCode(),HttpStatus.SC_OK);
           Assert.assertEquals(response.statusCode(),HttpStatus.SC_OK);
           ResponseBody body= response.getBody();
           GraphqlApiResponse responseBody= body.as(GraphqlApiResponse.class);
           Assert.assertTrue(responseBody.getData().getTokens().getToken()==null);
       }else

        Assert.assertEquals(response.statusCode(),HttpStatus.SC_UNPROCESSABLE_ENTITY);
    }

    public void validateInvalidCursorInputs(Response response){
        Assert.assertEquals(response.statusCode(),HttpStatus.SC_OK);
        JSONObject resp= new JSONObject(response.asString());
        JSONArray errors= resp.getJSONArray("errors");
        JSONObject errorBody= errors.getJSONObject(0);
        String message= errorBody.getString("message");
        JSONObject extensions= errorBody.getJSONObject("extensions");
        String code= extensions.getString("Code");
        String internal_error_code= extensions.getString("Internal_Error_Code");
        String reference= extensions.getString("Reference");

        Assert.assertEquals(message,"Input Cursor is not valid");
        Assert.assertEquals(code,"Query Error");
        Assert.assertEquals(internal_error_code,"p_s_sh_HMQ_5");
        Assert.assertEquals(reference,"http://docs.airstack.xyz/errors/ERROR_004");

        ResponseBody body= response.getBody();
        GraphqlApiResponse responseBody= body.as(GraphqlApiResponse.class);
        Assert.assertTrue(responseBody.getData().getTokens()==null);

    }

    public void validateJsonSchemaResponse(Response response){
        Assert.assertEquals(response.statusCode(),HttpStatus.SC_OK);
        File schema = new File(GraphQLJSON_SCHEMA_FILE);
        response.then().body(JsonSchemaValidator.matchesJsonSchema(schema));
    }

    public void validateInvalidQueryBody(Response response){
        Assert.assertEquals(response.statusCode(),HttpStatus.SC_OK);
        JSONObject resp= new JSONObject(response.asString());
        JSONArray errors= resp.getJSONArray("errors");
        JSONObject errorBody= errors.getJSONObject(0);
        String message= errorBody.getString("message");
        JSONObject extensions= errorBody.getJSONObject("extensions");
        String code= extensions.getString("Code");
        String internal_error_code= extensions.getString("Internal_Error_Code");
        String reference= extensions.getString("Reference");

        Assert.assertEquals(message,"Input Cursor is not valid");
        Assert.assertEquals(code,"Query Error");
        Assert.assertEquals(internal_error_code,"p_s_sh_HMQ_5");
        Assert.assertEquals(reference,"http://docs.airstack.xyz/errors/ERROR_004");
    }
}
