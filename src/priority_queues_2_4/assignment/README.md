<!DOCTYPE html>
<html lang="en">
<head>

<h3>Program in execution</h3> 

![hippo](https://github.com/nkey-ops/course-algorithms-by-princenton-p1/assets/81760194/14c669ef-6a31-4255-87ea-6095a5091b9a)


<meta charset="UTF-8">
</head>

<body>

<h2>ASSESSMENT SUMMARY</h2>
<pre>

Compilation:  <font color = #009900>PASSED</font>
API:          <font color = #009900>PASSED</font>

SpotBugs:     <font color = #009900>PASSED</font>
PMD:          <font color = #009900>PASSED</font>
Checkstyle:   <font color = #990000>FAILED (0 errors, 95 warnings)</font>

Correctness:  <font color = #009900>52/52 tests passed</font>
Memory:       <font color = #009900>22/22 tests passed</font>
Timing:       <font color = #009900>125/125 tests passed</font>

Aggregate score: 100.00%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 60%, Timing: 10%, Memory: 20% ]
</pre>

Write a program to solve the 8-puzzle problem
(and its natural generalizations) using the 
A* search algorithm.

<p><b>The problem.</b>
The <a href = "http://en.wikipedia.org/wiki/Fifteen_puzzle">8-puzzle</a>
is a sliding puzzle
<!--  invented and popularized by Noyes Palmer Chapman in the 1870s. -->
that is played on a 3-by-3 grid with 8 square tiles labeled 1 through 8, plus a blank 
square. The goal is to rearrange the tiles so that they are in row-major order, using
as few moves as possible. 
You are permitted to slide tiles either horizontally or vertically
into the blank square. 
The following diagram
shows a sequence of moves from an <em>initial board</em> (left)
to the <em>goal board</em> (right).


<p><center>
<IMG src="https://coursera.cs.princeton.edu/algs4/assignments/8puzzle/4moves.png" width = "600" alt =  "8puzzle 4 moves">
</center>

[Full Assignment...](https://coursera.cs.princeton.edu/algs4/assignments/8puzzle/specification.php)

<br><br>

<h2>ASSESSMENT DETAILS</h2>

<pre>

The following files were submitted:
----------------------------------
8.9K Oct 27 19:45 Board.java
4.5K Oct 27 19:45 Solver.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac Board.java
*-----------------------------------------------------------

% javac Solver.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
Board:

Solver:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% spotbugs *.class
*-----------------------------------------------------------


================================================================


% pmd .
*-----------------------------------------------------------


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] Board.java:25:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Board.java:33:13: The local (or parameter) variable &#x27;hamming&#x27; has the same name as an instance variable. Use a different name. [HiddenField]
[WARN] Board.java:34:13: The local (or parameter) variable &#x27;manhattan&#x27; has the same name as an instance variable. Use a different name. [HiddenField]
[WARN] Board.java:35:17: The local (or parameter) variable &#x27;isGoal&#x27; has the same name as an instance variable. Use a different name. [HiddenField]
[WARN] Board.java:40:17: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Board.java:40:38: &#x27;{&#x27; is not followed by whitespace. [WhitespaceAround]
[WARN] Board.java:40:55: &#x27;;&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Board.java:40:56: &#x27;}&#x27; is not preceded with whitespace. [WhitespaceAround]
[WARN] Board.java:42:17: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Board.java:42:52: &#x27;{&#x27; is not preceded with whitespace. [WhitespaceAround]
[WARN] Board.java:43:31: &#x27;;&#x27; is preceded with whitespace. [NoWhitespaceBefore]
[WARN] Board.java:48:30: &#x27;=&#x27; is not preceded with whitespace. [WhitespaceAround]
[WARN] Board.java:52:13: The local (or parameter) variable &#x27;x1&#x27; has the same name as an instance variable. Use a different name. [HiddenField]
[WARN] Board.java:52:17: The local (or parameter) variable &#x27;x2&#x27; has the same name as an instance variable. Use a different name. [HiddenField]
[WARN] Board.java:52:21: The local (or parameter) variable &#x27;y1&#x27; has the same name as an instance variable. Use a different name. [HiddenField]
[WARN] Board.java:52:25: The local (or parameter) variable &#x27;y2&#x27; has the same name as an instance variable. Use a different name. [HiddenField]
[WARN] Board.java:63:39: &#x27;)&#x27; is preceded with whitespace. [ParenPad]
[WARN] Board.java:77:47: The local (or parameter) variable &#x27;tiles&#x27; has the same name as an instance variable. Use a different name. [HiddenField]
[WARN] Board.java:81:39: The local (or parameter) variable &#x27;tiles&#x27; has the same name as an instance variable. Use a different name. [HiddenField]
[WARN] Board.java:84:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Board.java:87:28: &#x27;;&#x27; is preceded with whitespace. [NoWhitespaceBefore]
[WARN] Board.java:94:29: &#x27;{&#x27; is not preceded with whitespace. [WhitespaceAround]
[WARN] Board.java:102:13: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Board.java:110:28: &#x27;{&#x27; is not followed by whitespace. [WhitespaceAround]
[WARN] Board.java:110:29: &#x27;return&#x27; is not preceded with whitespace. [WhitespaceAround]
[WARN] Board.java:110:37: &#x27;;&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Board.java:110:38: &#x27;}&#x27; is not preceded with whitespace. [WhitespaceAround]
[WARN] Board.java:123:28: &#x27;{&#x27; is not preceded with whitespace. [WhitespaceAround]
[WARN] Board.java:128:34: Do not use the letter &#x27;o&#x27; as a parameter variable name. It is hard to distinguish from the number &#x27;0&#x27;. [ParameterName]
[WARN] Board.java:129:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Board.java:130:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Board.java:132:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Board.java:132:16: Do not use the &#x27;instanceof&#x27; operator in this course. Use &#x27;getClass()&#x27; to compare classes. [IllegalToken]
[WARN] Board.java:140:58: &#x27;;&#x27; is preceded with whitespace. [NoWhitespaceBefore]
[WARN] Board.java:144:39: &#x27;{&#x27; is not preceded with whitespace. [WhitespaceAround]
[WARN] Board.java:158:32: &#x27;(&#x27; is followed by whitespace. [ParenPad]
[WARN] Board.java:161:26: &#x27;,&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Board.java:167:30: &#x27;(&#x27; is followed by whitespace. [ParenPad]
[WARN] Board.java:168:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
...
Checkstyle ends with 0 errors and 95 warnings.

