//Машина
public class Car{
    private int gosNum; //гос номер
    private double mileage; //пробег
    private double typeFuel; //тип топлива
    private double consumptionsFuel; //расход топлива
    private double additionalParam; //доп.параметр

    //конструктор без доп.парамтера
    public Car(int gosNum, double mileage, double typeFuel, double consumptionsFuel) {
        this.gosNum = gosNum;
        this.mileage = mileage;
        this.typeFuel = typeFuel;
        this.consumptionsFuel = consumptionsFuel;
        this.additionalParam = additionalParam;
    }

    //конструктор с доп.параметром
    public Car(int gosNum, double mileage, double typeFuel, double consumptionsFuel, double additionalParam) {
        this.gosNum = gosNum;
        this.mileage = mileage;
        this.typeFuel = typeFuel;
        this.consumptionsFuel = consumptionsFuel;
        this.additionalParam = additionalParam;
    }

    //возвращаем госномер
    public int getGosNum() {
        return gosNum;
    }

    //Добавить пробег
    public void addMileage(double mileage){
        this.mileage += mileage;
    }

    //Добавить инф-ю о доп.параметре
    public void setAdditionalParam(double additionalParam){
        this.additionalParam += additionalParam;
    }

    //Получаем инф-ю о доп.парамтере
    public double getAdditionalParam() {
        return additionalParam;
    }

    @Override
    public boolean equals(Object obj) {
        return this.gosNum == ((Car)obj).gosNum;
    }

    //возвращаем пробег
    public double getMileage() {
        return mileage;
    }

    //возвращаем тип топлива
    public double getTypeFuel() {
        return typeFuel;
    }

    //возвращаем расход топлива
    public double getConsumptionsFuel() {
        return consumptionsFuel;
    }
}
