/*
Задание 1.
На входе имеется {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20",
"C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15",}
C(CODE_CAR)_гос номер-Пробег-(доп. параметр)
CODE_CAR
100 - легковой авто
200 - грузовой авто - объем перевезенного груза см. куб.
300 - пассажирский транспорт - число перевезенных пассажиров
400 - тяжелая техника(краны) - вес поднятых грузов тонн
Для каждого типа свой тип топлива:
100 - 46.10
300 - 47.50
200, 400 - 48.90
расход топлива
100 - 12.5
200 - 12
300 - 11.5
400 - 20
Необходимо:
- общую стоимость расходов на ГСМ, так и расходы на каждый класс авто
- тип авто имеющий наибольшую стоимость расходов
- тип авто имеющий наименьшую стоимость расходов
- реализовать функции которые в разрезе каждого типа авто выводят информацию о каждом авто (тип, номер, пробег, доп. параметр), с сортировкой по пробегу и доп параметру.
*/
import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args){
        //исходный массив
        String[] arrText = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50",
                            "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100",
                            "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};

        //сводный список по всем машинам
        ArrayList <Car> listCars = addCarToListCars(arrText);

        //Общая стоимость расходов на ГСМ
        System.out.println("Общая стоимость расходов: "+(CostOfCar(listCars,"Легковой автомобиль")
                                                       +CostOfCar(listCars,"Грузовая машина")
                                                       +CostOfCar(listCars,"Пассажирский транспорт")
                                                       +CostOfCar(listCars,"Тяжелая техника")));
        System.out.println();

        //Расходы на каждый класс авто
        System.out.println("Расходы на легковые автомобили: " + CostOfCar(listCars,"Легковой автомобиль"));
        System.out.println("Расходы на грузовые машины: " + CostOfCar(listCars,"Грузовая машина"));
        System.out.println("Расходы на пассажирский транспорт: " + CostOfCar(listCars,"Пассажирский транспорт"));
        System.out.println("Расходы на тяжелую технику: " + CostOfCar(listCars,"Тяжелая техника"));
        System.out.println();

        //Тип авто имеющий наибольшую стоимость расходов
        System.out.println("Наибольшие расходы имеет: " + ClassCarMaxMinCost(listCars,"Max"));
        System.out.println();

        //Тип авто имеющий наименьшую стоимость расходов
        System.out.println("Наименьшие расходы имеет: " + ClassCarMaxMinCost(listCars,"Min"));
        System.out.println();

        //сортируем по пробегу
        sortlistCars(listCars,(byte)0);
        //Информация в разрезе каждого типа авто
        System.out.println("Сортировка по пробегу");
        for (Car car : listCars){
            car.CarInfo();
        }
        System.out.println();

        //сортируем по доп. параметру
        sortlistCars(listCars,(byte)1);
        System.out.println("Сортировка по доп. параметру");
        //Информация в разрезе каждого типа авто
        for (Car car : listCars){
            car.CarInfo();
        }
        System.out.println();
    }
    //метод добавления машин в сводный список
    public static ArrayList <Car> addCarToListCars(String[] arrText){
        //сводный список
        ArrayList <Car> listCars = new ArrayList<>();

        //Добавляем каждый автомобиль из исходного массива в сводный список
        for (String strCar : arrText){
            //разбиваем элемент массива на составляющие
            String[] car = strCar.split("-");
            //определям какой автомобиль находится в strCar
            switch (car[0].split("_")[0]){
                //легковой автомобиль
                case "C100":
                    //если сводный список пустой, создаем автомобиль
                    if (listCars.isEmpty()){
                        //создаем легковой автомобиль
                        PassengerCar newCar=new PassengerCar(Short.valueOf(car[0].split("_")[1]));
                        //добавляем пробег
                        newCar.addMileAge(Double.valueOf(car[1]));
                        //добавляем автомобиль в сводный список
                        listCars.add(newCar);
                    }
                    else{
                        Car findCar=checkList(listCars,"Легковой автомобиль",Short.valueOf(car[0].split("_")[1]));
                        //проверяем есть ли в списке нужный автомобиль
                        if (findCar==null){
                            //создаем легковой автомобиль
                            PassengerCar newCar=new PassengerCar(Short.valueOf(car[0].split("_")[1]));
                            //добавляем пробег
                            newCar.addMileAge(Double.valueOf(car[1]));
                            //добавляем автомобиль в сводный список
                            listCars.add(newCar);
                        }else{
                            //добавляем пробег
                            findCar.addMileAge(Double.valueOf(car[1]));
                        }
                    }
                    break;
                //грузовая машина
                case "C200":
                    //если сводный список пустой, создаем грузовую машину
                    if (listCars.isEmpty()){
                        //создаем грузовую машину
                        Lorry newCar=new Lorry(Short.valueOf(car[0].split("_")[1]));
                        //добавляем пробег
                        newCar.addMileAge(Double.valueOf(car[1]));
                        //добавляем объем перевезенного груза
                        newCar.addCargoVolume(Double.valueOf(car[2]));
                        //добавляем автомобиль в сводный список
                        listCars.add(newCar);
                    }
                    else{
                        Lorry findCar=(Lorry)checkList(listCars,"Грузовая машина",Short.valueOf(car[0].split("_")[1]));
                        //проверяем есть ли в списке нужный автомобиль
                        if (findCar==null){
                            //создаем грузовую машину
                            Lorry newCar=new Lorry(Short.valueOf(car[0].split("_")[1]));
                            //добавляем пробег
                            newCar.addMileAge(Double.valueOf(car[1]));
                            //добавляем объем перевезенного груза
                            newCar.addCargoVolume(Double.valueOf(car[2]));
                            //добавляем автомобиль в сводный список
                            listCars.add(newCar);
                        }else{
                            //добавляем пробег
                            findCar.addMileAge(Double.valueOf(car[1]));
                            //добавляем объем перевезенного груза
                            findCar.addCargoVolume(Double.valueOf(car[2]));
                        }
                    }
                    break;
                //пассажирский транспорт
                case "C300":
                    //если сводный список пустой, создаем пассажирский транспорт
                    if (listCars.isEmpty()){
                        //создаем пассажирский транспорт
                        PassengerTransport newCar=new PassengerTransport(Short.valueOf(car[0].split("_")[1]));
                        //добавляем пробег
                        newCar.addMileAge(Double.valueOf(car[1]));
                        //добавляем кол-во перевезенных пассажиров
                        newCar.addNumPassengers(Short.valueOf(car[2]));
                        //добавляем автомобиль в сводный список
                        listCars.add(newCar);
                    }
                    else{
                        PassengerTransport findCar=(PassengerTransport)checkList(listCars,"Пассажирский транспорт",Short.valueOf(car[0].split("_")[1]));
                        //проверяем есть ли в списке нужный автомобиль
                        if (findCar==null){
                            //создаем пассажирский транспорт
                            PassengerTransport newCar=new PassengerTransport(Short.valueOf(car[0].split("_")[1]));
                            //добавляем пробег
                            newCar.addMileAge(Double.valueOf(car[1]));
                            //добавляем кол-во перевезенных пассажиров
                            newCar.addNumPassengers(Short.valueOf(car[2]));
                            //добавляем автомобиль в сводный список
                            listCars.add(newCar);
                        }else{
                            //добавляем пробег
                            findCar.addMileAge(Double.valueOf(car[1]));
                            //добавляем объем перевезенного груза
                            findCar.addNumPassengers(Short.valueOf(car[2]));
                        }
                    }
                    break;
                //тяжелая техника
                case "C400":
                    //если сводный список пустой, создаем пассажирский транспорт
                    if (listCars.isEmpty()){
                        //создаем тяжёлую технику
                        HeavyEquipment newCar=new HeavyEquipment(Short.valueOf(car[0].split("_")[1]));
                        //добавляем пробег
                        newCar.addMileAge(Double.valueOf(car[1]));
                        //добавляем вес поднятых грузов
                        newCar.addCargoWight(Short.valueOf(car[2]));
                        //добавляем автомобиль в сводный список
                        listCars.add(newCar);
                    }
                    else{
                        HeavyEquipment findCar=(HeavyEquipment)checkList(listCars,"Тяжелая техника",Short.valueOf(car[0].split("_")[1]));
                        //проверяем есть ли в списке нужный автомобиль
                        if (findCar==null){
                            //создаем пассажирский транспорт
                            HeavyEquipment newCar=new HeavyEquipment(Short.valueOf(car[0].split("_")[1]));
                            //добавляем пробег
                            newCar.addMileAge(Double.valueOf(car[1]));
                            //добавляем вес поднятых грузов
                            newCar.addCargoWight(Short.valueOf(car[2]));
                            //добавляем автомобиль в сводный список
                            listCars.add(newCar);
                        }else{
                            //добавляем пробег
                            findCar.addMileAge(Double.valueOf(car[1]));
                            //добавляем вес поднятых грузов
                            findCar.addCargoWight(Short.valueOf(car[2]));
                        }
                    }
                    break;
            }
        }
        return listCars;
    }
    //проверяем есть ли нужный автомобиль в списке, если есть возвращаем ссылку на него
    public static Car checkList(ArrayList <Car> listCars, String nameCar, Short codeCar){
        Car fCar=null;
        for (Car findCar : listCars){
            if (findCar.name.equals(nameCar) && findCar.numCar ==codeCar){
                fCar = findCar;
            }else{
                fCar = null;
            }
        }
        return fCar;
    }
    //Расходы на ГСМ
    public static double CostOfCar(ArrayList <Car> listCars, String classCar){
        double total = 0;
        for (Car car : listCars){
            if (car.name.equals(classCar)){
                total += car.mileAge/100*car.getConsumptionsFuel()*car.getTypeFuel();
            }
        }
        return total;
    }
    //метод определяющий наибольшую/наименьшую стоимость расходов
    public static String ClassCarMaxMinCost(ArrayList <Car> listCars,String MaxMin){
        double cost=0;
        String nameMaxMin="";
        //определяем название всех классов авто
        ArrayList <String> listNameCars=new ArrayList<>();
        for (Car car : listCars){
            if (listNameCars.indexOf(car.name)<0){
                listNameCars.add(car.name);
            }
        }
        //определяем максимальную/минимальную стоимость расходов
        cost=CostOfCar(listCars,listNameCars.get(0));
        nameMaxMin=listNameCars.get(0);
        if (MaxMin=="Max"){
            for (String name : listNameCars){
                if (cost<CostOfCar(listCars,name)){
                    cost=CostOfCar(listCars,name);
                    nameMaxMin=name;
                }
            }
        }else{
            for (String name : listNameCars){
                if (cost>CostOfCar(listCars,name)){
                    cost=CostOfCar(listCars,name);
                    nameMaxMin=name;
                }
            }
        }
        return nameMaxMin;
    }
    //сортировка сводного списка по пробегу или доп параметру
    public static void sortlistCars(ArrayList <Car> listCars, byte sortParam){
            //сортируем по коду класса авто
            boolean flagSort=true;
            while (flagSort) {
                flagSort=false;
                for (int i = 0; i < listCars.size()-1; i++) {
                    if (listCars.get(i).getCodeCar() > listCars.get(i + 1).getCodeCar()) {
                        flagSort = true;
                        Car buffer = listCars.get(i);
                        listCars.set(i,listCars.get(i+1));
                        listCars.set(i+1,buffer);
                    }
                }
            }
            //сортируем по пробегу внутри класса авто
            //формируем список классов авто
            ArrayList <String> listNameCar = new ArrayList<>();
            for (Car car : listCars){
                if (listNameCar.indexOf(car.name)<0){
                    listNameCar.add(car.name);
                }
            }
            if (sortParam==0) {
                //сортируем для каждого класса авто по пробегу
                for (String nameCar : listNameCar) {
                    flagSort = true;
                    while (flagSort) {
                        flagSort = false;
                        for (int i = 0; i < listCars.size() - 1; i++) {
                            if (listCars.get(i).name.equals(nameCar) && listCars.get(i + 1).name.equals(nameCar)) {
                                if (listCars.get(i).getMileAge() > listCars.get(i + 1).getMileAge()) {
                                    flagSort = true;
                                    Car buffer = listCars.get(i);
                                    listCars.set(i, listCars.get(i + 1));
                                    listCars.set(i + 1, buffer);
                                }
                            }
                        }
                    }
                }
            }else{
                //сортируем для каждого класса авто по доп параметру
                for (String nameCar : listNameCar) {
                    flagSort = true;
                    while (flagSort) {
                        flagSort = false;
                        for (int i = 0; i < listCars.size() - 1; i++) {
                            if (listCars.get(i).name.equals(nameCar) && listCars.get(i + 1).name.equals(nameCar)) {
                                if (listCars.get(i).getInfoParam()> listCars.get(i + 1).getInfoParam()) {
                                    flagSort = true;
                                    Car buffer = listCars.get(i);
                                    listCars.set(i, listCars.get(i + 1));
                                    listCars.set(i + 1, buffer);
                                }
                            }
                        }
                    }
                }
            }
    }
}