% custom checkstyle checks for Board.java
*-----------------------------------------------------------

% custom checkstyle checks for Solver.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of Board
*-----------------------------------------------------------
Running 26 total tests.

Tests 4-7 and 14-17 rely upon toString() returning results in prescribed format.

Test 1a: check hamming() with file inputs
  * puzzle04.txt
  * puzzle00.txt
  * puzzle07.txt
  * puzzle17.txt
  * puzzle27.txt
  * puzzle2x2-unsolvable1.txt
==&gt; passed

Test 1b: check hamming() with random n-by-n boards
  * 2-by-2
  * 3-by-3
  * 4-by-4
  * 5-by-5
  * 9-by-9
  * 10-by-10
  * 127-by-127
==&gt; passed

Test 2a: check manhattan() with file inputs
  * puzzle04.txt
  * puzzle00.txt
  * puzzle07.txt
  * puzzle17.txt
  * puzzle27.txt
  * puzzle2x2-unsolvable1.txt
==&gt; passed

Test 2b: check manhattan() with random n-by-n boards
  * 2-by-2
  * 3-by-3
  * 4-by-4
  * 5-by-5
  * 9-by-9
  * 10-by-10
  * 127-by-127
==&gt; passed

Test 3: check dimension() with random n-by-n boards
  * 2-by-2
  * 3-by-3
  * 4-by-4
  * 5-by-5
  * 6-by-6
==&gt; passed

Test 4a: check toString() with file inputs
  * puzzle04.txt
  * puzzle00.txt
  * puzzle06.txt
  * puzzle09.txt
  * puzzle23.txt
  * puzzle2x2-unsolvable1.txt
==&gt; passed

Test 4b: check toString() with random n-by-n boards
  * 2-by-2
  * 3-by-3
  * 4-by-4
  * 5-by-5
  * 9-by-9
  * 10-by-10
  * 127-by-127
==&gt; passed

Test 5a: check neighbors() with file inputs
  * puzzle04.txt
  * puzzle00.txt
  * puzzle06.txt
  * puzzle09.txt
  * puzzle23.txt
  * puzzle2x2-unsolvable1.txt
==&gt; passed

Test 5b: check neighbors() with random n-by-n boards
  * 2-by-2
  * 3-by-3
  * 4-by-4
  * 5-by-5
  * 9-by-9
  * 10-by-10
  * 127-by-127
==&gt; passed

Test 6a: check neighbors() of neighbors() with file inputs
  * puzzle04.txt
  * puzzle00.txt
  * puzzle06.txt
  * puzzle09.txt
  * puzzle23.txt
  * puzzle2x2-unsolvable1.txt
==&gt; passed

Test 6b: check neighbors() of neighbors() with random n-by-n boards
  * 2-by-2
  * 3-by-3
  * 4-by-4
  * 5-by-5
  * 9-by-9
  * 10-by-10
==&gt; passed

Test 7a: check twin() with file inputs
  * puzzle04.txt
  * puzzle00.txt
  * puzzle06.txt
  * puzzle09.txt
  * puzzle23.txt
  * puzzle2x2-unsolvable1.txt
==&gt; passed

