public class MyStack {
    //последний элемент в стэке
    private Element lastElement;

    //Добавление элемента в стэк
    public void push(String str){
        if (lastElement == null){
            lastElement = new Element(str);
        }else {
            lastElement= new Element(str,lastElement);
        }
    }

    //Возвращаем элемент из стэка без удаления
    public String peep(){
        try{
            return lastElement.str;
        }catch (NullPointerException e){
            return "Стэк пуст";
        }
    }

    //Забираем элемент из стэка
    public String pop(){
        try{
            String str = lastElement.str;

            //проверяем элемент единственный в стэке?
            if (lastElement.previousElement == null){
                lastElement = null;
            }else{
                lastElement = lastElement.previousElement;
            }

            //возвращаем элемент из стэка
            return str;
        }catch (NullPointerException e){
            return "Стэк пуст!!";
        }
    }

    private class Element {
        //хранимая строка
        private String str;
        //Предыдущий элемент
        private Element previousElement;

        Element(String str) {
            this.str = str;
        }

        Element(String str,Element previousElement){
            this(str);
            this.previousElement = previousElement;
        }
    }
}