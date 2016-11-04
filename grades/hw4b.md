hw4b Feedback
============


#### Implementation of Scrabble game (57/60)

* Your implementation seems to completely or almost completely implement the functionality related to the game’s board (squares, tiles, special tiles, drawing and exchanging tiles, purchasing special tiles, making moves, etc). Well done.
  * Players should be able to pass instead of placing or exchanging tiles.
* You implemented most of the functionality related to the validating a move in the game (checking placement, etc), but we identified the following minor issues:
  * All tiles must come from the current player’s rack (_and no tile can be used more often than it occurs in the rack_).
* Your implementation seems to completely or almost completely implement the functionality related to challenging a move in the game (validating words, reverting board state, etc). Well done!
  * Your implementation might not be 100% correct though, it appears you try to
    remove the tiles in the move multiple times.
* Your implementation seems to completely or almost completely implement the functionality related to scoring a move in the game (adding points for tiles and words, applying multipliers and scoring-related special tiles, etc). Well done.
* Your implementation seems to completely or almost completely implement the special tiles in the game (reverse order, boom, negative points, and own tile). Well done.

#### Program Design (16/25)

The design aspects of your implementation are mostly reasonable, but we have some suggestions for improvement, especially regarding responsibility assignment:

##### Coupling and Responsibility Assignment

* Your initial calls to `isValid` and/or `makeMove` should be made to
  a reasonable controller/game class. You frequently have two versions of each
  of the user methods, one in `Scrabble` and `Player`. There is no need for them
  both to exist, it just adds to complexity.
* The point computation should be performed in a reasonable place (responsibilities)
  * Who computes the points for a tile at a location?
  * Who computes the points for a word?
  * Who initiates/coordinates the computation of points?

##### Extensibility

* _minor_ In implementing your special tile you violate the “law of demeter”. [For example: You receive an instance of the game and access various inner objects as squares and tiles from there. Consider an implementation that does not depend on the specifics of the implementation.]

##### Code Reuse

* _minor_ You could have exploited some symmetry in the board so that you did
  not have to copy paste so many lines.

##### Other

* You used a while loop for the game flow. This does not make sense in the context of having a GUI, because the GUI has a main event loop that will wait for and dispatch events as necessary.

#### Testing and Build Automation (14/25)

* Your project is not built on Travis CI. Check completeness, dependencies and other issues such as the top-level settings.gradle file. Check the build.gradle and modify it to use the tests for this homework and not the ones from homework 3.
* Your test coverage seems mostly reasonable, but we have some smaller suggestions for improvement:
    * Your test cover only a small part of the specifications, as you only test for positive cases (e.g., making a valid move), but never test invalid inputs (e.g., detecting whether an invalid move is rejected).
* Your tests seem mostly reasonable, but we have some suggestions for improvement:
    * Repetitive set-up/tear-down code should be in the `SetUp` or `tearDown` methods. It is preferred to set fields in setUp and tearDown because that way all of the values will be fresh at the beginning of the test.

#### Documentation and Style (5/10)

* You committed all or most of your code in a single big commit. It is good practice (and also a good backup strategy) to commit regularly at milestones while you are still developing the solution.
* _minor_ `skipFalse` and `skipTrue` are unorthodox ways to mutate a field. Instead,
  just make a setter, that will take either of `true` and `false`.

---


#### Total (83/120)

You attempted to submit a day late, but you were already out of late days, as
shown on your hw4a feedback. So your submission was graded with a 10% late
penalty in accordance with the syllabus.

Raw Total: 92
92 * 0.9 = 82.8 -> 83

Late days used: 1 (**0** left)

---


#### Additional Notes


Graded by: Scott Krulcik (skrulcik@andrew.cmu.edu)


To view this file with formatting, visit the following page: https://github.com/CMU-15-214/zhilinh/blob/master/grades/hw4b.md