Test 7b: check twin() with random n-by-n boards
  * 2-by-2
  * 3-by-3
  * 4-by-4
  * 5-by-5
  * 9-by-9
  * 10-by-10
==&gt; passed

Test 8a: check isGoal() with file inputs
  * puzzle00.txt
  * puzzle04.txt
  * puzzle16.txt
  * puzzle06.txt
  * puzzle09.txt
  * puzzle23.txt
  * puzzle2x2-unsolvable1.txt
  * puzzle3x3-unsolvable1.txt
  * puzzle3x3-00.txt
  * puzzle4x4-00.txt
==&gt; passed

Test 8b: check isGoal() on n-by-n goal boards
  * 2-by-2
  * 3-by-3
  * 4-by-4
  * 5-by-5
  * 6-by-6
  * 100-by-100
==&gt; passed

Test 9: check that two Board objects can be created at the same time
  * random 3-by-3 and 3-by-3 boards
  * random 4-by-4 and 4-by-4 boards
  * random 2-by-2 and 2-by-2 boards
  * random 3-by-3 and 4-by-4 boards
  * random 4-by-4 and 3-by-3 boards
==&gt; passed

Test 10a: check equals()
  * reflexive
  * symmetric
  * transitive
  * argument is null
  * argument is of type String
  * argument is of type UncastableString
  * argument is of type Object and contains a reference to a Board
  * argument is of type Object containing a reference to a String
==&gt; passed

Test 10b: check correctness of equals() on random n-by-n boards
  * n = 2
  * n = 3
  * n = 4
  * 5 &lt;= n &lt; 10
==&gt; passed

Test 10c: check equals() when board sizes m and n are different
  * m = 4, n = 5
  * m = 2, n = 5
  * m = 5, n = 3
  * m = 2, n = 3
  * m = 3, n = 2
==&gt; passed

Test 11: check that Board is immutable by changing argument array after
         construction and making sure Board does not mutate
==&gt; passed

Test 12: check that Board is immutable by testing whether methods
         return the same value, regardless of order in which called
  * puzzle10.txt
  * puzzle20.txt
  * puzzle30.txt
  * 2-by-2
  * 3-by-3
  * 4-by-4
==&gt; passed

Test 13: check dimension() on a board that is kth neighbor of a board
  * 0th neighbor of puzzle27.txt
  * 1st neighbor of puzzle27.txt
  * 2nd neighbor of puzzle27.txt
  * 13th neighbor of puzzle27.txt
  * 13th neighbor of puzzle00.txt
  * 13th neighbor of puzzle2x2-unsolvable1.txt
==&gt; passed

Test 14: check hamming() on a board that is kth neighbor of a board
  * 0th neighbor of puzzle27.txt
  * 1st neighbor of puzzle27.txt
  * 2nd neighbor of puzzle27.txt
  * 13th neighbor of puzzle27.txt
  * 13th neighbor of puzzle00.txt
  * 13th neighbor of puzzle2x2-unsolvable1.txt
==&gt; passed

Test 15: check manhattan() on a board that is a kth neighbor of a board
  * 0th neighbor of puzzle27.txt
  * 1st neighbor of puzzle27.txt
  * 2nd neighbor of puzzle27.txt
  * 13th neighbor of puzzle27.txt
  * 13th neighbor of puzzle00.txt
  * 13th neighbor of puzzle2x2-unsolvable1.txt
==&gt; passed

Test 16: check hamming() on a board that is a kth twin of a board
  * 0th twin of puzzle27.txt
  * 1st twin of puzzle27.txt
  * 2nd twin of puzzle27.txt
  * 13th twin of puzzle27.txt
  * 13th twin of puzzle00.txt
  * 13th twin of puzzle2x2-unsolvable1.txt
==&gt; passed

Test 17: check manhattan() on a board that is a kth twin of a board
  * 0th twin of puzzle27.txt
  * 1st twin of puzzle27.txt
  * 2nd twin of puzzle27.txt
  * 13th twin of puzzle27.txt
  * 13th twin of puzzle00.txt
  * 13th twin of puzzle2x2-unsolvable1.txt
==&gt; passed


Total: 26/26 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Board
*-----------------------------------------------------------
Running 10 total tests.

Memory usage of an n-by-n board
[ must be at most 4n^2 + 32n + 64 bytes ]


              n       student (bytes)    reference (bytes)
----------------------------------------------------------
=&gt; passed     2           104                  128
=&gt; passed     3           128                  192
=&gt; passed     4           152                  240
=&gt; passed     8           344                  560
=&gt; passed    12           664                 1008
=&gt; passed    16          1112                 1584
=&gt; passed    20          1688                 2288
=&gt; passed    37          5568                 6856
=&gt; passed    72         20824                23088
=&gt; passed   120         57688                61488
==&gt; 10/10 tests passed

Total: 10/10 tests passed!

