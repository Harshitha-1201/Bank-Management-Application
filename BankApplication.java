import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankApplication {
    public static void main(String args[]) {
        JFrame frame = new JFrame("BANK MANAGEMENT SYSTEM");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 450);
        frame.setLayout(null);
        Color bg = new Color(250, 250, 250);
        frame.getContentPane().setBackground(bg);

        JPanel imagePanel = new ImagePanel(bg);
        imagePanel.setLayout(null);
        imagePanel.setBounds(0, 0, 650, 450);
        imagePanel.setBackground(bg);

        JLabel heading = new JLabel("Welcome to ATM!");
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBounds(130, 50, 350, 40);
        imagePanel.add(heading);

        JLabel cardNo = new JLabel("Card Number :");
        cardNo.setFont(new Font("Arial", Font.PLAIN, 19));
        JTextField textBox1 = new JTextField(16);
        cardNo.setBounds(50, 150, 150, 30);
        textBox1.setBounds(200, 150, 200, 30);
        imagePanel.add(cardNo);
        imagePanel.add(textBox1);

        JLabel pinLabel = new JLabel("PIN :");
        pinLabel.setFont(new Font("Arial", Font.PLAIN, 19));
        JPasswordField pinField = new JPasswordField(4);
        pinLabel.setBounds(120, 220, 150, 30);
        pinField.setBounds(200, 220, 200, 30);
        imagePanel.add(pinLabel);
        imagePanel.add(pinField);

        JButton signField = new JButton("SIGN IN");
        signField.setBounds(200, 280, 80, 25);
        signField.setBackground(Color.BLACK);
        signField.setForeground(Color.WHITE);
        imagePanel.add(signField);
        signField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNumber = textBox1.getText();
                String pinNumber = new String(pinField.getPassword());

                if (!cardNumber.isEmpty() && !pinNumber.isEmpty() && pinNumber.matches("\\d{4}")
                        && cardNumber.matches("\\d{16}")) {
                    if (DatabaseConnection.validateUser(cardNumber, pinNumber)) {
                        frame.setVisible(false);
                        OpenFrame5.openFrame5(cardNumber);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid Card Number or PIN!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Fill the Details Correctly", "Message",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton signField2 = new JButton("CLEAR");
        signField2.setBounds(320, 280, 80, 25);
        signField2.setBackground(Color.BLACK);
        signField2.setForeground(Color.WHITE);
        imagePanel.add(signField2);
        signField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textBox1.setText("");
                pinField.setText("");
            }
        });

        JButton signField3 = new JButton("SIGN UP");
        signField3.setBounds(200, 330, 200, 30);
        signField3.setBackground(Color.BLACK);
        signField3.setForeground(Color.WHITE);
        imagePanel.add(signField3);
        signField3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                OpenFrame2.openFrame2();
            }
        });

        frame.add(imagePanel);
        frame.setVisible(true);
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
