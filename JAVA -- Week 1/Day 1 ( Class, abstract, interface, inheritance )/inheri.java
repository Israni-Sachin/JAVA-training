class Vehicle {
    protected String brand = "Ford";
    public void honk() {
        System.out.println("Tuut, tuut!");
    }
}

class inheri extends Vehicle {
    private String modelName = "Mustang";
    public static void main(String[] args) {

        inheri myCar = new inheri();

        myCar.honk();

        System.out.println(myCar.brand + " " + myCar.modelName);
    }
}