Student   memory = 4.00 n^2 + 0.00 n + 88.00   (R^2 = 1.000)
Reference memory = 4.00 n^2 + 32.00 n + 48.00   (R^2 = 1.000)


================================================================



********************************************************************************
*  TESTING CORRECTNESS (substituting reference Board)
********************************************************************************

Testing correctness of Solver
*-----------------------------------------------------------
Running 26 total tests.

Test 1: check that Solver doesn&#x27;t mutate objects added to MinPQ
        after they&#x27;ve been added
  * puzzle00.txt
  * puzzle01.txt
  * puzzle02.txt
  * puzzle03.txt
  * puzzle04.txt
  * puzzle05.txt
  * puzzle06.txt
  * puzzle07.txt
  * puzzle08.txt
==&gt; passed

Test 2a: check moves() with file inputs
  * puzzle00.txt
  * puzzle01.txt
  * puzzle02.txt
  * puzzle03.txt
  * puzzle04.txt
  * puzzle05.txt
  * puzzle06.txt
  * puzzle07.txt
  * puzzle08.txt
  * puzzle09.txt
  * puzzle10.txt
  * puzzle11.txt
  * puzzle12.txt
  * puzzle13.txt
==&gt; passed

Test 2b: check solution() with file inputs
  * puzzle00.txt
  * puzzle01.txt
  * puzzle02.txt
  * puzzle03.txt
  * puzzle04.txt
  * puzzle05.txt
  * puzzle06.txt
  * puzzle07.txt
  * puzzle08.txt
  * puzzle09.txt
  * puzzle10.txt
  * puzzle11.txt
  * puzzle12.txt
  * puzzle13.txt
==&gt; passed

Test 3a: check moves() with more file inputs
  * puzzle14.txt
  * puzzle15.txt
  * puzzle16.txt
  * puzzle17.txt
  * puzzle18.txt
  * puzzle19.txt
  * puzzle20.txt
  * puzzle21.txt
  * puzzle22.txt
  * puzzle23.txt
  * puzzle24.txt
  * puzzle25.txt
  * puzzle26.txt
  * puzzle27.txt
  * puzzle28.txt
  * puzzle29.txt
  * puzzle30.txt
  * puzzle31.txt
==&gt; passed

Test 3b: check solution() with more file inputs
  * puzzle14.txt
  * puzzle15.txt
  * puzzle16.txt
  * puzzle17.txt
  * puzzle18.txt
  * puzzle19.txt
  * puzzle20.txt
  * puzzle21.txt
  * puzzle22.txt
  * puzzle23.txt
  * puzzle24.txt
  * puzzle25.txt
  * puzzle26.txt
  * puzzle27.txt
  * puzzle28.txt
  * puzzle29.txt
  * puzzle30.txt
  * puzzle31.txt
==&gt; passed

Test 4a: check moves() with random solvable n-by-n boards
  * 1000 random 3-by-3 boards that are exactly 1 move from goal
  * 1000 random 3-by-3 boards that are exactly 2 moves from goal
  * 1000 random 3-by-3 boards that are exactly 3 moves from goal
  * 1000 random 3-by-3 boards that are exactly 4 moves from goal
  * 1000 random 3-by-3 boards that are exactly 5 moves from goal
  * 1000 random 3-by-3 boards that are exactly 6 moves from goal
  * 1000 random 3-by-3 boards that are exactly 7 moves from goal
  * 1000 random 3-by-3 boards that are exactly 8 moves from goal
  * 1000 random 3-by-3 boards that are exactly 9 moves from goal
  * 1000 random 3-by-3 boards that are exactly 10 moves from goal
  * 1000 random 3-by-3 boards that are exactly 11 moves from goal
  * 1000 random 3-by-3 boards that are exactly 12 moves from goal
==&gt; passed

Test 4b: check solution() with random solvable n-by-n boards
  * 1000 random 3-by-3 boards that are exactly 1 move from goal
  * 1000 random 3-by-3 boards that are exactly 2 moves from goal
  * 1000 random 3-by-3 boards that are exactly 3 moves from goal
  * 1000 random 3-by-3 boards that are exactly 4 moves from goal
  * 1000 random 3-by-3 boards that are exactly 5 moves from goal
  * 1000 random 3-by-3 boards that are exactly 6 moves from goal
  * 1000 random 3-by-3 boards that are exactly 7 moves from goal
  * 1000 random 3-by-3 boards that are exactly 8 moves from goal
  * 1000 random 3-by-3 boards that are exactly 9 moves from goal
  * 1000 random 3-by-3 boards that are exactly 10 moves from goal
  * 1000 random 3-by-3 boards that are exactly 11 moves from goal
  * 1000 random 3-by-3 boards that are exactly 12 moves from goal
==&gt; passed

Test 5: create two Solver objects at the same time
  * puzzle04.txt and puzzle04.txt
  * puzzle00.txt and puzzle04.txt
  * puzzle04.txt and puzzle00.txt
