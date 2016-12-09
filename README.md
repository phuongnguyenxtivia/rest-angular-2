# rest-angular-2
Book Application: using REST service and Angular 2, bases on Don's template at [link-resource](https://projects.austin.xtivia.com/Speedray/speedray-demo-resource) and [link-client](https://projects.austin.xtivia.com/Speedray/demo-speedray-client)

### REST Usage

If all of the steps above have been successfully executed you should now have access to the following REST endpoints (assuming that your local copy of DXP is accessible at http://localhost:8080). **NOTE:** the **/o** portion of the URLs below is required; this is the URL mapping associated with the DXP servlet that services all requests targeted to the OSGi container.

| URL   |      Method      |  Notes |
|----------|:-------------:|:------|
| http://localhost:8080/o/rest/samples/books |GET| Returns the entire collection of in-memory Book objects   |
| http://localhost:8080/o/rest/samples/books/{id} | GET |  Returns a single Book object based on suppplied ID   |
| http://localhost:8080/o/rest/samples/books | POST |Creates a new Book object based on suppplied JSON and returns the created object including ID      |
| http://localhost:8080/o/rest/samples/books/{id} | PUT |Modifies an existing Book object based on suppplied JSON and uses the ID parameter to identify the target book     |
| http://localhost:8080/o/rest/samples/books/{id} | DELETE |  Removes a single Book object based on suppplied ID   

### What I did
- CRUD actions for Book Rest Api
- Form validation
- Routing for SPA
### How to use
Go to `output` folder, copy 2 jar put in deploy

### TO-DO list
- [ ] Display returned message (it can display any hard-code messages but json messages)
- [ ] Delete action cannot invoke Success callback by using subcribe() (Insert, Update, Get can do)
