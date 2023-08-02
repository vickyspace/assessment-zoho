class customer{
    private String username;
    private String password;
    private String name;
    private String number;
    private int credit;


    //Constructors
    public customer(String username, String password, String name, String number, int credit){
        this.username=username;
        this.password=password;
        this.name=name;
        this.number=number;
        this.credit=credit;

    }


    //Getter and Setters
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCredit() {
        return this.credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }


    //toString Method
    @Override
    public String toString() {
        return "UserName : "+ username +"\n"+
               "Password : "+ password +"\n"+
               "Name : "+ name +"\n"+
               "Mobile : "+ number +"\n"+
               "Credit : "+ credit + "\n";
    }
    
}