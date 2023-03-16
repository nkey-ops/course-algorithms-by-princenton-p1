Program in execution

![hippo](https://user-images.githubusercontent.com/81760194/225597366-573bb944-81cd-42c9-9c3c-d972b2ce1f7a.gif)



==============================================================================================================

<!DOCTYPE html>
<html lang="en">
<head>
Autograder Feedback
<meta charset="UTF-8">
</head>

<body>

<p>
<em>
See the Assessment Guide for information on how to interpret this report.
</em>

<p>
<em>
Want to receive personalized feedback on this submission?
You can pay to have a teaching assistant read and provide
personalized feedback on your submission at https://mooc.codepost.io.
</em>

<br><br>

<h2>ASSESSMENT SUMMARY</h2>
<pre>

Compilation:  <font color = #009900>PASSED</font>
API:          <font color = #009900>PASSED</font>

SpotBugs:     <font color = #009900>PASSED</font>
PMD:          <font color = #009900>PASSED</font>
Checkstyle:   <font color = #990000>FAILED (0 errors, 17 warnings)</font>

Correctness:  <font color = #009900>38/38 tests passed</font>
Memory:       <font color = #009900>9/8 tests passed</font>
Timing:       <font color = #009900>20/20 tests passed</font>

Aggregate score: 101.25%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 60%, Timing: 10%, Memory: 20% ]
</pre>


<br><br>

<h2>ASSESSMENT DETAILS</h2>

<pre>

The following files were submitted:
----------------------------------
5.3K Mar 16 10:04 Percolation.java
2.4K Mar 16 10:04 PercolationStats.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac Percolation.java
*-----------------------------------------------------------

% javac PercolationStats.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
Percolation:

PercolationStats:

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
[WARN] Percolation.java:10:1: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
[WARN] Percolation.java:158:30: &#x27;,&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Percolation.java:158:33: &#x27;,&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Percolation.java:158:36: &#x27;//&#x27; or &#x27;/*&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Percolation.java:192:27: Inner assignments should be avoided. [InnerAssignment]
[WARN] Percolation.java:193:27: Inner assignments should be avoided. [InnerAssignment]
[WARN] Percolation.java:198:11: &#x27;//&#x27; or &#x27;/*&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Percolation.java:231:24: Avoid nested blocks: the curly braces serve no purpose. [AvoidNestedBlocks]
[WARN] Percolation.java:234:25: Avoid nested blocks: the curly braces serve no purpose. [AvoidNestedBlocks]
[WARN] Percolation.java:237:22: Avoid nested blocks: the curly braces serve no purpose. [AvoidNestedBlocks]
[WARN] PercolationStats.java:7:1: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
[WARN] PercolationStats.java:15:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] PercolationStats.java:23:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] PercolationStats.java:70:33: &#x27;{&#x27; is not preceded with whitespace. [WhitespaceAround]
Checkstyle ends with 0 errors and 14 warnings.

% custom checkstyle checks for Percolation.java
*-----------------------------------------------------------
[WARN] Percolation.java:18:23: Can you use the type &#x27;boolean[]&#x27; instead of &#x27;int[]&#x27;? [Design]
[WARN] Percolation.java:19:23: Can you use the type &#x27;boolean[]&#x27; instead of &#x27;int[]&#x27;? [Design]
Checkstyle ends with 0 errors and 2 warnings.

% custom checkstyle checks for PercolationStats.java
*-----------------------------------------------------------
[WARN] PercolationStats.java:2:1: The constant &#x27;1.96&#x27; appears more than once. Define a constant variable (such as &#x27;CONFIDENCE_95&#x27;) to hold the constant &#x27;1.96&#x27;. [NumericLiteralCount]
Checkstyle ends with 0 errors and 1 warning.


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of Percolation
*-----------------------------------------------------------
Running 21 total tests.

Tests 1 through 7 create a Percolation object using your code, then repeatedly
open sites by calling open(). After each call to open(), it checks the return
values of isOpen(), percolates(), numberOfOpenSites(), and isFull() in that order.
Tests 12 through 15 create a Percolation object using your code, then repeatedly
call the methods open(), isOpen(), isFull(), percolates(), and, numberOfOpenSites()
in random order with probabilities p = (p1, p2, p3, p4, p5). The tests stop
immediately after the system percolates.

