
# Customer Relationship Management System (CRM)

## 📌 Project Overview

This is a **JSP–Servlet–JDBC based web application** developed using:

* Java (JDK 17+/21)
* JSP & Servlets (Jakarta EE – Tomcat 10)
* Oracle 11g XE Database
* JDBC
* Apache Tomcat 10.1

The system allows users to:

* Add new customer records
* View specific customer records
* View all customer records
* Prevent duplicate entries
* Generate structured Record IDs using Oracle Sequence

---

## 🏗 Architecture

```
JSP (View Layer)
        ↓
Servlet (Controller Layer)
        ↓
Administrator (Service Layer)
        ↓
CrmDAO (DAO Layer)
        ↓
Oracle Database
```

---

## 🗄 Database Configuration

### 1️⃣ Create Table

```sql
CREATE TABLE CRM_TBL (
    RECORDID      VARCHAR2(20) PRIMARY KEY,
    CUSTOMERNAME  VARCHAR2(50) NOT NULL,
    EMAIL         VARCHAR2(50) NOT NULL,
    PHONE         VARCHAR2(15) NOT NULL,
    JOIN_DATE     DATE NOT NULL,
    STATUS        VARCHAR2(20),
    REMARKS       VARCHAR2(100)
);
```

---

### 2️⃣ Create Sequence

```sql
CREATE SEQUENCE CRM_SEQ
START WITH 10
MAXVALUE 99
INCREMENT BY 1
NOCYCLE;
```

---

## 🆔 Record ID Format

Record ID is generated in the following format:

```
YYYYMMDD + First 2 letters of Customer Name (Uppercase) + Sequence
```

### Example:

Join Date: `2005-11-05`
Customer Name: `sham`
Sequence: `10`

Generated Record ID:

```
20051105SH10
```

---

## ⚙️ Database Connection (DBUtil)

```java
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "system";
String password = "your_password";

Class.forName("oracle.jdbc.OracleDriver");
Connection con = DriverManager.getConnection(url, user, password);
```

---

## 🚀 Features

### ✅ Add Customer

* Validates input fields
* Checks duplicate records
* Generates structured Record ID
* Inserts record into database

### ✅ View Customer

* Fetches record using Name + Join Date

### ✅ View All Customers

* Displays list of all customer records

---

## 🛡 Validations Implemented

* Bean must not be null
* Customer name must be at least 2 characters
* Email must contain "@"
* Phone must be at least 10 digits
* Duplicate records are prevented

---

## 🖥 How to Run

1. Install Oracle 11g XE
2. Create table and sequence using SQL commands above
3. Add `ojdbc17.jar` to:

   ```
   apache-tomcat/lib
   ```
4. Deploy project on Tomcat 10
5. Start server
6. Open:

   ```
   http://localhost:8081/Customer_Relationship_Management/
   ```

---

## 📦 Technologies Used

* Java
* JSP
* Servlets
* JDBC
* Oracle 11g XE
* Apache Tomcat 10
* Eclipse IDE

---

## 📊 Sample Output
<img width="804" height="534" alt="image" src="https://github.com/user-attachments/assets/ad17334d-2198-4240-8411-3da4913bc5ab" />
<img width="896" height="567" alt="image" src="https://github.com/user-attachments/assets/31184f9a-8954-4f32-ac05-4874a02c1cfa" />
<img width="835" height="241" alt="image" src="https://github.com/user-attachments/assets/94074865-59ad-44f1-a89b-e5a6e5ac960e" />
<img width="840" height="85" alt="image" src="https://github.com/user-attachments/assets/ac0ff668-9b45-4b22-92fc-0ccc36e59512" />
<img width="874" height="382" alt="image" src="https://github.com/user-attachments/assets/8e8257ae-3e60-498e-b1b7-3766ce96cdec" />





