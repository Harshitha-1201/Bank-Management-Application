import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.List;
import java.util.ArrayList;

public class OpenFrame5 {
public static void openFrame5(String cardNumber) {
    final String currentCardNumber = cardNumber;
    JFrame frame5 = new JFrame("ATM");
    frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame5.setSize(900, 500);
    frame5.setLayout(null);
    frame5.setBackground(Color.BLACK);


    JPanel pJPanel1 = new JPanel();
    pJPanel1.setLayout(null);
    pJPanel1.setBounds(0,0,900,500);
   pJPanel1.setBackground(Color.BLACK);
    pJPanel1.setForeground(Color.WHITE);
    frame5.add(pJPanel1);

    JLabel lable=new JLabel("Select Your Transaction");
    lable.setFont(new Font("Arial",Font.BOLD,30));
    lable.setHorizontalAlignment(SwingConstants.CENTER);
    lable.setForeground(Color.WHITE);
    lable.setBounds(140,20,500,50);
    pJPanel1.add(lable);

    JButton deposiButton=new JButton("Deposit");
    deposiButton.setBounds(170,100,150,50);
    deposiButton.setBackground(Color.WHITE);
    deposiButton.setForeground(Color.BLACK);
    pJPanel1.add(deposiButton);

    deposiButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           openFrame4.Frame4(currentCardNumber);
            frame5.setVisible(false);

        }
    });
    JButton cashButton = new JButton("Fast Cash");
    cashButton.setBackground(Color.WHITE);
    cashButton.setForeground(Color.BLACK);
    cashButton.setBounds(170,170,150,50);
    pJPanel1.add(cashButton);
    cashButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame5.setVisible(false);
            JFrame frame6 = new JFrame("Fast Cash");
            frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame6.setSize(900, 450);
            frame6.setLayout(null);

            JPanel panel1 = new JPanel();
            panel1.setLayout(null);
            panel1.setSize(900, 500);
            panel1.setBackground(Color.BLACK);
            frame6.add(panel1);

            JLabel label1 = new JLabel("Select Withdrawl Amount");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Arial",Font.PLAIN,30));
            label1.setBounds(120,30,550,50);
            label1.setForeground(Color.WHITE);
            panel1.add(label1);

            JButton b1Button = new JButton("Rs.100");
            b1Button.setBounds(170,100,150,50);
            b1Button.setBackground(Color.WHITE);
            b1Button.setForeground(Color.BLACK);
            panel1.add(b1Button);
           b1Button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        boolean success = DatabaseConnection.fastCashWithdraw(currentCardNumber, 100);
        if (success) {
            JOptionPane.showMessageDialog(frame6, "Rs.100 Withdrawn Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame6, "Withdrawal Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});
            JButton b2Button = new JButton("Rs.1000");
            b2Button.setBounds(170,170,150,50);
            b2Button.setBackground(Color.WHITE);
            b2Button.setForeground(Color.BLACK);
            panel1.add(b2Button);
            b2Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean success = DatabaseConnection.fastCashWithdraw(currentCardNumber, 1000);
        if (success) {
            JOptionPane.showMessageDialog(frame6, "Rs.1000 Withdrawn Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame6, "Withdrawal Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});


            JButton b3Button = new JButton("Rs.5000");
            b3Button.setBounds(170,240,150,50);
            b3Button.setBackground(Color.WHITE);
            b3Button.setForeground(Color.BLACK);
            panel1.add(b3Button);
            b3Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean success = DatabaseConnection.fastCashWithdraw(currentCardNumber, 5000);
        if (success) {
            JOptionPane.showMessageDialog(frame6, "Rs.5000 Withdrawn Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame6, "Withdrawal Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});

            JButton b4Button = new JButton("Rs.500");
            b4Button.setBounds(460,100,150,50);
            b4Button.setBackground(Color.WHITE);
            b4Button.setForeground(Color.BLACK);
            panel1.add(b4Button);
           b4Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean success = DatabaseConnection.fastCashWithdraw(currentCardNumber, 500);
        if (success) {
            JOptionPane.showMessageDialog(frame6, "Rs.500 Withdrawn Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame6, "Withdrawal Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});

            JButton b5Button = new JButton("Rs.2000");
            b5Button.setBounds(460,170,150,50);
            b5Button.setBackground(Color.WHITE);
            b5Button.setForeground(Color.BLACK);
            panel1.add(b5Button);
            b5Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean success = DatabaseConnection.fastCashWithdraw(currentCardNumber, 2000);
        if (success) {
            JOptionPane.showMessageDialog(frame6, "Rs.2000 Withdrawn Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame6, "Withdrawal Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});

            JButton b6Button = new JButton("Rs.10000");
            b6Button.setBounds(460,240,150,50);
            b6Button.setBackground(Color.WHITE);
            b6Button.setForeground(Color.BLACK);
            panel1.add(b6Button);
           b6Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean success = DatabaseConnection.fastCashWithdraw(currentCardNumber, 10000);
        if (success) {
            JOptionPane.showMessageDialog(frame6, "Rs.10000 Withdrawn Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame6, "Withdrawal Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});

            JButton baButton = new JButton("Back");
            baButton.setBounds(560,330,80,30);
            baButton.setBackground(Color.WHITE);
            baButton.setForeground(Color.BLACK);
            panel1.add(baButton);
            baButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    frame6.setVisible(false);
                    frame5.setVisible(true);

                }
            });
            frame6.setVisible(true);  
        }
    });
     JButton lable2 = new JButton("Pin Change");
     lable2.setBackground(Color.WHITE);
     lable2.setForeground(Color.BLACK);
     lable2.setBounds(170,240,150,50);
     pJPanel1.add(lable2);
     lable2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           frame5.setVisible(false); 
           
           JFrame frame7 = new JFrame("Pin Change");
           frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame7.setSize(900, 450);
           frame7.setLayout(null);

           JPanel panel2 = new JPanel();
           panel2.setLayout(null);
           panel2.setSize(900, 500);
           panel2.setBackground(Color.BLACK);
           frame7.add(panel2);

           JLabel label2 = new JLabel("Change Your Pin");
           label2.setHorizontalAlignment(SwingConstants.CENTER);
           label2.setFont(new Font("Arial",Font.BOLD,40));
           label2.setBounds(120,20,550,50);
           label2.setForeground(Color.WHITE);
           panel2.add(label2);

           JLabel label3 = new JLabel("New Pin       :");
           label3.setHorizontalAlignment(SwingConstants.CENTER);
           label3.setFont(new Font("Arial",Font.PLAIN,30));
           label3.setBounds(80,110,300,50);
           label3.setForeground(Color.WHITE);
           panel2.add(label3);

           JTextField field1 = new JTextField();
           field1.setBounds(360,120,300,30);
           field1.setBackground(Color.WHITE);
           field1.setForeground(Color.BLACK);
           panel2.add(field1);

           JLabel label4 = new JLabel("Re-Enter Pin    :");
           label4.setHorizontalAlignment(SwingConstants.CENTER);
           label4.setFont(new Font("Arial",Font.PLAIN,30));
           label4.setBounds(80,190,300,50);
           label4.setForeground(Color.WHITE);
           panel2.add(label4);

           JTextField field2 = new JTextField();
           field2.setBounds(360,200,300,30);
           field2.setBackground(Color.WHITE);
           field2.setForeground(Color.BLACK);
           panel2.add(field2);

           JButton button2 = new JButton("Change");
           button2.setBounds(430,270,150,30);
           button2.setBackground(Color.WHITE);
           button2.setForeground(Color.BLACK);
           panel2.add(button2);
           
           button2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String pin = field1.getText().trim();
        String rePin = field2.getText().trim();

        if (pin.isEmpty() || rePin.isEmpty()) {
            JOptionPane.showMessageDialog(frame7, "PIN fields cannot be empty!", "Message", JOptionPane.ERROR_MESSAGE);
            return;
        } 

        if (!pin.matches("\\d{4}")) {
            JOptionPane.showMessageDialog(frame7, "Invalid! PIN must be exactly 4 digits.", "Message", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!pin.equals(rePin)) {
            JOptionPane.showMessageDialog(frame7, "PINs do not match!", "Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean success = DatabaseConnection.updatePin(pin ,cardNumber);
        if(success) {
            JOptionPane.showMessageDialog(frame7, "Pin Updated Successfully!");
        }else {
            JOptionPane.showMessageDialog(frame7, "Something went Wrong!");
        }

    }
});

           JButton button3 = new JButton("Clear");
           button3.setBounds(380,320,100,30);
           button3.setBackground(Color.WHITE);
           button3.setForeground(Color.BLACK);
           panel2.add(button3);
           button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              field2.setText(" "); 
              field1.setText(" ");
            }
           });
           JButton button4 = new JButton("Back");
           button4.setBounds(530,320,100,30);
           button4.setBackground(Color.WHITE);
           button4.setForeground(Color.BLACK);
           panel2.add(button4);

           button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame7.setVisible(false);
               frame5.setVisible(true);
            }
           });
           frame7.setVisible(true);
        }
     });
     JButton lable3 = new JButton("Cash Withdrawl");
     lable3.setBackground(Color.WHITE);
     lable3.setForeground(Color.black);
     lable3.setBounds(460,100,150,50);
     pJPanel1.add(lable3);
    lable3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          frame5.setVisible(false); 
          
          JFrame frame8=new JFrame("Cash Withdrawl");           
          frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame8.setSize(900, 450);
          frame8.setLayout(null);

          JPanel panel3 = new JPanel();
          panel3.setLayout(null);
          panel3.setSize(900, 500);
          panel3.setBackground(Color.BLACK);
          frame8.add(panel3);

          
          JLabel label4 = new JLabel("Please Enter Your Amount");
          label4.setHorizontalAlignment(SwingConstants.CENTER);
          label4.setFont(new Font("Arial",Font.PLAIN,25));
          label4.setBounds(120,100,550,50);
          label4.setForeground(Color.WHITE);
          panel3.add(label4);

          JTextField field3 = new JTextField("Rs. ");
          field3.setBackground(Color.WHITE);
          field3.setBounds(190,180,400,40);
          field3.setForeground(Color.BLACK);
          panel3.add(field3);

          JButton b1 = new JButton("Withdraw");
          b1.setBackground(Color.WHITE);
          b1.setForeground(Color.BLACK);
          b1.setBounds(320,240,150,50);
          panel3.add(b1);
          b1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String amountText = field3.getText().trim().replaceAll("[^0-9]", "");

        if (!amountText.isEmpty() && amountText.matches("\\d+") && Integer.parseInt(amountText) > 0 && Integer.parseInt(amountText) <= 10000) {
            double amount = Double.parseDouble(amountText);
            boolean success = DatabaseConnection.fastCashWithdraw(currentCardNumber, amount);

            if (success) {
                JOptionPane.showMessageDialog(frame8, amount + " Withdrawn Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame8, "Withdrawal Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame8, "Invalid amount. Please enter a number between 1 and 10000.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        }
    }
});

          
          JButton b2 = new JButton("Clear");
          b2.setBackground(Color.WHITE);
          b2.setForeground(Color.BLACK);
          b2.setBounds(270,320,100,50);
          panel3.add(b2);
          b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field3.setText("Rs. ");

            }
          });
          JButton b3 = new JButton("Back");
          b3.setBackground(Color.WHITE);
          b3.setForeground(Color.BLACK);
          b3.setBounds(410,320,100,50);
          panel3.add(b3);
          b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame8.setVisible(false);
               frame5.setVisible(true); 
            }
          });

          frame8.setVisible(true);
        }
    });
     JButton lable4 = new JButton("Mini Statement");
     lable4.setBackground(Color.WHITE);
     lable4.setForeground(Color.black);
     lable4.setBounds(460,170,150,50);
     pJPanel1.add(lable4);
     lable4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame5.setVisible(false);

            JFrame frame9=new JFrame("Mini Statement");           
            frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame9.setSize(900, 450);
            frame9.setLayout(null);

            JPanel panel4 = new JPanel();
            panel4.setLayout(null);
            panel4.setSize(900, 500);
            panel4.setBackground(Color.BLACK);
            frame9.add(panel4);

            JLabel label3 = new JLabel("Indian Bank");
            label3.setHorizontalAlignment(SwingConstants.CENTER);
            label3.setFont(new Font("Arial",Font.BOLD,30));
            label3.setBounds(120,20,550,50);
            label3.setForeground(Color.WHITE);
            panel4.add(label3);

            JLabel label4 = new JLabel("Card Number  :");
            label4.setFont(new Font("Arial",Font.PLAIN,25));
            label4.setBounds(180,90,550,50);
            label4.setForeground(Color.WHITE);
            panel4.add(label4);

            JLabel label5 = new JLabel(currentCardNumber);
            label5.setFont(new Font("Arial",Font.PLAIN,25));
            label5.setBounds(370,90,550,50);
            label5.setForeground(Color.WHITE);
            panel4.add(label5);
            List<String> miniStatement = DatabaseConnection.getMiniStatement(currentCardNumber);

