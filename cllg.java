import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
class adminlogin extends Frame {
    String str1 = "";
    String str2 = "";
    String str3 ="";
    MenuBar m;
    Menu viewdetail,applyleave,examination,timetable,feedetail;
    public adminlogin(){
        m  = new MenuBar();
        setTitle("student page");
        viewdetail = new Menu("viewdetail");
        applyleave = new Menu("applyleave");
        examination = new Menu("examination");
        timetable = new Menu("timetable");
        feedetail = new Menu("feedetail");
        setMenuBar(m);
        m.add(viewdetail);
        m.add(applyleave);
        m.add(examination);
        m.add(timetable);
        m.add(feedetail);

        

    }

}  
class viewdetail implements ActionListener{
      Label uid,studentname, Branch;
      
       public viewdetail(){
        uid = new Label("password");
       }


}
class cllg {
    public static void main(String[] args){
        adminlogin a  = new adminlogin();
        a.setVisible(true);
        a.setSize(200,200);
    }
}