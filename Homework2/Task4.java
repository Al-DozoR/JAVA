/*
Задание 4.
Необходимо реализовать класс для калькулятора.
Минимальный набор функций:
- вычисление выражение
- возврат к последнему вычисленному выражению
- очистка значений всех выражений
 */
public class Task4 {
    public static void main(String[] args){
        System.out.println(Calculator.Calculate("10/2"));
        System.out.println(Calculator.Calculate("5/2"));
        System.out.println(Calculator.Calculate("15-2"));
        System.out.println(Calculator.returnResult());
        System.out.println(Calculator.returnResult());
        System.out.println(Calculator.returnResult());
    }
}
class Calculator{
    static double results[]=new double[0];
    //вычисление выражения
    static public double Calculate(String expression){
        double result=0;
        //вычисляем выражение
        switch (expression.replaceAll("[0-9]","")){
            case "+":
                result=Double.valueOf(expression.split("[+]")[0])+Double.valueOf(expression.split("[+]")[1]);
                break;
            case "-":
                result=Double.valueOf(expression.split("-")[0])-Double.valueOf(expression.split("-")[1]);
                break;
            case "*":
                result=Double.valueOf(expression.split("[*]")[0])*Double.valueOf(expression.split("[*]")[1]);
                break;
            case "/":
                result=Double.valueOf(expression.split("[/]")[0])/Double.valueOf(expression.split("[/]")[1]);
                break;
        }
        //записываем ответ в историю
        double[] buffer = new double[results.length+1];
        for (int i=0; i<results.length; i++){
            buffer[i]=results[i];
        }
        buffer[buffer.length-1]=result;
        results=buffer;
        return result;
    }
    //возврат к предыдущему результату
    static public double returnResult(){
        if (results.length>0) {
            double rResult = results[results.length - 1];
            double[] buffer = new double[results.length - 1];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = results[i];
            }
            results=buffer;
            return rResult;
        }
        else{
            return 0;
        }
    }
    //очистить историю
    static public void clear(){
        results=new double[0];
    }

}