==&gt; passed

Test 6a: call isSolvable() with file inputs
  * puzzle01.txt
  * puzzle03.txt
  * puzzle04.txt
  * puzzle17.txt
  * puzzle3x3-unsolvable1.txt
  * puzzle3x3-unsolvable2.txt
  * puzzle4x4-unsolvable.txt
==&gt; passed

Test 6b: call isSolvable() on random n-by-n boards
  * 100 random 2-by-2 boards
==&gt; passed

Test 7: check moves() on unsolvable puzzles
  * puzzle2x2-unsolvable1.txt
  * puzzle2x2-unsolvable2.txt
  * puzzle3x3-unsolvable1.txt
  * puzzle3x3-unsolvable2.txt
  * puzzle4x4-unsolvable.txt
==&gt; passed

Test 8: check solution() on unsolvable puzzles
  * puzzle2x2-unsolvable1.txt
  * puzzle2x2-unsolvable2.txt
  * puzzle3x3-unsolvable1.txt
  * puzzle3x3-unsolvable2.txt
  * puzzle4x4-unsolvable.txt
==&gt; passed

Test 9a: check that Solver is immutable by testing whether methods
         return the same value, regardless of order in which called
  * puzzle3x3-00.txt
  * puzzle3x3-01.txt
  * puzzle3x3-05.txt
  * puzzle3x3-10.txt
  * random 2-by-2 solvable boards
==&gt; passed

Test 9b: check that Solver is immutable by testing whether methods
         return the same value, regardless of order in which called
  * puzzle3x3-unsolvable1.txt
  * puzzle3x3-unsolvable2.txt
  * puzzle4x4-unsolvable.txt
  * random 2-by-2 unsolvable boards
==&gt; passed

Test 10a: check that equals() method in Board is called
  * puzzle04.txt
  * puzzle05.txt
  * puzzle10.txt
==&gt; passed

Test 10b: check that equals() method in Board is called only
          with an argument of type Board
  * puzzle00.txt
  * puzzle04.txt
  * puzzle05.txt
  * puzzle10.txt
==&gt; passed

Test 10c: check that equals() method in Board is called only
          with a neighbor of a neighbor as an argument
  * puzzle00.txt
  * puzzle04.txt
  * puzzle05.txt
  * puzzle10.txt
  * puzzle27.txt
==&gt; passed

Test 11: check that constructor throws exception if board is null
==&gt; passed

Test 12a: check moves() with 2-by-2 file inputs
  * puzzle2x2-00.txt
  * puzzle2x2-01.txt
  * puzzle2x2-02.txt
  * puzzle2x2-03.txt
  * puzzle2x2-04.txt
  * puzzle2x2-05.txt
  * puzzle2x2-06.txt
==&gt; passed

Test 12b: check solution() with 2-by-2 file inputs
  * puzzle2x2-00.txt
  * puzzle2x2-01.txt
  * puzzle2x2-02.txt
  * puzzle2x2-03.txt
  * puzzle2x2-04.txt
  * puzzle2x2-05.txt
  * puzzle2x2-06.txt
==&gt; passed

Test 13a: check moves() with 3-by-3 file inputs
  * puzzle3x3-00.txt
  * puzzle3x3-01.txt
  * puzzle3x3-02.txt
  * puzzle3x3-03.txt
  * puzzle3x3-04.txt
  * puzzle3x3-05.txt
  * puzzle3x3-06.txt
  * puzzle3x3-07.txt
  * puzzle3x3-08.txt
  * puzzle3x3-09.txt
  * puzzle3x3-10.txt
  * puzzle3x3-11.txt
  * puzzle3x3-12.txt
  * puzzle3x3-13.txt
  * puzzle3x3-14.txt
  * puzzle3x3-15.txt
  * puzzle3x3-16.txt
  * puzzle3x3-17.txt
  * puzzle3x3-18.txt
  * puzzle3x3-19.txt
  * puzzle3x3-20.txt
  * puzzle3x3-21.txt
  * puzzle3x3-22.txt
  * puzzle3x3-23.txt
  * puzzle3x3-24.txt
  * puzzle3x3-25.txt
  * puzzle3x3-26.txt
  * puzzle3x3-27.txt
  * puzzle3x3-28.txt
  * puzzle3x3-29.txt
  * puzzle3x3-30.txt
==&gt; passed

