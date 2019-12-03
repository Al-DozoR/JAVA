public class MyDeque {
    //первый элемент в очереди
    private Element firstElement;
    //последний элемент в очереди
    private Element lastElement;

    //Добавление элемента в очередь
    public void push(String str){
        if (firstElement==null){
            firstElement = new Element(str);
            lastElement = firstElement;
        }else{
            //создаем новый элемент очереди
            Element newElement = new Element(str);
            //записываем информацию в предшествующем элементе
            lastElement.nextElement = newElement;
            //меняем информацию о последнем элементе
            lastElement = newElement;
        }
    }

    //Возвращаем элемент из очереди без удаления
    public String peep(){
        try{
            return firstElement.str;
        }catch (NullPointerException e){
            return "Очередь пуста";
        }
    }

    //Забираем элемент из очереди
    public String pop(){
        try{
            String str = firstElement.str;
            //проверяем запрашиваемый элемент единственный в очереди
            if (firstElement == lastElement){
                firstElement = null;
                lastElement = null;
            }else{
                firstElement = firstElement.nextElement;
            }

            //возвращаем элемент из очереди
            return str;
        }catch (NullPointerException e){
            return "Очередь пуста!!";
        }
    }

    private class Element{
        //хранимая строка
        private String str;
        //Следующий элемент
        private Element nextElement;

        Element(String str){
            this.str=str;
        }
    }
}
