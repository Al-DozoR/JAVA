/*
Задача № 4
Реализовать итератор по массиву: методы hasNext, next, prev.
*/
public class Task4 {
    public static void main(String[] args){
        //исходный массив
        int [] arr = {1,2,3,4,5,6,7,8,9,10};

        //итератор
        MyIterator iterator = new MyIterator(arr);

        //выводим элементы массива с помощью итератора
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        while (iterator.hasPrev()){
            System.out.print(iterator.prev()+" ");
        }

    }
}
