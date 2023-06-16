<h2>Program in execution<h2>

![hippo](https://github.com/nkey-ops/course-algorithms-by-princenton-p1/assets/81760194/7a5460ae-670c-47dd-9066-106d7efa96a1)

  
<h2>ASSESSMENT SUMMARY</h2>
<pre>

Compilation:  <font color = #009900>PASSED</font>
API:          <font color = #009900>PASSED</font>

SpotBugs:     <font color = #990000>FAILED (3 warnings)</font>
PMD:          <font color = #009900>PASSED</font>
Checkstyle:   <font color = #990000>FAILED (0 errors, 43 warnings)</font>

Correctness:  <font color = #009900>41/41 tests passed</font>
Memory:       <font color = #009900>1/1 tests passed</font>
Timing:       <font color = #009900>41/41 tests passed</font>

Aggregate score: 100.00%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 60%, Timing: 10%, Memory: 20% ]
</pre>


<br><br>

<h2>ASSESSMENT DETAILS</h2>

<pre>

The following files were submitted:
----------------------------------
3.2K Jun  6 12:18 BruteCollinearPoints.java
4.1K Jun  6 12:18 FastCollinearPoints.java
4.8K Jun  6 12:18 Point.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac Point.java
*-----------------------------------------------------------

% javac LineSegment.java
*-----------------------------------------------------------

% javac BruteCollinearPoints.java
*-----------------------------------------------------------

% javac FastCollinearPoints.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
Point:

BruteCollinearPoints:

FastCollinearPoints:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% spotbugs *.class
*-----------------------------------------------------------
M C SPP_USE_ZERO_WITH_COMPARATOR SPP: Method Point.main(String[]) compares the result of a compareTo method to a value other than zero  At Point.java:[line 125]
M C SPP_USE_ZERO_WITH_COMPARATOR SPP: Method Point.main(String[]) compares the result of a compareTo method to a value other than zero  At Point.java:[line 140]
M B RV_NEGATING_RESULT_OF_COMPARETO RV: Negates the return value of &#x27;compareTo()&#x27;, which is questionable if the return value is -2^31.  At Point.java:[line 125]
SpotBugs ends with 3 warnings.


================================================================


% pmd .
*-----------------------------------------------------------


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] BruteCollinearPoints.java:2:1: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
[WARN] BruteCollinearPoints.java:38:32: &#x27;;&#x27; is preceded with whitespace. [NoWhitespaceBefore]
[WARN] BruteCollinearPoints.java:41:17: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] BruteCollinearPoints.java:44:17: &#x27;}&#x27; is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:44:18: &#x27;else&#x27; is not preceded with whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:74:59: &#x27;+=&#x27; is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:74:59: &#x27;+=&#x27; is not preceded with whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:82:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] BruteCollinearPoints.java:94:54: Do not use the letter &#x27;l&#x27; as a parameter variable name. It is hard to distinguish from the number &#x27;1&#x27;. [ParameterName]
[WARN] BruteCollinearPoints.java:96:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] BruteCollinearPoints.java:99:37: &#x27;+=&#x27; is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:99:37: &#x27;+=&#x27; is not preceded with whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:114:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] BruteCollinearPoints.java:115:28: &#x27;(&#x27; is followed by whitespace. [ParenPad]
[WARN] BruteCollinearPoints.java:118:34: &#x27;(&#x27; is followed by whitespace. [ParenPad]
[WARN] BruteCollinearPoints.java:119:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] FastCollinearPoints.java:28:12: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
[WARN] FastCollinearPoints.java:38:5: Declare static variables before instance variables, constructors, and methods. [DeclarationOrder]
[WARN] FastCollinearPoints.java:40:47: &#x27;{&#x27; is not preceded with whitespace. [WhitespaceAround]
[WARN] FastCollinearPoints.java:42:64: &#x27;)&#x27; is preceded with whitespace. [ParenPad]
[WARN] FastCollinearPoints.java:56:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] FastCollinearPoints.java:62:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] FastCollinearPoints.java:71:13: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] FastCollinearPoints.java:82:29: &#x27;;&#x27; is preceded with whitespace. [NoWhitespaceBefore]
[WARN] FastCollinearPoints.java:84:17: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] FastCollinearPoints.java:88:21: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] FastCollinearPoints.java:88:82: &#x27;)&#x27; is preceded with whitespace. [ParenPad]
[WARN] FastCollinearPoints.java:97:13: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] FastCollinearPoints.java:104:24: You should not need to use wildcard types in this course. [TypeParameter]
[WARN] FastCollinearPoints.java:104:26: You should not need to use type upper or lower bounds in this course. [TypeParameter]
[WARN] FastCollinearPoints.java:119:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] FastCollinearPoints.java:124:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Point.java:63:5: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
[WARN] Point.java:63:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Point.java:66:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Point.java:66:49: &#x27;)&#x27; is preceded with whitespace. [ParenPad]
[WARN] Point.java:67:14: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Point.java:68:14: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Point.java:70:24: Typecast is not followed by whitespace. [WhitespaceAfter]
...
Checkstyle ends with 0 errors and 43 warnings.

