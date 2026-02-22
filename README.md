# Premium Calculator Modern

A Spring Boot REST API for calculating insurance premiums. This is the modernized Java replacement for the legacy C# ASP.NET MVC application (`premium-calculator-legacy`).

## Tech Stack

- Java 17
- Spring Boot 3.2.5
- Maven
- Jakarta Bean Validation

## API

### POST /api/insurance

Creates an insurance application and calculates the premium.

**Request:**

```json
{
  "customerName": "John",
  "customerAddress": "123 Main St",
  "insuranceType": "AUTO"
}
```

| Field             | Type   | Required | Values                     |
|-------------------|--------|----------|----------------------------|
| `customerName`    | String | Yes      | Non-blank                  |
| `customerAddress` | String | Yes      | Non-blank                  |
| `insuranceType`   | String | Yes      | `AUTO`, `MEDICAL`, `HOUSE` |

**Success Response (201 Created):**

```json
{
  "applicationId": 1,
  "customerName": "John",
  "customerAddress": "123 Main St",
  "insuranceType": "AUTO",
  "calculatedPremium": 5000,
  "createdAt": "2026-02-20T11:42:35.123"
}
```

**Error Response (400 Bad Request):**

```json
{
  "errorCode": "VALIDATION_ERROR",
  "message": "customerName: must not be blank"
}
```

## Premium Calculation

### Base Premiums

| Insurance Type | Base Premium |
|----------------|-------------|
| AUTO           | 5000        |
| MEDICAL        | 7000        |
| HOUSE          | 10000       |

### Modifiers (applied in order)

1. **5% discount** if `customerName` length > 10 characters
2. **10% surcharge** if `customerAddress` contains "Metro" (case-sensitive)

Example: `customerName="JohnDoeSmith"` (12 chars), `address="123 Metro St"`, `type=AUTO`
  - 5000 x 0.95 = 4750 (discount)
  - 4750 x 1.10 = 5225 (surcharge)
  - Result: **5225**

## Project Structure

```
src/main/java/com/insurance/
  Application.java                          # Spring Boot entry point
  controller/InsuranceController.java       # REST endpoint
  service/InsuranceApplicationService.java  # Application orchestration
  service/PremiumCalculationService.java    # Premium calculation logic
  service/ApplicationIdGenerator.java       # Thread-safe ID generation
  dto/InsuranceRequestDto.java              # Request with validation
  dto/InsuranceResponseDto.java             # Response structure
  dto/ErrorResponseDto.java                 # Error response structure
  model/InsuranceType.java                  # AUTO, MEDICAL, HOUSE enum
  exception/GlobalExceptionHandler.java     # Validation error handling
```

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+

### Build and Run

```bash
mvn clean compile
mvn spring-boot:run
```

The application starts on `http://localhost:8080`.

### Verify with TDD Tests

Start this application, then in a separate terminal:

```bash
git clone https://github.com/shoubhikghosh83/premium-calculator-tdd-testcase.git
cd premium-calculator-tdd-testcase
mvn clean test
```

Expected result: `Tests run: 12, Failures: 0, Errors: 0, Skipped: 0`

## Author

Shoubhik Ghosh
