# Calculator Application

## Overview
This project is a Java-based calculator application implementing the Model-View-Controller (MVC) design pattern. It offers the functionality to evaluate mathematical expressions in both standard (infix) and Reverse Polish Notation (RPN) formats.

## Components

### Model
- `CalcModel`: The core of the calculator, responsible for evaluating expressions.
- `Entry`: Represents a single element (number, symbol, or string) in an expression.
- `Symbol`: An enum defining mathematical symbols.
- `Type`: An enum defining types of `Entry` objects.

### Controller
- `CalcController`: Manages interactions between the model and the view.

### View
- `AsciiView`: A text-based interface for the calculator.
- `CalcView`: A JavaFX GUI for the calculator.
- `MockView`: A mock view for testing purposes.
- `ViewInterface`: An interface defining methods for calculator views.

### Utilities
- `RevPolishCalc`: Evaluates expressions in Reverse Polish Notation.
- `StandardCalc`: Evaluates expressions in standard notation.
- `NumStack`: A stack for managing numbers.
- `OpStack`: A stack for managing operators.
- `StrStack`: A stack for managing strings.
- `Stack`: A general-purpose stack implementation for `Entry` objects.

### Exceptions
- `BadTypeException`: Thrown when an incorrect type is accessed in an `Entry`.
- `InvalidExpression`: Thrown when an expression is invalid or cannot be evaluated.

## Running the Application
To run this application, you need a Java runtime environment. Compile the Java files and run the `Driver` class, which initializes the MVC framework.

## How to Use
1. **AsciiView**: Interact via the console. Input expressions and commands as prompted.
2. **CalcView**: A graphical interface. Enter expressions and choose between standard and RPN modes.

## Development and Testing
- Test classes and mocks are included to facilitate unit testing.
- The project follows standard Java development practices and can be extended or modified as needed.

## Dependencies
- JavaFX is required for the graphical interface (`CalcView`).
## Authorship
Original authorship by Dave Cohen (d.cohen@rhul.ac.uk). 
