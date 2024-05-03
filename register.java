import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.Duration;

  class gym extends Frame implements ActionListener {
    Button b1, b2;


    public gym() {
        b1 = new Button("Register");
        b2 = new Button("login");
        setLayout(null);
        this.setTitle("gym");
        Color c = new Color(51, 153, 255);
        add(b1);
        add(b2);
        b1.setBounds(50, 60, 100, 30);
        b2.setBounds(50, 110, 100, 30);
        b1.setBackground(c);
        b2.setBackground(c);
        b1.addActionListener(this);
        b2.addActionListener(this);
        addWindowListener(new close(this));
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Register")) {
            loginpage p = new loginpage();
            p.setSize(500, 600);
            p.setVisible(true);
        } else if (ae.getActionCommand().equals("login")) {
        
            login k = new login();

            k.setSize(200, 200);
            k.setVisible(true);
        }
    }
}

 class close extends WindowAdapter {
    gym p;

    close(gym k) {
        p = k;
    }

    public void windowClosing(WindowEvent e) {
        p.dispose();
    }
}

class loginpage extends Frame implements ActionListener {
    TextField t1, t2, t3, t4, t5, t6, t7, t8, t9;
    Button B;
    Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l;

    public loginpage() {
        l = new Label("Registration form");
        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        t4 = new TextField();
        t5 = new TextField();
        t6 = new TextField();
        t7 = new TextField();
        t8 = new TextField();
        t9 = new TextField();
        B = new Button("submit");
        l1 = new Label("Duration:");
        l2 = new Label("Name:");
        l3 = new Label("UserName:");
        l4 = new Label("Password:");
        l5 = new Label("MobileNumber:");
        l6 = new Label("EmailId:");
        l7 = new Label("DateOfJoining:");
        l8 = new Label("Address:");
        l9 = new Label("VehicleNumber:");
        setLayout(null);
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
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(t7);
        add(t8);
        add(t9);
        add(B);

        l.setBounds(135, 40, 150, 20);
        l3.setBounds(20, 80, 90, 20);
        l2.setBounds(20, 120, 90, 20);
        l1.setBounds(20, 160, 90, 20);
        l4.setBounds(20, 200, 90, 20);
        l5.setBounds(20, 240, 90, 20);
        l6.setBounds(20, 280, 90, 20);
        l7.setBounds(20, 320, 90, 20);
        l8.setBounds(20, 360, 90, 20);
        l9.setBounds(20, 400, 90, 20);

        t3.setBounds(120, 80, 230, 20);
        t2.setBounds(120, 120, 230, 20);
        t1.setBounds(120, 160, 230, 20);
        t4.setBounds(120, 200, 230, 20);
        t5.setBounds(120, 240, 230, 20);
        t6.setBounds(120, 280, 230, 20);
        t7.setBounds(120, 320, 230, 20);
        t8.setBounds(120, 360, 230, 20);
        t9.setBounds(120, 400, 230, 20);

        B.setBounds(160, 440, 90, 20);

        this.setTitle("Registration form");
        addWindowListener(new closeregistration(this));
        B.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("submit")) {
            String url = "jdbc:mysql://localhost:3306/register";
            String username = "root";
            String password = "Anshika123";

             try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();

                String Duration= t1.getText();
                String Name = t2.getText();
                String UserName = t3.getText();
                String Password = t4.getText();
                String MobileNumber = t5.getText();
                String EmailId = t6.getText();
                String DateOfJoining = t7.getText();
                String Address = t8.getText();
                String VehicleNumber = t9.getText();

                String insertQuery = "INSERT INTO register (Duration, Name, UserName, Password, MobileNumber, EmailId, DateOfJoining, Address, VehicleNumber) VALUES "
                        + "('" + Duration + "', '" + Name + "', '" + UserName + "', '" + Password + "', '" + MobileNumber + "', '" + EmailId + "', '" + DateOfJoining + "', '" + Address + "', '" + VehicleNumber + "')";

                int rowsInserted = statement.executeUpdate(insertQuery);
                if (rowsInserted > 0) {
                    System.out.println("Registration successful.");
                    
                }

                statement.close();
                connection.close();
             } 
             catch (SQLException| ClassNotFoundException ex) {
                 ex.printStackTrace();
                System.out.println("Registration failed. Please try again.");
            }
        }
    }
}

class closeregistration extends WindowAdapter {
    loginpage p;

    closeregistration(loginpage k) {
        p = k;
    }

    public void windowClosing(WindowEvent e) {
        p.dispose();
    }
}
    class Gympage extends Frame implements ActionListener{
    Button b1,b2;
    Label l ,l1;
    Gympage(){
        b1=new Button("User");
        b2=new Button("Admin");
        l=new Label("Welcome");
        l1=new Label("Who are you?");
        setLayout(null);
        l.setFont(new Font("Arial", Font.PLAIN, 50));
        l1.setFont(new Font("Arial", Font.PLAIN, 24));
       this.setBackground(Color.CYAN);
        add(b1);
        add(b2);
        add(l);
        add(l1);
        l.setBounds(150,50,300,70);
        l1.setBounds(170,120,200,50);
        b1.setBounds(200,200,100,30);
        b2.setBounds(200,250,100,30);
        b1.addActionListener(this);
        b2.addActionListener(this);
        addWindowListener(new GympageClose(this));
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("User")){
           gym l = new gym();
            l.setSize(200, 200);
            l.setVisible(true);
        
        }
       else if(ae.getActionCommand().equals("Admin")){
         Adminpanel ap=new Adminpanel();
          ap.setSize(500,350);
            ap.setVisible(true);
        }
    }

}
class GympageClose extends WindowAdapter{
     Gympage g;
     GympageClose(Gympage g1){
       g=g1;
     }
     public void windowClosing(WindowEvent w){
        g.dispose();
     }
}

public class register {
         
    public static void main(String[] args) {
        String AdminId =  "Admin";
        String AdminPassword = "GYM123456789";
        Gympage p = new Gympage();
        p.setSize(500, 500);
        p.setVisible(true);
    }
}

