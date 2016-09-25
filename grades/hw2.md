hw2 Feedback
============

#### Correctly applying the concepts of polymorphism and information hiding (15/20)
* Polymorphism (10/15)
  * You missed an opportunity for polymorphism in your `Expression` classes. The individual Binary/Unary `Operator`s share common behavior, which you should use in your `Expression` implementations.
* Information Hiding (5/5)

#### Java best practices and compatibility with our informal specification (28/30)
* Part 1 (8/8)
* Part 2 (9/9)
* Part 3 (11/13)
  * Your `zero()` method does not restore your variable to its original value. This may result in unexpected results when evaluating other expressions using the same variable.
  * The `eval()` method of your `DerivativeExpression` does not restore your variable to its original value. This may result in unexpected results when evaluating other expressions using the same variable.

#### Unit testing, including coverage and compliance with best practices (29/30)
* Testing (12/12)
* Coverage (11/12)
  * Tests should be split up into the smallest testable parts of a program. Try to avoid testing multiple methods in one test case. ([link](https://github.com/CMU-15-214/zhilinh/blob/master/homework/2/src/test/java/edu/cmu/cs/cs214/hw2/operator/BinaryOperatorTest.java#L62))
* Best Practices (6/6)

#### Documentation and style (18/20) 
* Constants should be in all uppercase, separated by underscores. Ex: `VARIABLE_NAME`.  ([link](https://github.com/CMU-15-214/zhilinh/blob/master/homework/2/src/test/java/edu/cmu/cs/cs214/hw2/expression/DerivativeTest.java#L27))
* -0.1, It would be better to have an abstract `Operator` class instead of reimplementing the `toString()` behavior in each concrete Operator class. This is a good opportunity for code reuse. 
* -0.1 You don't need to check the incoming value of the expression since if it is the same, setting it to an equal value won't do anything anyway. ([link](https://github.com/CMU-15-214/zhilinh/blob/master/homework/2/src/main/java/edu/cmu/cs/cs214/hw2/expression/Variable.java#L53))
* Your commit messages are not very descriptive of the changes you make. In practice commit messages are often very important to track changes in a project. Please attempt more descriptive changes in the future.

---

#### Total (90/100)

Late days used: 1 (4 left)

---

#### Additional Notes

Graded by: Tim Brown (twbrown@andrew.cmu.edu)

To view this file with formatting, visit the following page: https://github.com/CMU-15-214/zhilinh/blob/master/grades/hw2.md

