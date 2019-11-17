/*
Задание 2.
Необходимо реализовать класс в конструктор которого передается целочисленный массив.
Необходимо реализовать в данном классе следующие функции:
- добавление элемента в массив (в конец и в определенную позицию)
- функцию вывод количества элементов в массиве
- удаление элемента массива по индексу
- изменения значения по его индексу
- функция вывода на экран всего массива
- функцию сортировки массива (по возрастанию и убыванию без изменения исходного массива)
- функцию вывода максимального/минимального элемента
- функцию заполнения массива одинаковыми элементами
*/
public class Task2 {
    public static void main(String[] args){
        int[] arr1 = {1,2,3,4,5};
        myArray myArr = new myArray(arr1);

        //вставить элемент в конец массива
        myArr.add(6);
        //вставить элемент в позицию 0
        myArr.add(6,0);
        //удаляем элемент в позиции 0
        myArr.remove(0);
        //изменение значения по его индексу
        myArr.set(999,0);
        //выводим на экран содержимое всего массива
        System.out.println(myArr.toString());
        //сортируем по возрастанию
        int[] arr2=myArr.sort(0);
        //сортируем по убыванию
        arr2=myArr.sort(1);
        //выводим максимальный элемент
        System.out.println(myArr.max());
        //выводим минимальный элемент
        System.out.println(myArr.min());
        //заполнить массив одинаковыми элементами
        myArr.fillMyArray(1);
    }
}
class myArray{
    int[] array;
    private int[] buffer;
    myArray(int[] array){
        this.array =  array;
    }
    //добавить элемент в конец массива
    public void add(int newElement){
        buffer=new int[array.length+1];
        //перезаписываем массив в буфер
        rewrite();
        buffer[buffer.length-1]=newElement;
        array=buffer;
    }
    //добавить элемент в определенную позицию
    public void add(int newElement, int index){
        buffer=new int[array.length+1];
        for (int i=0, j=0; i < buffer.length; i++){
            if (i==index){
                buffer[i]=newElement;
            }
            else{
                buffer[i]=array[j];
                j++;
            }
        }
        array=buffer;
    }
    //удаление элемента по индексу
    public void remove(int index){
        buffer=new int[array.length-1];
        for (int i=0, j=0; i < array.length; i++){
            if (i!=index){
                buffer[j]=array[i];
                j++;
            }
        }
        array=buffer;
    }
    //замена элемента по индексу
    public void set(int newElement,int index){
        array[index]=newElement;
    }
    //вывод на экран всего массива
    public String toString(){
        String str = "";
        for (int i : array){
            str += i + " ";
        }
        return str;
    }
    //сортировка массива
    public int[] sort(int sort){
        buffer=array;
        //если sort = 0 то сортируем по возрастанию
        if (sort==0){
            //сортируем
            boolean flagSort=true;
            while (flagSort) {
                flagSort=false;
                for (int i = 0; i < buffer.length-1; i++) {
                    if (buffer[i] > buffer[i+1]) {
                        flagSort = true;
                        int buf = buffer[i];
                        buffer[i]=buffer[i+1];
                        buffer[i+1]=buf;
                    }
                }
            }
        }
        else{
            boolean flagSort=true;
            while (flagSort) {
                flagSort=false;
                for (int i = 0; i < buffer.length-1; i++) {
                    if (buffer[i] < buffer[i+1]) {
                        flagSort = true;
                        int buf = buffer[i];
                        buffer[i]=buffer[i+1];
                        buffer[i+1]=buf;
                    }
                }
            }
        }
        return buffer;
    }
    //метод вывода максимального элемента
    public int max(){
        int max = array[0];
        for (int i=1; i < array.length; i++){
            if (max<array[i]){
                max=array[i];
            }
        }
        return max;
    }
    //метод вывода минимального элемента
    public int min(){
        int min = array[0];
        for (int i=1; i < array.length; i++){
            if (min>array[i]){
                min=array[i];
            }
        }
        return min;
    }
    //метод заполняем весь массив одинаковыми элементами
    public void fillMyArray(int element){
        for (int i=0; i < array.length; i++){
            array[i]=element;
        }
    }
    //метод перезаписи массива в буфер
    private void rewrite(){
        for (int i=0; i<array.length; i++){
            buffer[i]=array[i];
        }

    }
}