package org.amaap.credit.card.manager.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreditCard {
    private static List<Map<List<Integer>, List<String>>> dataList = new ArrayList<>();

    public static boolean card(int id, String name, String email) {
        // Check if the ID already exists in the list
        for (Map<List<Integer>, List<String>> map : dataList) {
            for (List<Integer> ids : map.keySet()) {
                if (ids.contains(id)) {
                    System.out.println(dataList);
                    throw new IllegalArgumentException("ID " + id + " already exists");
                }
            }
        }

        // If ID doesn't exist, proceed with adding the data
        List<Integer> idList = new ArrayList<>();
        List<String> nameEmailList = new ArrayList<>();

        // Adding values to the lists
        idList.add(id);
        nameEmailList.add(name);
        nameEmailList.add(email);

        // Creating a map to store ID as key and name-email list as value
        Map<List<Integer>, List<String>> dataMap = new HashMap<>();
        dataMap.put(idList, nameEmailList);

        // Adding the map to the list


        System.out.println("Credit card Assigned..");
        return dataList.add(dataMap);
    }

    public static void clearDataList() {
        dataList.clear();
    }
}
