import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class newformdetail extends Frame implements ActionListener{
    Label studentname ,Branch,Course,Fathername,Mothername,Phonenumber,Address,Emailid ,twl,ten;
    Label newform;
    TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    Button submit;
    public newformdetail(){
studentname = new Label("Student name");
       Branch = new Label("Branch");
       Course = new Label("Course");       
       Fathername = new Label("Father name");
       Mothername = new Label("Mother name");
       Phonenumber = new Label("Phone number");
       Address = new Label("Address");
       Emailid = new Label("Email id");
       twl = new Label("12th DMC");
       ten =  new Label("10th DMC");
       newform = new Label("New Admission");
       t1 = new TextField();
       t2 = new TextField();
       t3 = new TextField();
       t4 =new TextField();
       t5 = new TextField();
       t6 = new TextField();
       t7 =new TextField();
       t8 = new TextField();
       t9 =new TextField();
       t10=new TextField();
       add(studentname);
       add(Fathername);
       add(Mothername);
       add(Address);
       add(Emailid);
       add(Phonenumber);
       add(Branch);
       add(Course);
       add(newform);
       add(twl);
       add(ten);
       add(t1);
       add(t2);
       add(t3);
       add(t4);
       add(t5);
       add(t6);
       add(t7);
       add(t8);
       add(t9);
       add(t10);
       setLayout(null);
       studentname.setBounds(50, 50, 100, 30);
    Fathername.setBounds(50, 90, 100, 30);
    Mothername.setBounds(50, 130, 100, 30);
    Address.setBounds(50, 170, 100, 30);
    Emailid.setBounds(50, 210, 100, 30);
    Phonenumber.setBounds(50, 250, 100, 30);
    Branch.setBounds(50, 290, 100, 30);
    Course.setBounds(50, 330, 100, 30);
    twl.setBounds(50, 370, 100, 30);
    ten.setBounds(50, 410, 100, 30);

    t1.setBounds(200, 50, 200, 30);
    t2.setBounds(200, 90, 200, 30);
    t3.setBounds(200, 130, 200, 30);
    t4.setBounds(200, 170, 200, 30);
    t5.setBounds(200, 210, 200, 30);
    t6.setBounds(200, 250, 200, 30);
    t7.setBounds(200, 290, 200, 30);
    t8.setBounds(200, 330, 200, 30);
    t9.setBounds(200, 370, 200, 30);
    t10.setBounds(200, 410, 200, 30);
    newform.setBounds(200, 10, 100, 30);


    submit = new Button("Submit");
    submit.setBounds(200, 450, 80, 30);
    submit.addActionListener(this);
    add(submit);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Submit")){
               adminlogin a  = new adminlogin();
               a.setVisible(true);
               a.setSize(500,500 );
        }
    }
    
}
public class newform{
    public static void main(String[] args){
        newformdetail p = new newformdetail();
        p.setVisible(true);
        p.setSize(500,500);
    }
} 