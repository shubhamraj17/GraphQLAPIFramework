package helper;

import constant.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.*;

public class GraphQLHelper extends BaseHelper{


    public String setQueryBody(String Queryinput ){
        String queryBody="query Test1($input: TokensInput!) { Tokens(input: $input) { Token {"+ Queryinput +" } }  }";
        return queryBody;
    }
    public Response graphQLHelper(Query query,String blockchain,Integer limit,String address_eq,String cursor,String queryInput){
        String queryBody= setQueryBody(queryInput);
        query.setQuery(queryBody);
        QueryVariable variable= new QueryVariable();
        Address address=new Address();
        address.set_eq(address_eq);
        Filter filter= new Filter();
        filter.setAddress(address);
        Input input=new Input();
        input.setBlockchain(blockchain);
        input.setLimit(limit);
        input.setCursor(cursor);
        input.setFilter(filter);
        variable.setInput(input);

        query.setVariables(variable);

        Response response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(query)
                .when().post(Endpoints.GRAPH_QL_ENDPOINT)
                .thenReturn();
        response.prettyPrint();

        return response;

    }
}
