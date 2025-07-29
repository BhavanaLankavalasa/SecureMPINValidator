# Project Title:
# 🔐Secure MPIN Validator

## 📌Description:
This project focuses on analyzing a user's MPIN (Mobile Banking Personal Identification Number) and determining whether it is strong or weak based on meaningful patterns. The core idea behind this solution is to identify whether the MPIN is predictable or sensitive by comparing it against commonly used numbers and user-specific demographic patterns. 

Instead of treating MPIN as just a string of digits, the logic was built to understand possible connections and behavioral tendencies behind the choices users make such as using their date of birth or repeating digits. The outcome is a simple and clear result that helps categorize the MPIN's strength based on practical and real-world scenarios.

##Project Structure:
The folder structure of this project follows standard Java project conventions. All Java classes are organized under the package `com.onebanc.mpinValidation`, and the source files are placed under the `src` directory.

''' SecureMPINValidator/
│
├── README.md
├── .classpath
├── .project
├── src/
│   └── com/
│       └── mpinValidation/
│           ├── MPINAnalyzer.java
│           ├── MPINResult.java
│           ├── CommonPINChecker.java
│           ├── DemographicChecker.java
│           ├── TestCases.java
 '''


## Technology Used:
I have implemented this project using Java. Although this kind of validation and logic-based problem could also be handled using Python or other languages, I chose Java very consciously. Java provides a solid structure and strong object-oriented capabilities, which made it easier for me to divide the project into separate logical components and ensure clean modularity.

One of the main reasons I selected Java for this task is because of its strict type system and strong compile-time checks, which help avoid unexpected behavior and make the code more robust especially when handling multiple conditions and validations. This allowed me to focus not just on solving the problem, but also on building the solution in a well-structured and scalable way.

Java’s standard libraries and collections framework, particularly classes like `HashSet` and `ArrayList`, were very helpful in managing data efficiently while maintaining performance. It gave me better control over how I structured and accessed data something I consider important when designing validation-based logic like this.

I used Eclipse IDE to build the project as it provides a clean environment to organize code across multiple classes, test different scenarios, and debug effectively.

##Structure and Approach:
Before starting the implementation, I spent time breaking down the logic into individual components. I wanted each check whether for common patterns or demographic matches to be handled separately, keeping clarity and separation of responsibility in mind.

From a structural point of view, I followed a modular and object-oriented approach:

1. MPINAnalyzer.java – Acts as the main processor. It takes the MPIN and demographic inputs, performs validations, and returns a structured result.

2. CommonPINChecker.java – Focuses on identifying whether the MPIN is from a known list of commonly used numbers. I used a HashSet to store these values, allowing fast lookup and easy extension if new common pins are to be added later.

3. DemographicChecker.java – This class generates pattern variations from dates and compares them with the MPIN. It focuses on logical pattern matching that might indicate a weak PIN.

4. MPINResult.java – A simple data class that stores the result in a structured way strength and list of reasons. This design made it easy to interpret and extend the result.

5. TestCases.java – A dedicated test class that I created to simulate different cases. It helped me think critically about how different inputs behave and validate every part of the solution.

## Implementation of Tasks:
All the required parts were implemented thoughtfully:
- For common MPIN detection, I used a pre-defined list and verified against it.
- For demographic checks, I generated different valid patterns from user-related dates and compared them to the MPIN.
- If the MPIN is considered weak, the program not only returns that result but also includes specific reasons such as COMMONLY_USED or DEMOGRAPHIC_DOB_SELF.
- The logic supports both 4-digit and 6-digit MPINs.
- All the validations are performed dynamically without any hardcoded assumptions inside the logic.

## Testing:
To validate the implementation, I created 30 test cases covering various conditions like overlaps, different date formats, strong combinations, and boundary cases. The testing was structured and automated in the `TestCases.java` file. While creating these, I referred to patterns commonly found online, analyzed real-world tendencies in PIN usage, and designed inputs accordingly. Each test case compares the expected result with the actual result and prints whether it passed or failed. This helped me verify the reliability of the solution in a structured way.

## How to Run the Project:
- Open the project in Eclipse IDE.
- Navigate to the TestCases.java file.
- Right-click and select “Run As” → “Java Application”.
- The console will display the output of all the test cases along with their status.

I have tried to build this project with clarity and modular thinking, so that the code remains easy to understand, test, and modify. My focus was not just on making the logic work, but on structuring it in a way that reflects good practices and attention to how real-world patterns behave. I truly enjoyed working on this project.
