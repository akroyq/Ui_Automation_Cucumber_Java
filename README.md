# UI-Automation-Cucumber-Java
# Objective: 
Developed a sample BDD framework which support to develop automation test scripts for functional testing.

# Libraries used:
1. Java
2. Selenium
3. Cucumber
4. Extentsreport
5. Junit
6. Maven


# Steps to start:
1. Clone / Download the project into your local.
2. Open the Command prompt and navigate to project location.
3. Execute the following Maven command's
    - mvn clean :- To clean the maven repo.
    - mvn install :- To install the maven requirements.
    - mvn test -Dbrowser=chrome -Denv=UAT :- To execute the test scenarios on chrome browser and UAT env.


# Scenario details: 
1. Enter https://www.goibibo.com
2. Search for one-way flight.
3. Verify the page results are ordered in decreasing order of cost.

# Approach: 
1. Implemented Behavior Driven Development(BDD) approach.
2. Implemented FileUtil, RandomUtil, Screenshot libraries. 
3. Maintained low level and high level logs.
4. Used page object model design pattern.
5. Test data maintained in properties files/ data table.
6. Browser and environment are parameterized (example: -Dbrowser=chrome -Denv=UAT).
7. Maintained tags.
8. Used Junit library for assertions.
9.Used Extentsreport for reporting.
