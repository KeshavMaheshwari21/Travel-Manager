<h1 align="center">Travel Manager <img width="40" src="images/plane.gif"></h1>

A comprehensive **Travel Management System** designed to simplify travel planning, bookings, and expense tracking. Built with Java and MySQL, this application features an intuitive GUI and secure database connectivity.

## 📑 Table of Contents

- Features
- Technology Stack
- Setup & Installation
- Usage Guide
- Project Structure
- MySQL Database 

## ✨ Features

- User Registration/Login - Secure and personalized profiles
- Booking Management - Manage travel bookings
- Itinerary Generation - Automated based on trip details
- Data Persistence - SQL-based storage for secure data management
- Intuitive GUI - Java Swing for a user-friendly interface

## 🛠️ Technology Stack

- Language: Java
- GUI: Java Swing
- Database: MySQL
- Libraries: JDBC for database connection

## ⚙️ Setup & Installation

### Prerequisites

- Java Development Kit (JDK) - Version 11 or above
- MySQL - To store travel data

### Installation Steps

Clone the repository and navigate to it:

```bash
git clone https://github.com/KeshavMaheshwari21/Travel-Manager.git
cd Travel-Manager
```

## 📖 Usage Guide

1. **User Authentication** 🔑 - New users sign up; existing users log in.
2. **Trip Management** 🌏 - Add trip details (destination, dates, budget).
3. **Booking Management** 🏨 - Manage accommodations and transport bookings.
4. **Expense Tracking** 💸 - Update budget and log expenses.
5. **Generate Itinerary** 🗺️ - Automatically get a full trip itinerary.

## 📂 Project Structure

```bash
Travel-Manager/
├── src/                             # Source code directory ( contains all the java files )
├── bin/                             # Compiled .class files                         
├── lib/                             # External libraries and dependencies
│   └── mysql-connector.jar          # MySQL connector for database connection
├── images/                          # Contains all the images of the projects                        
└── Readme.md                        # Project description
```

## 🗄️ MySQL Database 

Creating the new Database for the Project :
```bash
create database travelmanagementsystem;
```

Use the new database for creating various tables :

```bash
use travelmanagementsystem;
```

### Creating the Tables in the Database

1. 🧑‍💼 **Account Table** : The **account** table stores essential user information for the **Travel Manager** application, including login credentials and security data. It contains the following fields:
- username: Unique identifier for each user
- name: Full name of the user
- password: User’s password (plain text; encryption recommended in production)
- security: Security question for account recovery
- answer: Answer to the security question

```bash
create table account(
username varchar(20),
name varchar(20),
password varchar(20),
security varchar(20),
answer varchar(20));
```

2. 🏨 **BookHotel Table** : The **bookhotel** table stores details related to hotel bookings in the **Travel Manager** application, including:
- username: Username of the person making the booking
- name: Name of the person booking the hotel
- persons: Number of persons included in the booking
- days: Number of days for the stay
- ac: Indicates if air conditioning is included
- food: Indicates if food is included
- id: Booking identification number
- number: Room or booking reference number
- phone: Contact number for the user
- price: Total price of the booking

```bash
create table bookhotel(
username varchar(20),
name varchar(20),
persons varchar(10),
days varchar(10),
ac varchar(10)
food varchar(10),
id varchar(15),
number varchar(20),
phone varchar(15),
price varchar(15));
```

3. 🎫 **BookPackage Table** : The **bookpackage** table stores information about travel package bookings in the **Travel Manager** application, with the following columns:
- username: Username of the person booking the package
- package: Name or type of travel package selected
- persons: Number of people included in the package
- id: Unique booking identification number
- number: Package reference number
- phone: Contact number of the user
- price: Total cost of the package

```bash
create table bookpackage(
username varchar(20),
package varchar(20),
persons varchar(10),
id varchar(15),
number varchar(20),
phone varchar(15),
price varchar(15));
```

4. 🧍 **Customer Table** : The **customer** table holds essential information about customers in the **Travel Manager** application. It includes:
- username: Unique username associated with the customer
- id: Unique customer ID
- number: Reference number related to the customer
- name: Full name of the customer
- gender: Gender of the customer
- country: Customer’s country of residence
- address: Full address of the customer
- phone: Contact phone number of the customer
- email: Email address of the customer

```bash
create table customer(
username varchar(20),
id varchar(15),
number varchar(20),
name varchar(20),
gender varchar(10),
country varchar(20),
address varchar(50),
phone varchar(15),
email varchar(25));
```

5. 🏩 **Hotel Table** : The **hotel** table stores key information about hotels in the **Travel Manager** application. It includes:
- name: Name of the hotel
- costperperson: Cost per person for staying at the hotel
- acroom: Cost of air-conditioned rooms
- foodincluded: Cost if food is included in the booking

```bash
create table hotel(
name varchar(30),
costperperson varchar(15),
acroom varchar(20),
foodincluded varchar(20));
```
