
import Library.UtilLib;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class interview {


    public static void main(String[] args) {
        /* Sample way reponse  was fetched */
       // Response response = RestAssured.get("http://localhost:3000/test");
      //   JsonPath jsonPath = new JsonPath(response.asString());

        //Sample wasy to call the function. Please READ.MD to know about the paramter

        UtilLib.getVehiclesByType(response, "Manual");


    }
}


