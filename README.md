
# Pekerjaan Rumah 13 

A simple test project to execute some test cases such as :
- Positive Test case
- Negative Test Case
- Boundary Test Case

This project use [Sauce Labs](https://www.saucedemo.com/) as a sample


## 1. Configuration

Please follow this Configuration. This all are dependencies and setup that used for this project

Dependencies and Configuration file is on ```build.gradle```

**Dependencies**
```java
dependencies {
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.10.0'
    testImplementation("io.github.bonigarcia:webdrivermanager:5.3.0")
    implementation group: 'io.cucumber', name: 'cucumber-java', version: '7.12.1'
    testImplementation group: 'io.cucumber', name: 'cucumber-junit', version: '7.12.1'
    testImplementation platform('org.junit:junit-bom:5.9.1')
    testImplementation 'org.junit.jupiter:junit-jupiter'
}
```
**configurations**  
```java
configurations {
    cucumberRuntime{
        extendsFrom testImplementation
    }
}
```
**Cucumber Setup**  
```java
task cucumber() {
    description("Running Cucumber Test")
    dependsOn assemble, compileTestJava
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = [
                    '--plugin', 'html:reports/index.html',
                    '--plugin', 'pretty',
                    '--glue', 'PekerjaanRumah13.StepDefinition',
                    '--tags', "${tags}",
                    'src/test/resources/feature'
            ]
        }
    }
}
```

**Note:**
- If you want to change the version of dependencies there might be some error/failed to run this project
## 2. Test Cases

There are 4 Scenario to test here. These scenario just a sample for testing purposes. in real cases should be different. Scenario quite straight forward with Gherkin language

- Login using valid email and password
- Login using invalid email and password
- Sort item by character descendingly
- All product price must be under 50 Dollar

Gherkin file is located in ```src/test/resources/feature/login.feature```

example: 
- Login using valid email and password
```Gherkin
  @valid-login
  @positive
  Scenario: Login using valid email and password
    Given user is on login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    When user click login button
    Then user is on homepage
```

## 3.Running

You can run this project using some method: 

**Using terminal**

- Quick run all 

``` bash 
./gradlew cucumber

```
![gradlew_cucumber](https://raw.githubusercontent.com/detagian/pekerjaanrumah13/main/gradlew_cucumber.png)


- Run with Tags 

``` bash 
./gradlew cucumber -Ptags="@positive"

```
![gradlew_cucumber_with_tag](https://raw.githubusercontent.com/detagian/pekerjaanrumah13/main/gradlew_cucumber_with_tag.png
)

**Direct Run From Cucumber File**

- Open login feature file and click play button or Shift+F10
![Quick_Run_All_Scenario](https://raw.githubusercontent.com/detagian/pekerjaanrumah13/main/Quick_Run_All_Scenario.png)
- Can also run per Scenario by clicking green play on left side of Scenario line
![Quick_Run_One_Scenario](https://raw.githubusercontent.com/detagian/pekerjaanrumah13/main/Quick_Run_One_Scenario.png)

## 4.Report

Report is generated in ```reports``` folder location

Setup report is inside the ```CucumberOption``` in ```CucumberTest.java``` file

```java
@CucumberOptions(
        glue = {"com.example.StepDefinition"},
        features = {"src/test/resources/feature"},
        plugin = {"pretty","html:reports/cucumber.html", "json:reports/cucumber.json"}

)
```
![Reports](https://raw.githubusercontent.com/detagian/pekerjaanrumah13/main/Report%20Preview.png)

