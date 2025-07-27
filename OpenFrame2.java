import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.Date;

public class OpenFrame2 {
public static void openFrame2() {
    JFrame frame2 = new JFrame("SIGN UP");
    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame2.setSize(950, 1000);
    frame2.setLayout(null);
    Color bg1 = new Color(250, 250, 250);
    frame2.getContentPane().setBackground(bg1);

    JPanel imagePanel2 = new ImagePanel(bg1);
    imagePanel2.setLayout(null);
    imagePanel2.setBounds(0, 0, 950, 900);
    frame2.add(imagePanel2);

    JLabel heading2 = new JLabel("APPLICATION FORM");
    heading2.setFont(new Font("Arial", Font.BOLD, 25));
    heading2.setHorizontalAlignment(SwingConstants.CENTER);
    heading2.setBounds(130, 50, 450, 40);
    imagePanel2.add(heading2);

    JLabel subHeading = new JLabel("Page 1: Personal Details");
    subHeading.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT,20));
    subHeading.setHorizontalAlignment(SwingConstants.CENTER);
    subHeading.setBounds(120,100,400,30);
    imagePanel2.add(subHeading);

    JLabel namLabel = new JLabel("Name      :");
    namLabel.setFont(new Font("Arial",Font.PLAIN,20));
    namLabel.setBounds(130,155,150,30);
    JTextField namField = new JTextField();
    namField.setBounds(250,155,350,30);
    imagePanel2.add(namLabel);
    imagePanel2.add(namField);

    JLabel namLabel2 = new JLabel("Father Name  :");
    namLabel2.setFont(new Font("Arial",Font.PLAIN,20));
    namLabel2.setBounds(90,200,150,30);
    JTextField namField2 = new JTextField();
    namField2.setBounds(250,200,350,30);
    imagePanel2.add(namLabel2);
    imagePanel2.add(namField2);

    JLabel dobLabel = new JLabel("Date of Birth:");
    dobLabel.setFont(new Font("Arial",Font.PLAIN,20));
    dobLabel.setBounds(100,250,150,30);
    imagePanel2.add(dobLabel);

    SpinnerDateModel dateModel = new SpinnerDateModel();
    JSpinner dateSpinner = new JSpinner(dateModel);
    dateSpinner.setBounds(250, 250, 350, 30);
    
    JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
    dateSpinner.setEditor(editor);
    imagePanel2.add(dateSpinner);

    JLabel gLabel = new JLabel("Gender    :");
    gLabel.setFont(new Font("Arial",Font.PLAIN,20));
    gLabel.setBounds(120,300,150,30);
    JRadioButton maleRadio = new JRadioButton("Male");
    JRadioButton femaleRadio = new JRadioButton("Female");
    maleRadio.setBounds(250, 300, 100, 30);
    femaleRadio.setBounds(410, 300, 100, 30);
    ButtonGroup gendeGroup = new ButtonGroup();
    gendeGroup.add(maleRadio);
    gendeGroup.add(femaleRadio);
    imagePanel2.add(gLabel);
    imagePanel2.add(maleRadio);
    imagePanel2.add(femaleRadio);

    JLabel emaiLabel = new JLabel("Email Address  :");
    emaiLabel.setFont(new Font("Arial",Font.PLAIN,20));
    emaiLabel.setBounds(70,350,150,30);
    JTextField emaField = new JTextField();
    emaField.setBounds(250,350,350,30);
    imagePanel2.add(emaiLabel);
    imagePanel2.add(emaField);

    JLabel maritJLabel = new JLabel("Marital Status :");
    maritJLabel.setFont(new Font("Arial",Font.PLAIN,20));
    maritJLabel.setBounds(81,400,150,30);
    JRadioButton sButton = new JRadioButton("Yes");
    JRadioButton sButton2 = new JRadioButton("No");
    JRadioButton sButton3 = new JRadioButton("Other");
    sButton.setBounds(250, 400, 100, 30);
    sButton2.setBounds(375, 400, 100, 30);
    sButton3.setBounds(500, 400, 100, 30);
    ButtonGroup gendeGroup2 = new ButtonGroup();
    gendeGroup2.add(sButton);
    gendeGroup2.add(sButton2);
    gendeGroup2.add(sButton3);
    imagePanel2.add(maritJLabel);
    imagePanel2.add(sButton);
    imagePanel2.add(sButton2);
    imagePanel2.add(sButton3);

    JLabel addJLabel = new JLabel("Address  :");
    addJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    addJLabel.setBounds(130, 460, 150, 30); 
    JTextField addField = new JTextField();
    addField.setBounds(250, 460, 350, 30);
    imagePanel2.add(addJLabel);
    imagePanel2.add(addField);
    
    JLabel ciLabel = new JLabel("City   :");
    ciLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    ciLabel.setBounds(160, 510, 150, 30);
    JTextField cTextField = new JTextField();
    cTextField.setBounds(250, 510, 350, 30);
    imagePanel2.add(ciLabel);
    imagePanel2.add(cTextField);

    JLabel pinLabel = new JLabel("Pin Code   :");
    pinLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    pinLabel.setBounds(110, 560, 150, 30);
    
    JTextField pinField = new JTextField();
    pinField.setBounds(250, 560, 350, 30);
    
    imagePanel2.add(pinLabel);
    imagePanel2.add(pinField);

    JLabel statLabel = new JLabel("State   :");
    statLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    statLabel.setBounds(145, 610, 150, 30);
    
    JTextField staField = new JTextField();
    staField.setBounds(250, 610, 350, 30);
    
    imagePanel2.add(statLabel);
    imagePanel2.add(staField);

    JButton nexButton = new JButton("Next");
    nexButton.setBounds(540,650,60,30);
    nexButton.setForeground(Color.WHITE);
    nexButton.setBackground(Color.BLACK);
    imagePanel2.add(nexButton);
    nexButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
             Date selectedDate = (Date) dateSpinner.getValue(); 
            java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
           String name = namField.getText().trim();
           String fatherName = namField2.getText().trim();
           String email = emaField.getText().trim();
           String address = addField.getText().trim();
           String city = cTextField.getText().trim();
           String pin = pinField.getText().trim();
           String state = staField.getText().trim();
           String gender = "";
          if (maleRadio.isSelected()) {
             gender = "Male";
           } else if (femaleRadio.isSelected()) {
             gender = "Female";
           }
           String maritalStatus ="";
           if (sButton.isSelected()) {
            maritalStatus = "Yes";
           } else if (sButton2.isSelected()) {
            maritalStatus = "No";
           } else {
            maritalStatus = "Other";
           }
           
           if(name.isEmpty() || fatherName.isEmpty() || selectedDate == null || gender.isEmpty() || email.isEmpty() || maritalStatus.isEmpty() || address.isEmpty() || city.isEmpty() || pin.isEmpty() || state.isEmpty() ) {
               JOptionPane.showMessageDialog(frame2,"Fill all the details","Message",JOptionPane.ERROR_MESSAGE);
               return;
           }
           if (!sButton.isSelected() && !sButton2.isSelected() && !sButton3.isSelected()) {
            JOptionPane.showMessageDialog(frame2, "Please select your marital status.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
       if (!name.matches("[a-zA-Z ]+")) {
           JOptionPane.showMessageDialog(frame2, "Name should only contain letters", "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }
       if (!fatherName.matches("[a-zA-Z ]+")) {
           JOptionPane.showMessageDialog(frame2, "Father's Name should only contain letters", "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }
       if (!city.matches("[a-zA-Z ]+")) {
           JOptionPane.showMessageDialog(frame2, "City should only contain letters", "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }
       if (!state.matches("[a-zA-Z ]+")) {
           JOptionPane.showMessageDialog(frame2, "State should only contain letters", "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }
       
    
       if (!pin.matches("\\d{6}")) {
           JOptionPane.showMessageDialog(frame2, "Pincode must be exactly 6 digits", "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }

       boolean success = DatabaseConnection.storeUserData(name, fatherName, sqlDate, gender, email, maritalStatus, address, city, pin, state);
       if(success) {
       JOptionPane.showMessageDialog(frame2, "Form submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
           
            frame2.dispose();
            openFrame3.Frame3(email);


       } else {
        JOptionPane.showMessageDialog(frame2,"Error to save data!","Error",JOptionPane.ERROR_MESSAGE);
       }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame2, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    });
    frame2.add(imagePanel2);
    frame2.setVisible(true);
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

