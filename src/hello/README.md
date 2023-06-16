

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>


<head>
    <link rel="stylesheet" type="text/css" href="../css/assignments.css">
    <link rel="stylesheet" type="text/css" href="https://algs4.cs.princeton.edu/css/link-icons.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.1/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>
    <title>Programming Assignment 0: Hello, World</title>
</head>

<body class = "specification">


<div id="nav2">
<a href = "specification.php" id="logo"> <img src="logo.png"> Hello, World</a>
<ul id="links">
<li><a href="specification.php" id = "here">Spec</a></li>
<li><a href="faq.php">FAQ</a></li>
<li><a href="hello.zip">Project</a></li>
<li><a href="https://www.coursera.org/learn/algorithms-part1/programming/37IH3/hello/submission" target="_blank">Submit</a></li>
</ul>
</div>

<p>
<br><h3><font color = red>UNDER CONSTRUCTION</font></h3>

<p>
<em>
This assignment is optional.
Its sole purpose is to ensure that you can write simple Java programs,
use <code>algs4.jar</code>, and submit them to the Coursera autograder.</em>


<ol start = 0>

<p><br>
<li><b>Install our Java programming environment (optional).</b>&nbsp;
Install our novice-friendly Java programming environment on your computer
by following these step-by-step instructions for 
<a href = "http://lift.cs.princeton.edu/java/mac">Mac OS X</a>,
<a href = "http://lift.cs.princeton.edu/java/windows">Windows</a>,
or
<a href = "http://lift.cs.princeton.edu/java/linux">Linux</a>.
On each assignment, use the <a href = "hello.zip">Project</a>
from the menu at top.

<p>
As part of these instructions, you will write, compile, and execute
the program
<a href = "https://introcs.cs.princeton.edu/11hello/HelloWorld.java.html">HelloWorld.java</a>.

<blockquote>
<pre class = "terminal">
<span class = prompt>~/Desktop/hello&gt;</span> <span class = command>javac HelloWorld.java</span>

<span class = prompt>~/Desktop/hello&gt;</span> <span class = command>java HelloWorld</span>
Hello, World
</pre>
</blockquote>

<!------------------------------------------------------------------------------------- -->
<p><br>
<li><b>Command-line arguments.</b>
Write a program <tt>HelloGoodbye.java</tt> that takes two names as command-line arguments
and prints hello and goodbye messages as shown below (with the names for the hello message
in the same order as the command-line arguments and with the names for the goodbye message
in reverse order).

<blockquote>
<pre class = "terminal">
<span class = prompt>~/Desktop/hello&gt;</span> <span class = command>javac HelloGoodbye.java</span>

<span class = prompt>~/Desktop/hello&gt;</span> <span class = command>java HelloGoodbye Kevin Bob</span>
Hello Kevin and Bob.
Goodbye Bob and Kevin.

<span class = prompt>~/Desktop/hello&gt;</span> <span class = command>java HelloGoodbye Alejandra Bahati</span>
Hello Alejandra and Bahati.
Goodbye Bahati and Alejandra.
</pre>
</blockquote>


<!------------------------------------------------------------------------------------- -->
<p><br>
<li><b>Using algs4.jar.</b> <font color = red><em>Under construction.</em></font>
Write a program <code>RandomWord.java</code>
that reads a sequence of words from <em>standard input</em>
and prints one of those words uniformly at random.
Do <em>not</em> store the words in an array or list. Instead, use
<em>Knuth’s method</em>: when reading the <em>i</em>th word, select it with probability 
\(1 \,/ \, i\) to be the champion, replacing the previous champion.
After reading all of the words, print the surviving champion.

<blockquote>
<pre class = "terminal">
<span class = prompt>~/Desktop/hello&gt;</span> <span class = command>javac-algs4 RandomWord.java</span>

<span class = prompt>~/Desktop/hello&gt;</span> <span class = command>java-algs4 RandomWord</span>
<span class = command>heads tails</span>
tails

<span class = prompt>~/Desktop/hello&gt;</span> <span class = command>java-algs4 RandomWord</span>
<span class = command>heads tails</span>
heads

<span class = prompt>~/Desktop/hello&gt;</span> <span class = command>more animals8.txt</span>
ant bear cat dog
emu fox goat horse

