public class MyIterator {
    int[] arr;
    private int cursor=0;

    MyIterator(int[] arr){
        this.arr = arr;
    }

    //возвращает true, если есть следующий элемент, иначе возвращает false
    public boolean hasNext(){
        return arr.length>cursor;
    }

    //возвращает true, если есть предыдущий элемент, иначе возвращает false
    public boolean hasPrev(){
        return 0<cursor;
    }

    //возвращаем текущий элемент и переходит к следующему
    public int next(){
        return arr[cursor++];
    }

    //возвращаем текущий элемент и переходит к предыдущему
    public int prev(){
        return arr[--cursor];
    }
}
