package programs.program.Patterns.BuilderPattern;

public class Product {
    private String name;
    private int id;
    private String description;
    private double discount;

    private Product(ProductBuilder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.description = builder.description;
        this.discount = builder.discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public static class ProductBuilder {

        private String name;
        private int  id;
        private String description;
        private double discount;

        //constructor of mandatory fields
        public ProductBuilder(String name, int id) {
            this.name = name;
            this.id = id;
        }


        // setters of optional fields
        public ProductBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder setDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        public Product build() {
            return new Product(this);
        }

    }






}
