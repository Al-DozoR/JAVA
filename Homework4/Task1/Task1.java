import java.util.*;

public class Task1 {
    public static void main(String[] args){
        //исходный массив
        String[] arrCars = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50",
                "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100",
                "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15",};

        //типы топлива
        HashMap<String, Double> fuelTypes = new HashMap<String, Double>();
        fuelTypes.put("C100",46.1);
        fuelTypes.put("C200",48.9);
        fuelTypes.put("C300",47.5);
        fuelTypes.put("C400",48.9);

        //расход топлива
        HashMap <String, Double> fuelConsumptions = new HashMap<String, Double>();
        fuelConsumptions.put("C100",12.5);
        fuelConsumptions.put("C200",12.0);
        fuelConsumptions.put("C300",11.5);
        fuelConsumptions.put("C400",20.0);

        //коллекция автомобилей
        HashMap<String, ArrayList<Car>> collectionCars = createCollectionCars(arrCars, fuelTypes, fuelConsumptions);

        //общие расходы на ГСМ
        System.out.println("Общая стоимость расходов: " + totalCostOfCar(collectionCars) + "\n");

        //Расходы на ГСМ на каждый класс авто
        for (String codeCar : collectionCars.keySet()){
            System.out.println("Расходы на " + nameCar(codeCar) + ": " + costOfCar(collectionCars, codeCar));
        }
        System.out.println();

        //Наибольшая стоимость расходов
        System.out.println("Наибольшие расходы имеет: " + nameCar(maxCodeCar(collectionCars)));
        System.out.println();

        //Наименьшая стоимость расходов
        System.out.println("Наименьшие расходы имеет: " + nameCar(minCodeCar(collectionCars)));
        System.out.println();

        //сортировка по пробегу
        System.out.println("Сортировка по пробегу");
        sortByMileage(collectionCars);
        //выводим информацию
        infoCar(collectionCars);
        System.out.println();