Tests 18 through 21 test backwash.

Except as noted, a site is opened at most once.

Test 1: open predetermined list of sites using file inputs
  * filename = input6.txt
  * filename = input8.txt
  * filename = input8-no.txt
  * filename = input10-no.txt
  * filename = greeting57.txt
  * filename = heart25.txt
==&gt; passed

Test 2: open random sites until the system percolates
  * n = 3
  * n = 5
  * n = 10
  * n = 10
  * n = 20
  * n = 20
  * n = 50
  * n = 50
==&gt; passed

Test 3: open predetermined sites for n = 1 and n = 2 (corner case test)
  * filename = input1.txt
  * filename = input1-no.txt
  * filename = input2.txt
  * filename = input2-no.txt
==&gt; passed

Test 4: check predetermined sites with long percolating path
  * filename = snake13.txt
  * filename = snake101.txt
==&gt; passed

Test 5: open every site
  * filename = input5.txt
==&gt; passed

Test 6: open random sites until the system percolates,
        allowing open() to be called on a site more than once
  * n = 3
  * n = 5
  * n = 10
  * n = 10
  * n = 20
  * n = 20
  * n = 50
  * n = 50
==&gt; passed

Test 7: open random sites with large n
  * n = 250
  * n = 500
  * n = 1000
  * n = 2000
==&gt; passed

Test 8: call methods with invalid arguments
  * n = 10, (row, col) = (-1, 5)
  * n = 10, (row, col) = (11, 5)
  * n = 10, (row, col) = (0, 5)
  * n = 10, (row, col) = (5, -1)
  * n = 10, (row, col) = (5, 11)
  * n = 10, (row, col) = (5, 0)
  * n = 10, (row, col) = (-2147483648, -2147483648)
  * n = 10, (row, col) = (2147483647, 2147483647)
==&gt; passed

Test 9: call constructor with invalid argument
  * n = -10
  * n = -1
  * n = 0
==&gt; passed