//класс машина
class Car{
    String name; //название машина
    short codeCar; //код машины
    double typeFuel; //тип топлива
    double consumptionsFuel; //расход топлива
    short numCar; //гос номер авто
    double mileAge; //пробег

    Car(String name,short codeCar, double typeFuel, double consumptionsFuel, short numCar){
        this.name = name;
        this.codeCar = codeCar;
        this.typeFuel = typeFuel;
        this.consumptionsFuel = consumptionsFuel;
        this.numCar = numCar;
    }

    //метод добавление пробега
    public void addMileAge(double mileAge){
        this.mileAge += mileAge;
    }

    //метод возврата пробега
    public double getMileAge(){
        return mileAge;
    }

    //метод возврата код машины
    public short getCodeCar(){
        return codeCar;
    }

    //метод возврата тип топлива
    public double getTypeFuel(){
        return typeFuel;
    }

    //мето возврата расхода топлива
    public double getConsumptionsFuel(){
        return consumptionsFuel;
    }

    //информация о доп параметре
    public double getInfoParam(){
        return 0;
    }

    //выводим информацию об авто
    public void CarInfo() {}
}
//класс легковая машина
class PassengerCar extends Car{
    PassengerCar(short codeCar){
        super("Легковой автомобиль",(short)100,46.10,12.5,codeCar);
    }

