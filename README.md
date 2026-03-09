# SOA Lab Project

This project demonstrates integration between REST and SOAP services.

## Projects

- user-soap-service → SOAP authentication service
- user-json-service → REST user profile service
- frontend-app → HTML frontend interface

## Architecture

Frontend → JSON REST API → SOAP Authentication Service

## Ports

SOAP Service: 8080  
JSON Service: 8081

## Authorization

Header:

Authorization: sample-token-123

## Example Request

GET http://localhost:8081/users/1