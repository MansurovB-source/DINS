## QAA HOME TASK

# DESCRIPTION:
Let's have a look at the REST API, that returns a list of posts with additional information.
Posts

Using this API, you are able to get all posts or a particular post by its id, like: /posts/1

NEED TO DO:
1. Create and automate test cases using Java, JavaScript or Python programming languages (preferably Java) for the following actions:
- Filtering by query parameters (like /posts?userId=1)
- Get a resource by id
- Get list of all resources

You don't need to cover cases about CREATE, UPDATE and DELETE operations in this task.

Preferable technical stack for Java: 
- Testing framework: TestNG, JUnit
- Build tool: Maven, Gradle
- Assertion libraries: Hamcrest
- HTTP client: RestAssured, Retrofit

2. Describe P0 test cases in plain text about CREATE, UPDATE and DELETE operations.
To CREATE a resource you need to fill the next mandatory fields in the body of the request: title, body, userId.
To UPDATE a resource you need to fill the necessary field(s) in the body of the request.
UPDATE and DELETE operations are possible by the id of the resource.

Describe your test cases in the next format:

| Summary | Steps | Expected result |
|---------|-------|-----------------|

3. Create a bug report for the next issue:
The request GET /posts/0 returned 404 Not Found, but you expect an empty list with 200 OK
