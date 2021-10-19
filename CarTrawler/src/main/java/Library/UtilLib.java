package Library;

import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilLib {

    public static Map<String, Double> getCheapestCarList(Response response) {

        ArrayList<ArrayList<String>> carName = response.path("VehAvailRSCore.VehVendorAvails.VehAvails.VehAvailCore.Vehicle.VehMakeModel.Name");

        ArrayList<ArrayList<String>> totalCarPrice = response.path("VehAvailRSCore.VehVendorAvails.VehAvails.VehAvailCore.TotalCharge.RateTotalAmount");

        HashMap<String, Double> cheapestCarList = new HashMap();

        int iterator1 = 0, iterator2 = 0;
        while (iterator1 < carName.size())
        {
            while (iterator2 < carName.get(iterator1).size())
            {
                String carType = carName.get(iterator1).get(iterator2);
                if (cheapestCarList.containsKey(carType))
                {
                    Double min = cheapestCarList.get(carType);
                    Double tempMin = Double.parseDouble(totalCarPrice.get(iterator1).get(iterator2));

                    if (min > tempMin)
                    {
                        cheapestCarList.put(carType, tempMin);
                    }

                }
                else
                    {
                    cheapestCarList.put(carType, Double.parseDouble(totalCarPrice.get(iterator1).get(iterator2)));
                    }
                iterator2++;
            }
            iterator2 = 0;
            iterator1++;
        }

        return cheapestCarList;
    }


    public static List sortByCorporate(Response response,List<String> corporateDivision)
    {
        ArrayList<HashMap<?,HashMap<?,String>>> vendorObjects = response.path("VehAvailRSCore.VehVendorAvails");
        List<String> sortedCorporateDivisionList = corporateDivision.stream().sorted().collect(Collectors.toList());
        List<HashMap> ans=new ArrayList<>();
        int iterator=0;
        for(String division:sortedCorporateDivisionList)
        {

            while (iterator<vendorObjects.size())
            {
                String tempDivision=vendorObjects.get(iterator).get("Vendor").get("Division");

                if(tempDivision.equals(division))
                {
                    ans.add(vendorObjects.get(iterator));
                }
                iterator++;
            }
            iterator=0;

        }

       return ans;
    }



    public static List getVehiclesByType(Response response,String filterType) {
        ArrayList<ArrayList<String>> carTypes = response.path("VehAvailRSCore.VehVendorAvails.VehAvails.VehAvailCore.Vehicle.TransmissionType");
        ArrayList<ArrayList<String>> vehicles = response.path("VehAvailRSCore.VehVendorAvails.VehAvails.VehAvailCore.Vehicle");
        ArrayList ans = new ArrayList();

        int iterator1 = 0, iterator2 = 0;

        while (iterator1 < carTypes.size())
        {
            while (iterator2 < carTypes.get(iterator1).size()) {
                if (carTypes.get(iterator1).get(iterator2).equals(filterType)) {
                    ans.add(vehicles.get(iterator1));

                }
                iterator2++;
            }
            iterator2 = 0;
            iterator1++;

    }
       return ans;
    }

    public static List sortByPriceInGroup(Response response)
    {
        ArrayList<ArrayList<Double>> carPrices = response.path("VehAvailRSCore.VehVendorAvails.VehAvails.VehAvailCore.TotalCharge.RateTotalAmount");

        ArrayList<List> ans = new ArrayList<>();

        int iterator=0;
        while(iterator<carPrices.size())
        {
            ans.add( carPrices.get(iterator).stream().sorted().collect(Collectors.toList()));

            iterator++;
        }
        return ans;
    }
}
