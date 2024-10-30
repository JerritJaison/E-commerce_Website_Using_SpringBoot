E-Commerce Website using Spring Boot and React
This project is a full-stack E-Commerce Product Management System designed to provide seamless functionality for managing products, including adding, updating, and retrieving product information. 
The backend is built with Spring Boot and Oracle, while the frontend uses React.js for an interactive user interface.

Table of Contents
-----------------
Features
Tech Stack
Project Structure
Setup
Usage
API Endpoints
Future Enhancements

Features
---------
* Product Management: Add, update, retrieve, and delete products.
* Image Handling: Upload and update product images.
* User-Friendly Interface: React-based front end for intuitive navigation.
* Error Handling: Comprehensive error management to enhance usability.
Tech Stack

Backend: Spring Boot
Database: Oracle 21c
Frontend: React.js
Additional Tools: Spring Boot Starter, JPA with @GeneratedValue, CSS for styling
Project Structure
Backend (Spring Boot)
Controllers: Handle HTTP requests and manage API endpoints.
Services: Contains business logic for handling products.
Repositories: Interface with Oracle 21c using JPA.
Configurations: Configurations for JPA, database connectivity, etc.

Frontend (React)
----------------
Components: Individual React components for UI elements (e.g., Product List, Product Form).
Services: Handle API calls to the Spring Boot backend.
CSS: Styling for a modern and intuitive UI.

Setup
-----
Prerequisites
* Java 17 or later
* Node.js and npm (for React frontend)
* Oracle Database 21c (you can use any database)
Backend Setup
Data base setup
--------------
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
