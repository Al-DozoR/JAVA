import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/*
Задача №5
Напишите метод, который получает на вход Map<K, V> и возвращает Map, где ключи и значения поменяны местами.
Так как значения могут совпадать, то тип значения в Map будет уже не K, а Collection<K>: Map<V, Collection<K>>
*/
public class Task5 {
    public static void main(String[] args){
        //исходная коллекция
        Map <String, Integer> map= new HashMap<>();
        map.put("Petr",1);
        map.put("Anna",2);
        map.put("Ivan",1);

        //выводим новую коллекцию
        System.out.println(changeMap(map));
    }
    public static Map changeMap(Map <String, Integer> map){
        //новая коллекция
        Map <Integer, HashSet<String>> newMap = new HashMap<>();

        for (String element : map.keySet()){
            //если в newMap ключ уже есть
            if (newMap.containsKey(map.get(element))){
                //добавляем в множество значение map
                newMap.get(map.get(element)).add(element);
            }
            //если в newMap ключ отсутствует
            else{
                //создаем множество
                HashSet<String> newSet = new HashSet<>();
                //добавляем элемент
                newSet.add(element);
                newMap.put(map.get(element),newSet);
            }
        }
        return newMap;
    }
}
