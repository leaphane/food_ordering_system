# food_ordering_system

---

## 1. What does CRUD stand for?
> *Create, read, update and delete*

## 2. Difference between HTTP methods POST, PUT, PATCH, DELETE?
> *Post is for creating a new resource, put is for updating an existing resource, delete is for deleting a resource 
patch is for partially updating an existing resource*

## 3. Give the correct HTTP status code for each:


### a. A new category was created
> *201*

### b. A category was deleted successfully
> *204*

### c. The id requested does not exist
> *404*

### d. The request body is missing a required field
> *400*

### e. The user is logged in but not allowed
> *403*

---

## 4. Difference between @RequestBody, @RequestParam, @PathVariable
> *.*

### @RequestBody
> *Maps the HTTP request body (JSON/XML) into a Java object. Used by PUT, PATCH, and POST*
> 
### @RequestParam
> *Extracts query parameters from the URL*

### @PathVariable
> *Extracts values directly from the URL path*

# Endpoints

| Method | URL                       | Body         |
  |--------|---------------------------|--------------|
| POST   | /api/categories           | { "name" }   |
| GET    | /api/categories           | -            |
| GET    | /api/categories/{id}      | -            |
| PUT    | /api/categories/{id}      | { "name" }   |
| DELETE | /api/categories/{id}      | -            |


