package com.test;
import java.util.*;

public class AppleTest {
    public static class CarRegistry {

        /**
         * Register a vehicle id by its manufacturer, model and color so that the vehicle id can later be
         * retrieved by calling the get method with the same parameters.
         *
         * @param manufacturer the car's manufacturer
         * @param model the car's model
         * @param color the car's color
         * @param vehicleId the car's vehicle id
         */
        public void put(String manufacturer, String model, String color, String vehicleId)         {
            //Validation
            //List<String> vehicleIdList = carInventory.getOrDefault(manufacturer+model+color,new ArrayList<>());
            //vehicleIdList.add(vehicleId);
            //carInventory.put(manufacturer+model+color, vehicleIdList);
            //throw new UnsupportedOperationException();
        }

        /**
         * Get a String[] of vehicle ids for the given manufacture, model and color.  Any of the parameters
         * can be null, in which case this will return all matches for that parameter.  E.g., If the registry
         * contains a blue Honda Accord and a red Honda Accord, passing in "Honda", "Accord" and null as
         * parameters will return the vehicleIds for both the blue and red Accords.
         *
         * @param manufacturer the car's manufacturer
         * @param model the car's model
         * @param color the car's color
         * @return a String[] of vehicle ids match the given manufacture, model and color
         */
        public static Map<String,Map<String,Map<String,List<String>>>> carInventory=new HashMap<>();
        //public static Map<String,List<String>> carInventory=new HashMap<>();

        public String[] get(String manufacturer, String model, String color) {
            Map<String,Map<String,List<String>>> modelColorCarRegistry;
            if(manufacturer!=null)
            {
                modelColorCarRegistry = carInventory.getOrDefault(manufacturer,new HashMap<>());
            }
            else
            {
                modelColorCarRegistry=new HashMap<>();
                for(Map map:carInventory.values())
                {
                    //map.forEach((key,value)->modelColorCarRegistry.merge(key,value,(v1,v2)->v1));
                }
            }

            Map<String,List<String>> colorCarRegistry;
            if(model!=null)
            {
                colorCarRegistry = modelColorCarRegistry.getOrDefault(model,new HashMap<>());
            }
            else
            {
                colorCarRegistry=new HashMap<>();
                for(Map map:modelColorCarRegistry.values())
                {
                   // map.forEach((key,value)->colorCarRegistry.merge(key,value,(v1,v2)->v1.addAll(v2)?v1:v1));
                }
            }
            if(color!=null)
                return  colorCarRegistry.getOrDefault(color,new ArrayList<>()).toArray(new String[0]);
            else
                return   colorCarRegistry.values().toArray(new String[0]);
            //String key = manufacturer+model+color;
            //System.out.println(key);

            //return carInventory.get(key).toArray(new String[0]);
            //throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        CarRegistry registry = new CarRegistry();
        registry.put("Ford", "Mustang", "red", "123");
        registry.put("Ford", "Mustang", "black", "456");
        registry.put("Ford", "Mustang", "black", "789");
        registry.put("Honda", "Accord", "red", "321");
        registry.put("Honda", "Accord", "blue", "987");
        registry.put("Honda", "Accord", "blue", "654");
        registry.put("Honda", "Accord", "red", "321");

        verify(registry.get("Ford", "Mustang", "red"), "123");
        verify(registry.get("Ford", "Mustang", "black"), "456", "789");
        verify(registry.get("Honda", "Accord", "blue"), "987", "654");
        verify(registry.get("Honda", "Accord", "red"), "321");
        // verify(registry.get("Tesla", "Roadster", "grey"));

        verify(registry.get("Honda", "Accord", null), "987", "654", "321");
        verify(registry.get(null, null, "red"), "123", "321");
        System.out.println("Success!");
    }

    // Verify that the actual and expected arrays match as Sets
    private static void verify(String[] actualVehicleIds, String... expectedVehicleIds) {
        if(actualVehicleIds.length!= actualVehicleIds.length);
           System.out.println("Test Failed");
        //assertEquals(new HashSet<>(Arrays.asList(expectedVehicleIds)), new HashSet<>(Arrays.asList(actualVehicleIds)));
    }
}