<span class = prompt>~/Desktop/hello&gt;</span> <span class = command>java-algs4 RandomWord < animals8.txt</span>
emu

<span class = prompt>~/Desktop/hello&gt;</span> <span class = command>java-algs4 RandomWord < animals8.txt</span>
bear
</pre>
</blockquote>

Use the following library functions from
<a href = "https://algs4.cs.princeton.edu/code/algs4.jar"><code>algs4.jar</code></a>:

<ul>
<p><li> <a href = "https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdIn.html#readString--"><code>StdIn.readString()</code></a>:
reads and returns the next string from standard input.

<p><li> <a href = "https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdIn.html#isEmpty--"><code>StdIn.isEmpty()</code></a>:
returns <code>true</code> if there are no more strings available on standard input,
and <code>false</code> otherwise.

<p><li> <a href = "https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdOut.html#println--"><code>StdOut.println()</code></a>:
prints a string and terminating newline to standard output.
It’s also fine to use <code>System.out.println()</code> instead.

<p><li> <a href = "https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdRandom.html#bernoulli-double-"><code>StdRandom.bernoulli(p)</code></a>:
returns <code>true</code> with probability \(p\) and <code>false</code> with probability \(1 - p\).
</ul>

<p>
In order to access these library functions, you must do the following two things:

<ul>
<p><li> Add <code>algs4.jar</code> to the <em>Java classpath</em>.
This typically requires a different mechanism from the command line and the IDE.

<ul>
<p><li>
If you used our autoinstaller, the <em>Bash</em> commands <code>javac-algs4</code>
and <code>java-algs4</code> add <code>algs4.jar</code> to the Java classpath.

<p><li>
If you use <em>IntelliJ</em>,
the supplied <em>IntelliJ</em> project folder includes <code>algs4.jar</code> and 
adds it to the Java classpath.

<p><li>
If you prefer to use some other 
shell (such as <em>Powershell</em> or <em>zsh</em>) or
IDE (such as <em>Eclipse</em> or <em>Netbeans</em>),
that’s fine&mdash;just be sure that you can configure it accordingly.
</ul>


<p><li> Add an <code>import</code> statement like the following at the top of your program:
<blockquote>
<pre>
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
</pre>
</blockquote>
<p>
If you use <em>IntelliJ</em> and the provided project folder,
<em>IntelliJ</em> will automatically add and remove <code>import</code>
statements as needed, so you won’t need to type them.

</ul>

<!------------------------------------------------------------------------------------- -->
</ol>



<p><br><b>Web submission.</b>
Submit a ZIP file containing only <code>HelloWorld.java</code>, <code>HelloGoodbye.java</code>,
and <code>RandomWord.java</code>.
Your submission may not call library functions except those in <code>java.lang</code>
and the ones in <code>algs4.jar</code> enumerated above.

<p><br>


<ADDRESS><SMALL>
This assignment was developed by Bob Sedgewick and Kevin Wayne.
<br>Copyright &copy; 2021.
</SMALL>
</ADDRESS>

</BODY></HTML>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Autograder Feedback</title>
<meta charset="UTF-8">
</head>

<body>

<p>
<em>
See the Assessment Guide for information on how to interpret this report.
</em>
<br><br>

<h2>ASSESSMENT SUMMARY</h2>
<pre>

Compilation:  <font color = #009900>PASSED</font>
API:          <font color = #009900>PASSED</font>

SpotBugs:     <font color = #009900>PASSED</font>
PMD:          <font color = #009900>PASSED</font>
Checkstyle:   <font color = #990000>FAILED (0 errors, 3 warnings)</font>

Correctness:  <font color = #009900>13/13 tests passed</font>
Memory:       <font color = #009900>No tests available for autograding.</font>
Timing:       <font color = #009900>No tests available for autograding.</font>

Aggregate score: 100.00%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 90% ]
</pre>


<br><br>

<h2>ASSESSMENT DETAILS</h2>

<pre>

The following files were submitted:
----------------------------------
213 Mar  2 12:55 HelloGoodbye.java
114 Mar  2 12:55 HelloWorld.java
381 Mar  2 12:55 RandomWord.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac HelloWorld.java
*-----------------------------------------------------------

