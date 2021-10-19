
import Library.UtilLib;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class interview {


    public static void main(String[] args) {
        /* Sample way response  was fetched */
        Response response = RestAssured.get("http://localhost:3000/test");
        JsonPath jsonPath = new JsonPath(response.asString());

        /*---------------------------------------------------------------------------------*/
        //Sample way to call the function. Please READ.MD to know more about the parameters
        /*--------------------------------------------------------------------------------*/
        //UtilLib.getCheapestCarList(response);
        //UtilLib.getVehiclesByType(response, "Manual");
        //UtilLib.sortByCorporate(response, Arrays.asList("FIREFLY","HERTZ","SIXT","AVIS","BUDGET","ENTERPRISE","THRIFTY"));
        System.out.println(UtilLib.sortByPriceInGroup(response));
    }
}


