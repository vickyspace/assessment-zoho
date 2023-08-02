import java.io.*;
import java.util.ArrayList;
import java.util.List;

class customerservice{

    List<customer> customers = new ArrayList<>();


    //reading contents from customer file
    public void readCustomers(String filepath){

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                String username = data[0];
                String password = data[1];
                String name = data[2];
                String number = data[3];
                int credit = Integer.parseInt(data[4]);
                customers.add(new customer(username, password, name, number, credit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //validating the customer credentials
    public boolean validate_customers(String username, String password){
        for(customer line :customers){
            if(((line.getUsername()).equals(username) && (line.getPassword()).equals(password)) || ((line.getUsername()).equals("admin@zoho.com") && (line.getPassword()).equals("xyzzy"))){
                return true;
            }
        }
        return false;

    }
}