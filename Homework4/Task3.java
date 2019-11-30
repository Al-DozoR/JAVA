import java.util.*;

/*
Задача №3
Напишите метод, который на вход получает коллекцию объектов, а возвращает коллекцию уже без дубликатов.
<T> Collection<T> removeDuplicates(Collection<T> collection)
*/
public class Task3 {
    public static void main(String[] args){
        ArrayList<String> collection = new ArrayList<String>(Arrays.asList(new String[]{"A", "B", "C", "A", "B", "C", "A", "B", "C", "A", "B", "C"}));
        System.out.println(removeDuplicates(collection));
    }

    static Collection removeDuplicates(Collection collection){
       return new HashSet<>(collection);
    }
}
