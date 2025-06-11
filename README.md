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

### Build Configuration

Before compiling the project, you need to add the AspectJ Maven Plugin to your `pom.xml`. This plugin is necessary to perform compile-time weaving, which is required for the aspect-oriented logging to work.

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

> **Note:** It is necessary to compile the project with this plugin to enable AspectJ weaving.

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

### Compilation

Compile the project using Maven:

```bash
mvn install
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