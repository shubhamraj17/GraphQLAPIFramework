package tests;

import helper.GraphQLHelper;
import validation.Validations;

public class BaseTest {
    GraphQLHelper helper;
    Validations validations;

    public BaseTest(){
        helper=new GraphQLHelper();
        validations= new Validations();
    }
}
