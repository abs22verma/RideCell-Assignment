# RideCell-Assignment

Pre-Requist
Install Java 1.8
Install Maven 3+
Install Eclipse

Step 1: import the "Assignment" project as maven
Step 2: Update the github credentials in 'base.properties' file (src/test/resources)
		username=<username>
		password=<password>
Step 3: Run the 'TestRunner.java' file as junit(src/test/java/com/ridecell/runner)

**Note: you can run the test using maven command like below
mvn test -Dusername=<username> -Dpassword=<password> -Dcucumber.filter.tags="@github"

**please provide github username and password