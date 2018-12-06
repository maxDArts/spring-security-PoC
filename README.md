# spring-security Proof of Concept
This test project shows how we can implement resource mangement according to our new rules (filter by /{**network**}/{**oganization**}/{resourse}) using spring security.

To run this project and test filtering you need to do the next steps
* add the source code as maven project into your favorite IDE
* provide path to your mongo instance (in properties.yaml) 
* run the Main.java file
* put into your browser any test url (for example: http://localhost:8080/net/org/read)
* fill the login form with credential (for example: {login: user, password: pass} or {login: root, password: pass})

For now, as you can see from Main.java, I created two different test users. One is admin (name: root, password: pass) and user (name: user, password: pass). Admin has access to any network and organization and user has READ access to net/org and WRITE access to /net/org2.
