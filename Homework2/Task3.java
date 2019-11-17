/*
Необходимо реализовать класс, который реализует структуру Связный список.
*/
public class Task3 {
    public static void main(String[] args){
        LinkedList myList = new LinkedList("Element 0");
        //Добавляем элементы
        myList.add("Element 1");
        myList.add("Element 2");
        myList.add("Element 3");
        myList.add("Element 4");
        System.out.println("Кол-во элментов в связаном списке: " + myList.count);
    }
}
class LinkedList{
    //количество элементов
    public static int count;
    //первый элемент
    Element first;
    //последний элемент
    Element last;

    LinkedList(String data){
        //создаем первый элемент
        Element newElement = new Element(data,null);
        this.first = newElement;
        this.last = newElement;
        this.count++;
    }
    LinkedList(){}

    //добавляем элемент в список
    public void add(String data){
        if (last!=null){
            Element newElement = new Element(data,last);
            last.nextAddress = newElement;
            this.last = newElement;
            this.count++;
        }
        else{
            //создаем первый элемент
            Element newElement = new Element(data,null);
            this.first = newElement;
            this.last = newElement;
            this.count++;
        }
    }

    //элемент
    class Element{
        //хранимая информация в элементе списка
        String data;
        //Адрес предыдущего элемента
        Element previousAddress=null;
        //Адрес следующего элемента
        Element nextAddress=null;
        Element(String data,Element previousAddress){
            this.data=data;
            this.previousAddress=previousAddress;
        }
    }
}