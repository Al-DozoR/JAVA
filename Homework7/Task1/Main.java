import java.util.LinkedList;

/*
Одна из классических задач по многопоточности. Дано два потока — производитель и потребитель.
Производитель генерирует некоторые данные (в примере — числа). Производитель «потребляет» их.
Два потока разделяют общий буфер данных, размер которого ограничен. Если буфер пуст, потребитель должен ждать, пока там появятся данные.
Если буфер заполнен полностью, производитель должен ждать, пока потребитель заберёт данные и место освободится.
*/
public class Main {
    public static void main(String[] args){
        //буфер данных
        LinkedList<Integer> dataBuffer = new LinkedList<>();

        //размер буфера данных
        int size=10;

        //поток производителя
        Thread manufacturer = new Thread(new Manufacturer(dataBuffer,size),"Manufacturer");

        //поток потребителя
        Thread consumer = new Thread(new Consumer(dataBuffer,size),"Consumer");

        //запускаем потоки
        manufacturer.start();
        consumer.start();
    }
}
