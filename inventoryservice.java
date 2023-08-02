import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class inventoryservice {

    List<inventory> inventories = new ArrayList<>();


    //reading the contents from inventory file
    public void readinventory(String filepath){

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                String category = data[0];
                String brand = data[1];
                String model = data[2];
                int price = Integer.parseInt(data[3]);
                int stock = Integer.parseInt(data[4]);
                int discount = Integer.parseInt(data[5]);
                inventories.add(new inventory(category, brand, model, price, stock, discount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //return the items with discount
    public void items_with_discount(){
        for(inventory line : inventories){
            if(line.getDiscount()>0){
                System.out.println(line.toString());
            }
        }
    }

    //return the category of all items
    public void get_categories(){
        for(inventory line : inventories){
            System.out.println(line.getCategory());
        }
    }
    
    //return the product details using the category
    public void get_product_info(String category){
        for(inventory line : inventories){
            if((line.getCategory()).equals(category)){
                System.out.println(line.toString());
            }
        }
    }


    //return the product details using the model attributes
    public void get_product_details(String model){
        for(inventory line : inventories){
            if((line.getModel()).equals(model)){
                System.out.println(line.toString());
            }
        }
    }

    //return the price of the product using the model attributes
    public int get_price(String model){
        for(inventory line : inventories){
            if((line.getModel()).equals(model)){
                return line.getPrice();
            }
        }
        return 0;
    }

    //return the product details using the brand and model attributes
    public void get_product(String brand, String model){
        for(inventory line : inventories){
            if((line.getBrand()).equals(brand)&&(line.getModel()).equals(model)){
                System.out.println(line.toString());
            }
        }
    }

    //Generating the invoice using the model and price attributes
    public String invoic_genrate(String model, int price){
            Scanner scan = new Scanner(System.in);
            System.out.println("How much credit do you want to use ?");
            int credit_use = scan.nextInt();
            int n=price/1000;
            int total_credit=n*20;
            int amount_reduce =credit_use*50;
            int credit_remain= total_credit - credit_use;
            int balance_price= price - amount_reduce;
            return "-------Product Purchased Invoice --------\n" +"\n"+
                   "Amount Reduce = " + amount_reduce + "\n"+
                   "Total Credit = " + total_credit + "\n"+
                   "Credit Used = " + credit_use + "\n"+
                   "Credits Remain = " + credit_remain + "\n"+
                   "Total Price = " + balance_price + "\n";
    }


    //Checking the availability of the product
    public String check_stocks(String model){
        for(inventory line : inventories){
            if((line.getModel()).equals(model)){
                if(line.getStock()>0){
                    return "Product Available, Continue Purchase....\n";
                }else{
                    return "Product Out of Stock, Continue Purchase....\n";
                }
            }
        }
        return "Please Enter the correct details.........\n";

    }
    
}
