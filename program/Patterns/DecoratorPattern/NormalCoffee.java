package programs.program.Patterns.DecoratorPattern;

public class NormalCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Normal Coffee";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}
