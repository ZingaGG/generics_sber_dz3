
package org.example;

import java.util.*;

import org.example.CollectionUtil;
import org.example.Model.CountMapImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1:");


        CountMapImpl<String> countMap = new CountMapImpl<>();

        countMap.add("a");
        countMap.add("b");
        countMap.add("a");
        countMap.add("c");
        countMap.add("b");
        countMap.add("a");

        System.out.println("Count for 'a': " + countMap.getCount("a"));
        System.out.println("Count for 'b': " + countMap.getCount("b"));
        System.out.println("Count for 'c': " + countMap.getCount("c"));

        System.out.println("Removing 'b', count was: " + countMap.remove("b"));
        System.out.println("Count for 'b' after remove: " + countMap.getCount("b"));

        System.out.println("Unique elements count: " + countMap.size()); // Ожидаемый вывод: 2 (apple, orange)

        CountMapImpl<String> anotherCountMap = new CountMapImpl<>();
        anotherCountMap.add("a");
        anotherCountMap.add("b");
        anotherCountMap.add("c");

        countMap.addAll(anotherCountMap);

        System.out.println("Count for 'a' after addAll: " + countMap.getCount("a"));  // Ожидаемый вывод: 4
        System.out.println("Count for 'b' after addAll: " + countMap.getCount("b")); // Ожидаемый вывод: 1
        System.out.println("Count for 'c' after addAll: " + countMap.getCount("c"));   // Ожидаемый вывод: 1

        Map<String, Integer> resultMap = countMap.toMap();
        System.out.println("Map from toMap(): " + resultMap);

        Map<String, Integer> destinationMap = new HashMap<>();
        countMap.toMap(destinationMap);
        System.out.println("Destination Map after toMap(destination): " + destinationMap);


        System.out.println("\n-------------------------------------");
        System.out.println("\nTask 2:");

        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21));
        List<Integer> c2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        {
            List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
            List<Integer> list2 = new ArrayList<>();
            list1.add(6);
            CollectionUtil.addAll(list1, list2);
            System.out.println("Method 'addAll': " + list2);
        }


        System.out.println("Method 'indexOf': " + CollectionUtil.indexOf(integers, 1));

        integers = CollectionUtil.limit(integers, 10);
        System.out.println("Method 'limit': " + integers);

        CollectionUtil.add(integers, 11);
        System.out.println("Method 'add': " + integers);

        CollectionUtil.removeAll(integers, c2);
        System.out.println("Method 'removeAll': " + integers);

        {
            List<Integer> list = Arrays.asList(8, 1, 3, 5, 6, 4, 9, 10);
            List<Integer> list2 = Arrays.asList(8, 1, 3, 5, 6, 4);
            List<Integer> list3 = Arrays.asList(8, 1, 3, 2, 6, 4);
            System.out.println("Method 'containsAll' with true result: " + CollectionUtil.containsAll(list, list2));
            System.out.println("Method 'containsAll' with false result: " + CollectionUtil.containsAll(list, list3));
        }

        {
            List<Integer> list = Arrays.asList(8, 1, 3, 5, 6, 4, 9, 10);
            List<Integer> list2 = List.of(8);
            List<Integer> list3 = List.of(2);
            System.out.println("Method 'containsAny' with true result: " + CollectionUtil.containsAny(list, list2));
            System.out.println("Method 'containsAny' with false result: " + CollectionUtil.containsAny(list, list3));
        }

        {
            List<Integer> list = Arrays.asList(8, 1, 3, 5, 6, 4);
            List<Integer> result = CollectionUtil.range(list, 3, 6);
            System.out.println("Method 'range': "+ result);
        }

        {
            List<Integer> list = Arrays.asList(8, 1, 3, 5, 6, 4);


            Comparator<Integer> comparator = Integer::compare;


            List<Integer> result = CollectionUtil.range(list, 3, 6, comparator);
            System.out.println("Method 'range + comparator': "+ result);
        }
    }
}