% custom checkstyle checks for Point.java
*-----------------------------------------------------------

% custom checkstyle checks for BruteCollinearPoints.java
*-----------------------------------------------------------

% custom checkstyle checks for FastCollinearPoints.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of Point
*-----------------------------------------------------------
Running 3 total tests.

Test 1: p.slopeTo(q)
  * positive infinite slope, where p and q have coordinates in [0, 500)
  * positive infinite slope, where p and q have coordinates in [0, 32768)
  * negative infinite slope, where p and q have coordinates in [0, 500)
  * negative infinite slope, where p and q have coordinates in [0, 32768)
  * positive zero     slope, where p and q have coordinates in [0, 500)
  * positive zero     slope, where p and q have coordinates in [0, 32768)
  * symmetric for random points p and q with coordinates in [0, 500)
  * symmetric for random points p and q with coordinates in [0, 32768)
  * transitive for random points p, q, and r with coordinates in [0, 500)
  * transitive for random points p, q, and r with coordinates in [0, 32768)
  * slopeTo(), where p and q have coordinates in [0, 500)
  * slopeTo(), where p and q have coordinates in [0, 32768)
  * slopeTo(), where p and q have coordinates in [0, 10)
  * throw a java.lang.NullPointerException if argument is null
==&gt; passed

Test 2: p.compareTo(q)
  * reflexive, where p and q have coordinates in [0, 500)
  * reflexive, where p and q have coordinates in [0, 32768)
  * antisymmetric, where p and q have coordinates in [0, 500)
  * antisymmetric, where p and q have coordinates in [0, 32768)
  * transitive, where p, q, and r have coordinates in [0, 500)
  * transitive, where p, q, and r have coordinates in [0, 32768)
  * sign of compareTo(), where p and q have coordinates in [0, 500)
  * sign of compareTo(), where p and q have coordinates in [0, 32768)
  * sign of compareTo(), where p and q have coordinates in [0, 10)
  * throw java.lang.NullPointerException exception if argument is null
==&gt; passed

Test 3: p.slopeOrder().compare(q, r)
  * reflexive, where p and q have coordinates in [0, 500)
  * reflexive, where p and q have coordinates in [0, 32768)
  * antisymmetric, where p, q, and r have coordinates in [0, 500)
  * antisymmetric, where p, q, and r have coordinates in [0, 32768)
  * transitive, where p, q, r, and s have coordinates in [0, 500)
  * transitive, where p, q, r, and s have coordinates in [0, 32768)
  * sign of compare(), where p, q, and r have coordinates in [0, 500)
  * sign of compare(), where p, q, and r have coordinates in [0, 32768)
  * sign of compare(), where p, q, and r have coordinates in [0, 10)
  * throw java.lang.NullPointerException if either argument is null
