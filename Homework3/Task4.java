import java.util.ArrayList;

/*
1. Для 1 и 4 задания, выполнить переработку, и дополнить реализацию использованием абстрактными классами и интерфейсами.
Например, существует несколько вариантов реализации калькулятора (обычный, инженерный, для программистов), у них есть общая функциональность,
так и есть набор функций, который для каждого свой.
*/

public class Task4 {
    public static void main(String[] args){
        //простой калькулятор
        CalculatorSimple simpleCalcul = new CalculatorSimple();
        //инженерный калькулятор
        CalculatroEngineering enginCalcul = new CalculatroEngineering();
        //калькулятор программиста
        CalculatorProgrammer progCalcul = new CalculatorProgrammer();

        //вычисляем простое выражение
        System.out.println(simpleCalcul.calculate("5+9"));
        //возвести в квадрат
        System.out.println(enginCalcul.square(5));
        //перевести в двоичную систему
        System.out.println(progCalcul.ConvertBinary(56));

    }
}

//класс калькулятор
abstract class CALCULATOR{
    //история вычислений
    public ArrayList <Double> history;

    //добавить результат в историю вычислений
    abstract void addHistory (Double result);

    //получить элемент из истории
    abstract double getHistory ();

    //Очистить историю
    abstract void clearHistory();

    //вычислить выражение
    abstract double calculate(String expression);
}

//интерфейс инженерного калькулятора
interface EngineeringCalculator{
    //возведение в квадрат
    public double square(double num);
}

//интерфейс калькулятора для программистов
interface ProgrammerCalculator{
    //перевод десятичного числа в двоичную систему исчисления
    public String ConvertBinary(long num);
}

//простой калькулятор
class CalculatorSimple extends CALCULATOR{
    private ArrayList <Double> history = new ArrayList<>();

    //добавить в историю элемент
    void addHistory(Double result) {
        this.history.add(result);
    }

    //получить элемент из истории
    double getHistory() {
        if (history.size()>0)
            return this.history.get(history.size()-1);
        else
            return -1;
    }

    //очистить историю
    void clearHistory() {
        history.clear();
    }

    double calculate(String expression) {
        //вычисление выражения
        double result = 0;
        //вычисляем выражение
        switch (expression.replaceAll("[0-9]","")) {
            case "+":
                result = Double.valueOf(expression.split("[+]")[0]) + Double.valueOf(expression.split("[+]")[1]);
                break;
            case "-":
                result = Double.valueOf(expression.split("-")[0]) - Double.valueOf(expression.split("-")[1]);
                break;
            case "*":
                result = Double.valueOf(expression.split("[*]")[0]) * Double.valueOf(expression.split("[*]")[1]);
                break;
            case "/":
                result = Double.valueOf(expression.split("[/]")[0]) / Double.valueOf(expression.split("[/]")[1]);
                break;
        }
        //добавляем результат в историю
        addHistory(result);
        return result;
    }
}

//Инженерный калькулятор
class CalculatroEngineering extends CalculatorSimple implements EngineeringCalculator{
    public double square(double num) {
        double result = num * num;
        //добавляем результат в историю
        addHistory(result);
        return result;
    }
}

//Калькулятор программиста
class CalculatorProgrammer extends CalculatorSimple implements ProgrammerCalculator{
    //конвертируем в двоичную систему
    public String ConvertBinary(long num) {
        StringBuilder NumBinary = new StringBuilder();
        while (num / 2 != 0){
            NumBinary.append(num % 2);
            num = num / 2;
        }
        NumBinary.append(num % 2);
        return String.valueOf(NumBinary.reverse());
    }
}