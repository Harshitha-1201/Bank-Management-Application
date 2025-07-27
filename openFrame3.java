import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class openFrame3 {
    public static void Frame3(String email) {
        JFrame frame3 = new JFrame("SIGN UP");
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(950, 1000);
        frame3.setLayout(null);
        Color bg2 = new Color(250, 250, 250);
        frame3.getContentPane().setBackground(bg2);

        JPanel imagePanel4 = new ImagePanel(bg2);
        imagePanel4.setLayout(null);
        imagePanel4.setBounds(0, 0, 950, 900);
        frame3.add(imagePanel4);

        JLabel hd = new JLabel("Page 2 : Account Details");
        hd.setFont(new Font("Arial", Font.PLAIN, 30));
        hd.setBounds(130, 50, 450, 40);
        hd.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel4.add(hd);

        // JLabel hd1 = new JLabel("form no : 6211");
        // hd1.setFont(new Font("Arial",Font.PLAIN,15));
        // hd1.setBounds(700,50,400,40);
        // imagePanel4.add(hd1);

        JLabel lJLabel = new JLabel("Account Type    :");
        lJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        lJLabel.setBounds(110, 130, 450, 40);
        imagePanel4.add(lJLabel);

        JRadioButton b1Button = new JRadioButton("Saving Account");
        b1Button.setBounds(160, 180, 190, 40);
        JRadioButton b2Button = new JRadioButton("Fixed Deposit Account");
        b2Button.setBounds(500, 180, 190, 40);
        JRadioButton b3Button = new JRadioButton("Current Account");
        b3Button.setBounds(160, 240, 190, 40);
        JRadioButton b4Button = new JRadioButton("Recurring Deposit Amount");
        b4Button.setBounds(500, 240, 190, 40);

        ButtonGroup buttonGroup3 = new ButtonGroup();
        buttonGroup3.add(b1Button);
        buttonGroup3.add(b2Button);
        buttonGroup3.add(b3Button);
        buttonGroup3.add(b4Button);

        imagePanel4.add(lJLabel);
        imagePanel4.add(b1Button);
        imagePanel4.add(b2Button);
        imagePanel4.add(b3Button);
        imagePanel4.add(b4Button);

        JLabel cardJLabel = new JLabel("<html>Card Number<br>(your 18 digit card number)</html>");
        cardJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        cardJLabel.setBounds(110, 290, 450, 60);
        imagePanel4.add(cardJLabel);

        JLabel cardJLabel2 = new JLabel(":");
        cardJLabel2.setBounds(380, 285, 450, 60);
        imagePanel4.add(cardJLabel2);

        JLabel cardJLabel3 = new JLabel(
                "<html>XXXX-XXXX-XXXX-XXXX<br>(It would be appear on ATM<br>card/chequeue Book & Statements)</html>");
        cardJLabel3.setBounds(440, 300, 450, 70);
        cardJLabel3.setFont(new Font("Arial", Font.PLAIN, 17));
        imagePanel4.add(cardJLabel3);

        JLabel cardJLabel4 = new JLabel("PIN       :");
        cardJLabel4.setFont(new Font("Arial", Font.PLAIN, 20));
        cardJLabel4.setBounds(305, 350, 450, 70);
        imagePanel4.add(cardJLabel4);

        JLabel pinJLabel = new JLabel("XXXX");
        pinJLabel.setBounds(450, 370, 450, 30);
        pinJLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        imagePanel4.add(pinJLabel);

        JLabel serLabel = new JLabel("Services Required      :");
        serLabel.setBounds(110, 410, 450, 30);
        serLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        imagePanel4.add(serLabel);

        JCheckBox b1Box = new JCheckBox("ATM Card");
        b1Box.setBounds(110, 460, 200, 50);
        JCheckBox b2Box = new JCheckBox("Mobile Banking");
        b2Box.setBounds(355, 460, 200, 50);
        JCheckBox b3Box = new JCheckBox("Internet Banking");
        b3Box.setBounds(110, 520, 200, 50);
        JCheckBox b4Box = new JCheckBox("E-MAIL Address");
        b4Box.setBounds(600, 460, 200, 50);
        JCheckBox b5Box = new JCheckBox("Cheque Book");
        b5Box.setBounds(355, 520, 200, 50);
        JCheckBox b6Box = new JCheckBox("E Statement");
        b6Box.setBounds(600, 520, 200, 50);

        imagePanel4.add(b1Box);
        imagePanel4.add(b2Box);
        imagePanel4.add(b3Box);
        imagePanel4.add(b4Box);
        imagePanel4.add(b5Box);
        imagePanel4.add(b6Box);
        imagePanel4.add(serLabel);

        JCheckBox box = new JCheckBox(
                "I here by declares that the above entered details correct to the best of my knowledge.");
        box.setFont(new Font("Arial", Font.PLAIN, 20));
        box.setBounds(120, 600, 790, 30);
        imagePanel4.add(box);

        JButton sub = new JButton("Submit");
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.setBounds(390, 650, 100, 30);
        imagePanel4.add(sub);
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selected = b1Button.isSelected() || b2Button.isSelected() || b3Button.isSelected()
                        || b4Button.isSelected();
                boolean servicesSelected = b1Box.isSelected() || b2Box.isSelected() || b3Box.isSelected() ||
                        b4Box.isSelected() || b5Box.isSelected() || b6Box.isSelected();
                boolean declarationChecked = box.isSelected();

                if (!selected) {
                    JOptionPane.showMessageDialog(frame3, "Please select an account type", "Message",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!servicesSelected) {
                    JOptionPane.showMessageDialog(frame3, "Please select at least one service", "Message",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!declarationChecked) {
                    JOptionPane.showMessageDialog(frame3, "You must agree to the declaration before proceeding",
                            "Message", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String accountType = "";
                if (b1Button.isSelected())
                    accountType = "Saving Account";
                if (b2Button.isSelected())
                    accountType = "Fixed Deposit Account";
                if (b3Button.isSelected())
                    accountType = "Current Account";
                if (b4Button.isSelected())
                    accountType = "Recurring Deposit Amount";

                StringBuilder services = new StringBuilder();
                if (b1Box.isSelected())
                    services.append("ATM Card,  ");
                if (b2Box.isSelected())
                    services.append("Mobile Banking, ");
                if (b3Box.isSelected())
                    services.append("Internet Banking, ");
                if (b4Box.isSelected())
                    services.append("E-MAIL Address, ");
                if (b5Box.isSelected())
                    services.append("Cheque Book, ");
                if (b6Box.isSelected())
                    services.append("E Statement, ");
                boolean success = DatabaseConnection.updateAccountTypeData(accountType, services.toString(), email);
                if (success) {
                    String[] cardDetails = DatabaseConnection.generateAndUpdateCardDetails(email);
                    if (cardDetails != null) {
                        JOptionPane
                                .showMessageDialog(frame3,
                                        "Account Created Successfully!\n" + "Your Card Number: " + cardDetails[0] + "\n"
                                                + "Your PIN: " + cardDetails[1],
                                        "Success", JOptionPane.INFORMATION_MESSAGE);

                        frame3.dispose();
                        openFrame4.Frame4(cardDetails[0]);

                    } else {
                        JOptionPane.showMessageDialog(frame3, "Failed to generate card details", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame3, "Failed to save data", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame3.add(imagePanel4);
        frame3.setVisible(true);
    }

    static class ImagePanel extends JPanel {
        private Color backgroundColor;

        public ImagePanel(Color bg) {
            this.backgroundColor = bg;
            setBackground(backgroundColor);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon icon = new ImageIcon("resources/bankImage.jpg");
            Image image = icon.getImage();
            int x = 30;
            int y = 20;
            int width = 90;
            int height = 90;
            g.drawImage(image, x, y, width, height, this);
        }
    }
}