    //выводим информацию об авто
    public void CarInfo() {
        System.out.println("Тип: " + name + " | Номер: " + codeCar + " | Пробег: " + mileAge);
    }

    //информация о доп параметре
    public double getInfoParam(){
        return 0;
    }
}
//класс грузовая машина
class Lorry extends Car{
    double cargoVolume; //объем перевезенного груза см.куб

    Lorry(short codeCar){
        super("Грузовая машина",(short)200,48.90,12,codeCar);
    }

    //метод добавления объема перевезенного груза
    public void addCargoVolume(double cargoVolume){
        this.cargoVolume=cargoVolume;
    }

    //выводим информацию об авто
    public void CarInfo() {
        System.out.println("Тип: " + name + " | Номер: " + codeCar + " | Пробег: " + mileAge + " км. | Объем перевезенного груза: " + cargoVolume + " см.куб.");
    }

    //информация о доп параметре
    public double getInfoParam(){
        return cargoVolume;
    }
}
//класс пассажирский транспорт
class PassengerTransport extends Car{
    short numPassengers; //кол-во перевезенных пассажиров

    PassengerTransport(short codeCar){
        super("Пассажирский транспорт",(short)300,47.50,11.5,codeCar);
    }

    //метод добавления кол-ва перевезенных пассажиров
    public void addNumPassengers(short numPassengers){
        this.numPassengers=numPassengers;
    }

    //выводим информацию об авто
    public void CarInfo() {
        System.out.println("Тип: " + name + " | Номер: " + codeCar + " | Пробег: " + mileAge + "км. | Кол-во перевезенных пассажиров: " + numPassengers + " чел");
    }

    //информация о доп параметре
    public double getInfoParam(){
        return numPassengers;
    }
}
//класс тяжелая техника
class HeavyEquipment extends Car{
    double cargoWeight; //вес поднятых грузов в тоннах

    HeavyEquipment(short codeCar){
        super("Тяжелая техника",(short)400,48.90,20,codeCar);
    }

    //Метод добавления веса
    public void addCargoWight(double cargoWeight){
        this.cargoWeight=cargoWeight;
    }

    //выводим информацию об авто
    public void CarInfo() {
        System.out.println("Тип: " + name + " | Номер: " + codeCar + " | Пробег: " + mileAge + "км. | Вес перевезенного груза: " + cargoWeight + " тонн");
    }

    //информация о доп параметре
    public double getInfoParam(){
        return cargoWeight;
    }
}