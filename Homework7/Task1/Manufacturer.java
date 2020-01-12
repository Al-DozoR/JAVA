import java.util.Queue;

//класс производитель
public class Manufacturer implements Runnable {
    //Буфер данных
    private Queue <Integer> dataBuffer;
    //размер буфера данных
    private int size;

    //конструктор
    public Manufacturer(Queue<Integer> dataBuffer, int size){
        this.dataBuffer = dataBuffer;
        this.size = size;
    }

    //метод добавления элементов в буфер данных
    private int manufacturer() throws InterruptedException{
        //случайное число
        int randNum;
        synchronized (dataBuffer){
            //проверяем заполнен ли буфер
            if (dataBuffer.size()==size){
                dataBuffer.wait();
            }

            //генерируем случайное число
            randNum=(int) (Math.random()*100);

            //добавить элемент в буфер
            dataBuffer.add(randNum);

            //возобнавляем поток потребителя
            dataBuffer.notifyAll();

            return randNum;
        }
    }

    @Override
    public void run() {
        while (true){
            try{
                System.out.println("Произовдитель в буфер данных положил цифру: " + manufacturer());
            }catch (InterruptedException e){
                System.out.println("Ошибка потока производителя");
            }
        }
    }
}
