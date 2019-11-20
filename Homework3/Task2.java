/* Для задания 2 и 3 необходимо разработать общую структуру. То есть задачу, где необходимо было реализовать структуру связный список,
по функциональности необходимо привести к реализации ArrayList.*/
public class Task2 {
    public static void main(String[] args){
        //Создаем массив MyArrayList
        MyArrayList myArray = new MyArrayList();

        //добавляем элемент Int в массив
        System.out.println("Добавляем 5 в массив");
        myArray.add(5);

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray );

        //добавляем элемент Int в массив
        System.out.println("Добавляем 25 в массив");
        myArray.add(25);

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray );

        //добавляем элемент Int в массив
        System.out.println("Добавляем 0 в массив");
        myArray.add(0);

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray );

        //добавляем элемент Int в массив
        System.out.println("Добавляем 680 в массив");
        myArray.add(680);

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray );

        //добавляем элмент Int в массив на позицию 2
        System.out.println("Добавляем 14 в массив в позицию 2");
        myArray.add(2,14);

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray );

        //добавляем элмент Int в массив на позицию 2
        System.out.println("Добавляем 93 в массив в позицию 0");
        myArray.add(0,93);

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray );

        //добавляем элмент Int в массив на позицию 2
        System.out.println("Добавляем 628 в массив в позицию 6");
        myArray.add(6,628);

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray );

        //удаляем элемент под индексом 2
        System.out.println("удаляем элемент под индексом 2");
        myArray.remove(2);

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray );

        //удаляем элемент под индексом 0
        System.out.println("удаляем элемент под индексом 0");
        myArray.remove(0);

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray );

        //удаляем элемент под индексом 4
        System.out.println("удаляем элемент под индексом 4");
        myArray.remove(4);

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray );

        //удаляем элемент под индексом 1
        System.out.println("удаляем элемент под индексом 1");
        myArray.remove(1);

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray );

        //сортируем массив по возрастанию
        System.out.println("Сортируем массив по возрастанию");
        myArray.sortAsc();

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray );

        //сортируем массив по убыванию
        System.out.println("Сортируем массив по возрастанию");
        myArray.sortDesc();

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray );

        //изменяем элемент массива в позиции 0 на 178
        System.out.println("изменяем элемент массива в позиции 0 на 178 ");
        myArray.set(0,178);

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray );

        //максимально число в массиве
        System.out.println("Максимальное число в массиве: " + myArray.max());

        //Минимальное число в массиве
        System.out.println("Минимальное число в массиве: " + myArray.min());

        //заполняем массив одинаковыми элементами
        myArray.fill(555);

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray );

        //создаем массив Int
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        //создаем MyArrayList передаем в конструктор массив Int
        MyArrayList myArray1 = new MyArrayList(array);

        //выводим информацию о массиве
        System.out.println("В массиве MyArrayList следующие элементы: " + myArray1 );

        //возвращаем массив Int
        int[] array2 = new int[myArray1.size];
        array2 = myArray1.toIntArray();

        System.out.print("В массиве array2: ");
        for (int i : array2){
            System.out.print(i + " ");
        }

    }
}

//класс ArrayList принимающий значения типа Int
class MyArrayList implements MyList{
    //количество элементов в MyArrayList
    public  int size;

    //ссылка на первый элемент MyArrayList
    private Element first;

    //ссылка на последний элемент MyArrayList
    private Element last;

    //Добавляем элемент в конец массива.
    public void add(int e) {
        //проверяем пустой массив или нет
        if (size > 0){
            //если не пустой
            //добавляем элемент в MyArrayList
            Element newElement = new Element(this.size, e,this.last);
            //добавляем ссылку в последнем элементе
            last.nextAddress = newElement;
            //определяем последний элемент в MyArrayList
            this.last = newElement;
            //увеличиваем кол-во элементов в MyArrayList
            this.size++;
        }
        else{
            //если пустой
            //создаем первый элемент
            Element newElement = new Element(this.size, e,null);
            //определяем первый элемент в MyArrayList
            this.first = newElement;
            //определяем последний элемент в MyArrayList
            this.last = newElement;
            //увеличиваем кол-во элементов в MyArrayList
            this.size++;
        }
    }

