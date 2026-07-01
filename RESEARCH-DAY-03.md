# JPA & Spring Boot Interview Questions

## Q1. What is JPA? What is Hibernate? How are they related?

**Answer:**

JPA (Java Persistence API) is a Java specification that defines a standard way to map Java objects to database tables using Object-Relational Mapping (ORM). It provides interfaces and annotations but does not contain the implementation.

Hibernate is the most widely used implementation of the JPA specification. It provides the actual functionality for performing database operations such as creating, reading, updating, and deleting data.

Spring Boot uses Hibernate as its default JPA implementation, allowing developers to program against the JPA specification while Hibernate handles the underlying persistence.

---

## Q2. What is the difference between `@Entity` and `@Table`?

**Answer:**

`@Entity` tells JPA that a class represents a database entity and should be managed by the persistence provider.

`@Table` specifies the name of the database table that the entity maps to. If `@Table` is omitted, JPA uses the entity class name as the table name by default.

---

## Q3. What is a foreign key? What is `@ManyToOne`?

**Answer:**

A foreign key is a column in one table that references the primary key of another table, creating a relationship between the two tables and maintaining referential integrity.

`@ManyToOne` defines a relationship where many instances of one entity are associated with a single instance of another entity.

---

## Q4. What does `@JoinColumn(name = "category_id")` do?

**Answer:**

`@JoinColumn(name = "category_id")` specifies the foreign key column used to establish the relationship between two entities. It tells Hibernate which database column stores the reference to the related entity.

---

## Q5. Why store price as `BigDecimal` and not `double`?

**Answer:**

`BigDecimal` provides precise decimal arithmetic without rounding errors, making it suitable for financial calculations. In contrast, `double` uses floating-point arithmetic, which can introduce precision errors and lead to inaccurate monetary values.

---

## Q6. What does `FetchType.LAZY` vs `FetchType.EAGER` mean? What is the default for `@ManyToOne`?

**Answer:**

`FetchType.LAZY` delays loading a related entity until it is first accessed, improving performance by avoiding unnecessary database queries.

`FetchType.EAGER` loads the related entity immediately when the parent entity is retrieved.

The default fetch type for `@ManyToOne` is `FetchType.EAGER`.

---

## Q7. What is the N+1 query problem?

**Answer:**

The N+1 query problem occurs when one query retrieves a collection of entities, and an additional query is executed for each entity to load its related data. This results in excessive database queries and can significantly reduce application performance.

---

## Q8. What is dependency injection? Constructor injection vs field injection—which is preferred and why?

**Answer:**

Dependency Injection is a design pattern where Spring creates and supplies the required objects instead of classes creating them themselves.

Constructor injection is the preferred approach because it makes dependencies explicit, supports immutable (`final`) fields, improves testability, and ensures that required dependencies are provided when the object is created.

Field injection is generally discouraged because it hides dependencies and makes testing more difficult.

---

## Q9. What does `@RequiredArgsConstructor` (Lombok) do?

**Answer:**

`@RequiredArgsConstructor` automatically generates a constructor for all `final` fields and fields annotated with `@NonNull`. This reduces boilerplate code and works well with constructor-based dependency injection in Spring.

---

## Q10. What is the role of the SERVICE layer? Why must it be separate from the controller?

**Answer:**

The service layer contains the application's business logic. It is responsible for validating data, applying business rules, coordinating operations, interacting with repositories, and managing transactions.

The controller should only handle HTTP requests and responses, delegating business logic to the service layer. Separating these responsibilities improves maintainability, reusability, readability, and testability.

---

## Q11. Why must you validate that `categoryId` exists before saving a menu?

**Answer:**

The `categoryId` must be validated to ensure the referenced category exists before saving the menu. This maintains referential integrity, prevents invalid foreign key relationships, and allows the application to return a meaningful error instead of relying on a database constraint violation.

---

## Q12. Difference between `save()` and `saveAndFlush()`?

**Answer:**

`save()` stores the entity in the persistence context, and Hibernate synchronizes the changes with the database at an appropriate time, usually when the transaction is committed.

`saveAndFlush()` saves the entity and immediately synchronizes the pending changes with the database. It should only be used when the application requires the data to be written to the database immediately.

---

## Q13. Why write private mapper methods (Entity ↔ DTO)?

**Answer:**

Private mapper methods centralize the conversion between entities and DTOs, keeping controllers and services clean. They prevent exposing internal entity structures, separate the persistence model from the API model, improve maintainability, and ensure mapping logic is implemented consistently in one place.