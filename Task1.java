public class Task1{
    public static void main(String[] args){
        String[] array = {"Z11-100", "Z12-150", "Z13-120", "Z11-80", "Z12-50", "Z13-40", "Z11-200", "Z12-0", "Z13-10", "Z11-170"};

        //у всех авто одинаковый расход
        System.out.println("У всех авто одинаковый расход");
        Car Z11=new Car("Z11",46.1);
        Car Z12=new Car("Z12",47.5);
        Car Z13=new Car("Z13",48.9);

        Car[] cars={Z11,Z12,Z13};
        Car.TotalCost(cars,array);
        Car.TypeAutoMaxMinCost(cars,array,"Max");
        Car.TypeAutoMaxMinCost(cars,array,"Min");

        //У авто расход топлива разный
        System.out.println("У авто разный расход топлива");
        Z11=new Car("Z11",46.1,12.5);
        Z12=new Car("Z12",47.5,12);
        Z13=new Car("Z13",48.9,11.5);

        cars[0]=Z11;
        cars[1]=Z12;
        cars[2]=Z13;
        Car.TotalCost(cars,array);
        Car.TypeAutoMaxMinCost(cars,array,"Max");
        Car.TypeAutoMaxMinCost(cars,array,"Min");
    }
}
class Car {
    private double FuelType; //Тип топлива
    private double FuelConsumption;// Расход топлива
    private String Name; //Название авто

    Car(String Name, double FuelType) {
        this.Name = Name;
        this.FuelType = FuelType;
        this.FuelConsumption =0.15;
    }

    Car(String Name, double FuelType, double FuelConsumption) {
        this.Name = Name;
        this.FuelType = FuelType;
        this.FuelConsumption = FuelConsumption/100;
    }

    public static void TotalCost(Car[] Cars, String[] CodMileage) {
        double Cost=0;
        for (Car ElementCar : Cars) {
            for (String ElementCodMileage : CodMileage) {
                if (ElementCodMileage.split("-")[0].equals(ElementCar.Name)){
                    Cost+=Double.valueOf(ElementCodMileage.split("-")[1])*ElementCar.FuelConsumption*ElementCar.FuelType;
                }
            }
        }
        System.out.println("Общая стоимость расходов ГСМ: " + Cost);
    }

    public static void TypeAutoMaxMinCost(Car[] Cars, String[] CodMileage, String MaxMin){
        double Cost=0;
        double MinCost=0;
        double MaxCost=0;
        String Name="";
        for (Car ElementCar : Cars) {
            for (String ElementCodMileage : CodMileage) {
                if (ElementCodMileage.split("-")[0].equals(ElementCar.Name)){
                    Cost+=Double.valueOf(ElementCodMileage.split("-")[1])*ElementCar.FuelConsumption*ElementCar.FuelType;
                }
            }
            if(MinCost==0)MinCost=Cost;
            if(MaxMin=="Max" & MaxCost<Cost) {
                MaxCost=Cost;
                Name=ElementCar.Name;
            }else if (MaxMin!="Max" & MinCost>Cost){
                MinCost=Cost;
                Name=ElementCar.Name;
            }
            Cost=0;
        }
        if (MaxMin=="Max")
            System.out.println("Тип авто имеющий наибольшую стоимость расходов: " + Name);
        else
            System.out.println("Тип авто имеющий наименьшую стоимость расходов: " + Name);
    }
}


