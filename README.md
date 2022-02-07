# Adidas

Selenium end-to-end testing for Adidas checkout flow

This project was written using IntelliJ IDEA Community Edition.

Project Packages
-----

All packages are located under `src\test\java`

* PageObjects:  
  Contains class files for each web page being tested. BasePage, Page element definitions / mappings, and functions for
  interacting with page elements.

* Driver:  
  Contains helper function to instantiate and tear down WebDriver to the appropriate browser type. Wait class contains
  helper functions to handle driver waits for page elements conditions.

* Features:  
  Feature file containing test scenarios

* StepDefinitions:  
  Contains step definitions for executing tests

Selenium WebDriver
------------
This project is configured to use Firefox & Chrome WebDriver's. The default is set to Chrome. This can be changed to
Firefox in `src\test\resources\config.properties`. The right WebDriver version for your OS/browser combination needs to
be added to `src\test\resources` and updated in `src\test\resources\config.properties`. It can be downloaded
from https://chromedriver.chromium.org/downloads


Maven Java Project / Maven Wrapper
-----
This project is written in Java and tests can be executed using Maven commands.

```bash
# Linux/macOS
./mvnw clean verify

# Windows
.\mvnw.cmd clean verify
```