JTextArea statementArea = new JTextArea();
statementArea.setEditable(false);
statementArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
statementArea.setBackground(Color.BLACK);
statementArea.setForeground(Color.GREEN);
statementArea.setBounds(100, 160, 700, 100);

StringBuilder sb = new StringBuilder();
for (String entry : miniStatement) {
    sb.append(entry).append("\n");
}
statementArea.setText(sb.toString());

panel4.add(statementArea);


            JButton b3 = new JButton("Back");
            b3.setBackground(Color.WHITE);
            b3.setForeground(Color.BLACK);
            b3.setBounds(460,290,100,50);
            panel4.add(b3);
            b3.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                 frame9.setVisible(false);
                 frame5.setVisible(true); 
              }
            });


            frame9.setVisible(true);
        }
     });

     JButton lable5 = new JButton("Balance Enquiry");
     lable5.setBackground(Color.WHITE);
     lable5.setForeground(Color.black);
     lable5.setBounds(460,240,150,50);
     pJPanel1.add(lable5);
     lable5.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           frame5.setVisible(false); 
           JFrame frame10=new JFrame("Balance Enquiry");           
           frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame10.setSize(900, 450);
           frame10.setLayout(null);

           JPanel panel5 = new JPanel();
           panel5.setLayout(null);
           panel5.setSize(900, 500);
           panel5.setBackground(Color.BLACK);
           frame10.add(panel5);

           JLabel label3 = new JLabel("Total Balance");
           label3.setHorizontalAlignment(SwingConstants.CENTER);
           label3.setFont(new Font("Arial",Font.BOLD,30));
           label3.setBounds(120,20,550,50);
           label3.setForeground(Color.WHITE);
           panel5.add(label3);

           JLabel label4 = new JLabel("Your Current Account Balance is");
           label4.setHorizontalAlignment(SwingConstants.CENTER);
           label4.setFont(new Font("Arial",Font.PLAIN,30));
           label4.setBounds(100,120,550,50);
           label4.setForeground(Color.WHITE);
           panel5.add(label4);

        Double balance = DatabaseConnection.getBalance(currentCardNumber); 
        String balanceText = String.format("₹ %.2f", balance);

        JLabel labelBalance = new JLabel(balanceText);
        labelBalance.setHorizontalAlignment(SwingConstants.CENTER);
        labelBalance.setFont(new Font("Arial", Font.BOLD, 35));
        labelBalance.setBounds(100, 170, 650, 50);
        labelBalance.setForeground(Color.YELLOW);
        panel5.add(labelBalance);

           JButton b3 = new JButton("Back");
           b3.setBackground(Color.WHITE);
           b3.setForeground(Color.BLACK);
           b3.setBounds(460,290,100,50);
           panel5.add(b3);
           b3.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                frame10.setVisible(false);
                frame5.setVisible(true); 
             }
           });


           frame10.setVisible(true);
        }
     });

     JButton exit = new JButton("Exit");
     exit.setBounds(580,360,80,30);
     exit.setBackground(Color.WHITE);
     exit.setForeground(Color.black);
     pJPanel1.add(exit);
     exit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame5.setVisible(false);
        }
     });
    frame5.setVisible(true);

}
}