        //сортировка по доп.парамтеру
        System.out.println("Сортировка по доп.параметру");
        sortByAdditionalParam(collectionCars);
        //выводим информацию
        infoCar(collectionCars);
    }

    //создаем коллекцию автомобилей
    public static HashMap createCollectionCars(String[] arrCars, HashMap fuelTypes, HashMap fuelConsumptions){
        HashMap<String, ArrayList<Car>> collectionCars = new HashMap<String, ArrayList<Car>>();

        //разбираем исходный массив строк
        for (String str : arrCars){
            //код машины
            String codeCar = str.split("_")[0];
            //проверяем есть ли в коллекции данный тип автомобиля
            if (collectionCars.containsKey(codeCar)){
                //проверяем есть ли в коллекции автомобиль с нужным гос номером
                int gosNum = Integer.parseInt(str.split("_")[1].split("-")[0]); //гос номер
                double mileage = Integer.parseInt(str.split("_")[1].split("-")[1]); //пробег
                if (collectionCars.get(codeCar).contains(new Car(gosNum,0.0,0.0,0.0))){
                    //авто с нужныйм номер найден добавляем пробеги и доп. параметр
                    for (Car car : collectionCars.get(codeCar)){
                        if (car.getGosNum() == gosNum ){
                            //Добавляем пробег
                            car.addMileage(mileage);
                            //проверяем есть ли доп.парамтер
                            if (str.split("-").length>2){
                                car.setAdditionalParam(Integer.parseInt(str.split("_")[1].split("-")[2]));
                            }
                        }
                    }
                }
                else{
                    //добавляем в коллекцию новый автомобиль
                    collectionCars.get(codeCar).add(createCar(str,fuelTypes,fuelConsumptions));
                }
            }
            else{
                //создаем автомобилей данного типа
                ArrayList<Car> cars= new ArrayList<>();
                //добавляем автомобиль
                cars.add(createCar(str,fuelTypes,fuelConsumptions));
                //Добавляем новый тип авто в коллекцию
                collectionCars.put(codeCar,cars);
            }
        }

        //возвращаем коллекцию автомобилей
        return collectionCars;
    }

    //создаем автомобиль
    public static Car createCar(String str, HashMap fuelTypes, HashMap fuelConsumptions){
        int gosNum = Integer.parseInt(str.split("_")[1].split("-")[0]); //гос номер
        double mileage = Integer.parseInt(str.split("_")[1].split("-")[1]); //пробег
        double fuelType = (double) fuelTypes.get(str.split("_")[0]); //тип топлива
        double fuelConsumption = (double) fuelConsumptions.get(str.split("_")[0]); //расход топлива

        //проверяем есть ли доп параметр
        if (str.split("-").length>2){
            //возвращаем Car конструктором с доп.парамтером
            return new Car(gosNum, mileage, fuelType, fuelConsumption, Integer.parseInt(str.split("-")[2]));
        }
        else{
            //возвращаем Car конструктором без доп.парамтера
            return new Car(gosNum, mileage, fuelType, fuelConsumption);
        }
    }

    //определяем название класс авто по codeCar
    public static String nameCar(String codeCar){
        switch (codeCar){
            case "C100":
                return "Легковые автомобили";
            case "C200":
                return "грузовые машины";
            case "C300":
                return "пассажирский транспорт";
            case "C400":
                return "тяжелая техника";
            default:
                return "тип авто не найден";
        }
    }

    //Расходы на ГСМ
    public static double costOfCar(HashMap <String, ArrayList<Car>> collectionCars, String codeCar){
        double total = 0;
        for (Car car : collectionCars.get(codeCar)){
            total += car.getMileage()/100*car.getConsumptionsFuel()*car.getTypeFuel();
        }
        return total;
    }

    //Общие расходы на ГСМ
    public static double totalCostOfCar(HashMap <String, ArrayList<Car>> collectionCars){
        double total=0;
        for (String codeCar : collectionCars.keySet()){
            total += costOfCar(collectionCars, codeCar);
        }
        return total;
    }

    //наибольшая стоимость расходов
    public static String maxCodeCar(HashMap <String, ArrayList<Car>> collectionCars){
        String maxCode="";
        double maxTotal =0;
        for (String codeCar : collectionCars.keySet()){
            double total = costOfCar(collectionCars,codeCar);
            if (maxTotal < total || maxCode.equals("")){
                maxCode = codeCar;
                maxTotal = total;
            }
        }
        return maxCode;
    }

    //наименьшая стоимость расходов
    public static String minCodeCar(HashMap <String, ArrayList<Car>> collectionCars){
        String minCode="";
        double minTotal = 0;
        for (String codeCar : collectionCars.keySet()){
            double total = costOfCar(collectionCars,codeCar);
            if (minTotal > total || minCode.equals("")){
                minCode = codeCar;
                minTotal = total;
            }
        }
        return minCode;
    }

    //выводим информацию о каждом авто
    public static void infoCar(HashMap <String, ArrayList<Car>> collectionCars){
        for (String codeCar : collectionCars.keySet()){
            for (Car car : collectionCars.get(codeCar)){
                System.out.println("Тип: " + nameCar(codeCar) + " | Номер: " + car.getGosNum() + " | Пробег: " + car.getMileage() + (car.getAdditionalParam() > 0 ? " Доп параметр: " + car.getAdditionalParam() : ""));
            }
        }
    }

    //сортировка по пробегу
    public static void sortByMileage (HashMap <String, ArrayList<Car>> collectionCars){
        for (String codeCar : collectionCars.keySet()){
            Collections.sort(collectionCars.get(codeCar), new Comparator<Car>() {
                @Override
                public int compare(Car o1, Car o2) {
                    return (int)(o1.getMileage() - o2.getMileage());
                }
            });
        }
    }

    //сортировка по доп. параметру
    public static void sortByAdditionalParam (HashMap <String, ArrayList<Car>> collectionCars){
        for (String codeCar : collectionCars.keySet()){
            Collections.sort(collectionCars.get(codeCar), new Comparator<Car>() {
                @Override
                public int compare(Car o1, Car o2) {
                    return (int)(o1.getAdditionalParam() - o2.getAdditionalParam());
                }
            });
        }
    }


}
