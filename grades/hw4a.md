hw4a Feedback
============

#### Notation (20/20)

* Your diagrams conform well to our expectations on UML notation across all models. Well done.

#### Domain Model (12/16)

* Your domain model misses a few minor concepts and relationships.
    * individual special tiles
    * Squares
    * score modifier squares

* Your domain model matches our expectations regarding the level of abstraction

#### System Sequence Diagram (6/8)

* Your system sequence diagram uses concepts that indicate a wrong level of abstraction in minor instances as annotated in the model.
    * Does not properly show alternates and optional actions

* Your system sequence diagram sufficiently models the interactions in the given scenario

#### Behavioral Contracts (2/4)

* Your contracts do not match the expected level of abstraction and/or do not align with the design problem, as annotated in the model
    * All validation is hidden in implementation specific method instead of
        listed

#### Interaction Diagram (`challenge`) (14/16)

* Your interaction diagram matches our expectations regarding modeling accuracy of the challenging interaction. Well done.

* we have no major concerns regarding the design (e.g., responsibility assignment) of your validation interaction

* Your interaction diagram matches our expectation regarding the level of abstraction

#### interaction diagram (`makemove`) (11/16)

* Your interaction diagram describes the move mechanism well, but misses some aspects of counting points or evaluating special tiles, as annotated in the model.

* We have several questions or suggestions regarding the design of your move mechanisms, as annotated in the model.
    * Consider how your special tiles will be able to manipulate the entire game
        and even adjust score

* Your interaction diagram matches our expectation regarding the level of abstraction

#### object model (12/16)

* We have no major concerns regarding the completeness of your object model

* In general, your object model seems reasonable from a design perspective (e.g., responsibility assignment). We have only minor suggestions for improvement, as annotated in the models.
    * Multipliers might want a default instance that multiplies by the
        identity.

* We have no major concerns regarding abstraction level and use of object-oriented concepts in your object model
    * Mutability of tiles is a concern though.

#### justification (3/4)

* Your justification meets our expectations regarding vocabulary and discussion of design goals and principles, thanks.
    * Focus more on design tradeoffs rather than just explain how the game works.

#### consistency (20/20)

* We have no major concerns regarding consistency across your modeling artifacts. Well done!

you can regain up to 75% of the points lost in this milestone in Milestone C by addressing our comments and updating your design documents. If you have lost a large number of points, we recommend some interaction with the course staff. Beyond that, we do *not* pose additional questions that you need to answer for Milestone C.

---

#### Total (100/120)

Late days used: 2 (0 left)

---

#### Additional Notes

Graded by: Scott Krulcik (skrulcik@andrew.cmu.edu)

To view this file with formatting, visit the following page: https://github.com/CMU-15-214/zhilinh/blob/master/grades/hw4a.md


