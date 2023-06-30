package dataProvider;

import org.testng.annotations.DataProvider;

public class QueryVariableDP {

    @DataProvider(name = "GraphQLSchemaDP")
    public Object[][] GraphQLSchemaDP(){
        return new Object[][]{
                {"ethereum",10,"0x60e4d786628fea6478f785a6d7e704777c86a7c6","","id address chainId name symbol type totalSupply decimals baseURI\n" +
                        "lastTransferTimestamp lastTransferBlock lastTransferHash\n" +
                        "contractMetaData { description} logo { medium original } tokenBalances { tokenId amount blockchain }"},
        };
    }

    @DataProvider(name = "sampleReqDP")
    public Object[][] sampleQueryVariableDP(){
        return new Object[][]{
                {"ethereum",10,"0x60e4d786628fea6478f785a6d7e704777c86a7c6","","id address"},
                {"ethereum",9,"0x60e4d786628fea6478f785a6d7e704777c86a7c6","","id address"}
        };
    }

    @DataProvider(name = "negativeQueryVarDPWrongInputs")
    public Object[][] negativeQueryVarDPWrongInputs(){
        return new Object[][]{
                {"bitcoin",10,"0x60e4d786628fea6478f785a6d7e704777c86a7c6","","id address"},
                {"ethereum",10,"@0x60e4d786628fea6478f785a6d7e704777c86a7c","","id address"},

        };
    }

    @DataProvider(name = "negativeQueryVarDPInvalidChar")
    public Object[][] negativeQueryVarDPInvalidChar(){
        return new Object[][]{
                {"@#%./",10,"0x60e4d786628fea6478f785a6d7e704777c86a7c6","","id address"},
                {"ethereum",10,"@0x60e4d786628fea6478f785a6d7e704777c86a7c@@@123455","","id address"},
        };
    }

    @DataProvider(name = "negativeQueryVarDPInvalidCursorInputs")
    public Object[][] negativeQueryVarDPInvalidCursorInputs(){
        return new Object[][]{
                {"ethereum",10,"0x60e4d786628fea6478f785a6d7e704777c86a7c6","100","id address"},
                {"ethereum",10,"0x60e4d786628fea6478f785a6d7e704777c86a7c6","@#$./","id address"},

        };
    }

    @DataProvider(name = "negativeQueryInput")
    public Object[][] negativeQueryInput(){
        return new Object[][]{
                {"ethereum",10,"0x60e4d786628fea6478f785a6d7e704777c86a7c6","100","@!#$"},
                {"ethereum",10,"0x60e4d786628fea6478f785a6d7e704777c86a7c6","@#$./","idaddressname"},

        };
    }
}
