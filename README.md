# BMI Calculator in Java

A Java-based BMI (Body Mass Index) calculator application that implements object-oriented programming principles and robust error handling.

## Overview

This project implements a BMI calculator that takes user input for height and weight, calculates the BMI, and provides a health category classification. The application is built using object-oriented principles and includes comprehensive error handling.

## Features

- Height and weight input validation
- Metric unit conversion (centimeters to meters)
- BMI calculation
- Health category classification
- Robust exception handling
- Resource management

## Technical Details

### Class Structure

#### `Information` Class
Represents the core data structure, including height, weight, and BMI calculation.
class Information {
    float height;
    float weight;
    float bmi;
}

#### `BMICalculator2` Class
Main class containing the calculator logic and user interface.

### Key Components

#### Input Handling
- Uses `java.util.Scanner` for user input
- Input validation with `try-catch` blocks
- Automatic unit conversion (cm to m for height)

#### Exception Handling
- Custom exception messages for invalid inputs
- Separate exception handling for height and weight inputs
- Resource cleanup in `finally` block

#### BMI Calculation Methods
- **`InputHeight()`**: Validates and processes height input  
- **`InputWeight()`**: Validates and processes weight input  
- **`CalculateBMI()`**: Computes BMI using the formula `weight / (height²)`  
- **`BMICategory()`**: Classifies BMI into health categories  

### BMI Categories
| BMI Range       | Category          |
|------------------|-------------------|
| < 18.5          | Underweight       |
| 18.5 - 23.9     | Normal            |
| 24.0 - 26.9     | Overweight        |
| 27.0 - 29.9     | Mild Obesity      |
| 30.0 - 34.9     | Moderate Obesity  |
| ≥ 35.0          | Severe Obesity    |

## Implementation Details

### Error Handling
The program includes robust error handling for:
- Invalid numerical inputs
- Zero or negative values for height and weight
- Non-numeric or unexpected data types
```java
try {
    // Input processing
    if(height <= 0) {
        throw new IllegalArgumentException("Height must be a positive number");
    }
    // Calculation
} catch(Exception e) {
    System.out.println("Input Error: Please enter valid numbers");
    throw new Exception("Invalid height input", e);
}
```

### Resource Management
The program ensures proper cleanup of system resources, such as closing the `Scanner` object in the `finally` block.
```Java
finally {
    myScanner.close();  // Proper cleanup of system resources
}
```

## Technologies Used

- Java
- `java.util.Scanner` for input handling
- Object-Oriented Programming principles
- Exception handling mechanisms

## Build and Run

### Compile the Java files:
```bash
javac BMICalculator2.java
```

## Run the program:
```bash
java BMICalculator2
```

### Input Guidelines

- **Height**: Enter in centimeters (positive number)  
- **Weight**: Enter in kilograms (positive number)  
- Only numerical inputs are accepted  
- Decimal numbers are supported  

### Error Messages

The program provides user-friendly error messages for:  
- Non-numeric inputs  
- Zero or negative values  
- Invalid data types  
- Resource handling errors  

### Future Improvements

- GUI implementation  
- Support for different measurement units (imperial system)  
- Data persistence  
- Batch processing capabilities  
- Health recommendation system based on BMI results 
