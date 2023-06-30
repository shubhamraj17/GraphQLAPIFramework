package helper;

import io.restassured.RestAssured;
import utils.ConfigManager;

public class BaseHelper {

    public static final String BASE_URL= ConfigManager.getConfig("base_url");

    public BaseHelper(){
        RestAssured.baseURI=BASE_URL;
    }
}
