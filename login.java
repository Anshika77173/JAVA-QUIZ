 import java.awt.*;
import  java.awt.event.*;
import java.sql.*;
class login extends Frame implements ActionListener{
    TextField t1,t2;
    Label l1,l2,l3,l4,l5;
    Button b;
    public login(){
        Color c=new Color(51,153,255);
        t1 = new TextField("UserName");
        t2 = new TextField("Password");
        l1 = new Label("Login");
        l2 = new Label("please enter your login and password");
        l3 = new Label("forgot password");
        b = new Button("login");
        setLayout(null);
         this.setBackground(c);
        add(l1);
        add(l2);
        add(t1);
        add(t2);
        add(l3);
        add(b);
        l1.setBounds(210,60,100, 20);
        l2.setBounds(125,80,220,20);
        t1.setBounds(150,120,170,20);
        t2.setBounds(150,160,170,20);
        l3.setBounds(190,180,90,20);
        b.setBounds(150,220,170,20);
        b.addActionListener(this);
        addWindowListener(new closelogin(this));
    }
        public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("login")) {
            String enteredUsername = t1.getText();
            String enteredPassword = t2.getText();

            
            boolean isValid = validateLogin(enteredUsername, enteredPassword);

            if (isValid) {
                D1 d = new D1(this, "Login Successful", false);
                d.setSize(200, 200);
                d.setVisible(false);
          userdetail p = new userdetail();
           p.setSize(200,200);
           p.setVisible(true);

                
            } else {
                D1 d = new D1(this, "Login Failed", false);
                d.setSize(200, 200);
                d.setVisible(true);
            }
        }
    }
    private boolean validateLogin(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/register";
        String dbUserName = "root";
        String dbPassword = "Anshika123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);
            Statement statement = connection.createStatement();

            String selectQuery = "SELECT * FROM register WHERE UserName = '" + username + "' AND Password = '" + password + "'";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            boolean isValid = resultSet.next();

            resultSet.close();
            statement.close();
            connection.close();

            return isValid;
        }
         catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
}
}
class D1 extends Dialog {
    Label l1;
    public D1(Frame parent, String message, boolean a) {
        super(parent, "", a);
        l1 = new Label(message);
        setLayout(null);
        add(l1);
        l1.setBounds(50, 90, 100, 20);
      
    }
}

class closelogin extends WindowAdapter{
    login p;
    closelogin(login k ){
        p=k;
    }
    public void windowClosing(WindowEvent e){
        p.dispose();
    }
}


class userdetail extends Frame implements ActionListener{
Button b1,b2,b3,b4,b5,b6;
     userdetail(){
       
   b1 =new Button("see your  diet schedule");
    b2 = new Button("see your payment status");
    b3 = new Button("see the comments by admin");
    b4 = new Button("request for purchase of suppliments");
   b5 =new Button("request for purchase of gym equipments ");
   b6 = new Button ("status of attendance");
   add(b1);
   add(b2);
   add(b3);
   add(b4);
   add(b5);
   add(b6);

        setLayout(null);
        b1.setBounds(250, 100, 250, 30);
        b2.setBounds(250, 150, 250, 30);
        b3.setBounds(250, 200, 250, 30);
        b4.setBounds(250, 250, 250, 30);
        b5.setBounds(250, 300, 250, 30);
        b6.setBounds(250, 350, 250, 30);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        this.setBackground(Color.cyan);


    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("see your diet schedule")){
            // Diet d = new Diet();
            // d.setSize(500,500);
            // d.setVisible(true);
        }
        else if(e.getActionCommand().equals("see your payment status")){
            // payment  p  = new payment();
            // p.setSize(500,500);
            // p.setVisible(true);
        }
        else if(e.getActionCommand().equals("request for purchase of suppliments")){
            //  suppliments s = new suppliments();
            //  s.setSize(400,300);
            //  s.setVisible(true);
        }
        else if(e.getActionCommand().equals("request for purchase of gym equipments")){
            // purchase p = new purchase();
            // p.setSize(500,500);
            // p.setVisible(true);
        }
        else if(e.getActionCommand().equals("see the comments by admin")){
            
            // comments c = new comments();
            // c.setSize(500,500);
            // c.setVisible(true);
        }
    }


}
class loginfailed extends Frame{
    Label l ,l1;
    loginfailed(){
        l = new Label("login failed");
        l1 = new Label("please enter your valid ID and PASSWORD");
        this.setLayout(null);
        this.setBackground(Color.CYAN);
        l.setFont(new Font( "Arial",Font.PLAIN,50));
         l1.setFont(new Font( "Arial",Font.PLAIN,50)); 
         add(l);
         add(l1);
         l.setBounds(135,100,180,50);
         l1.setBounds(80,180,400,30);

    }
}
 class Adminpanel extends Frame  implements ActionListener{
    Button b;
    TextField AdminID,AdminPASSWORD;
    Label  l,l1,l2;
    Adminpanel(){
        b =new Button("login");
        AdminID = new TextField();
        AdminPASSWORD = new TextField();
        l = new Label("Admin page");
        l1= new Label("AdminID");
        l2 = new Label("AdminPASSWORD");
        setLayout(null);
        this.setBackground(Color.CYAN);
         l.setFont(new Font( "Arial",Font.PLAIN,50));
         l1.setFont(new Font( "Arial",Font.PLAIN,20));
         l2.setFont(new Font( "Arial",Font.PLAIN,20));
         add(b);
         add(AdminID);
         add(AdminPASSWORD);
         add(l);
         add(l1);
         add(l2);
         b.addActionListener(this);
          l.setBounds(110,70,300,70);
                 l1.setBounds(50,170,120,30);
                 AdminID.setBounds(240,170,200,30);
                 l2.setBounds(50,220,180,30);
                 AdminPASSWORD.setBounds(240,220,200,30);
                 b.setBounds(200,280,100,30);
        
    }
    public void actionPerformed(ActionEvent e){
        String str = AdminID.getText();
        String str1 =AdminPASSWORD.getText();
        if(e.getActionCommand().equals("login")){
          if(str.equals("Admin") && str1.equals("GYM123456789")){  
            Admindetails AP = new Admindetails();
            AP.setSize(500,500);
            AP.setVisible(true);
          }
          else{
            loginfailed f = new loginfailed();
            f.setSize(500,500);
            f.setVisible(true);
          }
        }
    }
    

}

