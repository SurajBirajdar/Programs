package programs.program.Patterns.FactoryPattern;

public class Factory {

    public Car getCar(String carType) {
        if(carType.equalsIgnoreCase("SUV"))
            return new SUV();
        if(carType.equalsIgnoreCase("Breeza"))
            return new Breeza();

        return null;
    }
}
