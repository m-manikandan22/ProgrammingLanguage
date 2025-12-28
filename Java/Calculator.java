import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    TextField display;
    Button bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,plus,minus,multi,div,clear,equals;

    Calculator(){
        display = new TextField("0");
        display.setBounds(50,50,400,50);

        bt0 = new Button("0");
        bt0.setBounds(160,450,80,80);
        bt0.addActionListener(this);

        bt1 = new Button("1");
        bt1.setBounds(60,350,80,80);
        bt1.addActionListener(this);

        bt2 = new Button("2");
        bt2.setBounds(160,350,80,80);
        bt2.addActionListener(this);

        bt3 = new Button("3");
        bt3.setBounds(260,350,80,80);
        bt3.addActionListener(this);

        bt4 = new Button("4");
        bt4.setBounds(60,250,80,80);
        bt4.addActionListener(this);

        bt5 = new Button("5");
        bt5.setBounds(160,250,80,80);
        bt5.addActionListener(this);

        bt6 = new Button("6");
        bt6.setBounds(260,250,80,80);
        bt6.addActionListener(this);

        bt7 = new Button("7");
        bt7.setBounds(60,150,80,80);
        bt7.addActionListener(this);

        bt8 = new Button("8");
        bt8.setBounds(160,150,80,80);
        bt8.addActionListener(this);

        bt9 = new Button("9");
        bt9.setBounds(260,150,80,80);
        bt9.addActionListener(this);

        plus = new Button("+");
        plus.setBounds(360,150,80,80);
        plus.addActionListener(this);

        minus = new Button("-");
        minus.setBounds(360,250,80,80);
        minus.addActionListener(this);

        multi = new Button("*");
        multi.setBounds(360,350,80,80);
        multi.addActionListener(this);

        div = new Button("/");
        div.setBounds(360,450,80,80);
        div.addActionListener(this);

        clear = new Button("clear");
        clear.setBounds(60,450,80,80);
        clear.addActionListener(this);

        equals = new Button("=");
        equals.setBounds(260,450,80,80);
        equals.addActionListener(this);

        add(display);
        add(bt0);
        add(bt1);
        add(bt2);
        add(bt3);
        add(bt4);
        add(bt5);
        add(bt6);
        add(bt7);
        add(bt8);
        add(bt9);
        add(plus);
        add(minus);
        add(multi);
        add(div);
        add(clear);
        add(equals);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(500,600);
        setTitle("Calculator");
        setLayout(null);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt0){
            String expression = display.getText();
            expression+="0";
            display.setText(expression);
        }
        if(e.getSource()==bt1){
            String expression = display.getText();
            expression+="1";
            display.setText(expression);
        }
        if(e.getSource()==bt2){
            String expression = display.getText();
            expression+="2";
            display.setText(expression);
        }
        if(e.getSource()==bt3){
            String expression = display.getText();
            expression+="3";
            display.setText(expression);
        }
        if(e.getSource()==bt4){
            String expression = display.getText();
            expression+="4";
            display.setText(expression);
        }
        if(e.getSource()==bt5){
            String expression = display.getText();
            expression+="5";
            display.setText(expression);
        }
        if(e.getSource()==bt6){
            String expression = display.getText();
            expression+="6";
            display.setText(expression);
        }
        if(e.getSource()==bt7){
            String expression = display.getText();
            expression+="7";
            display.setText(expression);
        }
        if(e.getSource()==bt8){
            String expression = display.getText();
            expression+="8";
            display.setText(expression);
        }
        if(e.getSource()==bt9){
            String expression = display.getText();
            expression+="9";
            display.setText(expression);
        }
        if(e.getSource()==plus){
            String expression = display.getText();
            expression+="+";
            display.setText(expression);
        }
        if(e.getSource()==minus){
            String expression = display.getText();
            expression+="-";
            display.setText(expression);
        }
        if(e.getSource()==multi){
            String expression = display.getText();
            expression+="*";
            display.setText(expression);
        }
        if(e.getSource()==div){
            String expression = display.getText();
            expression+="/";
            display.setText(expression);
        }
        if(e.getSource()==clear){
            display.setText("0");
        }

        if(e.getSource()==equals){
            int a,b,i;
            char operator='+';

            String expression = display.getText();
            String tempA="" ,tempB="" ;
            for(i=0;i<expression.length();i++){
                if(Character.isDigit(expression.charAt(i))){
                    tempA+=expression.charAt(i);
                }
                else{
                    operator = expression.charAt(i);
                    break;
                }
            }
            tempB = expression.substring(i+1);

            a= Integer.parseInt(tempA);
            b= Integer.parseInt(tempB);

            int result =0;
            switch(operator)
            {
                case '+':
                    result = a+b;
                    break;
                case '-':
                    result = a-b;
                    break;
                case '*':
                    result = a*b;
                    break;
                case'/':
                    result =a/b;
                    break;
            }
            display.setText(String.valueOf(result));
        }
        
    }
    static void main(String[] args) {

        new Calculator();
    }
}
