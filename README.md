# Jumia App
A single page application in Java (Frameworks allowed) that uses the provided database to list and categorize country phone numbers.

### How to run?
1. `git clone https://github.com/Hassan-Elseoudy/JumiaBE`
2. `docker-compose up`

### How to test?
1. You can check from swagger over: http://localhost:8080/api/v1/jumia/swagger-ui/
2. Select `Customer Controller` and then select `GET /api/v1/jumia/customer` then on the right, select `Try it out`.
3. You can filter by Country Id or by state or without any filtration.
4. You can paginate by page number and size.

### Notes:
1. Secrets should be added to a ConfigMap, Since this is a demo project, So It was added in the files for simplicity.
2. Using *YAGNI* principle, I only added the `@GetMapping` request in `CustomerController`, If the requirements were to add multiple endpoints, then It should be easily done later.
3. I preferred to use `Country` as a table in the project, rather that `ImmutableObjects`, So that we can easily add/remove/update the regex, but as I mentioned, no controllers.
4. There was no default values for page sizes, so I sat default to `10` and max page size to `50`.