Test 13b: check solution() with 3-by-3 file inputs
  * puzzle3x3-00.txt
  * puzzle3x3-01.txt
  * puzzle3x3-02.txt
  * puzzle3x3-03.txt
  * puzzle3x3-04.txt
  * puzzle3x3-05.txt
  * puzzle3x3-06.txt
  * puzzle3x3-07.txt
  * puzzle3x3-08.txt
  * puzzle3x3-09.txt
  * puzzle3x3-10.txt
  * puzzle3x3-11.txt
  * puzzle3x3-12.txt
  * puzzle3x3-13.txt
  * puzzle3x3-14.txt
  * puzzle3x3-15.txt
  * puzzle3x3-16.txt
  * puzzle3x3-17.txt
  * puzzle3x3-18.txt
  * puzzle3x3-19.txt
  * puzzle3x3-20.txt
  * puzzle3x3-21.txt
  * puzzle3x3-22.txt
  * puzzle3x3-23.txt
  * puzzle3x3-24.txt
  * puzzle3x3-25.txt
  * puzzle3x3-26.txt
  * puzzle3x3-27.txt
  * puzzle3x3-28.txt
  * puzzle3x3-29.txt
  * puzzle3x3-30.txt
==&gt; passed

Test 14a: check moves() with 4-by-4 file inputs
  * puzzle4x4-00.txt
  * puzzle4x4-01.txt
  * puzzle4x4-02.txt
  * puzzle4x4-03.txt
  * puzzle4x4-04.txt
  * puzzle4x4-05.txt
  * puzzle4x4-06.txt
  * puzzle4x4-07.txt
  * puzzle4x4-08.txt
  * puzzle4x4-09.txt
  * puzzle4x4-10.txt
  * puzzle4x4-11.txt
  * puzzle4x4-12.txt
  * puzzle4x4-13.txt
  * puzzle4x4-14.txt
  * puzzle4x4-15.txt
  * puzzle4x4-16.txt
  * puzzle4x4-17.txt
  * puzzle4x4-18.txt
  * puzzle4x4-19.txt
  * puzzle4x4-20.txt
  * puzzle4x4-21.txt
  * puzzle4x4-22.txt
  * puzzle4x4-23.txt
  * puzzle4x4-24.txt
  * puzzle4x4-25.txt
  * puzzle4x4-26.txt
  * puzzle4x4-27.txt
  * puzzle4x4-28.txt
  * puzzle4x4-29.txt
  * puzzle4x4-30.txt
==&gt; passed

Test 14b: check solution() with 4-by-4 file inputs
  * puzzle4x4-00.txt
  * puzzle4x4-01.txt
  * puzzle4x4-02.txt
  * puzzle4x4-03.txt
  * puzzle4x4-04.txt
  * puzzle4x4-05.txt
  * puzzle4x4-06.txt
  * puzzle4x4-07.txt
  * puzzle4x4-08.txt
  * puzzle4x4-09.txt
  * puzzle4x4-10.txt
  * puzzle4x4-11.txt
  * puzzle4x4-12.txt
  * puzzle4x4-13.txt
  * puzzle4x4-14.txt
  * puzzle4x4-15.txt
  * puzzle4x4-16.txt
  * puzzle4x4-17.txt
  * puzzle4x4-18.txt
  * puzzle4x4-19.txt
  * puzzle4x4-20.txt
  * puzzle4x4-21.txt
  * puzzle4x4-22.txt
  * puzzle4x4-23.txt
  * puzzle4x4-24.txt
  * puzzle4x4-25.txt
  * puzzle4x4-26.txt
  * puzzle4x4-27.txt
  * puzzle4x4-28.txt
  * puzzle4x4-29.txt
  * puzzle4x4-30.txt
==&gt; passed

Test 15a: check moves() with random solvable n-by-n boards
  * 100 random 2-by-2 boards that are &lt;= 6 moves from goal
  * 200 random 3-by-3 boards that are &lt;= 20 moves from goal
  * 200 random 4-by-4 boards that are &lt;= 20 moves from goal
  * 200 random 5-by-5 boards that are &lt;= 20 moves from goal
==&gt; passed

Test 15b: check solution() with random solvable n-by-n boards
  * 100 random 2-by-2 boards that are &lt;= 6 moves from goal
  * 200 random 3-by-3 boards that are &lt;= 20 moves from goal
  * 200 random 4-by-4 boards that are &lt;= 20 moves from goal
  * 200 random 5-by-5 boards that are &lt;= 20 moves from goal
==&gt; passed


Total: 26/26 tests passed!


================================================================
********************************************************************************
*  MEMORY (substituting reference Board)
********************************************************************************

Analyzing memory of Solver
*-----------------------------------------------------------
Running 12 total tests.

Maximum allowed time per puzzle is 5.0 seconds.
Maximum allowed memory per puzzle = 200000000 bytes.

Test 1: Measure memory of Solver.

               filename   moves   memory
---------------------------------------------
=&gt; passed  puzzle10.txt      10     4744         
=&gt; passed  puzzle15.txt      15     5712         
=&gt; passed  puzzle20.txt      20     2936         
=&gt; passed  puzzle25.txt      25     3616         
=&gt; passed  puzzle30.txt      30     4296         
=&gt; passed  puzzle35.txt      35     5840         
==&gt; 6/6 tests passed



