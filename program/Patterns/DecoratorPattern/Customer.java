package programs.program.Patterns.DecoratorPattern;

public class Customer {

    public static void main(String[] args) {
        Coffee coffee = new NormalCoffee();
        System.out.println(coffee.getDescription() + " price: " + coffee.getCost());
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " price: " + coffee.getCost());
    }
}