==&gt; passed


Total: 3/3 tests passed!


================================================================
********************************************************************************
*  TESTING CORRECTNESS (substituting reference Point and LineSegment)
********************************************************************************

Testing correctness of BruteCollinearPoints
*-----------------------------------------------------------
Running 17 total tests.

The inputs satisfy the following conditions:
  - no duplicate points
  - no 5 (or more) points are collinear
  - all x- and y-coordinates between 0 and 32,767

Test 1: points from a file
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==&gt; passed

Test 2a: points from a file with horizontal line segments
  * filename = horizontal5.txt
  * filename = horizontal25.txt
==&gt; passed

Test 2b: random horizontal line segments
  *  1 random horizontal line segment
  *  5 random horizontal line segments
  * 10 random horizontal line segments
  * 15 random horizontal line segments
==&gt; passed

Test 3a: points from a file with vertical line segments
  * filename = vertical5.txt
  * filename = vertical25.txt
==&gt; passed

Test 3b: random vertical line segments
  *  1 random vertical line segment
  *  5 random vertical line segments
  * 10 random vertical line segments
  * 15 random vertical line segments
==&gt; passed

Test 4a: points from a file with no line segments
  * filename = random23.txt
  * filename = random38.txt
==&gt; passed

Test 4b: random points with no line segments
  *  5 random points
  * 10 random points
  * 20 random points
  * 50 random points
==&gt; passed

Test 5: points from a file with fewer than 4 points
  * filename = input1.txt
  * filename = input2.txt
  * filename = input3.txt
==&gt; passed

Test 6: check for dependence on either compareTo() or compare()
        returning { -1, +1, 0 } instead of { negative integer,
        positive integer, zero }
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==&gt; passed

Test 7: check for fragile dependence on return value of toString()
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==&gt; passed

Test 8: random line segments, none vertical or horizontal
  *  1 random line segment
  *  5 random line segments
  * 10 random line segments
  * 15 random line segments
==&gt; passed

Test 9: random line segments
  *  1 random line segment
  *  5 random line segments
  * 10 random line segments
  * 15 random line segments
==&gt; passed

Test 10: check that data type is immutable by testing whether each method
         returns the same value, regardless of any intervening operations
  * input8.txt
  * equidistant.txt
==&gt; passed

Test 11: check that data type does not mutate the constructor argument
  * input8.txt
  * equidistant.txt
==&gt; passed

Test 12: numberOfSegments() is consistent with segments()
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = horizontal5.txt
  * filename = vertical5.txt
  * filename = random23.txt
==&gt; passed

Test 13: throws an exception if either the constructor argument is null
         or any entry in array is null
  * argument is null
  * Point[] of length 10, number of null entries = 1
  * Point[] of length 10, number of null entries = 10
  * Point[] of length 4, number of null entries = 1
  * Point[] of length 3, number of null entries = 1
  * Point[] of length 2, number of null entries = 1
  * Point[] of length 1, number of null entries = 1
==&gt; passed

Test 14: check that the constructor throws an exception if duplicate points
  * 50 points
  * 25 points
  * 5 points
  * 4 points
  * 3 points
  * 2 points
==&gt; passed


Total: 17/17 tests passed!


================================================================
Testing correctness of FastCollinearPoints
*-----------------------------------------------------------
Running 21 total tests.

The inputs satisfy the following conditions:
  - no duplicate points
  - all x- and y-coordinates between 0 and 32,767

Test 1: points from a file
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = input299.txt
==&gt; passed

Test 2a: points from a file with horizontal line segments
  * filename = horizontal5.txt
  * filename = horizontal25.txt
  * filename = horizontal50.txt
  * filename = horizontal75.txt
  * filename = horizontal100.txt
==&gt; passed

Test 2b: random horizontal line segments
  *  1 random horizontal line segment
  *  5 random horizontal line segments
  * 10 random horizontal line segments
  * 15 random horizontal line segments
