package programs.program.Patterns.FactoryPattern;

public class TestFactory {

    public static void main(String[] args) {
        Factory fac = new Factory();
        Car car = fac.getCar("SUV");
        car.assemble();
    }
}
