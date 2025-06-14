# Unit Testing Example (Java + JUnit 5 + Mockito)

This is a simple example project demonstrating how to write unit tests in Java using:

- JUnit 5
- Mockito
- Spring Boot Test

The example method under test is a `ReportService` that generates a `UserReportDTO` based on data from:

- a `UserService`
- an `OrderService`

## Project Structure

- `ReportService.java` → service under test
- `ReportServiceTest.java` → unit tests
- `User.java`, `Order.java` → example models
- `UserReportDTO.java` → DTO under test
- `UserNotFoundException.java` → example exception

## Running the Tests

You can run the tests using:

```bash
./mvnw test
```
or inside your IDE (IntelliJ IDEA, Eclipse, etc.).

## Related Blog Post

👉 [Tired of Writing Bad Unit Tests? Here’s the Beginner’s Guide I Wish I Had](https://medium.com/@uthpala_sam/tired-of-writing-bad-unit-tests-heres-how-to-do-it-right-b886be7d8173)

## License

MIT License
