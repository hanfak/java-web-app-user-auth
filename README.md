## Task

To  create a web application that allows a user to register their credentials and password. When the user logs into the application they are required to verify via SMS Two Factor Authentication (2FA).

## User Stories

US1. Get welcome page
  As a user
  So I know what to do when accessing the site
  I want to be presented with choice of registering or logging in
  
US2. Register a User
  As a user,
  So that I can store my details and login straight away
  I want to register to the application
  
US3. Login a User
  As a user,
  so that I can use the website
  I want to login to the my personalised application

US4. Two factor authentication
  As a user
  so that I know my details are secure
  I want to use a text authentication to access the my application
  
 (US is short for User Story)

## Technology

- Java language using Eclipse J2EE IDE
- MySQL database
- Tomcat server 
- MySQL connector (to connect database to program)
- servlet api (to connect servlet to run on Tomcat)
- Git for version control

## Approach

I went about it in an agile manner, starting off with user stories and completing each one. I aimed to spike the program then redo it using a testing, but the difficulties in the setup meant I ran out of time.

I decided to use the MVC pattern for structuring my web app and kept my controllers(used servlets as a substitute) skinny by extracting as much out of the request methods (ie POST) to private methods and to the other methods. I kept my methods and classes simple, and aimed to do one thing (single responsibility principle). For example, splitting the database connection from the database querying/insert functionality. I stored the users details as an object, thus making it easier to access and implement assoicated behaviour throughout the program.

## Completed

I have completed the first three user stories:
	- A user can register or log in
	- A user must fill in all the fields in the registration form to continue
	- A user's details are stored in a database (see `/SQLscripts/database.sql` for details on the database setup)
	- When registered, user taken to login page
	- If login does not match record in database, stuck on login
	- When login is success taken to welcome page

## To do

- User story 4
	- Add redirect from login POST controller to mobile authentication page
	- Create controller to for mobile authentication for GET form to input code and POST to check if code matches and redirect to welcome page
	- Create class to handle code creation, to create randomised code
	- Implement Zensend to send text containing code
	- Create method to get user details from database (database manager class) to personalise welcome page after 2FA has been done.
- Check password and password confirmation match up on registration form, create new field for password confirmation in register.jsp
- Secure passwords in database, use a hashing technique like brcypt to securely store the hashed passwords, and able to decrypt when need to use
- Use sessions to keep track of user and not able to login again, allow for logout
- Use dependency injection in servlets/controllers for instantiating the model object and thus lower coupling
- Adding tests and redoing program using TDD

## Issues and difficulties

Using servlets was a new technology for implementing a web app, this took some time to understand and know how to go about completing the task. I had several issues including:
	- Use the wrong version of eclipse, which meant I could not see as  Tomcat an option
	- Tomcat not linking to my servlets, solved by adding the correct library to build path
	- sql not connecting, solved by storing jar file in project
	
I have done some basic java before hand, so almost all of this was new to me and a lot of research was done on how to solve this problem. 

Due to the lack of time I was not able to implement any testing. 

## To execute

- clone repo
- open in IDE
- install mysql-connector-java, apache tomacat, mysql
- From `/SQLscripts/database.sql`, run this script in mysql shell to create the database
- setup server to tomcat 
- click on project and run as server
- if browser tab does not pop up, got to browser and enter in address bar `http://localhost:8080/JavaAuthenticationProject/`