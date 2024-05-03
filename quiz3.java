
import java. util.*;
 class c1  extends Thread  {
    String str1[] ={"what is the captial of india ?",
                    "What is the full form of oops ?",
                    "who developed c language ?",
                    " who developed c++ language ?",
                    " how many keyword is used in c lanuage ?"};
                    String flip ="What is the capital of Haryana ?";

                    String str2[][]={{"1) new delhi ","2)gurdaspur","  3) patiala",  "4)Amritsar."},{
                                        "1)objects oriends programing ","2)object oriented programming", "3)oreinteds objects programming", "4) none of these ."},{
                                     "1)Dennis ritche", "2)bjourne storustrup", "3)william shaspear", "4)none of these ."},{
                                     "1)Dennis ritche  ","2)bjourne storustrup ","3)william shaspear",  "4)none of these ."},{
                                       "1)43 ","2)56"," 3)32", " 4) 78 ."}};
                    String flipoption = "1)punjab 2)ludihana 3)noid 4)chandigarh";
                    String str3[] = {"1","2","1","2","3"};
                    String flipAns= "4";
                    int right =0;
                    int wrong =0;
                    int skip =0;
                    int flag1=0;
                    int flag2 =0;
                    int flag3=0;
                    int i;
                    int j;
String hint[]={" red fort is locates in this city.",
  "it is evolution of procedural language.",
   "he was an American scientist.",
  "he was served as a visiting professor of computer science at columbia university in the city of newyork.",
  "these words are help us to use the functionalty of c language."};
                    public void run(){
                        for(i=0;i<str1.length;i++){
                            System.out.println("Question"+(i+1)+":" +str1[i]);
                            for(j=0;j<str2.length-1;j++){
                            System.out.println(str2[i][j]);
                            }
                            System.out.println("enter your Anser(1,2,3,4,5->skip,6->lifeline): ");
                            c2 p = new c2(this);
                                      p.start();
                                    this.suspend();

                        }        System.out.println("quiz summary");
                                 System.out.println("correct anser"+right);
                                 System.out.println("wrong anser"+wrong);
                                 System.out.println("skip anser"+skip);
                    }

         
                            

}
class c2 extends Thread{
        c1 w;
        c2(c1 p){
            w=p;
        }
        Scanner s = new Scanner(System.in);
        public void run(){
            String ans = s.nextLine();
            if(ans.equals(w.str3[w.i]))
            {
                  w.right++;
            }
            else if(ans.equals(w.flipAns)){
                w.right++;
            }
            else if(ans.equals("5")){
                w.skip++;
            }
            else if(ans.equals("6")){
                c3 r = new c3(w,this);
                r.start();
                this.stop();

            }
            else{
                w.wrong++;
            }
            w.resume();
        }

}
class c3 extends Thread{
    c2  t;
    c1 v;
    c3 (c1 w, c2 p){
        t=p;
        v=w;
    }
    public void menu(){
        System.out.println("\n1 for 50:50\n2 for hint\n3 for flip ");
    }
    public void run(){
        menu();
        Scanner s =  new Scanner(System.in);
        int  b = s.nextInt();
        if(b==1){
            if(v.flag1==0){
                if(v.str3[v.i]=="1"){
                    System.out.println(v.str2[v.i][0]);
                
                    System.out.println(v.str2[v.i][1]);
                }
                else if(v.str3[v.i]=="2"){
                   System.out.println(v.str2[v.i][1]);
                   System.out.println(v.str2[v.i][2]);

                }
                else if(v.str3[v.i]=="3"){
                   System.out.println(v.str2[v.i][2]);
                    System.out.println(v.str2[v.i][3]);

                }
                else if(v.str3[v.i]=="4"){
                    System.out.println(v.str2[v.i][3]);
                    System.out.println(v.str2[v.i][0]);
                }
                v.flag1=1;
            }
        
        else {
            System.out.println("cannot take 50:50");
        }
    }
    
 else if(b==2){
    if(v.flag2==0){
          System.out.println(v.hint[v.i]);
v.flag2=1;
}


else{
    System.out.println("cannot take hint");
}
 }


 else if(b==3){
    if(v.flag3==0){
        System.out.println(v.flip);
        System.out.println(v.flipoption);
        System.out.println("enter your anser");
    
    }

    else{
        System.out.println("cannot take flip");
    
    v.flag3=1;
    }
}



         c2 d = new c2(v);
         d.start();


    }
}
 public class quiz3{
    public static void main(String[] args){
        c1 p =new c1();
        p.start();
    } 
}
 

