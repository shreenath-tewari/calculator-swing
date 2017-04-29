import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

class Calculator extends JFrame implements ActionListener
{
    final int WIDTH = 400;
    final int HEIGHT = 500;
    
    protected int operator;
    protected double a, b, r;

    
    protected JTextField jtf;
    JButton badd, bsub, bmul, bdiv, bdec, bequals, bclear, broot, bpower, bmod;
    JButton bdigits[];
    
    Calculator()
    {
        int i;
        
        operator = 0;
        a = b = r = 0.0d;

        
        jtf = new JTextField();
        
        badd = new JButton("+");
        bsub = new JButton("-");
        bmul = new JButton("*");
        bdiv = new JButton("/");
        bdec = new JButton(".");
        bequals = new JButton("=");
        broot = new JButton("Root");
        bpower = new JButton("^");
        bmod = new JButton("%");
        bclear = new JButton("<-");

        
        bdigits = new JButton[10];
        
        for(i = 0; i < 10; i++)
            bdigits[i] = new JButton(String.valueOf(i)); 
        
        jtf.setBounds(40, 35, 300, 40);
                
        buttonLayout();
        addComponents();
        
        for(i = 0; i < 10; i++)
            bdigits[i].addActionListener(this);
             
        badd.addActionListener(this);
        bsub.addActionListener(this);
        bmul.addActionListener(this);
        bdiv.addActionListener(this);
        bmod.addActionListener(this);
        bdec.addActionListener(this);
        bequals.addActionListener(this);
        bpower.addActionListener(this);
        bclear.addActionListener(this);
        broot.addActionListener(this);

        
        setLayout(null);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void buttonLayout()
    {
        int x, y, d, i, j, x_space, y_space, flag;
        x_space = 40;
        y_space = 150;
        d = 9;
        flag = 0;
        
        for(i = 0; i < 5; i++)
        {
            if(flag == 0)
            {
                for(j = 0; j < 4; j++)
                {
                    switch(j + 1)
                    {
                        case 1: broot.setBounds((x_space + (75 * j)), 120, 75, 30);
                            break;
                        case 2: bpower.setBounds((x_space + (75 * j)), 120, 75, 30);
                            break;
                        case 3: bclear.setBounds((x_space + (75 * j)), 120, 75, 30);
                            break;
                        case 4: bmod.setBounds((x_space + (75 * j)), 120, 75, 30);
                            break;                            
                    }
                }
                flag = 1;
            }
            if(i < 3)
            {
                for(j = 0; j < 3; j++)
                {
                    x = x_space + (75 * j);
                    y = y_space + (30 * i);
                    bdigits[d].setBounds(x, y, 75, 30);
                    d--;
                }
            }
            if(i == 3)
            {
                for(j = 0; j <= 3; j++)
                {
                    switch(j + 1)
                    {
                        case 1: bdec.setBounds((x_space + (75 * j)), (y_space + 30 * i), 75, 30);
                            break;
                        case 2: bdigits[0].setBounds((x_space + (75 * j)), (y_space + 30 * i), 75, 30);
                            break;
                        case 3: bequals.setBounds((x_space + (75 * j)), (y_space + 30 * i), 75, 30);
                            break;
                        case 4: bdiv.setBounds((x_space + (75 * j)), (y_space + (30 * i)), 75, 30);
                            break;
                    }
                }
            }
            switch(i + 1)
            {
                case 1: badd.setBounds((x_space + (75 * 3)), (y_space + (30 * i)), 75, 30);
                    break;
                case 2: bsub.setBounds((x_space + (75 * 3)), (y_space + (30 * i)), 75, 30);
                    break;
                case 3: bmul.setBounds((x_space + (75 * 3)), (y_space+  (30 * i)), 75, 30);
                    break;
            }
        }
    }
    
    public void addComponents()
    {
        add(jtf);
        
        for(int i = 0; i < 10; i++)
            add(bdigits[i]);
        add(bdec);
        add(bmod);
        add(bequals);
        add(bclear);
        add(bpower);
        add(broot);
        add(badd);
        add(bsub);
        add(bmul);
        add(bdiv);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        int i, j;
        
        for(i = 0; i < 10; i++)
        {
            if(e.getSource() == bdigits[i])
            {
                jtf.setText(jtf.getText().concat(i + ""));
            }
        }
        
        if(e.getSource() == badd)
        {
            a = Double.parseDouble(jtf.getText());
            jtf.setText("");
            operator = 1;
        }
        if(e.getSource() == bsub)
        {
            a = Double.parseDouble(jtf.getText());
            jtf.setText("");
            operator = 2;
        }
        if(e.getSource() == bmul)
        {
            a = Double.parseDouble(jtf.getText());
            jtf.setText("");
            operator = 3;
        }
        if(e.getSource() == bdiv)
        {
            a = Double.parseDouble(jtf.getText());
            jtf.setText("");
            operator = 4;
        }
        if(e.getSource() == bmod)
        {
            a = Double.parseDouble(jtf.getText());
            jtf.setText("");
            operator = 5;
        }
        if(e.getSource() == bpower)
        {
            a = Double.parseDouble(jtf.getText());
            jtf.setText("");
            operator = 6;
        }
        if(e.getSource() == broot)
        {
            a = Double.parseDouble(jtf.getText());
            jtf.setText("");
            operator = 7;
        }
        if(e.getSource() == bdec)
        {
            String temp = jtf.getText();
            for(i = 0; i < temp.length(); i++)
            {
                if(temp.charAt(i) == '.')
                    jtf.setText(temp.substring(0,(i - 1)));
            }
            a = Double.parseDouble(jtf.getText());
            jtf.setText(String.valueOf(a).concat("."));
        }
        if(e.getSource() == bclear)
        {
            jtf.setText(jtf.getText().substring(0,(jtf.getText().length() - 2)));
        }
        
        if(e.getSource() == bequals)
        {
            switch(operator)
            {
                case 1: b = Double.parseDouble(jtf.getText());
                        r = addition(a, b);
                        jtf.setText(String.valueOf(r));
                        break;
                case 2: b = Double.parseDouble(jtf.getText());
                        r = subtraction(a, b);
                        jtf.setText(String.valueOf(r));
                        break;
                case 3: b = Double.parseDouble(jtf.getText());
                        r = multiplication(a, b);
                        jtf.setText(String.valueOf(r));
                        break;
                case 4: b = Double.parseDouble(jtf.getText());
                    r = division(a, b);
                    jtf.setText(String.valueOf(r));
                    break;
                case 5: b = Double.parseDouble(jtf.getText());
                    r = modulus(a, b);
                    jtf.setText(String.valueOf(r));
                    break;
                case 6: b = Double.parseDouble(jtf.getText());
                    r = power(a, b);
                    jtf.setText(String.valueOf(r));
                    break;
                case 7: r = root(a);
                    jtf.setText(String.valueOf(r));
                    break;
            }
        }
    }
    
    double addition(double x, double y)
    {
        return (x + y);
    }
    double subtraction(double x, double y)
    {
        return (x - y);
    }
    double multiplication(double x, double y)
    {
        return (x * y);
    }
    double division(double x, double y)
    {
        return (x / y);
    }
    double modulus(double x, double y)
    {
        return (x % y);
    }
    double power(double x, double y)
    {
        return (Math.pow(x,y));
    }
    double root(double x)
    {
        return (Math.sqrt(x));
    }   
    
    public static void main(String args[])
    {   
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        new Calculator();
    }
}