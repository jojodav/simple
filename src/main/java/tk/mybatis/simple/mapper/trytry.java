package tk.mybatis.simple.mapper;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class trytry {

    public static void main(String[] args) {

    List<Integer> list1 = Arrays.asList(1, 2, 3,4);
    List<Integer> list2 = Arrays.asList(4, 5, 6);
    List<Integer> list3 = Arrays.asList(7, 8, 9);

//    List<Integer> result = new LinkedList<Integer>(Arrays.asList(10,11,12));
//    result.addAll(list1);
//    result.addAll(list2);
//    result.addAll(list3);

    List<Integer> result = Stream.of(list1, list2, list3)
            .flatMap(Collection::stream)
            //.distinct()
            .toList();

    result=result.stream().distinct().toList();

    System.out.println(result);
    }
}
