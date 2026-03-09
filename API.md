# API Documentation

## 1. REST API (User JSON Service)

Base URL:

http://localhost:8081

Authentication Header:

Authorization: sample-token-123

---

## GET User

Endpoint:

GET /users/{id}

Description:

Тухайн ID-тай хэрэглэгчийн мэдээллийг авах.

Example Request:

GET http://localhost:8081/users/1

Response Example:

{
"id": "1",
"name": "Bolormaa",
"email": "[bolormaa@gmail.com](mailto:bolormaa@gmail.com)",
"bio": "Software engineering student",
"phone": "99112233"
}

---

## POST User

Endpoint:

POST /users

Description:

Шинэ хэрэглэгч нэмэх.

Example Request Body:

{
"id": "2",
"name": "Anu",
"email": "[anu@gmail.com](mailto:anu@gmail.com)",
"bio": "Student",
"phone": "99887766"
}

Response:

{
"id": "2",
"name": "Anu",
"email": "[anu@gmail.com](mailto:anu@gmail.com)",
"bio": "Student",
"phone": "99887766"
}

---

## PUT User

Endpoint:

PUT /users/{id}

Description:

Хэрэглэгчийн мэдээллийг шинэчлэх (update).

Example:

PUT http://localhost:8081/users/2

Request Body:

{
"id": "2",
"name": "Anu Updated",
"email": "[anuupdated@gmail.com](mailto:anuupdated@gmail.com)",
"bio": "Updated student",
"phone": "99110022"
}

---

## DELETE User

Endpoint:

DELETE /users/{id}

Description:

Хэрэглэгчийг системээс устгах.

Example:

DELETE http://localhost:8081/users/2

Response:

User deleted successfully

---

# 2. SOAP Authentication Service

SOAP Endpoint:

http://localhost:8080/ws

SOAP Service нь хэрэглэгчийн authentication болон token validation хийдэг.

Available Operations:

* registerUser
* loginUser
* validateToken

---

# 3. Authentication Flow

1. Frontend application REST API руу request илгээнэ.
2. JSON service request-ийг хүлээн авна.
3. JSON service SOAP service рүү token шалгуулах request явуулна.
4. SOAP service token зөв эсэхийг шалгана.
5. Token зөв бол JSON service хэрэглэгчийн мэдээллийг буцаана.
6. Token буруу бол access denied буцаана.

---

# 4. Example Request Flow

Frontend → JSON REST API → SOAP Authentication Service

Example:

Frontend request:

GET /users/1

Header:

Authorization: sample-token-123

JSON service SOAP service рүү validateToken дуудах бөгөөд token зөв бол хэрэглэгчийн мэдээллийг буцаана.