Test 2: Measure memory of MinPQ.

                              deep              max           ending
               filename     memory             size             size
--------------------------------------------------------------------
=&gt; passed  puzzle10.txt      22672               32               32         
=&gt; passed  puzzle15.txt      29080               50               50         
=&gt; passed  puzzle20.txt     164640              443              443         
=&gt; passed  puzzle25.txt    1156528             3144             3144         
=&gt; passed  puzzle30.txt    5025120            13283            13283         
=&gt; passed  puzzle35.txt   40723336           119288           119288         
==&gt; 6/6 tests passed


Total: 12/12 tests passed!


================================================================



********************************************************************************
*  TIMING (substituting reference Board)
********************************************************************************

Timing Solver
*-----------------------------------------------------------
Running 125 total tests.

Maximum allowed time per puzzle is 5.0 seconds.

Test 1: Measure CPU time and check correctness

               filename   moves    n  seconds
---------------------------------------------
=&gt; passed  puzzle20.txt      20    3     0.01 
=&gt; passed  puzzle22.txt      22    3     0.01 
=&gt; passed  puzzle21.txt      21    3     0.00 
=&gt; passed  puzzle23.txt      23    3     0.00 
=&gt; passed  puzzle24.txt      24    3     0.00 
=&gt; passed  puzzle25.txt      25    3     0.01 
=&gt; passed  puzzle27.txt      27    3     0.01 
=&gt; passed  puzzle29.txt      29    3     0.01 
=&gt; passed  puzzle26.txt      26    3     0.01 
=&gt; passed  puzzle28.txt      28    3     0.01 
=&gt; passed  puzzle30.txt      30    3     0.02 
=&gt; passed  puzzle31.txt      31    3     0.03 
=&gt; passed  puzzle39.txt      39    4     0.02 
=&gt; passed  puzzle41.txt      41    5     0.02 
=&gt; passed  puzzle34.txt      34    4     0.08 
=&gt; passed  puzzle37.txt      37    4     0.03 
=&gt; passed  puzzle44.txt      44    5     0.10 
=&gt; passed  puzzle32.txt      32    4     0.23 
=&gt; passed  puzzle35.txt      35    4     0.13 
=&gt; passed  puzzle33.txt      33    4     0.26 
=&gt; passed  puzzle43.txt      43    4     0.36 
=&gt; passed  puzzle46.txt      46    4     0.34 
=&gt; passed  puzzle40.txt      40    4     0.18 
=&gt; passed  puzzle36.txt      36    4     1.26 
=&gt; passed  puzzle45.txt      45    4     0.55 
==&gt; 25/25 tests passed



Test 2: Count MinPQ operations

               filename   insert()         delMin()
---------------------------------------------------
=&gt; passed  puzzle20.txt       1114              671         
=&gt; passed  puzzle22.txt       3005             1773         
=&gt; passed  puzzle21.txt       1976             1171         
=&gt; passed  puzzle23.txt       4381             2605         
=&gt; passed  puzzle24.txt       2263             1375         
=&gt; passed  puzzle25.txt       7803             4659         
=&gt; passed  puzzle27.txt       5970             3643         
=&gt; passed  puzzle29.txt      10952             6683         
=&gt; passed  puzzle26.txt       5644             3411         
=&gt; passed  puzzle28.txt      15592             9495         
=&gt; passed  puzzle30.txt      33986            20703         
=&gt; passed  puzzle31.txt      40606            24841         
=&gt; passed  puzzle39.txt      40731            20101         
=&gt; passed  puzzle41.txt      28329            12163         
=&gt; passed  puzzle34.txt     149053            71579         
=&gt; passed  puzzle37.txt      63347            30357         
=&gt; passed  puzzle44.txt     151278            68057         
=&gt; passed  puzzle32.txt     400718           191821         
=&gt; passed  puzzle35.txt     236203           116915         
=&gt; passed  puzzle33.txt     461509           221837         
=&gt; passed  puzzle43.txt     648651           319143         
=&gt; passed  puzzle46.txt     599095           299779         
=&gt; passed  puzzle40.txt     315109           155063         
=&gt; passed  puzzle36.txt    1987594           966993         
=&gt; passed  puzzle45.txt     929742           459265         
==&gt; 25/25 tests passed



Test 3: Count Board operations (that should not get called)

               filename    hamming()   toString()
