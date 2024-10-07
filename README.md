
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | AMAN JAIN                  |
| Date         | 03/23/2000                 |
| Course       | Fall 2024                  |
| Assignment # | 2                          |

# Assignment Overview
Please add a paragraph or two overviewing the objectives of the assignment.
Ans : This assignment involves developing a notification system for coordinating product deliveries between retailers and freelance drivers. The system generates delivery requests from stores and notifies all available drivers about them. The focus is on implementing the core functionality using object-oriented principles, without the need for a user interface, and verifying it with unit tests.

The implementation leverages the Observer design pattern to ensure flexibility and scalability, allowing for easy additions of new driver types and vehicles. The project follows best practices, adhering to the SOLID principles and the Google Java Style Guide, ensuring maintainability and clean code.

# GitHub Repository Link:
https://github.com/Aman23000/SDP_Assignment_2.git

# Implementation Description 

Implementation Questions

- Explain the level of flexibility in your implementation, including how new object types can be easily added or removed in the future.
The implementation uses the Observer design pattern, which allows new types of Driver or Vehicle objects to be easily added or removed without modifying the core logic of the Shop or DeliveryRequest classes. This is because new drivers simply need to implement the Observer interface and register with the Shop observable to receive notifications. This flexibility ensures that the system can easily scale with new driver types or delivery methods in the future.

- Discuss the simplicity and understandability of your implementation, ensuring that it is easy for others to read and maintain.
The code adheres to standard object-oriented principles and the Google Java Style Guide, making it clean and maintainable. The use of interfaces (Observer and Observable) clearly separates concerns and responsibilities, improving readability. The implementation is also structured in such a way that the notification logic is encapsulated within the Shop class, while the driver-specific behavior remains in the Driver class, promoting clarity.

- Describe how you have avoided duplicated code and why it is important.
The use of inheritance for Vehicle types (Car, Taxi, Scooter) reduces redundancy, as these subclasses inherit common properties and methods from the base Vehicle class. This eliminates duplicate code related to vehicle behavior. Avoiding duplication is crucial to maintaining a cleaner, more maintainable codebase, as it minimizes the risk of errors and reduces the need for future changes across multiple classes.

- If applicable, mention any design patterns you have used and explain why they were chosen.
The Observer design pattern was chosen because it aligns well with the requirement of broadcasting delivery requests to multiple drivers. It allows for a decoupled relationship between the Shop (subject) and the Driver objects (observers), ensuring that new drivers can be added or removed dynamically without altering the notification logic.
For each assignment, please answer the following:

- Explain the level of flexibility in your implementation, including how new object types can
be easily added or removed in the future.
Ans : The implementation follows the Observer design pattern, which is highly flexible for future expansions. New object types, such as different types of drivers or delivery vehicles, can be added by simply extending or implementing the relevant base classes and interfaces (e.g., adding a new type of vehicle involves creating a subclass of the Vehicle class). Similarly, new drivers can be introduced by implementing the Observer interface and registering them with the Shop class, which acts as the observable.

This decoupling between the observable (Shop) and the observers (Driver objects) ensures that the system can be easily modified without altering the core logic. New features, such as driver availability or different delivery request priorities, could be added without impacting the existing code structure, preserving backward compatibility.

- Discuss the simplicity and understandability of your implementation, ensuring that it is
easy for others to read and maintain.
Ans : The implementation is structured using well-established object-oriented principles, which enhance readability and maintainability. By adhering to SOLID principles and the Google Java Style Guide, the code is kept clear and consistent. The use of interfaces such as Observer and Observable separates the concerns of generating and handling delivery notifications from the behavior of individual drivers, making the system easy to follow.

Methods and classes are designed to be single-purpose, improving understandability. Each class and method has well-defined responsibilities, reducing cognitive load for developers who need to extend or maintain the system. Descriptive class names like DeliveryRequest, Driver, Vehicle, and Shop further contribute to the code's clarity.

- Describe how you have avoided duplicated code and why it is important.
Ans : To avoid duplicated code, the implementation uses inheritance and interfaces where applicable. For instance, the Vehicle class serves as a parent class for Car, Scooter, and Taxi, which avoids repeating common properties and behaviors. This practice not only reduces code redundancy but also makes the codebase easier to update and extend in the future. If changes are needed in the base Vehicle class, they are automatically reflected in all subclasses, preventing potential inconsistencies and errors that could arise from maintaining duplicated code.

Eliminating duplicated code is critical for maintaining a clean, maintainable, and error-free codebase. It allows for easier updates and reduces the likelihood of introducing bugs when implementing new features or fixing issues.
  
- If applicable, mention any design patterns you have used and explain why they were chosen.
Ans : The project leverages the Observer design pattern, which is particularly suitable for the notification system described in the assignment. This pattern allows the Shop class to notify all registered Driver objects when a new delivery request is created, without needing to know the specifics of each driver. This decoupling between the subject (the Shop) and the observers (the Drivers) allows for more flexible and scalable communication. Drivers can be added or removed without modifying the core notification logic, and the system can easily be extended to support other observers (e.g., a monitoring system) in the future.


# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/) on your system. 

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile
Type on the command line: 

```bash
mvn clean compile
```



## JUnit Tests
JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```


## Spotbugs 

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


## Checkstyle 

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser. 

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`




