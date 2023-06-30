# GraphQLAPIFramework
### Automated GraphQL Api using Rest-Assured and TestNg with Java. 
### Maven Dependencies are present in the pom.xml file. 
## Prerequisite
### Install java version - openjdk version "20.0.1"
### Install  maven version - Apache Maven 3.9.2 (or whichever is the latest version) 
### IDE - Intellij
## Steps to run tests 
### 1. Open the project folder in Intellij IDE 
### 2. Run command - mvn clean install -U (this will download all maven dependencies), make sure the build is successful. 
### 3. Individual tests can be run directly from the file - GraphQLTest.java or use the command mvn test to run all the tests. 
## Report - 
|    Test    | Methods Passed | Scenarios Passed | # skipped | # failed |  Total Time  | Included Groups | Excluded Groups |
|:----------:|:--------------:|:----------------:|:---------:|:--------:|:------------:|:---------------:|:---------------:|
| ApiTesting |             11 |               11 |         0 |        0 | 12.8 seconds |                 |                 |
|            |                |                  |           |          |              |                 |                 |
|            |                |                  |           |          |              |                 |                 |

#### tests are present in the GraphQLTest file, after running the file an emailable report will be generated in test-output folder. 

