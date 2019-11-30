import java.util.HashMap;
import java.util.Map;
/*
Задача №2
Постройте частотный словарь букв латинского(английского) алфавита.
*/
public class Task2 {
    public static void main (String[] args){
        //исходный текст
        String text = "Java was started as a project called \"Oak\" by James Gosling in June 1991. Gosling's goals were to implement a virtual machine and a language that had a familiar C-like notation but with greater uniformity and simplicity than C/C++. The first public implementation was Java 1.0 in 1995. It made the promise of \"Write Once, Run Anywhere\", with free runtimes on popular platforms. It was fairly secure and its security was configurable, allowing for network and file access to be limited. The major web browsers soon incorporated it into their standard configurations in a secure \"applet\" configuration. popular quickly. New versions for large and small platforms (J2EE and J2ME) soon were designed with the advent of \"Java 2\". Sun has not announced any plans for a \"Java 3\".";

        //выводим результат
        System.out.println(Dictionary(text));
    }

    static Map Dictionary(String text){
        //частотный словарь
        Map <Character, Integer> dictionary = new HashMap<>();
        //пробегаем по тексту
        for (char ch : text.replaceAll("[^A-z]","").toUpperCase().toCharArray()){
            //проверяем наличе буквы в словаре
            if (dictionary.containsKey(ch)){
                //если есть увеличиваем счетчик
                dictionary.put(ch, dictionary.get(ch) + 1);
            }
            else{
                //если нет созадем ключ
                dictionary.put(ch, 1);
            }
        }
        //возвращаем частотный словарь
        return dictionary;
    }
}
