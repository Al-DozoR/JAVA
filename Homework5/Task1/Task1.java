/*
Задача 1
Реализовать очередь
 */
public class Task1 {
    public static void main(String[] args){
        //создаем очередь
        MyDeque deque = new MyDeque();
        //добавляем элементы
        deque.push("1");
        deque.push("2");
        deque.push("3");
        deque.push("4");
        //получить элемент без удаления
        System.out.println(deque.peep()+"\n");
        //получить элементы с удалением
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
    }
}
