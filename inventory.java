public class inventory {
    private String category;
    private String brand;
    private String model;
    private int price;
    private int stock;
    private int discount;

    //Constructors
    public inventory(String category, String brand, String model, int price, int stock, int discount) {
        this.category = category;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stock = stock;
        this.discount = discount;
    }


    //Getters and Setters
    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    //toString Method
    @Override
    public String toString() {
        return "Category : "+ category + "\n"+
               "Brand : "+ brand + "\n"+
               "Model : "+ model + "\n"+
               "Price : "+ price + "\n"+
               "Stock : "+ stock + "\n"+
               "Discount :"+ discount + "\n";
    }

}

    