==&gt; passed

Test 3a: points from a file with vertical line segments
  * filename = vertical5.txt
  * filename = vertical25.txt
  * filename = vertical50.txt
  * filename = vertical75.txt
  * filename = vertical100.txt
==&gt; passed

Test 3b: random vertical line segments
  *  1 random vertical line segment
  *  5 random vertical line segments
  * 10 random vertical line segments
  * 15 random vertical line segments
==&gt; passed

Test 4a: points from a file with no line segments
  * filename = random23.txt
  * filename = random38.txt
  * filename = random91.txt
  * filename = random152.txt
==&gt; passed

Test 4b: random points with no line segments
  *  5 random points
  * 10 random points
  * 20 random points
  * 50 random points
==&gt; passed

Test 5a: points from a file with 5 or more on some line segments
  * filename = input9.txt
  * filename = input10.txt
  * filename = input20.txt
  * filename = input50.txt
  * filename = input80.txt
  * filename = input300.txt
  * filename = inarow.txt
==&gt; passed

Test 5b: points from a file with 5 or more on some line segments
  * filename = kw1260.txt
  * filename = rs1423.txt
==&gt; passed

Test 6: points from a file with fewer than 4 points
  * filename = input1.txt
  * filename = input2.txt
  * filename = input3.txt
==&gt; passed

Test 7: check for dependence on either compareTo() or compare()
        returning { -1, +1, 0 } instead of { negative integer,
        positive integer, zero }
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = input299.txt
==&gt; passed

Test 8: check for fragile dependence on return value of toString()
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==&gt; passed

Test 9: random line segments, none vertical or horizontal
  *  1 random line segment
  *  5 random line segments
  * 25 random line segments
  * 50 random line segments
  * 100 random line segments
==&gt; passed

Test 10: random line segments
  *  1 random line segment
  *  5 random line segments
  * 25 random line segments
  * 50 random line segments
  * 100 random line segments
==&gt; passed

Test 11: random distinct points in a given range
  * 5 random points in a 10-by-10 grid
  * 10 random points in a 10-by-10 grid
  * 50 random points in a 10-by-10 grid
  * 90 random points in a 10-by-10 grid
  * 200 random points in a 50-by-50 grid
==&gt; passed

Test 12: m*n points on an m-by-n grid
  * 3-by-3 grid
  * 4-by-4 grid
  * 5-by-5 grid
  * 10-by-10 grid
  * 20-by-20 grid
  * 5-by-4 grid
  * 6-by-4 grid
  * 10-by-4 grid
  * 15-by-4 grid
  * 25-by-4 grid
==&gt; passed

Test 13: check that data type is immutable by testing whether each method
         returns the same value, regardless of any intervening operations
  * input8.txt
  * equidistant.txt
==&gt; passed

Test 14: check that data type does not mutate the constructor argument
  * input8.txt
  * equidistant.txt
==&gt; passed

Test 15: numberOfSegments() is consistent with segments()
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = horizontal5.txt
  * filename = vertical5.txt
  * filename = random23.txt
==&gt; passed

Test 16: throws an exception if either constructor argument is null
         or any entry in array is null
  * argument is null
  * Point[] of length 10, number of null entries = 1
  * Point[] of length 10, number of null entries = 10
  * Point[] of length 4, number of null entries = 1
  * Point[] of length 3, number of null entries = 1
  * Point[] of length 2, number of null entries = 1
  * Point[] of length 1, number of null entries = 1
==&gt; passed

Test 17: check that the constructor throws an exception if duplicate points
  * 50 points
  * 25 points
  * 5 points
  * 4 points
  * 3 points
  * 2 points
==&gt; passed


Total: 21/21 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Point
*-----------------------------------------------------------
Running 1 total tests.

The maximum amount of memory per Point object is 32 bytes.

Student memory = 24 bytes (passed)

