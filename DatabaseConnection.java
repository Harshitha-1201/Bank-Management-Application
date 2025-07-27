import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;


public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/bms";
    private static final String user = "LENOVO";
    private static final String password = "Harshitha@1201";
    

    public static boolean validateUser(String cardNumber, String pin) {
        String sql = "SELECT * FROM users_data WHERE card_number = ? AND pin = ?";

        try (Connection conn = DriverManager.getConnection(URL, user, password);
         PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, cardNumber);
            pstmt.setString(2, pin);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); 
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static double getBalance(String cardNumber) {
        String sql = "SELECT balance FROM account_balance WHERE cardnumber = ?";
        try (Connection conn = DriverManager.getConnection(URL, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cardNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("balance");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
    public static List<String> getMiniStatement(String cardNumber) {
    List<String> transactions = new ArrayList<>();
    String sql = "SELECT type, amount, timestamp FROM transactions WHERE cardnumber = ? ORDER BY timestamp DESC LIMIT 5";

    try (Connection conn = DriverManager.getConnection(URL, user, password);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, cardNumber);
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String type = rs.getString("type");
                double amount = rs.getDouble("amount");
                Timestamp time = rs.getTimestamp("timestamp");
                String entry = String.format("%-12s ₹%-10.2f %s", type, amount, time.toString());
                transactions.add(entry);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return transactions;
}

    public static boolean updateAccountTypeData(String accountType, String services, String email){ 
        String sql = "UPDATE users_data SET account_type = ?,  services_required = ? WHERE email = ?";
        try (Connection conn = DriverManager.getConnection(URL, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, accountType);
            stmt.setString(2, services);
            stmt.setString(3, email);
    
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;  
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }

    }
    public static boolean updatePin(String newPin, String cardNumber) {
        String sql = "UPDATE users_data SET pin = ? WHERE card_number = ?";
        try(Connection conn = DriverManager.getConnection(URL, user, password);
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,newPin);
            stmt.setString(2,cardNumber);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean storeUserData(String name, String fatherName, java.sql.Date dateOfBirth, String gender,String email,String maritalStatus, String address,String city, String pincode, String state) {
String sql = "INSERT INTO users_data (name, father_name, date_of_birth, gender,email, marital_status, address, city, pincode, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
try (Connection conn = DriverManager.getConnection(URL, user, password);
PreparedStatement pstmt = conn.prepareStatement(sql)) {


pstmt.setString(1, name);
pstmt.setString(2, fatherName);
pstmt.setDate(3, new java.sql.Date(dateOfBirth.getTime()));
pstmt.setString(4, gender);
pstmt.setString(5, email);
pstmt.setString(6, maritalStatus);
pstmt.setString(7, address);
pstmt.setString(8, city);
pstmt.setString(9, pincode);
pstmt.setString(10, state);


int rowsInserted = pstmt.executeUpdate();
return rowsInserted > 0;  

} catch (SQLException e) {
e.printStackTrace();
return false; 
}
}
public static String[] generateAndUpdateCardDetails(String email) {
    String cardNumber = generateCardNumber();
    String pin = generatePinNumber();
    String sql = "UPDATE users_data  SET card_number = ?, pin = ? WHERE email = ?";
    try (Connection conn = DriverManager.getConnection(URL, user, password)) {
     String checkSql = "SELECT id FROM users_data WHERE email = ?";
       try(PreparedStatement stm = conn.prepareStatement(checkSql)) {
        stm.setString(1, email);
        ResultSet rs = stm.executeQuery();
        if(!rs.next()) {
            JOptionPane.showMessageDialog(null, "No user found", "Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    try(PreparedStatement stm = conn.prepareStatement(sql)) {
        stm.setString(1, cardNumber);
        stm.setString(2,pin);
        stm.setString(3,email);
        int rowsUpdated = stm.executeUpdate();
         if (rowsUpdated > 0) {
            String balancesql = "INSERT INTO account_balance(cardnumber, balance) VALUES (?, 0.0)";
            try(PreparedStatement balancesmt = conn.prepareStatement(balancesql)) {
                balancesmt.setString(1,cardNumber);
                balancesmt.executeUpdate();
            }
            return new String[] {cardNumber, pin};
        }
    }  
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database Error" + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
    }
    return null;
}

 public static String generateCardNumber() {
    Random rad = new Random();
    StringBuilder sb = new StringBuilder("4");
    for(int i=1;i<16;i++) {
        sb.append(rad.nextInt(10));
    }
    return sb.toString();

 }
 public static String generatePinNumber() {
    Random rand = new Random();
    int pin = rand.nextInt(9000) + 1000;
    return String.valueOf(pin);
 }
 public static boolean depositAmount(String cardNumber, double amount) {
    String txnInsert = "INSERT INTO transactions (cardnumber, type, amount) VALUES (?, 'DEPOSIT', ?)";
    String balanceUpdate = "INSERT INTO account_balance (cardnumber, balance) VALUES (?, ?) " +
                           "ON DUPLICATE KEY UPDATE balance = balance + VALUES(balance), last_updated = CURRENT_TIMESTAMP";
    try (Connection conn = DriverManager.getConnection(URL, user, password)) {
        conn.setAutoCommit(false);

        // Insert transaction
        try (PreparedStatement pstTxn = conn.prepareStatement(txnInsert)) {
            pstTxn.setString(1, cardNumber);
            pstTxn.setDouble(2, amount);
            pstTxn.executeUpdate();
        }

        // Update balance
        try (PreparedStatement pstBal = conn.prepareStatement(balanceUpdate)) {
            pstBal.setString(1, cardNumber);
            pstBal.setDouble(2, amount);
            pstBal.executeUpdate();
        }

        conn.commit();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
public static boolean fastCashWithdraw(String cardNumber, double amount) {
    String checkBalanceSQL = "SELECT balance FROM account_balance WHERE cardnumber = ? FOR UPDATE";
    String insertTxnSQL = "INSERT INTO transactions (cardnumber, type, amount) VALUES (?, 'FASTCASH', ?)";
    String updateBalanceSQL = "UPDATE account_balance SET balance = balance - ?, last_updated = CURRENT_TIMESTAMP WHERE cardnumber = ? AND balance >= ?";

    try (Connection conn = DriverManager.getConnection(URL, user, password)) {
        conn.setAutoCommit(false);
        double currentBalance = 0;
        try (PreparedStatement checkStmt = conn.prepareStatement(checkBalanceSQL)) {
            checkStmt.setString(1, cardNumber);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    currentBalance = rs.getDouble("balance");
                } else {
                    System.out.println("No account found for card number: " + cardNumber);
                    conn.rollback();
                    return false;
                }
            }
        }

        if (currentBalance < amount) {
            System.out.println("Insufficient balance. Current: " + currentBalance + ", requested: " + amount);
            conn.rollback();
            return false;
        }
        try (PreparedStatement insertTxn = conn.prepareStatement(insertTxnSQL)) {
            insertTxn.setString(1, cardNumber);
            insertTxn.setDouble(2, amount);
            insertTxn.executeUpdate();
        }

        try (PreparedStatement updateBal = conn.prepareStatement(updateBalanceSQL)) {
            updateBal.setDouble(1, amount);
            updateBal.setString(2, cardNumber);
            updateBal.setDouble(3, amount);
            int rowsAffected = updateBal.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("Failed to update balance. Possible race condition or insufficient funds.");
                conn.rollback();
                return false;
            }
        }

        conn.commit(); 
        System.out.println("Cash withdrawal successful.");
        return true;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

   

public static void main(String[] args) {

    }
} 
   