    //Добавляем элемент в определенную позицию.
    public void add(int index, int e) {
        //проверяем существование индекса в массиве
        if (checkIndex(index)){
            //вставляем новый элемент в первую позицию
            if (index == 0){
                //создаем новый элемент
                Element newElement = new Element(index,e,null);
                newElement.nextAddress = this.first;
                this.first.previousAddress = newElement;
                //изменяем ссылки массива
                this.first = newElement;
                //изменяем индексы у всех элементов
                changeIndex(this.first,0);
                //изменяем размер массива
                this.size++;
            }
            //вставляем новый элемен в последнюю позицию
            else if (index == size){
                Element newElement = new Element(this.size, e,last);
                last.nextAddress = newElement;
                this.last = newElement;
                this.size++;
            }
            //вставляем новый элемент в среднюю позицию
            else{
                //получаем ссылку на элемент с индексом Index
                Element oldElement = findElement(index);
                //создаем новый элемент
                Element newElement = new Element(index,e,oldElement.previousAddress);
                newElement.nextAddress = oldElement;
                //изменияем ссылки у элементов
                newElement.previousAddress.nextAddress = newElement;
                oldElement.previousAddress = newElement;
                //изменяем индексы у всех элеменов
                changeIndex(newElement.nextAddress, index+1);
                //изменяем размер массива
                this.size++;
            }
        }
    }

    //Удаляем элемент с позиции.
    public void remove(int index) {
        //проверяем существование индекса в массиве
        if (checkIndex(index)){
            //удаляем первый элемент
            if (index == 0){
                //изменяем ссылки у объектов
                this.first = this.first.nextAddress;
                this.first.previousAddress = null;
                //изменяем индексы у всех элементов
                changeIndex(first,0);
                //изменяем размерность массива
                this.size--;
            }
            //удаляем последний элемент
            else if (index == size -1){
                //изменяем ссылки у объектов
                this.last = last.previousAddress;
                this.last.nextAddress = null;
                //изменяем размерность массива
                this.size--;
            }
            //удаляем элемент в средней позиции
            else{
                //получаем ссылку на объект который хотим удалить
                Element delElement = findElement(index);
                //изменяем ссылки у объектов
                delElement.previousAddress.nextAddress = delElement.nextAddress;
                delElement.nextAddress.previousAddress = delElement.previousAddress;
                //изменяем индексы у всех элементов
                changeIndex(delElement.nextAddress,index);
                //изменяем размерность массива
                this.size--;
            }
        }
    }

    //Сортировка массива по возрастанию.
    public void sortAsc() {
        //флаг что сортировка закончена
        boolean flagsort=true;
        while (flagsort){
            flagsort=false;
            //Итерируемый элемент
            Element iterElement = this.first;
            while (iterElement.nextAddress != null){
                if (iterElement.data > iterElement.nextAddress.data){
                    int buffer = iterElement.data;
                    iterElement.data = iterElement.nextAddress.data;
                    iterElement.nextAddress.data = buffer;
                    iterElement = iterElement.nextAddress;
                    flagsort=true;
                }
                else {
                    iterElement = iterElement.nextAddress;
                }
            }
        }
    }

    //Сортировка массива по убыванию.
    public void sortDesc() {
        //флаг что сортировка закончена
        boolean flagsort=true;
        while (flagsort){
            flagsort=false;
            //Итерируемый элемент
            Element iterElement = this.first;
            while (iterElement.nextAddress != null){
                if (iterElement.data < iterElement.nextAddress.data){
                    int buffer = iterElement.data;
                    iterElement.data = iterElement.nextAddress.data;
                    iterElement.nextAddress.data = buffer;
                    iterElement = iterElement.nextAddress;
                    flagsort=true;
                }
                else {
                    iterElement = iterElement.nextAddress;
                }
            }
        }
    }

    //Изменить элемент в определенной позиции.
    public void set(int index, int e) {
        //находим нужный элемент
        Element fElement = findElement(index);
        //изменяем значение
        fElement.data = e;
    }

