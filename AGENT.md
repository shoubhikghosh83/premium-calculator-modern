# AGENT.md — Modern Implementation Repository

## Purpose

This repository contains the modernized implementation of the premium calculator system using:

- Spring Boot (Backend)
- React (Frontend)

It must satisfy tests defined in:
premium-calculator-tdd-testcase

---

## Architecture Guidelines

Backend:
- Java 17
- Spring Boot
- Layered architecture:
  - Controller
  - Service
  - Repository
  - Domain
  - PremiumCalculator component
- Use DTOs
- Use Enum for InsuranceType
- No business logic in controller

Frontend:
- React
- Clean separation between API layer and UI

---

## STRICT DEVELOPMENT FLOW

Phase 1:
Tests are generated in test repository.

Phase 2:
Implementation must satisfy failing tests.

Phase 3:
Refactor without breaking tests.

---

## Implementation Rules

- Minimal code to pass tests.
- No hardcoded magic numbers.
- Premium calculation logic must be isolated.
- Validation must use proper annotations.
- Follow SOLID principles.

---

## Branch Strategy

Work only in:
devin-modernization branch.

Never push directly to main.

All changes must be submitted via Pull Request.

---

## Jira Integration

- Every change must be linked to a Jira issue.
- PR description must include Jira key.
- Update Jira status accordingly.

---

## Constraints

- Do NOT alter test expectations.
- Do NOT bypass failing tests.
- Do NOT change legacy repository.
