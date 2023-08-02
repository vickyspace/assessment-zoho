import java.util.Scanner;

class app{
    
    public static void main(String [] args){
      
        //Reading the Customer Information from the zuser_db.txt file
        customerservice customerobj = new customerservice();
        customerobj.readCustomers("zusers_db.txt");

        //Reading the Inventory Information from the zkart_db.txt file
        inventoryservice inventoryobj = new inventoryservice();
        inventoryobj.readinventory("zkart_db.txt");

        //Validating the users -- Login Portal 
        System.out.println("-------- Welcome to Z-Kart Application -------------\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the username ?");
        String username =scan.nextLine();
        System.out.println("Enter the password ?");
        String password =scan.nextLine();

        //Validating users credentials -------(---Admin Mode Added---)
        if (customerobj.validate_customers(username, password)){
            System.out.println("Login Success, Continue Your Shopping....\n");
            System.out.println("These are the products having discounts...\n");
            inventoryobj.items_with_discount();
            System.out.println("Add to cart, y or n ?");
            String output=scan.nextLine();

            //Looping the purchase till customers add the product to cart ------
            while ((output).equals("n")){

                //Search by category -----
                System.out.println("The Categories of products available are....\n");
                inventoryobj.get_categories();
                System.out.println("Enter the name of the Categories want to show ?");
                String category = scan.nextLine();
                inventoryobj.get_product_info(category);

                //Product confirmation for buying -----
                System.out.println("Enter the brand name that you want to purchase ?");
                String brand = scan.nextLine();
                System.out.println("Enter the model name that you want to purchase ?");
                String model = scan.nextLine();
                inventoryobj.get_product(brand, model);

                //Checking availability ---
                System.out.println("Checking availability...\n");
                System.out.println(inventoryobj.check_stocks(model));

                //if customer didn't purchase, the loop starts again -----
                System.out.println("Add to cart, y or n ?");
                output=scan.nextLine();
            }

            if((output).equals("y")){

                //Product confirmation for buying -----
                System.out.println("Enter the brand name that you want to purchase ?");
                String brand = scan.nextLine();
                System.out.println("Enter the model name that you want to purchase ?");
                String model = scan.nextLine();
                inventoryobj.get_product(brand, model);

                //Checking availability ---
                System.out.println("Checking availability...\n");
                System.out.println(inventoryobj.check_stocks(model));

                //product summary ----
                System.out.println("------Product Summary -------\n");
                inventoryobj.get_product_details(model);

                //Calculating the price by using credits ----
                int price = inventoryobj.get_price(model);
                System.out.println(inventoryobj.invoic_genrate(model, price));
                System.out.println("Product Purchased Successfully.....\n");
            }
        }else{
            System.out.println("Login Failed, If you are not registered, please sign up...\n");
        }
    }
}