    //Максимальное число в массиве.
    public int max() {
        //итерируемый элемент
        Element fElement = this.first;
        int max = this.first.data;
        //пробегаем по всем элементам
        while (fElement != null){
            if (max < fElement.data){
                max = fElement.data;
                fElement = fElement.nextAddress;
            }
            else{
                fElement = fElement.nextAddress;
            }
        }
        return max;
    }

    //Минимальное число в массиве.
    public int min() {
        //итерируемый элемент
        Element fElement = this.first;
        int min = this.first.data;
        //пробегаем по всем элементам
        while (fElement != null){
            if (min > fElement.data){
                min = fElement.data;
                fElement = fElement.nextAddress;
            }
            else{
                fElement = fElement.nextAddress;
            }
        }
        return min;
    }

    //Заполнить массив элементами e.
    public void fill(int e) {
        //Итерируемый элемент
        Element fElement = this.first;
        //пробегаем по всем элементам
        while (fElement != null){
            //присваиваем новое значение
            fElement.data = e;
            fElement = fElement.nextAddress;
        }
    }

    //Текстовое представление массива.
    public String toString() {
        //итерируемый элемент
        Element fElement = this.first;
        String str="";
        //пробегаем по всем элементам
        while (fElement != null){
            str+=fElement.data + " ";
            fElement = fElement.nextAddress;
        }
        return str;
    }

    //Ввернуть массив типа Int.
    public int[] toIntArray(){
        //итерируемый элемент
        Element iterElement = this.first;
        //внутренний массив
        int[] array =new int[size];
        int i = 0;
        //пробегаем по всем элементам
        while (iterElement != null){
            array[i]=iterElement.data;
            iterElement = iterElement.nextAddress;
            i++;
        }
        return array;
    }

    public MyArrayList(){}

    public MyArrayList(int e){
        //создаем элемент
        Element newElement = new Element(this.size, e,null);
        this.first = newElement;
        this.last = newElement;
        this.size++;
    }

    public MyArrayList(int [] e){
        //создае MyArrayList из массива int
        for (int element : e){
            this.add(element);
        }
    }

    //проверяем сущестует ли индекс в MyArrayList
    private boolean checkIndex (int index){
        if (index > size || index < 0){
            return false;
        }else{
            return true;
        }
    }

    //метод изменения индекса во всех элементах
    private void changeIndex (Element startElement, int startIndex){
        //пробегаем по всем элементам
        while(startElement != null){
            //присваиваем элементу новый индекс
            startElement.index = startIndex;
            startElement = startElement.nextAddress;
            //увеличиваем индекс
            startIndex++;
        }
    }

    //поиск элемента по индексу
    private Element findElement (int index){
        //элемент который ищем
        Element fElement = first;
        //пробегаем по всем элементам массива
        while (fElement.index != index){
            //присваиваем следующий адресс элемента
            fElement = fElement.nextAddress;
        }
        //возвращаем найденный элемент
        return fElement;
    }

    //реализация элемента MyList
    class Element {
        //хранимая информация в элементе списка
        public int data;

        //индекс элемента
        public int index;

        //Адрес предыдущего элемента
        public Element previousAddress = null;

        //Адрес следующего элемента
        public Element nextAddress = null;

        Element(int index, int data, Element previousAddress){
            this.index = index;
            this.data = data;
            this.previousAddress = previousAddress;
        }
    }
}

//интерфейс реализующий поведение MyArrayList
interface MyList {
    //Добавляем элемент в конец массива.
    public void add (int e);

    //Добавляем элемент в определенную позицию.
    public void add (int index, int e);

    //Удаляем элемент с позиции.
    public void remove (int index);

    //Текстовое представление массива.
    public String toString ();

    //Сортировка массива по возрастанию.
    public void sortAsc ();

    //Сортировка массива по убыванию.
    public void sortDesc ();

    //Изменить элемент в определенной позиции.
    public void set (int index, int e);

    //Максимальное число в массиве.
    public int max ();

    //Минимальное число в массиве.
    public int min ();

    //Заполнить массив элементами e.
    public void fill (int e);

    //Ввернуть массив типа Int.
    public int[] toIntArray();
}
