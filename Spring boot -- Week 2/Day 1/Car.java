public class Car {
    private Engine engine;

    // Setter for Dependency Injection
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is driving...");
    }
}
