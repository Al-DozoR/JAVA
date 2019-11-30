/*
Задача №6
Необходимо написать функцию, которая на вход получает массив строк, в формате имя_игрока количество_очков.
Необходимо вывести победителя данной игры. Победителем считается тот, кто раньше набрал максимальное количество очков.
Входные данные = "Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1"
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task6 {

    public static void main(String[] args){
        //игровой лист
        String[] listGame = {"Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1"};
        //выводим чемпиона
        System.out.println(champ(listGame));
    }

    //Функция возвращает победителя
    public static String champ(String[] listGame){
        //коллекция игроков
        Map<String, ArrayList<Integer>> players = new HashMap<>();
        //шаг игры
        Integer step=0;
        //перебираем игровой лист
        for (String element : listGame){
            //если игрок есть в коллекции
            if (players.containsKey(element.split(" ")[0])){
                //массив с информацией об игроке
                ArrayList <Integer> score = new ArrayList<>();
                //добавляем шаг
                score.add(++step);
                //добавляем количество очков на текущий шаг игры
                score.add(players.get(element.split(" ")[0]).get(1) + Integer.valueOf(element.split(" ")[1]));
                //обновляем информацию об игроке в коллекции
                players.put(element.split(" ")[0],score);
            }
            //если игрока нет в колекции
            else{
                //массив с информацией об игроке
                ArrayList <Integer> score = new ArrayList<>();
                //добавляем шаг
                score.add(++step);
                //добавляем количество очков на текущий шаг игры
                score.add(Integer.valueOf(element.split(" ")[1]));
                //обновляем информацию об игроке в коллекции
                players.put(element.split(" ")[0],score);
            }
        }
        //ищем чемпиона
        step=0;
        Integer maxPoints=0;
        String champ=null;
        for (String player : players.keySet()){
            if ((maxPoints<=players.get(player).get(1) && step>players.get(player).get(0))||(maxPoints<players.get(player).get(1) && step<players.get(player).get(0))){
                step = players.get(player).get(0);
                maxPoints = players.get(player).get(1);
                champ = player;
            }
        }
        //возвращаем чемпиона
        return champ;
    }
}
