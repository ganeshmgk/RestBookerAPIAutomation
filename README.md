# RestBooker API Automation

This project provides automated test coverage for the [Restful Booker API](https://restful-booker.herokuapp.com/) using **Java**, **RestAssured**, and **TestNG**.  
It includes test cases for health checks, authentication, booking creation, booking retrieval, and booking deletion.

## 🧪 Technologies Used

- Java 17+
- RestAssured
- TestNG
- Maven
- JSON

## 🚀 Project Structure

 Notes
Base URI: https://restful-booker.herokuapp.com

Token is dynamically created and reused in tests.

Tests include assertions on response codes and content.

POJOs used for cleaner response mapping.

## ✅ Test Scenarios Covered
| Feature        | Description                            |
|----------------|----------------------------------------|
| Server Health  | Ping `/ping` to verify server is up    |
| Create Token   | Authenticates and retrieves token      |
| Create Booking | Creates a booking with user details    |
| Get Booking    | Fetches booking by ID                  |
| Delete Booking | Deletes a booking using token          |

Ganesh M G K
Email: 
GitHub: ganeshmgk

## 🔧 How to Run the Tests

1. Clone the repository

```bash
git clone https://github.com/<your-username>/RestBookerAPIAutomation.git
cd RestBookerAPIAutomation


