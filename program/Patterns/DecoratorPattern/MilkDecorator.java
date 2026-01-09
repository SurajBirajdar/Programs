package programs.program.Patterns.DecoratorPattern;

public class MilkDecorator extends NormalCoffee {
    Coffee coffee;
    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 1.5;
    }
}