Total: 1/1 tests passed!


================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing BruteCollinearPoints
*-----------------------------------------------------------
Running 10 total tests.

Test 1a-1e: Find collinear points among n random distinct points


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=&gt; passed    16   0.00         680           0            680                  800         
=&gt; passed    32   0.00        5456           0           5456                 5952         
=&gt; passed    64   0.00       43680           0          43680                45696         
=&gt; passed   128   0.01      349504           0         349504               357632         
=&gt; passed   256   0.05     2796160           0        2796160              2828800         
==&gt; 5/5 tests passed

Test 2a-2e: Find collinear points among n/4 arbitrary line segments


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=&gt; passed    16   0.00         698           0            698                  833         
=&gt; passed    32   0.00        5540           0           5540                 6047         
=&gt; passed    64   0.00       44040           0          44040                45943         
=&gt; passed   128   0.01      350992           0         350992               358378         
=&gt; passed   256   0.03     2802208           0        2802208              2831311         
==&gt; 5/5 tests passed

Total: 10/10 tests passed!


================================================================



Timing FastCollinearPoints
*-----------------------------------------------------------
Running 31 total tests.

Test 1a-1g: Find collinear points among n random distinct points


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=&gt; passed    64   0.01       41362           0          41362                   64         
=&gt; passed   128   0.01      196244           0         196244                  128         
=&gt; passed   256   0.02      899080           0         899080                  256         
=&gt; passed   512   0.11     4037566           0        4037566                  515         
=&gt; passed  1024   0.43    18099102           0       18099102                 1039         
=&gt; passed  2048   0.88    79921306           0       79921306                 2108         
==&gt; 6/6 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (79921306 / 18099102) = 2.14
=&gt; passed

==&gt; 7/7 tests passed

Test 2a-2g: Find collinear points among the n points on an n-by-1 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=&gt; passed    64   0.00       19062           0          19062                 7350         
=&gt; passed   128   0.00       64676           0          64676                23930         
=&gt; passed   256   0.00      230902           0         230902                82301         
=&gt; passed   512   0.01      861346           0         861346               298886         
=&gt; passed  1024   0.03     3306478           0        3306478              1127616         
=&gt; passed  2048   0.09    12925946           0       12925946              4363206         
=&gt; passed  4096   0.29    51059086           0       51059086             17135741         
==&gt; 7/7 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (51059086 / 12925946) = 1.98
=&gt; passed

==&gt; 8/8 tests passed

Test 3a-3g: Find collinear points among the n points on an n/4-by-4 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=&gt; passed    64   0.00       39120           0          39120                 3713         
=&gt; passed   128   0.00      160348           0         160348                14654         
=&gt; passed   256   0.01      625386           0         625386                58511         
=&gt; passed   512   0.03     2481954           0        2481954               229369         
=&gt; passed  1024   0.12     9868262           0        9868262               902871         
=&gt; passed  2048   0.35    39218240           0       39218240              3601335         
=&gt; passed  4096   1.35   156673136           0      156673136             14308333         
==&gt; 7/7 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (156673136 / 39218240) = 2.00
=&gt; passed

==&gt; 8/8 tests passed

Test 4a-4g: Find collinear points among the n points on an n/8-by-8 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=&gt; passed    64   0.00       41396           0          41396                 3370         
=&gt; passed   128   0.00      192444           0         192444                14210         
=&gt; passed   256   0.01      828870           0         828870                57190         
=&gt; passed   512   0.04     3503382           0        3503382               229345         
=&gt; passed  1024   0.16    14524968           0       14524968               912538         
=&gt; passed  2048   0.61    59598098           0       59598098              3631522         
=&gt; passed  4096   2.26   242240504           0      242240504             14532741         
==&gt; 7/7 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (242240504 / 59598098) = 2.02
=&gt; passed

==&gt; 8/8 tests passed

Total: 31/31 tests passed!


================================================================




</pre>
</body>
</html>
