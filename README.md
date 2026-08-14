# 🤖 AI-Powered Workforce Management Platform

A full-stack workforce management application built with **Java Spring Boot**, **MySQL**, **Thymeleaf**, **Spring Security**, and **Google Gemini AI**.

The platform provides secure employee management, user authentication, and an AI-powered assistant through a web-based interface.

## 🚀 Live Demo

🔗 **[View Live Application](https://ai-powered-workforce-management-platform.onrender.com)**

> The application is deployed on Render and uses a Railway MySQL database.

---

## ✨ Features

### 🔐 Authentication & Security
- User registration and login
- Secure authentication using Spring Security
- Password encryption using BCrypt
- Protected application routes
- Role-based authorization
- Access denied handling

### 👥 Employee Management
- Add new employees
- View all employees
- View individual employee details
- Edit employee information
- Delete employees
- Employee data stored in MySQL

### 🤖 AI-Powered Assistant
- Integrated Google Gemini AI
- AI-powered HR/workforce assistance
- Interactive AI assistant through the web interface

### 🗄️ Database
- MySQL database
- Spring Data JPA
- Hibernate ORM
- Automatic table creation/update using JPA

### ☁️ Deployment
- Spring Boot application deployed on Render
- MySQL database hosted on Railway
- Environment variables used for production configuration

---

## 🛠️ Tech Stack

| Category | Technologies |
|---|---|
| Language | Java |
| Backend | Spring Boot |
| Security | Spring Security, BCrypt |
| ORM | Hibernate, Spring Data JPA |
| Database | MySQL |
| Frontend | HTML, CSS, Thymeleaf |
| AI | Google Gemini API |
| Build Tool | Maven |
| API Testing | Postman |
| Version Control | Git, GitHub |
| Deployment | Render, Railway |

---

## 📂 Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── com/example/Main/
│   │       ├── ai/
│   │       ├── config/
│   │       ├── controller/
│   │       ├── entity/
│   │       ├── repository/
│   │       └── service/
│   │
│   └── resources/
│       ├── static/
│       └── templates/
│
└── test/