class Admindetails extends Frame implements ActionListener{
    Button b1,b2,b3,b4,b5,b6,b7,b8;
        String str = "";
    Admindetails(){
        
        b1 = new Button("enter the registration fees");
        b2 = new Button("check diet schedule");
        b3 = new Button("check time schedule");
        b4 = new Button("check exrecise regime");
      b5 = new Button  ("equipments");
      b6 = new Button ("suppliments");
      b7= new Button  ("mark status");
      b8= new Button  ("mark attendance");
        setLayout(null);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);  
         b1.addActionListener(this);
        b2.addActionListener(this);  
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this); 
         b1.setBounds(50, 50, 200, 30);
        b2.setBounds(50, 100, 200, 30);
        b3.setBounds(50, 150, 200, 30);
        b4.setBounds(50, 200, 200, 30);
        b5.setBounds(50, 250, 200, 30);
        b6.setBounds(50, 300, 200, 30);
        b7.setBounds(50, 350, 200, 30);
        b8.setBounds(50, 400, 200, 30);

       
               this.setBackground(Color.cyan);


    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("enter the registration fees")){
             fees f = new fees();
             f.setSize(500,500);
             f.setVisible(true);
        }
        else if(e.getActionCommand().equals("check diet schedule")){
               diet t = new diet();
               t.setSize(500,500);
               t.setVisible(true);
        }
        
        else if(e.getActionCommand().equals("check time schedule")){
            String str = "hello";
        }
        else if(e.getActionCommand().equals("check exercise regime")){
            String str ="hello";

        }
        else if(e.getActionCommand().equals("equipments")){
            equipments p = new equipments();
            p.setSize(500,500);
            p.setVisible(true);
        }
        else if(e.getActionCommand().equals("suppliments")){
            suppliments s = new suppliments();
            s.setSize(500,500);
            s.setVisible(true);
        }
        else if(e.getActionCommand().equals("mark status")){
            String str= "hello";
        }
        else if(e.getActionCommand().equals("mark attendance")){
            String str = "hello";
        }

    }
   
}

    class suppliments extends Frame{
        Label l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
        suppliments(){
            l =new Label("Suppliments availble in GYM");
            l1 = new Label("Protein powder");
            l2 = new Label("Ceratin");
            l3= new Label("Branched chain Amino acid");
            l4 = new Label("pre workout suppliments");
            l5 = new Label("Beta Alinine");
            l6 = new Label("Fish oil");
            l7 = new Label("glutamine");
            l8 = new Label("vitamins and minerals");
            l9 = new Label("multivitamins");
            l10 = new Label("ZMA");
            l11 = new Label("Caffiene");
            l12 = new Label("Whey isolate");
            l13 = new Label("post workout suppliments");
            setLayout(null);
             l.setFont(new Font( "Arial",Font.PLAIN,15));
            
            add(l);
            add(l1);
            add(l2);
            add(l3);
            add(l4);
            add(l5);
            add(l6);
            add(l7);
            add(l8);
            add(l9);
            add(l10);
            add(l11);
            add(l12);
            add(l13);
            l.setBounds(150,50,150,20);
            l1.setBounds(100,100,150,20);
            l2.setBounds(100,150,150,20);
            l3.setBounds(100,200,150,20);
            l4.setBounds(100,250,150,20);
            l5.setBounds(100,300,150,20);
            l6.setBounds(100,350,150,20);
            l7.setBounds(100,400,150,20);
            l8.setBounds(100,450,150,20);
            l9.setBounds(100,500,150,20);
            l10.setBounds(100,550,150,20);
            l11.setBounds(100,600,150,20);
            l12.setBounds(100,650,150,20);
            l13.setBounds(100,700,150,20);
            this.setBackground(Color.cyan);


        }
    } 
   
    class diet extends Frame implements ActionListener{
//String Str[][]={{"Day:","BreakFast","Lunch","Pre-workout Snack","Dinner"},{"First:","Oats Banana Pancakes with Protein Shake","Multigrain roti + palak chicken + Avocado bell pepper salad","Bananas","Brown rice, peas paneer curry, sprouts vegetable salad"},{"Secnod:","Oatmeal with Greek Yogurt & Seasonal fruit Mango Juice","Multigrain roti, fish curry, vegetable salad","Toast with Jam","Broken wheat khichidi along with carrot raita, egg white, and vegetable salad"},{"Third:","Poached Eggs Whole Grain Toast" ,"Protein Shake","Quinoa upma, chicken and broccoli salad","Mixed Nuts & Dried Fruits","Lean Beef and vegetable curry, brown rice, cucumber raita Baby Potatoes" ,"Chocolate Milk"},{"Fourth:","Oatmeal with Honey Apple Juice","Grilled Chicken salad Whole Grain Bread","Toast with Peanut Butter","Methi Chicken Brown Rice Broccoli Protein Shake"},{"FiFth:","Scrambled Egg Whole Grain Toast Smoothie","Grilled chicken vegetable roti rolls Green Salad","Mixed Nuts & Dried Fruits","Chicken Stir Fry Spring Onion, Peppers & Broccoli Chocolate Milk"},{"Sixth:","Oatmeal Whole Grain Toast Orange Juice ","Whole Grain Chicken Wrap Black Beans, Peppers & Greek Yogurt","Apple with peanut butter ","Keema bhurji and multigrain rotiLean Beef Mince Sweet Potato Protein Shake"},{"Seventh:","Oatmeal with Nuts Smoothie","Whole wheat pasta with chicken and Green Salad","Granola or Cereal","Fish curry, boiled green peas salad Brown Rice Garden Peas Milk"}};

Button b;
TextField Day,Breakfast,Lunch,preWorkOutSnack,Dinner;
Label l,l1,l2,l3,l4,l5;
public diet(){
     l4=new Label("Set Diet Plan");
    l=new Label("Day:");
    l1=new Label("Breakfast:");
    l2=new Label("Lunch:");
    l3=new Label("preWorkOutSnack:");
    l5=new Label("Dinner:");
Day=new TextField();
Breakfast=new TextField();
Lunch=new TextField();
preWorkOutSnack=new TextField();
Dinner=new TextField();
b=new Button("Add into Diet");
setLayout(null);
this.setBackground(Color.CYAN);
l4.setFont(new Font("Arial", Font.PLAIN, 40));
l.setFont(new Font("Arial", Font.PLAIN, 20));
l1.setFont(new Font("Arial", Font.PLAIN, 20));
l2.setFont(new Font("Arial", Font.PLAIN, 20));
l3.setFont(new Font("Arial", Font.PLAIN, 20));
l5.setFont(new Font("Arial", Font.PLAIN, 20));
add(l);
add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(Day);
add(Breakfast);
add(Lunch);
add(preWorkOutSnack);
add(Dinner);
add(b);

l4.setBounds(120,40,250,70);
l.setBounds(20,130,150,30);
l1.setBounds(20,180,150,30);
l2.setBounds(20,230,150,30);
l3.setBounds(20,280,180,30);
l5.setBounds(20,330,150,30);
Day.setBounds(210,130,350,30);
Breakfast.setBounds(210,180,350,30);
Lunch.setBounds(210,230,350,30);
preWorkOutSnack.setBounds(210,280,350,30);
Dinner.setBounds(210,330,350,30);
b.setBounds(200,380,100,30);
b.addActionListener(this);;
}
public void actionPerformed(ActionEvent a){
    if(a.getActionCommand().equals("Add into Diet")){
       
            String url = "jdbc:mysql://localhost:3306/register";
            String username = "root";
            String password = "Anshika123";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();

               
                
                String breakfast = Breakfast.getText();
                String lunch = Lunch.getText();
                String PreWorkOutSnack = preWorkOutSnack.getText();
                String dinner = Dinner.getText();
               
               
                String insertQuery = "INSERT INTO dietchart (Breakfast, Lunch, Preworkoutsnaks, Dinner) VALUES "
                        + "('" + breakfast + "', '" + lunch + "', '" + PreWorkOutSnack+ "', '" + dinner +  "')";
                      int rowsInserted = statement.executeUpdate(insertQuery);
                    if(rowsInserted>0){
                        D1 d = new D1(this, "Submit", false);
                    d.setSize(200, 200);
                    d.setVisible(true);
                    }
                
                statement.close();
                connection.close();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}  
    class fees extends Frame implements ActionListener{
    TextField t1,t2,t3;
    Label l,l1,l2,l3;
    Button b;
    public fees(){
        t1=new TextField(getName(), ABORT);
         t2=new TextField(getName(), ABORT);
          t3=new TextField(getName(), ABORT);
          l=new Label("Add Registeration Fees");
          l1=new Label("User_Id:");
          l2=new Label("Name:");
          l3=new Label("Registeration Fees");
          b=new Button("Add");
          setLayout(null);
          this.setBackground(Color.CYAN);
          l.setFont(new Font("Arial",Font.PLAIN,30));
          l1.setFont(new Font("Arial",Font.PLAIN,15));
          l2.setFont(new Font("Arial",Font.PLAIN,15));
          l3.setFont(new Font("Arial",Font.PLAIN,15));
          add(t1);
          add(t2);
          add(t3);
          add(l);
          add(l1);
          add(l2);
          add(l3);
          add(b);
          l.setBounds(120,40,250,70);
l1.setBounds(20,130,150,30);
l2.setBounds(20,180,150,30);
l3.setBounds(20,230,150,30);
t1.setBounds(210,130,350,30);
t2.setBounds(210,180,350,30);
t3.setBounds(210,230,350,30);
b.setBounds(200,280,100,30);
          b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add")){
             
        String Userid = t1.getText();
            String UserName = t2.getText();
String url1 = "jdbc:mysql://localhost:3306/register";
        String dbUsername1 = "root";
        String dbPassword1 = "Anshika123";
                try {
    
     Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url1, dbUsername1, dbPassword1);
                Statement statement = connection.createStatement();
            String Fees=t3.getText();
                
               String query1 = "update register set fees='"+Fees+"' where UserId='"+Userid+"' ";
               int t= statement.executeUpdate(query1);
                    System.out.println(t);
               statement.close();
                connection.close();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
                System.out.println(ex);
            }
        }
            
    else {
                D1 d = new D1(this, " Failed", false);
                d.setSize(200, 200);
                d.setVisible(true);
    }
}
        }

            
    
    class equipments extends Frame{
        Label  L ,l1,l2,l3,l4,l5,l6;
        equipments(){
            L =  new Label ("Equipments List");
            l1 = new Label("cardiovsscular equipments");
            l2 = new Label("Strength traning equipments");
            l3 = new Label("Functional training equipments");
            l4 = new Label("Machines for isolation  exercises");
            l5 = new Label("Crossfit and hiit equipments");
            l6 = new Label("Group exercise equipments");
            L.setFont(new Font("Arial",Font.PLAIN,40));
            l1.setFont(new Font("Arial",Font.PLAIN,20));
            l2.setFont(new Font("Arial",Font.PLAIN,20));
            l3.setFont(new Font("Arial",Font.PLAIN,20));
            l4.setFont(new Font("Arial",Font.PLAIN,20));
            l5.setFont(new Font("Arial",Font.PLAIN,20));
            l6.setFont(new Font("Arial",Font.PLAIN,20));
            
            setLayout(null);
            add(L);
            add(l1);
            add(l2);
            add(l3);
            add(l4);
            add(l5);
            add(l6);
            L.setBounds(100,40,300,60);
         l1.setBounds(100, 130, 300, 30);
        l2.setBounds(100, 170, 300, 30);
        l3.setBounds(100, 220, 300, 30);
        l4.setBounds(100, 270, 300, 30);
        l5.setBounds(100, 320, 300, 30);
        l6.setBounds(100, 370, 300, 30); 
        this.setBackground(Color.CYAN);
                  }

    }
