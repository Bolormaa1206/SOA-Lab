# API Documentation

## JSON Service (REST)

Base URL:
http://localhost:8081

### Get User

GET /users/{id}

Example:

http://localhost:8081/users/1

Header:
Authorization: sample-token-123

Response:

{
 "id": "1",
 "name": "Bolormaa",
 "email": "bolormaa@gmail.com",
 "bio": "Software engineering student",
 "phone": "99112233"
}

---

## SOAP Auth Service

Endpoint:

http://localhost:8080/ws

Operations:

- loginUser
- registerUser
- validateToken