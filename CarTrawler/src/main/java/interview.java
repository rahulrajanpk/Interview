
import Library.UtilLib;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class interview {


    public static void main(String[] args) {
        Response response = RestAssured.get("http://localhost:3000/test");
        JsonPath jsonPath = new JsonPath(response.asString());

        UtilLib.getCheapestCarList(response);
        UtilLib.getVehiclesByType(response, "Manual");
        UtilLib.sortByPriceInGroup(response);

    }
}


