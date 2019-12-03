/*
Задача 2
Реализовать стэк
 */
public class Task2 {
    public static void main(String[] args){
        //создаем стэк
        MyStack myStack = new MyStack();
        //Добавяем элементы
        myStack .push("1");
        myStack .push("2");
        myStack .push("3");
        myStack .push("4");
        //получить элемент без удаления
        System.out.println(myStack.peep()+"\n");
        //получить элементы с удалением
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