Test 10: create multiple Percolation objects at the same time
        (to make sure you didn&#x27;t store data in static variables)
==&gt; passed

Test 11: open predetermined list of sites using file inputs,
         but permute the order in which methods are called
  * filename = input8.txt;  order =     isFull(),     isOpen(), percolates()
  * filename = input8.txt;  order =     isFull(), percolates(),     isOpen()
  * filename = input8.txt;  order =     isOpen(),     isFull(), percolates()
  * filename = input8.txt;  order =     isOpen(), percolates(),     isFull()
  * filename = input8.txt;  order = percolates(),     isOpen(),     isFull()
  * filename = input8.txt;  order = percolates(),     isFull(),     isOpen()
==&gt; passed

Test 12: call open(), isOpen(), and numberOfOpenSites()
         in random order until just before system percolates
  * n = 3, trials = 40, p = (0.4, 0.4, 0.0, 0.0, 0.3)
  * n = 5, trials = 20, p = (0.4, 0.4, 0.0, 0.0, 0.3)
  * n = 7, trials = 10, p = (0.4, 0.4, 0.0, 0.0, 0.3)
  * n = 10, trials = 5, p = (0.4, 0.4, 0.0, 0.0, 0.3)
  * n = 20, trials = 2, p = (0.4, 0.4, 0.0, 0.0, 0.3)
  * n = 50, trials = 1, p = (0.4, 0.4, 0.0, 0.0, 0.3)
==&gt; passed

Test 13: call open() and percolates() in random order until just before system percolates
  * n = 3, trials = 40, p = (0.5, 0.0, 0.0, 0.5, 0.0)
  * n = 5, trials = 20, p = (0.5, 0.0, 0.0, 0.5, 0.0)
  * n = 7, trials = 10, p = (0.5, 0.0, 0.0, 0.5, 0.0)
  * n = 10, trials = 5, p = (0.5, 0.0, 0.0, 0.5, 0.0)
  * n = 20, trials = 2, p = (0.5, 0.0, 0.0, 0.5, 0.0)
  * n = 50, trials = 1, p = (0.5, 0.0, 0.0, 0.5, 0.0)
==&gt; passed

Test 14: call open() and isFull() in random order until just before system percolates
  * n = 3, trials = 40, p = (0.5, 0.0, 0.5, 0.0, 0.0)
  * n = 5, trials = 20, p = (0.5, 0.0, 0.5, 0.0, 0.0)
  * n = 7, trials = 10, p = (0.5, 0.0, 0.5, 0.0, 0.0)
  * n = 10, trials = 5, p = (0.5, 0.0, 0.5, 0.0, 0.0)
  * n = 20, trials = 2, p = (0.5, 0.0, 0.5, 0.0, 0.0)
  * n = 50, trials = 1, p = (0.5, 0.0, 0.5, 0.0, 0.0)
==&gt; passed

Test 15: call all methods in random order until just before system percolates
  * n = 3, trials = 40, p = (0.2, 0.2, 0.2, 0.2, 0.2)
  * n = 5, trials = 20, p = (0.2, 0.2, 0.2, 0.2, 0.2)
  * n = 7, trials = 10, p = (0.2, 0.2, 0.2, 0.2, 0.2)
  * n = 10, trials = 5, p = (0.2, 0.2, 0.2, 0.2, 0.2)
  * n = 20, trials = 2, p = (0.2, 0.2, 0.2, 0.2, 0.2)
  * n = 50, trials = 1, p = (0.2, 0.2, 0.2, 0.2, 0.2)
==&gt; passed

Test 16: call all methods in random order until almost all sites are open
         (with inputs not prone to backwash)
  * n = 3
  * n = 5
  * n = 7
  * n = 10
  * n = 20
  * n = 50
==&gt; passed

Test 17: substitute the WeightedQuickUnionUF implementation with one that
         picks the leader nondeterministically after each call to union();
         call all methods in random order until almost all sites are open
         (with inputs not prone to backwash)
  * n = 3
  * n = 5
  * n = 7
  * n = 10
  * n = 20
  * n = 50
==&gt; passed

Test 18: check for backwash with predetermined sites
  * filename = input20.txt
  * filename = input10.txt
  * filename = input50.txt
  * filename = jerry47.txt
  * filename = sedgewick60.txt
  * filename = wayne98.txt
==&gt; passed

Test 19: check for backwash with predetermined sites that have
         multiple percolating paths
  * filename = input3.txt
  * filename = input4.txt
  * filename = input7.txt
==&gt; passed

Test 20: call all methods in random order until all sites are open
         (these inputs are prone to backwash)
  * n = 3
  * n = 5
  * n = 7
  * n = 10
  * n = 20
  * n = 50
==&gt; passed

Test 21: substitute WeightedQuickUnionUF data type that picks leader nondeterministically;
         call all methods in random order until all sites are open
         (these inputs are prone to backwash)
  * n = 3
  * n = 5
  * n = 7
  * n = 10
  * n = 20
  * n = 50
==&gt; passed


Total: 21/21 tests passed!


================================================================
********************************************************************************
*  TESTING CORRECTNESS (substituting reference Percolation)
********************************************************************************

Testing correctness of PercolationStats
*-----------------------------------------------------------
Running 17 total tests.

Test 1: check formatting of output of main()
  % java-algs4 PercolationStats 20 10
  mean                    = 0.584
  stddev                  = 0.04171996591028755
  95% confidence interval = [0.5581416972285066, 0.6098583027714933]

  % java-algs4 PercolationStats 200 100
  mean                    = 0.591508
  stddev                  = 0.010563004742587178
  95% confidence interval = [0.589437651070453, 0.5935783489295471]

==&gt; passed

Test 2: check that methods in PercolationStats do not print to standard output
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==&gt; passed

Test 3: check that mean() returns value in expected range
  * n =   2, trials = 10000
  * n =   5, trials = 10000
  * n =  10, trials = 10000
  * n =  25, trials = 10000
==&gt; passed

Test 4: check that stddev() returns value in expected range
  * n =   2, trials = 10000
  * n =   5, trials = 10000
  * n =  10, trials = 10000
  * n =  25, trials = 10000
==&gt; passed

Test 5: check that PercolationStats constructor creates
        trials Percolation objects, each of size n-by-n
  * n =  15, trials =  15
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==&gt; passed

Test 6: check that PercolationStats.main() creates
        trials Percolation objects, each of size n-by-n
  * n =  15, trials =  15
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==&gt; passed

Test 7: check that PercolationStats calls open() until system percolates
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==&gt; passed

Test 8: check that PercolationStats does not call open() after system percolates
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==&gt; passed

Test 9: check that mean() is consistent with the number of intercepted calls to open()
        on blocked sites
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==&gt; passed

Test 10: check that stddev() is consistent with the number of intercepted calls to open()
         on blocked sites
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==&gt; passed

Test 11: check that confidenceLo() and confidenceHigh() are consistent with mean() and stddev()
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==&gt; passed

Test 12: check that exception is thrown if either n or trials is out of bounds
  * n = -23, trials =  42
  * n =  23, trials =   0
  * n = -42, trials =   0
  * n =  42, trials =  -1
  * n = -2147483648, trials = -2147483648
==&gt; passed

Test 13: create two PercolationStats objects at the same time and check mean()
         (to make sure you didn&#x27;t store data in static variables)
  * n1 =  50, trials1 =  10, n2 =  50, trials2 =   5
  * n1 =  50, trials1 =   5, n2 =  50, trials2 =  10
  * n1 =  50, trials1 =  10, n2 =  25, trials2 =  10
  * n1 =  25, trials1 =  10, n2 =  50, trials2 =  10
  * n1 =  50, trials1 =  10, n2 =  15, trials2 = 100
  * n1 =  15, trials1 = 100, n2 =  50, trials2 =  10
==&gt; passed

Test 14: check that the methods return the same value, regardless of
         the order in which they are called
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==&gt; passed

Test 15: check that no calls to StdRandom.setSeed()
  * n = 20, trials = 10
  * n = 20, trials = 10
  * n = 40, trials = 10
  * n = 80, trials = 10
==&gt; passed

Test 16: check distribution of number of sites opened until percolation
  * n = 2, trials = 100000
  * n = 3, trials = 100000
  * n = 4, trials = 100000
==&gt; passed

Test 17: check that each site is opened the expected number of times
  * n = 2, trials = 100000
  * n = 3, trials = 100000
  * n = 4, trials = 100000
==&gt; passed


Total: 17/17 tests passed!


================================================================
********************************************************************************
*  MEMORY (substituting reference Percolation)
********************************************************************************

Analyzing memory of PercolationStats
*-----------------------------------------------------------
Running 4 total tests.

Test 1a-1d: check memory usage as a function of T trials for n = 100
            (max allowed: 8*T + 128 bytes)

                 T        bytes
--------------------------------------------
=&gt; passed       16           48         
=&gt; passed       32           48         
=&gt; passed       64           48         
=&gt; passed      128           48         
==&gt; 4/4 tests passed


Estimated student memory = 48.00   (R^2 = 1.000)

Total: 4/4 tests passed!


================================================================



********************************************************************************
*  TIMING (substituting reference Percolation)
********************************************************************************

Timing PercolationStats
*-----------------------------------------------------------
Running 4 total tests.

Test 1: Call PercolationStats constructor and instance methods and
        count calls to StdStats.mean() and StdStats.stddev().
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==&gt; passed

Test 2: Call PercolationStats constructor and instance methods and
        count calls to methods in StdRandom.
  * n = 20, trials = 10
  * n = 20, trials = 10
  * n = 40, trials = 10
  * n = 80, trials = 10
==&gt; passed

Test 3: Call PercolationStats constructor and instance methods and
        count calls to methods in Percolation.
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==&gt; passed

Test 4: Call PercolationStats constructor and instance methods with trials = 3
        and values of n that go up by a multiplicative factor of sqrt(2).
        The test passes when n reaches 2,896.

     The approximate order-of-growth is n ^ (log ratio)

         n  seconds log ratio
     ------------------------
       724     0.16       2.7
      1024     0.43       2.7
      1448     1.16       2.9
      2048     2.94       2.7
      2896     7.23       2.6
==&gt; passed


Total: 4/4 tests passed!


================================================================



********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Percolation
*-----------------------------------------------------------
Running 4 total tests.

Test 1a-1d: check that total memory &lt;= 17 n^2 + 128 n + 1024 bytes

                 n        bytes
--------------------------------------------
=&gt; passed       64        45368         
=&gt; passed      256       721208         
=&gt; passed      512      2883896         
=&gt; passed     1024     11534648         
==&gt; 4/4 tests passed


Estimated student memory = 11.00 n^2 + 0.00 n + 312.00   (R^2 = 1.000)


Test 2 (bonus): check that total memory &lt;= 11 n^2 + 128 n + 1024 bytes
==&gt; passed


Total: 5/4 tests passed!


================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing Percolation
*-----------------------------------------------------------
Running 16 total tests.

Test 1a-1e: Creates an n-by-n percolation system; open sites at random until
            the system percolates, interleaving calls to percolates() and open().
            Count calls to connected(), union() and find().

                                       2 * connected()
                 n       union()              + find()        constructor
-----------------------------------------------------------------------------------
=&gt; passed       16          131                   131                   1         
=&gt; passed       32          605                   605                   1         
=&gt; passed       64         2458                  2458                   1         
=&gt; passed      128         8677                  8677                   1         
=&gt; passed      256        36348                 36348                   1         
=&gt; passed      512       147259                147259                   1         
=&gt; passed     1024       595191                595191                   1         
==&gt; 7/7 tests passed


If one of the values in the table violates the performance limits
the factor by which you failed the test appears in parentheses.
For example, (9.6x) in the union() column indicates that it uses
9.6x too many calls.


Tests 2a-2f: Check whether the number of calls to union(), connected(), and find()
             is a constant per call to open(), isOpen(), isFull(), and percolates().
             The table shows the maximum number of union() and find() calls made
             during a single call to open(), isOpen(), isFull(), and percolates().
             One call to connected() counts as two calls to find().

                 n     per open()      per isOpen()    per isFull()    per percolates() 
---------------------------------------------------------------------------------------------
=&gt; passed       16        3               0               0               0         
=&gt; passed       32        4               0               0               0         
=&gt; passed       64        4               0               0               0         
=&gt; passed      128        4               0               0               0         
=&gt; passed      256        4               0               0               0         
=&gt; passed      512        4               0               0               0         
=&gt; passed     1024        4               0               0               0         
==&gt; 7/7 tests passed



Running time (in seconds) depends on the machine on which the script runs.


Test 3: Create an n-by-n percolation system; interleave calls to percolates()
        and open() until the system percolates. The values of n go up by a
        factor of sqrt(2). The test is passed if n &gt;= 4096 in under 10 seconds.

     The approximate order-of-growth is n ^ (log ratio)

                        log   union-find     log
         n  seconds   ratio   operations   ratio
     -------------------------------------------
      1024     0.14     2.7      1760988     2.0
      1448     0.40     3.1      3563196     2.0
      2048     0.91     2.4      7089243     2.0
      2896     2.24     2.6     14223504     2.0
      4096     5.06     2.4     28472058     2.0
==&gt; passed



Test 4: Create an n-by-n percolation system; interleave calls to open(),
        percolates(), isOpen(), isFull(), and numberOfOpenSites() until.
        the system percolates. The values of n go up by a factor of sqrt(2).
        The test is passed if n &gt;= 4096 in under 10 seconds.

                        log   union-find     log
         n  seconds   ratio   operations   ratio
     -------------------------------------------
      1024     0.14     2.1      1788840     2.0
      1448     0.39     3.0      3539253     2.0
      2048     0.95     2.6      7111992     2.0
      2896     2.37     2.7     14257860     2.0
      4096     5.76     2.6     28321371     2.0
==&gt; passed


Total: 16/16 tests passed!


================================================================




</pre>
</body>
</html>


==============================================================================================================

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>


<head>
    <link rel="stylesheet" type="text/css" href="../css/assignments.css">
    <link rel="stylesheet" type="text/css" href="https://algs4.cs.princeton.edu/css/link-icons.css">
    Programming Assignment 1: Percolation
</head>
<body class = "specification">

<p>
Write a program to estimate the value of the 
<em>percolation threshold</em>
via Monte Carlo simulation.


</p><p><b>Install our Java programming environment (optional).</b>
Install our custom IntelliJ programming environment by following
these step-by-step instructions for your operating system
[
<a href = "https://lift.cs.princeton.edu/java/mac">Mac OS X</a>
&middot;
<a href = "https://lift.cs.princeton.edu/java/windows">Windows</a>
&middot;
<a href = "https://lift.cs.princeton.edu/java/linux">Linux</a>
]. 

<p>
After following these instructions, the commands <code>javac-algs4</code> and <code>java-algs4</code>
will classpath in <a href = "https://algs4.cs.princeton.edu/code/algs4.jar">algs4.jar</a>,
which contains Java classes for I/O and all of the algorithms in the textbook.
To access a class in <code>algs4.jar</code>,
you need an <code>import</code> statement, such as the ones below:</em>

<blockquote>
<pre>
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
</pre></blockquote>

<p>
Note that <em>your</em> code must be in the <em>default package</em>; if you use a <code>package</code>
statement, the autograder will reject your submission.


<p><b>Percolation.</b>
Given a composite systems comprised of randomly distributed insulating and metallic
materials: what fraction of the materials need to be metallic so that the composite system is an 
electrical conductor? Given a porous landscape with water on the surface (or oil below),
under what conditions will the water be able to drain through to the bottom (or the
oil to gush through to the surface)?
Scientists have defined an abstract process known as <em>percolation</em>
to model such situations.

<p><b>The model.</b>
We model a percolation system using an <em>n</em>-by-<em>n</em> grid of <em>sites</em>.
Each site is either <em>open</em> or <em>blocked</em>.
A <em>full</em> site is an open site
that can be connected to an open site in the top row via a chain of
neighboring (left, right, up, down) open sites.
We say the system <em>percolates</em> if 
there is a full site in the bottom row.
In other words, a system percolates if we fill all open sites
connected to the top row and that process fills some open
site on the bottom row. (For the 
insulating/metallic materials example, the open sites correspond
to metallic materials, so that a system that percolates 
has a metallic path from top to bottom, with full sites conducting.
For the porous substance example, the open sites 
correspond to empty space through which water might 
flow, so that a system that percolates lets water fill open sites, 
flowing from top to bottom.)

<center>
<blockquote>
<img src = "percolates-yes.png" height = 175 align = "top" alt = "percolates">
&nbsp;
&nbsp;
&nbsp;
&nbsp;
&nbsp;
<img src = "percolates-no.png" height = 175 align = "top" alt = "does not percolate">
</blockquote>
</center>

<!--
<p>
<center>
<img src = "percolates.png" alt = "Percolates">
</center>
-->


<p><b>The problem.</b>
In a famous scientific problem, researchers are interested in the
following question: if sites are independently set to be open with
probability <em>p</em> (and therefore blocked with
probability 1 &minus; <em>p</em>), what is the probability that the system percolates?
When <em>p</em> equals 0, the system does not percolate; when <em>p</em> equals 1,
the system percolates.
The plots below show the site vacancy probability <em>p</em> versus the percolation
probability for 20-by-20 random grid (left) and 100-by-100 random grid (right).
<p>

<center>
<img src = "percolation-threshold20.png" height = 175 alt = "Percolation threshold for 20-by-20 grid">
&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;
<img src = "percolation-threshold100.png" height = 175 alt = "Percolation threshold for 100-by-100 grid">
&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;
</center>

<p>
When <em>n</em> is sufficiently large, there is a <em>threshold</em> value <em>p</em>* such
that when <em>p</em> &lt; <em>p</em>* a random <em>n</em>-by-<em>n</em> grid 
almost never percolates, and when <em>p</em> &gt; <em>p</em>*,
a random <em>n</em>-by-<em>n</em> grid almost always percolates.
No mathematical solution for determining the percolation threshold <em>p</em>*
has yet been derived.
Your task is to write a computer program to estimate <em>p</em>*.


<p><b>Percolation data type.</b>
To model a percolation system, create a data type <code>Percolation</code> with the following API:

<blockquote>
<pre class = "api">
public class Percolation {

    <span class = "comment">// creates n-by-n grid, with all sites initially blocked</span>
    public Percolation(int n)

    <span class = "comment">// opens the site (row, col) if it is not open already</span>
    public void open(int row, int col)

    <span class = "comment">// is the site (row, col) open?</span>
    public boolean isOpen(int row, int col)

    <span class = "comment">// is the site (row, col) full?</span>
    public boolean isFull(int row, int col)

    <span class = "comment">// returns the number of open sites</span>
    public int numberOfOpenSites()

    <span class = "comment">// does the system percolate?</span>
    public boolean percolates()

    <span class = "comment">// test client (optional)</span>
    public static void main(String[] args)
}
</pre></blockquote>


<p><em>Corner cases.&nbsp;</em>
By convention, the row and column indices 
are integers between 1 and <em>n</em>, where (1, 1) is the upper-left site:
Throw an <code>IllegalArgumentException</code>
if any argument to <code>open()</code>, <code>isOpen()</code>, or <code>isFull()</code> 
is outside its prescribed range.
Throw an <code>IllegalArgumentException</code> in the constructor if <em>n</em> &le; 0.


<p><em>Performance requirements.&nbsp;</em>
The constructor must take time proportional to <em>n</em><sup>2</sup>;
all instance methods must take constant time plus a constant number of calls to 
<code>union()</code> and <code>find()</code>.


<p><b>Monte Carlo simulation.</b>
To estimate the percolation threshold, consider the following computational experiment:
<ul>

<p><li> Initialize all sites to be blocked.

<p><li> Repeat the following until the system percolates:

<ul>
<p><li> Choose a site uniformly at random among all blocked sites.
<p><li> Open the site.
</ul>

<p><li> The fraction of sites that are opened when the system percolates
provides an estimate of the percolation threshold.
</ul>


<p>
For example, if sites are opened in a 20-by-20 lattice according to the snapshots below,
then our estimate of the percolation threshold is 204/400 = 0.51 because the system
percolates when the 204th site is opened.

<p>
<center>
<TABLE BORDER = 0 CELLPADDING =2 CELLSPACING = 0>
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<td><IMG SRC="percolation-50.png" height = 175 alt = "Percolation 50 sites">
<br><center><font size = -1><em>50 open sites</em></font></center>
<td><IMG SRC="percolation-100.png" height = 175 alt = "Percolation 100 sites">
<br><center><font size = -1><em>100 open sites</em></font></center>
<td><IMG SRC="percolation-150.png" height = 175 alt = "Percolation 150 sites">
<br><center><font size = -1><em>150 open sites</em></font></center>
<td><IMG SRC="percolation-204.png" height = 175 alt = "Percolation 204 sites">
<br><center><font size = -1><em>204 open sites</em></font></center>
<!--
<td><IMG SRC="percolation-250.png" height = 175 alt = "Percolation 250 sites">
<br><center><font size = -1><em>250 open sites</em></font></center>
-->
</tr>
</table>
</center>

<p>
By repeating this computation experiment <em>T</em> times and averaging the results,
we obtain a more accurate estimate of the percolation threshold.
Let <em>x<sub>t</sub></em> be the fraction of open sites in computational experiment <em>t</em>.
The sample mean \(\overline x\) provides an estimate of the percolation threshold;
the sample standard deviation <em>s</em>; measures the sharpness of the threshold.


<p>

<blockquote>
<!-- <img src = "percolation-stats.png" alt = "Estimating the sample mean and variance"> -->

\[
\overline x  = \frac{x_1 \, + \, x_2 \, + \, \cdots \, + \, x_{T}}{T},
\quad s^2  = \frac{(x_1 - \overline x )^2 \, + \, (x_2 - \overline x )^2 \,+\, \cdots \,+\, (x_{T} - \overline x )^2}{T-1}
\]

</blockquote>



Assuming <em>T</em> is sufficiently large (say, at least 30), the following
provides a 95% confidence interval for the percolation threshold:

<p>
<blockquote>
<!-- <img src = "percolation-confidence.png" alt = "95% confidence interval for percolation threshold"> -->

\[ 
\left [ \; \overline x  -  \frac {1.96 s}{\sqrt{T}}, \;\;
           \overline x  +  \frac {1.96 s}{\sqrt{T}} \; \right]
\]
</blockquote>

<p>
To perform a series of computational experiments, create a data type <code>PercolationStats</code>
with the following API.

<blockquote>
<pre class = "api">
public class PercolationStats {

    <span class = "comment">// perform independent trials on an n-by-n grid</span>
    public PercolationStats(int n, int trials)

    <span class = "comment">// sample mean of percolation threshold</span>
    public double mean()

    <span class = "comment">// sample standard deviation of percolation threshold</span>
    public double stddev()

    <span class = "comment">// low endpoint of 95% confidence interval</span>
    public double confidenceLo()

    <span class = "comment">// high endpoint of 95% confidence interval</span>
    public double confidenceHi()

   <span class = "comment">// test client (see below)</span>
   public static void main(String[] args)

}
</pre>
</blockquote>

Throw an <code>IllegalArgumentException</code> in the constructor
if either <em>n</em> &le; 0 or <em>trials</em> &le; 0.
<p>
Also, include a <code>main()</code> method
that takes two <em>command-line arguments</em>
<em>n</em> and <em>T</em>, performs <em>T</em> independent
computational experiments (discussed above) on an <em>n</em>-by-<em>n</em> grid,
and prints the sample mean, sample standard deviation, and the 
<em>95% confidence interval</em> for the percolation threshold.
Use
<a href = "https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdRandom.html"><code>StdRandom</code></a>
to generate random numbers; use 
<a href = "https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdStats.html"><code>StdStats</code></a>
to compute the sample mean and sample standard deviation.

<blockquote>
<pre class = "terminal">
<span class = prompt>~/Desktop/percolation&gt;</span> <span class = command>java-algs4 PercolationStats 200 100</span>
mean                    = 0.5929934999999997
stddev                  = 0.00876990421552567
95% confidence interval = [0.5912745987737567, 0.5947124012262428]

<span class = prompt>~/Desktop/percolation&gt;</span> <span class = command>java-algs4 PercolationStats 200 100</span>
mean                    = 0.592877
stddev                  = 0.009990523717073799
95% confidence interval = [0.5909188573514536, 0.5948351426485464]

<span class = prompt>~/Desktop/percolation&gt;</span> <span class = command>java-algs4 PercolationStats 2 10000</span>
mean                    = 0.666925
stddev                  = 0.11776536521033558
95% confidence interval = [0.6646167988418774, 0.6692332011581226]

<span class = prompt>~/Desktop/percolation&gt;</span> <span class = command>java-algs4 PercolationStats 2 100000</span>
mean                    = 0.6669475
stddev                  = 0.11775205263262094
95% confidence interval = [0.666217665216461, 0.6676773347835391]
</pre>
</blockquote>



<p><b>Analysis of running time and memory usage (optional and not graded).</b>
Implement the <code>Percolation</code> data type using the <em>quick find</em> algorithm in
<a href ="https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/QuickFindUF.html"><code>QuickFindUF</code></a>.
<ul>
<p><li>
Use <a href ="https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/Stopwatch.html"><code>Stopwatch</code></a>
to measure the total running time of <code>PercolationStats</code> for various values of
<em>n</em> and <em>T</em>.
How does doubling <em>n</em> affect the total running time?
How does doubling <em>T</em> affect the total running time?
Give a formula (using tilde notation) of the total running
time on your computer (in seconds) as a single function of both
<em>n</em> and <em>T</em>.

<p><li>
Using the 64-bit memory-cost model from lecture,
give the total memory usage in bytes (using tilde notation) that a <code>Percolation</code>
object uses to model an <em>n</em>-by-<em>n</em> percolation system.     
Count all memory that is used, including memory for the union&ndash;find data structure.
</ul>

</ul>

<p>
Now, implement the <code>Percolation</code> data type using the <em>weighted quick union</em> algorithm in
<a href ="https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/WeightedQuickUnionUF.html"><code>WeightedQuickUnionUF</code></a>.
Answer the questions in the previous paragraph.


<p><b>Web submission.</b>
Submit a .zip file containing only
Submit only <code>Percolation.java</code> (using the weighted quick-union algorithm 
from 
<a href ="https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/WeightedQuickUnionUF.html"><code>WeightedQuickUnionUF</code></a>)
and <code>PercolationStats.java</code>.
We will supply <code>algs4.jar</code>.
Your submission may not call library functions except those in
<a href ="https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdIn.html"><code>StdIn</code></a>,
<a href ="https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdOut.html"><code>StdOut</code></a>,
<a href ="https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdRandom.html"><code>StdRandom</code></a>,
<a href ="https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdStats.html"><code>StdStats</code></a>,
<a href ="https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/WeightedQuickUnionUF.html"><code>WeightedQuickUnionUF</code></a>,
and
<code>java.lang</code>.

<p><b>For fun.</b>
Create your own percolation input file and share it in the discussion forums.
For some inspiration, do an image search for “nonogram puzzles solved.”

<p><br>


<ADDRESS><SMALL>
This assignment was developed by Bob Sedgewick and Kevin Wayne.
<br>Copyright &copy; 2008.
</SMALL>
</ADDRESS>

</BODY></HTML>
