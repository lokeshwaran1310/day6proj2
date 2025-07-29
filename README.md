# 🐞 Bug Tracking System

## 📌 Title
**Bug Tracking System using Java and PostgreSQL**

---

## 📖 Description
This is a console-based application that allows users to **insert, view, update, and delete** bugs from a PostgreSQL database. It mimics a basic bug management tool often used in software development teams.

---

## 🧩 Components

1. **Entity Layer**
   - `Bug.java`: Represents the bug entity with attributes like ID, title, description, and status.

2. **Controller Layer**
   - `BugController.java`: Handles user input and invokes service methods.

3. **Service Layer**
   - `BugService.java`: Contains business logic and validation.

4. **Repository Layer**
   - `BugRepository.java` (Interface): Declares DB operations.
   - `BugRepositoryImpl.java`: Implements the interface using JDBC.

5. **Utility Layer**
   - `DbUtil.java`: Establishes database connection using JDBC.

---

## 🎨 Design Highlights

- **Layered architecture** (Controller → Service → Repository → DB)
- **Input validation** for empty fields and allowed status values (`open`, `closed`)
- **Dynamic bug listing** sorted by ID
- **JDBC abstraction** from business logic via interface
- **Proper error handling** and user feedback messages
- **Scalable base** that can be extended to web applications later

---

## 🎯 Purpose

- To demonstrate core Java application development skills.
- To understand and apply layered architecture.
- To perform database operations using JDBC.
- To simulate a basic version of a real-world bug tracking system.

---

## 👨‍💻 Author

**Lokeshwaran M**  |
**lokeshwaran.m@epssw.com**

---

