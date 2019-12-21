![Readme image](src/main/resources/readme.png)

# Battleship ([UML Diagram](https://github.com/vpasq/Battleship/blob/master/UML_Battleship.pdf)) 


Battleship is a Java Maven project for a game simulation that uses the following design patterns:
- The Command Pattern
- The Strategy Pattern 
- The Factory Pattern
- The Observer Pattern



# The Command Pattern

This Battleship game design allows for dynamically initializing the game board with a different
number of ships, and also with different sized board grids. The ships are randomly placed on the 
player's boards in both horizontal and vertical directions.

Command objects are used to encapsulate these different initialization requests. The JUnit
test suite tests for two command objects, one that initializes the player's boards
with 3 ships on a 5 x 5 grid, and another that initializes the player's boards with 6 ships on a 
10 x 10 grid. Additional command object requests can be easily added by implementing the 
Command interface.

# The Strategy Pattern

Used to encapsulate a family of battleship algorithms. By exploiting polymorphism,
the game can be initialized with different battleship types for each player. In addition, if an 
advanced rule was added allowing players to dynamically switch ships during runtime, the Strategy
Pattern would make it possible.


# The Factory Pattern

Used to create different ship types. The Simple Factory Pattern is used in combination 
with the Strategy Pattern to allow clients to create different ship types without having to
program to a concrete implementation.

# The Observer Pattern

Used to notify each player of a winner. When a player fires a winning shot, the Observer Pattern
notifies each player by displaying the winning game board to each player. The JUnit test suite
for this pattern uses System.out to display two "Winning Game Boards" to the screen, one for each 
player.

# Install and run jUnit tests
```bash
1. Clone this repository
2. mvn clean compile test

```

# Version
1.0.0

# License

The MIT License (MIT)

Copyright (c) 2019 Vincent Pasquariello

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


