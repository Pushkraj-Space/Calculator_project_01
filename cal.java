//Author :- Pushkraj
// Date of Creation :- 18th October  2022
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.lang.Math;
public class cal extends Applet implements ActionListener{
    TextField t1,t2;
    Label l1,l2;
    Button b[] = new Button[21];
    double[] ans = new double[2];
    String str[] = {"7","8","9","*","C","4","5","6","-","\u221A","1","2","3","+","X!","0",".","/","=","Dev_Info"};
    int i,x=100,y=100,k=0,j,dot=0,flag=0;
    double prev=0,curr=0,temp=0,n;
    char ch='8';
    public void init(){
        setLayout(null);
        t1 = new TextField(250);
        add(t1);
        t2 = new TextField(250);
        add(t2);
        // t1.setBounds(100,100,250,50);
        // t2.setBounds(100,80,250,20);
        t1.setBounds(0,0,0,0);
        t2.setBounds(100,100,250,50);
        t1.setEditable(false);
        t2.setEditable(false);
        t1.setBackground(Color.white);
        t2.setBackground(Color.white);
        for(i=1; i<5; i++){
            x = 100;
            y += 50;
           for(j=0; j<5; j++){
                b[k] = new Button(str[k]);
                add(b[k]);
                b[k].addActionListener(this);
                b[k++].setBounds(x,y,50,50);
                x+=50;
           }
        }
    }
    public void actionPerformed(ActionEvent e){
        for(i=0; i<17; i++){
            if((e.getSource() == b[i]) && i!=3 && i!=4 && i!=8 && i!=9 && i!=13 && i!=14 && i!=16){
                t1.setText(t1.getText() + str[i]);
                t2.setText(t2.getText() + str[i]);
            }
        }
        if(e.getSource() == b[16]){
            if(dot == 0){
                t1.setText(t1.getText() + str[16]);
                t2.setText(t2.getText() + str[16]);
                dot=1;
            }else{
                t1.setText("Invalid Syntax !");
            }
        }
        if(e.getSource() == b[13]){
            //plus
            if(ch!='8' && ch!='+'){
                check();
                ch = '+';
            }else{
                ch='+';
                check();
            }
            dot = 0;
            flag=1;
            t2.setText(t2.getText() + str[13]);
            t1.setText("");
        }
        if(e.getSource() == b[8]){
            //minus
            if(ch!='8' && ch!='-'){
                check();
                ch = '-';
            }else{
                ch='-';
                check();
            }
            dot = 0;
            flag = 1;
            t2.setText(t2.getText() + str[8]);
            t1.setText("");
        }
        if(e.getSource() == b[3]){
            //multiply
            if(ch!='8' && ch!='*'){
                check();
                ch = '*';
            }else{
                ch='*';
                check();
            }
            dot = 0;
            flag=1;
            t1.setText("");
            t2.setText(t2.getText() + str[3]);
        }
        if(e.getSource() == b[17]){
            //division
            if(ch!='8' && ch!='/'){
                check();
                ch = '/';
            }else{
                ch='/';
                check();
            }
            dot = 0;
            flag=1;
            t1.setText("");
            t2.setText(t2.getText() + str[17]);
        }
        if(e.getSource() == b[9]){
            //sqrt
            dot = flag = 0;
            prev = Double.parseDouble(t1.getText());
            t1.setText(Double.toString(Math.sqrt(prev)));
            t2.setText(Double.toString(Math.sqrt(prev)));
        }
        if(e.getSource() == b[4]){
            //clear
            dot = flag = 0;
            curr = prev = 0;
            ch = '8';
            t1.setText("");
            t2.setText("");
        }
        if(e.getSource() == b[18]){
            //equal (=)
            check();
            prev =0;
            dot = flag = 0;
            ch='8';
            t1.setText(Double.toString(curr));
            t2.setText(Double.toString(curr));
        }
        if(e.getSource() == b[14]){
            //Factorial
            n = Double.parseDouble(t1.getText());
            double fact = 1;
            for(i=2; i<=n; i++){
                fact = fact * i;
            }
            t1.setText(Double.toString(fact));
            if(ch!='8')
                t2.setText(t2.getText() + "!");
            else
                t2.setText(t1.getText());
            dot = flag = 0;
        }
        if(e.getSource() == b[19]){
            t2.setText("/* Devloped by Pushkraj */");
            t1.setText("/* Devloped by Pushkraj */");
        }
    }
    double check(){
        if(ch == '+'){
            curr = prev + Double.parseDouble(t1.getText());
            prev = curr;
        }else if(ch == '-'){
            if(flag==1)
            curr = prev - Double.parseDouble(t1.getText());
            else{
                flag=1;
                curr = Double.parseDouble(t1.getText());
            }
            prev = curr;
        }else if(ch == '*'){
            if(flag==1){
                curr = prev * Double.parseDouble(t1.getText());
            }else{
                flag=1;
                curr = Double.parseDouble(t1.getText());
            }
            prev = curr;
        }else if(ch=='/'){
            if(flag==1){
                curr = prev / Double.parseDouble(t1.getText());
            }else{
                flag=1;
                curr = Double.parseDouble(t1.getText());
            }
            prev = curr;
        }
        return curr;
    }
}