# EAFramework
Selenium Framework

Mozilla Firefox - geckodriver [v0.33.0](https://github.com/mozilla/geckodriver/releases)   
JUnit Jupiter API [v5.10.2](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.10.2)  
Selenium Java [v4.17.0](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.17.0)  

If any error occurs regarding missing JUnit dependencies (installed through maven), JUnit should be added as a dependency manually.
Also you need to install the Test Automation plugin for Intellij.

For MacOS you should use only drivers compatibles with macOS

Log4j might be suitable to be used in logging the messages.

TODO:
- Figure out the Cucumber report: a json file is generated only if you run the runner class without maven. In maven only 1 test runs and the json file is not generate. It s possible to read another runner??
- The course shows me how to use selenium grid with selenium-server-standalone which is deprecated. Need to figure out how to work with newer technologies.
- To study more about Lombok plugin, and it's use in POJO classes and in testing (@Data and @Builder), add it as a maven dep.
