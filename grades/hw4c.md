# hw4c Feedback

## Design of GUI and Special Tile Implementation (20/30)

* Your implementation effectively separates the GUI from the Core.
* We could not identify any implementation of the additional special tile.
  * You wrote a class, but it has no effect, it just prints a message.

## Implementation of GUI (20/40)

* Your GUI contains most of the key pieces of information we would expect to see, but we identified the following minor issues:
  * Did not specify cost of special tile when a player purchases it in the GUI.
* Your GUI does not correctly handle the various board state change events.
  * You have a `GameChangeListener` but it does not appropriately use the
    observer pattern to allow the core to update a GUI easily.
* Your GUI contains most of the key aspects of Scrabble gameplay, but we identified the following minor issues:
  *  Not able to pass on a turn.
* Your project cannot be built on Travis CI, but it does build locally, and we were able to start your game using `gradle run`.
* You committed all or most of your code in a single big commit. It is good practice (and also a good backup strategy) to commit regularly at milestones while you are still developing the solution.

## Reflection on the design process (0/10)

* You did not turn in any reflections on your design process.
  * Don't lose points on this part! :(

---


#### Total (40/80)


#### HW4A Points Back: 19 * 0.75 = 14.25

I gave almost all points back, but not for rationale which was not updated.


Penalty days used: 2 (0 late days left)

---


#### Additional Notes

You did a nice job overall! The low score is because properly using the observer
pattern, including design reflection, and implementing the new tile all counted
for a lot.


Graded by: Scott Krulcik (skrulcik@andrew.cmu.edu)


To view this file with formatting, visit the following page: https://github.com/CMU-15-214/zhilinh/blob/master/grades/hw4c.md

