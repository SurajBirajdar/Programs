package programs.program.Patterns.BuilderPattern;

public class TestBuilder {

    public static void main(String[] args) {
        Product product = new Product.ProductBuilder("apple macbook",1).setDescription("fine product").setDiscount(10).build();
        System.out.println(product.toString());
    }
}
