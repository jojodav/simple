package tk.mybatis.simple.mapper;

import java.util.*;
import java.util.stream.Collectors;

public class checkStreamMap {
    public static void main(String[] args) {
        Map map1=Map.of("key1",1,"key",2,"key3",3);

        List<Map<String,Integer>> list=List.of(
                map1,
                Map.of("key",4),
                Map.of("key",5)
        );

        Map<String,Object> m2=new HashMap<>();
        m2.put("m1","this");

        Set<String> s2=new TreeSet<>();
        s2.add("m1");

        Set<String> labelStr =Set.of("a","b");

        //map() 操作
        var listMap=list.stream().map(e->e.get("key")).toList();
        System.out.println("key" + listMap.toString());

        var listMap0=list.stream().map(e->e.size()).toList();
        System.out.println("size" + listMap0.toString());

        //每一个map 的keySet
        var listMap1=list.stream().map(Map::keySet).toList();
        System.out.println("keySet" + listMap1.toString());


        //每一个map 的keySet
        var listMap2=list.stream().map(Map::values).toList();
        System.out.println("values" + listMap2.toString());


        //每一个map 的keySet
        var listMapa=list.stream().map(Map::entrySet).toList();
        System.out.println("entrySet" + listMapa.toString());

        //每一个map 的keySet
        var listMap3=list.stream().flatMap(e->e.keySet().stream()).toList();
        System.out.println("flatMapKeySet" + listMap3.toString());

        //每一个map 的keySet
        var listMap4=list.stream().flatMap(e->e.entrySet().stream()).toList();
        System.out.println("flatMapEntrySetSet" + listMap4.toString());
    }
}
