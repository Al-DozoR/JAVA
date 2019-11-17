public class Task4{
    public static void main(String[] args) {
        String text="52+91*7/82+ 5+456+ 45-421*45+1-4/5";

        String[] Stack=new String[0]; //Стек цифр и арифметических знаков

        text=text.replace(" ",""); //убиваем пробелы

        //записываем строку в стэк
        for(int i=0; i<text.length();i++){
            if (text.charAt(i)=='+' | text.charAt(i)=='-' | text.charAt(i)=='*' | text.charAt(i)=='/'){
                Stack=AddArray(Stack,Character.toString(text.charAt(i)));
            }else {
                String number=Character.toString(text.charAt(i));
                for (int j=i+1;j<text.length()+1;j++){
                    if (j==text.length()){
                        i=j-1;
                        Stack=AddArray(Stack,number);
                        break;
                    }
                    if (text.charAt(j) != '+' && text.charAt(j) != '-' && text.charAt(j) != '*' && text.charAt(j) != '/') {
                        number+=Character.toString(text.charAt(j));
                    }else{
                        i=j-1;
                        Stack=AddArray(Stack,number);
                        break;
                    }
                }
            }
        }
        //делаем вычисления * или / в стэке
        for (int i=0;i<Stack.length;i++){
            if (Stack[i].equals("*") | Stack[i].equals("/")){
                Stack=Calculation(Stack,i);
                i=0;
            }
        }
        //делаем вычислеиня + или - в стэке
        for (int i=0;i<Stack.length;i++){
            if (Stack[i].equals("+") | Stack[i].equals("-")){
                Stack=Calculation(Stack,i);
                i=0;
            }
        }
        System.out.println(text+" = "+Stack[0]);
    }
    //Добавляем элемент в массив
    static String[] AddArray(String[] OldArray, String NewElement){
        String[] NewArray=new String[OldArray.length+1];
        if (OldArray.length!=0){
            for(int i=0;i<OldArray.length;i++){
                NewArray[i]=OldArray[i];
            }
        }
        NewArray[OldArray.length]=NewElement;
        return NewArray;
    }
    //Вычисления
    static String[] Calculation(String[] OldArray,int numElement){
        String[] NewArray=new String[OldArray.length-2];
        String Result="";
        switch (OldArray[numElement]){
            case "+":
                Result=Double.toString(Double.valueOf(OldArray[numElement-1])+Double.valueOf(OldArray[numElement+1]));
                break;
            case "-":
                Result=Double.toString(Double.valueOf(OldArray[numElement-1])-Double.valueOf(OldArray[numElement+1]));
                break;
            case "*":
                Result=Double.toString(Double.valueOf(OldArray[numElement-1])*Double.valueOf(OldArray[numElement+1]));
                break;
            case "/":
                Result=Double.toString(Double.valueOf(OldArray[numElement-1])/+Double.valueOf(OldArray[numElement+1]));
                break;
        }
        for (int i=0,j=0;i<NewArray.length;i++,j++){
            if (j==numElement-1){
                NewArray[i]=Result;
                j+=2;
                continue;
            }
            NewArray[i]=OldArray[j];
        }
        return NewArray;
    }
}
