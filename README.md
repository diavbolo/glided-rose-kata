## Requirements
https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/master/GildedRoseRequirements.txt

## Notes
* No **exception handling** is implemented since there are no external
dependencies. In principle Item would be the ideal class where to perform 
the variable validation but re-factoring it is out of scope.
* Instead of directly modifying GlidedRose, a **new child class** called
GlidedRoseImproved has been implemented with an override method.
* The chosen unit testing is focused on functional requirements rather than
testing individually each method/function.

## Validation
Environment used: Eclipse 4.17.0, JRE SE 11.0.9.
* 100% code coverage.
* SonarLint syntax check passed.