-------------------------------------------------
=&gt; passed  puzzle20.txt            0            0         
=&gt; passed  puzzle22.txt            0            0         
=&gt; passed  puzzle21.txt            0            0         
=&gt; passed  puzzle23.txt            0            0         
=&gt; passed  puzzle24.txt            0            0         
=&gt; passed  puzzle25.txt            0            0         
=&gt; passed  puzzle27.txt            0            0         
=&gt; passed  puzzle29.txt            0            0         
=&gt; passed  puzzle26.txt            0            0         
=&gt; passed  puzzle28.txt            0            0         
=&gt; passed  puzzle30.txt            0            0         
=&gt; passed  puzzle31.txt            0            0         
=&gt; passed  puzzle39.txt            0            0         
=&gt; passed  puzzle41.txt            0            0         
=&gt; passed  puzzle34.txt            0            0         
=&gt; passed  puzzle37.txt            0            0         
=&gt; passed  puzzle44.txt            0            0         
=&gt; passed  puzzle32.txt            0            0         
=&gt; passed  puzzle35.txt            0            0         
=&gt; passed  puzzle33.txt            0            0         
=&gt; passed  puzzle43.txt            0            0         
=&gt; passed  puzzle46.txt            0            0         
=&gt; passed  puzzle40.txt            0            0         
=&gt; passed  puzzle36.txt            0            0         
=&gt; passed  puzzle45.txt            0            0         
==&gt; 25/25 tests passed



Test 4a: Count Board operations (that should get called)

               filename    Board()            equals()         manhattan()
--------------------------------------------------------------------------
=&gt; passed  puzzle20.txt       1784                1772                3236         
=&gt; passed  puzzle22.txt       4777                4769                8671         
=&gt; passed  puzzle21.txt       3146                3136                5710         
=&gt; passed  puzzle23.txt       6985                6975               12671         
=&gt; passed  puzzle24.txt       3637                3625                6590         
=&gt; passed  puzzle25.txt      12461               12451               22596         
=&gt; passed  puzzle27.txt       9612                9602               17406         
=&gt; passed  puzzle29.txt      17634               17624               31930         
=&gt; passed  puzzle26.txt       9054                9046               16406         
=&gt; passed  puzzle28.txt      25086               25074               45428         
=&gt; passed  puzzle30.txt      54688               54680               99028         
=&gt; passed  puzzle31.txt      65446               65436              118475         
=&gt; passed  puzzle39.txt      60831               60821              111615         
=&gt; passed  puzzle41.txt      40491               40479               74904         
=&gt; passed  puzzle34.txt     220631              220623              405476         
=&gt; passed  puzzle37.txt      93703               93693              172231         
=&gt; passed  puzzle44.txt     219334              219322              404643         
=&gt; passed  puzzle32.txt     592538              592526             1089169         
=&gt; passed  puzzle35.txt     353117              353105              647780         
=&gt; passed  puzzle33.txt     683345              683335             1255775         
=&gt; passed  puzzle43.txt     967793              967783             1776018         
=&gt; passed  puzzle46.txt     898873              898863             1647860         
=&gt; passed  puzzle40.txt     470171              470163              862814         
=&gt; passed  puzzle36.txt    2954586             2954574             5425679         
=&gt; passed  puzzle45.txt    1389006             1388996             2548383         
==&gt; 25/25 tests passed



Test 4b: count Board operations (that should get called),
         rejecting if doesn&#x27;t adhere to stricter caching limits

               filename    Board()            equals()         manhattan()
--------------------------------------------------------------------------
=&gt; passed  puzzle20.txt       1784                1772                3236         
=&gt; passed  puzzle22.txt       4777                4769                8671         
=&gt; passed  puzzle21.txt       3146                3136                5710         
=&gt; passed  puzzle23.txt       6985                6975               12671         
=&gt; passed  puzzle24.txt       3637                3625                6590         
=&gt; passed  puzzle25.txt      12461               12451               22596         
=&gt; passed  puzzle27.txt       9612                9602               17406         
=&gt; passed  puzzle29.txt      17634               17624               31930         
=&gt; passed  puzzle26.txt       9054                9046               16406         
=&gt; passed  puzzle28.txt      25086               25074               45428         
=&gt; passed  puzzle30.txt      54688               54680               99028         
=&gt; passed  puzzle31.txt      65446               65436              118475         
=&gt; passed  puzzle39.txt      60831               60821              111615         
=&gt; passed  puzzle41.txt      40491               40479               74904         
=&gt; passed  puzzle34.txt     220631              220623              405476         
=&gt; passed  puzzle37.txt      93703               93693              172231         
=&gt; passed  puzzle44.txt     219334              219322              404643         
=&gt; passed  puzzle32.txt     592538              592526             1089169         
=&gt; passed  puzzle35.txt     353117              353105              647780         
=&gt; passed  puzzle33.txt     683345              683335             1255775         
=&gt; passed  puzzle43.txt     967793              967783             1776018         
=&gt; passed  puzzle46.txt     898873              898863             1647860         
=&gt; passed  puzzle40.txt     470171              470163              862814         
=&gt; passed  puzzle36.txt    2954586             2954574             5425679         
=&gt; passed  puzzle45.txt    1389006             1388996             2548383         
==&gt; 25/25 tests passed


Total: 125/125 tests passed!


================================================================




</pre>
</body>
</html>
