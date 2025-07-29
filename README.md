# 🏦 Bank Management System

A desktop-based **Bank Management System** built using **Java Swing** for the GUI and **JDBC** for database connectivity. The application simulates core banking functions such as withdrawals, deposits, fast cash, PIN changes, mini statements, and balance inquiries.

## 📌 Key Features

- 🔐 **User Authentication**
  - **New User Registration** via the **BankManagementSystem** main frame.
  - Automatically generates a **Card Number** and **PIN** after successful signup.
  - Existing users can **Sign In** with their card number and PIN.

- 💳 **Banking Functionalities**
  - **Withdrawal**
  - **Fast Cash**
  - **Deposit**
  - **PIN Change**
  - **Mini Statement**
  - **Balance Enquiry**

## 🧩 GUI Flow (Frame Classes)

| Frame/Class Name       |      Description                    |
|------------------------|-------------------------------------|
| BankApplication.java   | Main frame for login/signup         |
| openFrame2.java        | Sign up details for new user        |
| openFrame3.java        | User details and generates card number and pin number     |
| openFrame4.java        | Deposit money after filling the details of new user       |
| openFrame5.java        | Withdrawal, Fast Cash, Pin Change, Mini Statement, Balance Enquiry operations  |
| DataBaseConnection.java| JDBC logic for connecting to MySQL  |

## 🛠 Tech Stack

- **Frontend:** Java Swing (AWT/Swing components)
- **Backend:** Java
- **Database:** MySQL
- **Database Connection:** JDBC (via DataBaseConnection.java)
- **IDE:** Visual Studio Code

## 📁 Project Structure

```plaintext
BankManagementSystem/
│
├── BankManagementSystem.java     # Main login/signup frame
├── openFrame2.java               # Home dashboard
├── openFrame3.java               # Withdraw/Deposit functionality
├── openFrame4.java               # Fast Cash / PIN Change
├── openFrame5.java               # Mini Statement / Balance Enquiry
├── DataBaseConnection.java       # MySQL JDBC connection class
├── bank.sql                      # MySQL schema file
└── README.md


javac -cp ".;lib/mysql-connector-java.jar" *.java
java -cp ".;lib/mysql-connector-java.jar" BankManagementSystem