% javac HelloGoodbye.java
*-----------------------------------------------------------

% javac RandomWord.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
HelloWorld:

HelloGoodbye:

RandomWord:

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
[WARN] HelloGoodbye.java:2:1: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
[WARN] HelloWorld.java:2:1: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
[WARN] RandomWord.java:6:1: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
Checkstyle ends with 0 errors and 3 warnings.

% custom checkstyle checks for HelloWorld.java
*-----------------------------------------------------------

% custom checkstyle checks for HelloGoodbye.java
*-----------------------------------------------------------

% custom checkstyle checks for RandomWord.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of HelloWorld
*-----------------------------------------------------------
Running 2 total tests.

Test 1: check output format of main()
  % java HelloWorld
  Hello, World

==&gt; passed

Test 2: check correctness of main()
  * java HelloWorld
==&gt; passed


HelloWorld Total: 2/2 tests passed!


================================================================
Testing correctness of HelloGoodbye
*-----------------------------------------------------------
Running 6 total tests.

Test 1: check output format of main()
  % java HelloGoodbye Kevin Bob
  Hello Kevin and Bob.
  Goodbye Bob and Kevin.

  % java HelloGoodbye Alejandra Bahati
  Hello Alejandra and Bahati.
  Goodbye Bahati and Alejandra.

==&gt; passed

Test 2: check correctness of main() using names from assignment specification
  * java HelloGoodbye Kevin Bob
  * java HelloGoodbye Alejandra Bahati
==&gt; passed

Test 3: check correctness of main() using fixed names
  * java HelloGoodbye Chandra Deshi
  * java HelloGoodbye Ayşe María
  * java HelloGoodbye Wayan Taiyeo
  * java HelloGoodbye Ástfríður Bedřiška
==&gt; passed

Test 4: check correctness of main() when two names are the same
  * java HelloGoodbye Turing Turing
  * java HelloGoodbye Lovelace Lovelace
  * java HelloGoodbye Hopper Hopper
  * java HelloGoodbye Knuth Knuth
==&gt; passed

Test 5: check correctness of main() using random names
  * java HelloGoodbye Belén Gülsü
  * java HelloGoodbye Naama Kliti
  * java HelloGoodbye Zafeiroula Sanah
  * java HelloGoodbye Magbul Ziba
  * java HelloGoodbye Ileana Edelwald
==&gt; passed

Test 6: test correctness of main() using many random names
  * 10 pairs of random names
  * 100 pairs of random names
  * 1000 pairs of random names
  * 10000 pairs of random names
==&gt; passed


HelloGoodbye Total: 6/6 tests passed!


================================================================
Testing correctness of RandomWord
*-----------------------------------------------------------
Running 5 total tests.

Test 1: check that main() prints exactly one word
  % java-algs4 RandomWord  &lt; animals8.txt
  cat

  % java-algs4 RandomWord  &lt; animals8.txt
  emu

  % java-algs4 RandomWord  &lt; coin.txt
  tails

  % java-algs4 RandomWord  &lt; names.txt
  Tõiv

==&gt; passed

Test 2: check that the first word main() prints appears on standrd input
  * 10000 trials from coin.txt
  * 10000 trials from animals8.txt
  * 10000 trials from animals.txt
  * 10000 trials from colors.txt
  * 10000 trials from algorithms.txt
  * 10000 trials from dream.txt
==&gt; passed

Test 3: check that main() consumes all data from standard input
  * coin.txt
  * animals8.txt
  * animals.txt
  * colors.txt
  * algorithms.txt
  * names.txt
  * dream.txt
==&gt; passed

Test 4: check that main() chooses a word uniformly at random
  * 12000 trials from coin.txt
  * 12000 trials from roshambo.txt
  * 12000 trials from die.txt
  * 12000 trials from animals8.txt
  * 12000 trials from animals25.txt
  * 12000 trials from algorithms.txt
==&gt; passed

Test 5: check that main() chooses a word uniformly at random
        (with some words on standard input repeated)
  * 36000 trials from biased-coin.txt
  * 36000 trials from loaded-die.txt
  * 36000 trials from two-dice.txt
  * 36000 trials from tinyTale.txt
==&gt; passed


RandomWord Total: 5/5 tests passed!


================================================================

</pre>
</body>
</html>

