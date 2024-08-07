# Expression Evaluator

This repository contains a Java class `Solution` designed to evaluate arithmetic expressions containing integers, parentheses, plus ('+'), and minus ('-') operators. The main method `calculate` processes the input string representation of the expression and computes its value using a depth-first search (DFS) approach.

## Class: Solution

### Methods

### My Thought process
   
    I belive this is  one of the trickiest problem i have done , i have a  similar problem to this called "Decode string" , basically this involves a dfs approach ,( solve the inner bracket first) , i used the reference of the decode string and figured a way to do this .


#### `calculate(String s)`
This method initializes the class with the input expression and calls the `dfs` method to evaluate it.
- **Parameters:** 
  - `s`: A string representing the arithmetic expression.
- **Returns:** 
  - The evaluated result of the expression as an integer.

#### `dfs()`
This method performs a depth-first search to evaluate the expression recursively. It handles nested parentheses by calling itself when encountering a '(' and returns the computed value when encountering a ')'.
- **Returns:** 
  - The computed value of the current expression segment as an integer.

### Detailed Explanation

- **Initialization**:
  - The input string is converted to a character array `arr` for easy traversal.
  - An index variable `index` is used to keep track of the current position in the array.

- **DFS Traversal**:
  - The `dfs` method initializes `sum` to store the result of the expression and `operator` to handle the current arithmetic operation (1 for '+', -1 for '-').
  - It iterates through the character array `arr`, processing each character based on its type:
    - `')'`: Ends the current DFS call.
    - `'('`: Initiates a new DFS call to evaluate the expression within the parentheses.
    - `'+'`: Sets the operator to 1.
    - `'-'`: Sets the operator to -1.
    - Digit: Constructs the full number and updates `sum` accordingly.

### Code

```java
public class Solution {
    
    char[] arr;
    int index = 0; 

    public int dfs() {
        int sum = 0, operator = 1; 
        
        while (index < arr.length) {
            if (arr[index] == ')') {
                break; 
            } else if (arr[index] == '(') {
                index++; 
                sum += operator * dfs();
            } else if (arr[index] == '+') {
                operator = 1;
            } else if (arr[index] == '-') {
                operator = -1;
            } else if (Character.isDigit(arr[index])) {
                StringBuilder sb = new StringBuilder(); 
                while (index < arr.length && Character.isDigit(arr[index])) {
                    sb.append(arr[index++]);
                }
                int num = Integer.parseInt(sb.toString()) * operator;
                index--;
                sum += num;
            }
            index++;
        }
        return sum;  
    }
    
    public int calculate(String s) {
        arr = s.toCharArray();
        return dfs(); 
    }
}


##### Time and Space Complexity
   ### Time Complexity: O(n), where n is the length of the input string. Each character in the string is processed exactly once.
   ### Space Complexity: O(n), where n is the length of the input string. This space is used by the recursion stack in the worst case scenario when there  are many nested parentheses.
