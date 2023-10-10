class Car {
    int gasolineGauge;

    public Car(int gasoline) {
        gasolineGauge = gasoline;
    }
}

class HybridCar extends Car {
    int electricGauge;

    public HybridCar(int gasoline, int electric) {
        super(gasoline);
        electricGauge = electric;
    }
}

class HybridWaterCar extends HybridCar {
    int waterGauge;
    public void showCurrentGauge() {
        System.out.println("잔여 가솔린 : " + gasolineGauge);
        System.out.println("잔여 전기량 : " + electricGauge);
        System.out.println("잔여 워터량 : " + waterGauge);
    }

    public HybridWaterCar(int gasoline, int electric, int water) {
        super(gasoline, electric);
        waterGauge = water;
    }
}

class CarMain {
    public static void main(String[] args) {
        HybridWaterCar c = new HybridWaterCar(10, 20, 30);
        c.showCurrentGauge();
    }
}