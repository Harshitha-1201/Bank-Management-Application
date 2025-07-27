import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
public class openFrame4 {
public static void Frame4(String cardNumber) {
    final String currentCardNumber = cardNumber;
    JFrame frame4 = new JFrame("Deposit");
    frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame4.setSize(900, 500);
    frame4.setLayout(null);
    frame4.setBackground(Color.BLACK);

    JPanel pJPanel = new JPanel();
    pJPanel.setLayout(null);
    pJPanel.setBounds(0,0,900,500);
    pJPanel.setBackground(Color.BLACK);
    pJPanel.setForeground(Color.WHITE);
    
    JLabel label1 = new JLabel("Enter Amount You Want to Deposit");
    label1.setHorizontalAlignment(SwingConstants.CENTER);
    label1.setBounds(90,20,600,50);
    label1.setFont(new Font("Arial",Font.PLAIN,30));
    label1.setForeground(Color.WHITE);
    pJPanel.add(label1);
    
    JLabel cardNumberLabel = new JLabel(cardNumber); 
    cardNumberLabel.setBounds(50, 130, 250, 30); 
    cardNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
    cardNumberLabel.setOpaque(true); 
    cardNumberLabel.setBackground(Color.WHITE);
    cardNumberLabel.setForeground(Color.BLACK); 
    pJPanel.add(cardNumberLabel);
    
    
    JTextField lbox = new JTextField("Rs.");
    lbox.setBounds(450, 130, 180, 30); 
    lbox.setHorizontalAlignment(SwingConstants.CENTER);
    pJPanel.add(lbox);

    JButton deposit=new JButton("Deposit");
    deposit.setBackground(Color.WHITE);
    deposit.setForeground(Color.BLACK);
    deposit.setBounds(600,200,150,30);
    pJPanel.add(deposit);
    deposit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
            String amountText = lbox.getText().trim();
            amountText = amountText.replaceAll("[^0-9]", "");
            if(!amountText.isEmpty() && amountText.matches("\\d+") && Integer.parseInt(amountText) > 0) { 
                 double amount = Double.parseDouble(amountText);
            
            boolean success = DatabaseConnection.depositAmount(currentCardNumber, amount);
            if (success) {
                JOptionPane.showMessageDialog(frame4, "Rs. " + amount + " deposited successfully");
            } else {
                JOptionPane.showMessageDialog(frame4, "Deposit failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame4, "Invalid amount");
        }
                
               
        }
    });
    JButton Back = new JButton("Back");
    Back.setBounds(600,260,150,30);
    Back.setBackground(Color.WHITE);
    Back.setForeground(Color.BLACK);
    pJPanel.add(Back);
    Back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           frame4.setVisible(false);
           OpenFrame5.openFrame5(currentCardNumber);
        }
    });
  
    frame4.add(pJPanel);
    frame4.setVisible(true);                               
}
}
