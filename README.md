# SOA Lab Project – SOAP and REST Integration

## 1. Project Overview (Төслийн танилцуулга)

Энэ төсөл нь **REST JSON service** болон **SOAP authentication service** хоорондын интеграцийг харуулах зорилготой.

Систем нь дараах гурван үндсэн хэсгээс бүрдэнэ:

* **Frontend Application** – HTML + JavaScript интерфэйс
* **User JSON Service** – REST API ашиглан хэрэглэгчийн профайл удирдана
* **User SOAP Service** – authentication болон token validation хийдэг

Энэ архитектур нь REST болон SOAP сервисүүдийг хамтад нь ашиглах жишээг харуулж байна.

---

# 2. System Architecture (Системийн архитектур)

Системийн бүтэц:

Frontend → JSON REST Service → SOAP Authentication Service

* **Frontend** – REST API руу HTTP request илгээнэ
* **JSON Service** – хэрэглэгчийн CRUD үйлдлийг гүйцэтгэнэ
* **SOAP Service** – authentication болон token validation хийнэ

Өгөгдөл нь түр хугацаанд **in-memory HashMap** ашиглан хадгалагдаж байна.

---

# 3. Technologies Used (Ашигласан технологи)

Энэ төсөлд дараах технологиудыг ашигласан:

* Java
* Spring Boot
* Spring Web MVC (REST)
* Spring Web Services (SOAP)
* Maven
* HTML
* JavaScript
* Git / GitHub

---

# 4. Project Structure (Төслийн бүтэц)

Repository нь дараах 3 project-оос бүрдэнэ:

SOA-Lab
├ user-json-service
├ user-soap-service
└ frontend-app

### user-json-service

REST API ашиглан хэрэглэгчийн мэдээллийг удирдана.

### user-soap-service

SOAP service бөгөөд authentication болон token validation хийдэг.

### frontend-app

HTML + JavaScript ашигласан интерфэйс бөгөөд REST API-г тестлэхэд ашиглагдана.

---

# 5. REST API (JSON Service)

Base URL:

http://localhost:8081

### GET /users/{id}

Хэрэглэгчийн мэдээллийг авах.

### POST /users

Шинэ хэрэглэгч нэмэх.

### PUT /users/{id}

Хэрэглэгчийн мэдээллийг шинэчлэх.

### DELETE /users/{id}

Хэрэглэгчийг устгах.

---

# 6. SOAP Service Operations

SOAP endpoint:

http://localhost:8080/ws

Үйлдлүүд:

* registerUser
* loginUser
* validateToken

JSON service нь **validateToken** SOAP operation ашиглан authentication шалгадаг.

---

# 7. Authentication Flow (Нэвтрэлт шалгах процесс)

1. Frontend request илгээнэ
2. JSON service request хүлээн авна
3. JSON service SOAP service рүү validateToken илгээнэ
4. SOAP service token шалгана
5. Token зөв бол JSON service хэрэглэгчийн мэдээллийг буцаана

---

# 8. Installation (Суулгах заавар)

Алхамууд:

1. **user-soap-service** project run хийх
2. **user-json-service** project run хийх
3. **frontend-app/index.html** файлыг browser дээр нээх

---

# 9. Testing the Application

Frontend интерфэйсээр дараах үйлдлүүдийг тестлэх боломжтой:

* View User
* Add User
* Update User
* Delete User

Authentication Token:

sample-token-123

---

# 10. Data Storage (Өгөгдөл хадгалалт)

Энэ лабораторид өгөгдлийг **in-memory HashMap** ашиглан хадгалсан.

Давуу тал:

* database шаардлагагүй
* энгийн туршилт хийхэд тохиромжтой

Production системд дараах database ашиглаж болно:

* MySQL
* PostgreSQL
* MongoDB
