public class Task3 {
    public static void main(String[] args) {
        String text="sdfdsf,srwe14,7854,,dgd,afrfg6789421,afasd234,1235zcpoyudnvode..,10";
        Counting1(text,'2');
        Counting2(text,'2');
        Counting3(text,'2');
        PositionsChar(text,'2');
    }
    static void Counting1(String text,char ch){
        int num=0;
        for(int i=0;i<text.toCharArray().length;i++){
             if (text.toCharArray()[i]==ch){
                 num++;
             }
         }
        System.out.println("Реализация метода №1 Символ \"" + ch + "\" встречается " + num + " раз");
    }
    static void Counting2(String text,char ch){
        int index=0;
        int num=0;
        while (text.indexOf(ch,index)!=-1){
            num++;
            index=text.indexOf(ch,index)+1;
        }
        System.out.println("Реализация метода №2 Символ \"" + ch + "\" встречается " + num + " раз");
    }
    static void Counting3(String text,char ch) {
        String newtext=text.replaceAll("[^"+ch+"]","");
        System.out.println("Реализация метода №3 Символ \"" + ch + "\" встречается " + newtext.length() + " раз");
    }
    static void PositionsChar(String text, char ch){
        int index=0;
        System.out.print("Символ \""+ch+"\" находтся на позициях: ");
        while (text.indexOf(ch,index)!=-1){
            System.out.print(text.indexOf(ch,index) +  " ");
            index=text.indexOf(ch,index)+1;
        }
    }
}

