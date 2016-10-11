hw3 Feedback
============

#### Demonstrate mastery of earlier learning goals, especially the concepts of information hiding and polymorphism, software design based on informal specifications, testing, and testing best practices. (44/50)

* Information hiding (10/10)

* Compliance with specification (20/20)

* Testing practices (9/10)
  * Your exception testing technique does not follow best practices. Use @Test (expected = [insert Exception name].class) in jUnit.

* Java coding best practices and style (5/10)
  * Your permutation generator and cryptarithm solver should be in separate packages. It is important to keep an organized package structure to facilitate information hiding and code reuse.
  * Your submission contains massive blocks of code duplication. Copy and pasting code makes your code hard to understand and maintain.
  * Method names should start with lowercase letters and should be `camelCase`. (Solution.java)

#### Use inheritance and delegation, and design patterns effectively to achieve design flexibility and code reuse (25/30)
  * Your cryptarithm solver return value is not reusable for anything other than printing the solution. This makes your program not testable separately and is generally bad practice

#### Discuss the relative advantages and disadvantages of alternative design choices (12/20)
  * You did not provide an API for the Command design pattern, as required by the assignment. 
  * You did not provide an API for the Template Method design pattern, as required by the assignment.

---

#### Total (81/100)

Late days used: 2 (3 left)

---

#### Additional Notes

Graded by: Tianyu Li (tli2@andrew.cmu.edu)

To view this file with formatting, visit the following page: https://github.com/CMU-15-214/zhilinh/blob/master/grades/hw3.md

