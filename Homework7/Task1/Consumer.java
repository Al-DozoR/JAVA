import java.util.Queue;

//класс потребитель
public class Consumer implements Runnable {
    //Буфер данных
    private Queue<Integer> dataBuffer;
    //размер буфера данных
    private int size;

    //конструктор
    public Consumer(Queue<Integer> dataBuffer, int size) {
        this.dataBuffer = dataBuffer;
        this.size = size;
    }

    //метод потребления элементов из буфера данных
    private int consumer() throws InterruptedException{
        //число буфера
        int num;
        synchronized (dataBuffer){
            //проверяем пустой ли буфер
            if (dataBuffer.isEmpty()){
                dataBuffer.wait();
            }

            //берем элементь из буфера
            num = dataBuffer.poll();

            //возобнавляем поток производителя
            dataBuffer.notifyAll();

            return num;
        }
    }


    @Override
    public void run() {
        while (true){
            try{
                System.out.println("Потребитель из буфера данных вязл цифру: " + consumer());
            }catch (InterruptedException e){
                System.out.println("Ошибка потока потребителя");
            }
        }
    }
}
