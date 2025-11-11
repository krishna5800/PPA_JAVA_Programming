import javax.swing.*;
import java.awt.event.*;

class Challenge implements ActionListener
{
    //Characteristics

    JFrame fobj;
    JButton bobj1,bobj2,bobj3,bobj4;
    JTextField tobj,tobj1;
    JLabel num1lable,num2lable,Resultlable;

    public Challenge(String title, int width, int height)
    {
        fobj = new JFrame(title);

        num1lable = new JLabel("Number1");
        num1lable.setBounds(100,100,100,30);

        tobj = new JTextField();
        tobj.setBounds(300,100,100,30);

        num2lable = new JLabel("Number2");
        num2lable.setBounds(100,200,100,30);

        tobj1 = new JTextField();
        tobj1.setBounds(300,200,100,30);

        bobj1 = new JButton("Add(+)");
        bobj1.setBounds(50,350,80,30);

        bobj2 = new JButton("Sub(-)");
        bobj2.setBounds(150,350,80,30);

        bobj3 = new JButton("Mul(*)");
        bobj3.setBounds(250,350,80,30);

        bobj4 = new JButton("Div(/)");
        bobj4.setBounds(350,350,80,30);

        Resultlable = new JLabel("");
        Resultlable.setBounds(200,430,100,30);

        fobj.add(bobj1);
        fobj.add(bobj2);
        fobj.add(bobj3);
        fobj.add(bobj4);
        fobj.add(tobj);
        fobj.add(tobj1);
        fobj.add(num1lable);
        fobj.add(num2lable);
        fobj.add(Resultlable);

        bobj1.addActionListener(this);
        bobj2.addActionListener(this);
        bobj3.addActionListener(this);
        bobj4.addActionListener(this);

        fobj.setLayout(null);
        fobj.setSize(width,height);

        fobj.setVisible(true);
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

        public void actionPerformed(ActionEvent aobj)
    {
        String num1 = tobj.getText();
        int no1 = Integer.parseInt(num1);
        String num2 = tobj1.getText();
        int no2 = Integer.parseInt(num2);

        int sum = 0;
        int sub = 0;
        int mul = 0;
        int div = 0;

        if(aobj.getSource() == bobj1)
        {
            sum = no1+no2;
            Resultlable.setText("Result is : " + sum);
        }
        else if((aobj.getSource() == bobj2))
        {
            sub = no1-no2;
            Resultlable.setText("Result is : " + sub);
        }
        else if((aobj.getSource() == bobj3))
        {
            mul = no1*no2;
            Resultlable.setText("Result is : " + mul);
        }
        else if((aobj.getSource() == bobj4))
        {
            div = no1/no2;
            Resultlable.setText("Result is : " + div);
        }
        
    }
}

class Calculator_Challenge
{
    public static void main(String A[])
    {
        Challenge cobj = new Challenge("Calculator", 500,550);
    }
}