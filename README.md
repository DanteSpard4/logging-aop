# logging-aop

A simple Aspect-Oriented Programming (AOP) logging library for Java projects.

## Overview

This repository provides a library for logging using Aspect-Oriented Programming (AOP) techniques in Java. With this approach, logging logic is separated from business logic, making applications cleaner, more modular, and easier to maintain.

## Features

- **Automatic Logging**: Intercept and log method calls automatically.
- **Customizable Aspects**: Easily add or modify logging behavior via aspects.
- **Non-intrusive**: No need to modify your existing business logic.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 

### Installation

Clone the repository:

```bash
git clone https://github.com/DanteSpard4/logging-aop.git
cd logging-aop
```

### Compilation

Compile and install the project to your local Maven repository:

```bash
mvn install
```

This command will build the project and install the generated library into your local Maven repository (typically located at `~/.m2/repository`).  
You can then use this library as a dependency in other Maven projects on your machine.

### Adding as a Dependency

To use this library in another Maven project, add the following dependency to the `<dependencies>` section of your project's `pom.xml`:

```xml
<dependency>
    <groupId>com.dantespard4</groupId>
    <artifactId>logging-aop</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

> **Note:** Make sure you have installed the library to your local Maven repository using `mvn install` in the `logging-aop` project before adding it as a dependency.

### Build Configuration

Before running your application, you must compile the project with the AspectJ Maven Plugin. This step is required so that aspect weaving is properly applied, which enables the logging functionality provided by this library.

Add the following plugin configuration inside the `<plugins>` section of your `pom.xml`:

```xml
<plugin>
    <groupId>dev.aspectj</groupId>
    <artifactId>aspectj-maven-plugin</artifactId>
    <version>1.14.1</version>
    <dependencies>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjtools</artifactId>
            <version>1.9.22</version>
        </dependency>
    </dependencies>
    <executions>
        <execution>
            <goals>
                <goal>compile</goal>
                <goal>test-compile</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <complianceLevel>17</complianceLevel>
        <source>17</source>
        <target>17</target>
        <showWeaveInfo>true</showWeaveInfo>
        <verbose>true</verbose>
        <aspectLibraries>
            <aspectLibrary>
                <groupId>com.dantespard4</groupId>
                <artifactId>logging-aop</artifactId>
            </aspectLibrary>
        </aspectLibraries>
    </configuration>
</plugin>
```

> **Note:** You must compile the project with this plugin before running your application, otherwise the aspects for logging will not be applied.

### SLF4J Backend Requirement

This library uses [SLF4J](http://www.slf4j.org/) for logging abstraction. To actually see log outputs, you must add a logging backend compatible with SLF4J (such as Logback) as a dependency in your project.  
Example (for Logback):

```xml
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.5.6</version>
</dependency>
```

### Usage

1. Integrate the logging aspect library into your Java project.
2. Annotate methods or classes you want to log (if applicable).
3. Run your application as usual; logging will be handled by the aspect.

### Example

```java
import com.dantespard4.loggingaop.annotations.LogExecutionTime;

public class ExampleService {

    @LogExecutionTime
    public void process() {
        // Method logic here
    }
}
```
The logging aspect in this library will automatically log method entry and exit, and, con la anotación `@LogExecutionTime`, también se registrará el tiempo de ejecución del método process.

## Structure

- `src/main/java`: Java source files, including aspects and Annotations.
- `src/test/java`:  example usage.

## Contributing

Contributions are welcome! Please open issues or submit pull requests.

## License

This project is licensed under the MIT License.

## Contact

For questions or suggestions, open an issue or contact [DanteSpard4](https://github.com/DanteSpard4).
