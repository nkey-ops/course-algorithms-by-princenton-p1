Program in execution

![hippo](https://github.com/nkey-ops/course-algorithms-by-princenton-p1/assets/81760194/4ee9fcc8-a448-49b7-a96d-556e6d489dd6)


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
<br><br>

<h2>ASSESSMENT SUMMARY</h2>
<pre>

Compilation:  <font color = #009900>PASSED (0 errors, 4 warnings)</font>
API:          <font color = #009900>PASSED</font>

SpotBugs:     <font color = #990000>FAILED (1 warning)</font>
PMD:          <font color = #009900>PASSED</font>
Checkstyle:   <font color = #990000>FAILED (0 errors, 24 warnings)</font>

Correctness:  <font color = #009900>49/49 tests passed</font>
Memory:       <font color = #009900>134/133 tests passed</font>
Timing:       <font color = #009900>193/193 tests passed</font>

Aggregate score: 100.08%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 60%, Timing: 10%, Memory: 20% ]
</pre>


<br><br>

<h2>ASSESSMENT DETAILS</h2>

<pre>

The following files were submitted:
----------------------------------
5.0K Mar 28 13:41 Deque.java
 446 Mar 28 13:41 Permutation.java
3.4K Mar 28 13:41 RandomizedQueue.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac Deque.java
*-----------------------------------------------------------

% javac RandomizedQueue.java
*-----------------------------------------------------------
RandomizedQueue.java:8: warning: [unchecked] unchecked cast
	private Item[] data = (Item[]) new Object[1];
	                               ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class RandomizedQueue
RandomizedQueue.java:30: warning: [unchecked] unchecked cast
    		Item[] data2 = (Item[]) new Object[(data.length * 2)];
    		                        ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class RandomizedQueue
RandomizedQueue.java:49: warning: [unchecked] unchecked cast
    		Item[] data2 = (Item[]) new Object[(size &gt; 0 ? size : 1)];
    		                        ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class RandomizedQueue
RandomizedQueue.java:99: warning: [unchecked] unchecked cast
				Item[] items = (Item[]) new Object[size];
				                        ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class RandomizedQueue
4 warnings

% javac Permutation.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
Deque:

RandomizedQueue:

Permutation:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% spotbugs *.class
*-----------------------------------------------------------
M C SUA_SUSPICIOUS_UNINITIALIZED_ARRAY SUA: Method RandomizedQueue$1.init() returns an array that appears not to be initialized  At RandomizedQueue.java:[line 100]
SpotBugs ends with 1 warning.


================================================================


% pmd .
*-----------------------------------------------------------


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] Deque.java:7:1: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
[WARN] Deque.java:32:26: Inner assignments should be avoided. [InnerAssignment]
[WARN] Deque.java:49:26: Inner assignments should be avoided. [InnerAssignment]
[WARN] Deque.java:52:30: Inner assignments should be avoided. [InnerAssignment]
[WARN] Deque.java:67:26: Inner assignments should be avoided. [InnerAssignment]
[WARN] Deque.java:84:26: Inner assignments should be avoided. [InnerAssignment]
[WARN] Deque.java:95:16: Anonymous inner class length is 24 lines (max allowed is 20). [AnonInnerLength]
[WARN] Deque.java:108:36: Are you sure you want an empty statement here? An empty statement might indicate a superfluous semicolon. [EmptyStatement]
[WARN] Permutation.java:6:1: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
[WARN] Permutation.java:8:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Permutation.java:12:9: &#x27;while&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] Permutation.java:17:9: &#x27;while&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] RandomizedQueue.java:8:1: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
[WARN] RandomizedQueue.java:29:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] RandomizedQueue.java:47:9: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] RandomizedQueue.java:48:17: The local (or parameter) variable &#x27;size&#x27; has the same name as an instance variable. Use a different name. [HiddenField]
[WARN] RandomizedQueue.java:76:16: Anonymous inner class length is 40 lines (max allowed is 20). [AnonInnerLength]
[WARN] RandomizedQueue.java:98:34: &#x27;{&#x27; is not preceded with whitespace. [WhitespaceAround]
[WARN] RandomizedQueue.java:100:17: &#x27;if&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] RandomizedQueue.java:102:17: &#x27;for&#x27; is not followed by whitespace. [WhitespaceAfter]
[WARN] RandomizedQueue.java:102:45: &#x27;;&#x27; is preceded with whitespace. [NoWhitespaceBefore]
[WARN] RandomizedQueue.java:102:51: &#x27;)&#x27; is preceded with whitespace. [ParenPad]
Checkstyle ends with 0 errors and 22 warnings.

% custom checkstyle checks for Deque.java
*-----------------------------------------------------------

% custom checkstyle checks for RandomizedQueue.java
*-----------------------------------------------------------
[WARN] RandomizedQueue.java:29:35: The numeric literal &#x27;0.75&#x27; appears to be unnecessary. [NumericLiteral]
[WARN] RandomizedQueue.java:47:43: The numeric literal &#x27;0.40&#x27; appears to be unnecessary. [NumericLiteral]
Checkstyle ends with 0 errors and 2 warnings.

% custom checkstyle checks for Permutation.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of Deque
*-----------------------------------------------------------
Running 19 total tests.

Tests 1-8 make random intermixed calls to addFirst(), addLast(),
removeFirst(), removeLast(), isEmpty(), and size(), and iterator().
The probabilities of each operation are (p1, p2, p3, p4, p5, p6, p7),
respectively.

Test 1: check random calls to addFirst(), addLast(), and size()
  *    5 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2, 0.0)
  *   50 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2, 0.0)
  *  500 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2, 0.0)
  * 1000 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2, 0.0)
==&gt; passed

Test 2: check random calls to addFirst(), removeFirst(), and isEmpty()
  *    5 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0, 0.0)
  *   50 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0, 0.0)
  *  500 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0, 0.0)
  * 1000 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0, 0.0)
  *    5 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0, 0.0)
  *   50 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0, 0.0)
  *  500 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0, 0.0)
  * 1000 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0, 0.0)
==&gt; passed

Test 3: check random calls to addFirst(), removeLast(), and isEmpty()
  *    5 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0, 0.0)
  *   50 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0, 0.0)
  *  500 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0, 0.0)
  * 1000 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0, 0.0)
  *    5 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0, 0.0)
  *   50 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0, 0.0)
  *  500 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0, 0.0)
  * 1000 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0, 0.0)
==&gt; passed

Test 4: check random calls to addLast(), removeLast(), and isEmpty()
  *    5 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0, 0.0)
  *   50 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0, 0.0)
  *  500 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0, 0.0)
  * 1000 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0, 0.0)
  *    5 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0, 0.0)
  *   50 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0, 0.0)
  *  500 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0, 0.0)
  * 1000 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0, 0.0)
==&gt; passed

Test 5: check random calls to addLast(), removeFirst(), and isEmpty()
  *    5 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0, 0.0)
  *   50 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0, 0.0)
  *  500 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0, 0.0)
  * 1000 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0, 0.0)
  *    5 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0, 0.0)
  *   50 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0, 0.0)
  *  500 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0, 0.0)
  * 1000 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0, 0.0)
==&gt; passed

Test 6: check random calls to addFirst(), removeFirst(), and iterator()
  *    5 random calls (0.8, 0.0, 0.1, 0.0, 0.0, 0.0, 0.1)
  *   50 random calls (0.8, 0.0, 0.1, 0.0, 0.0, 0.0, 0.1)
  *  500 random calls (0.8, 0.0, 0.1, 0.0, 0.0, 0.0, 0.1)
  * 1000 random calls (0.8, 0.0, 0.1, 0.0, 0.0, 0.0, 0.1)
  *    5 random calls (0.1, 0.0, 0.8, 0.0, 0.0, 0.0, 0.1)
  *   50 random calls (0.1, 0.0, 0.8, 0.0, 0.0, 0.0, 0.1)
  *  500 random calls (0.1, 0.0, 0.8, 0.0, 0.0, 0.0, 0.1)
  * 1000 random calls (0.1, 0.0, 0.8, 0.0, 0.0, 0.0, 0.1)
==&gt; passed

Test 7: check random calls to all methods except iterator()
  *    5 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1, 0.0)
  *   50 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1, 0.0)
  *  500 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1, 0.0)
  * 1000 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1, 0.0)
  *    5 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1, 0.0)
  *   50 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1, 0.0)
  *  500 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1, 0.0)
  * 1000 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1, 0.0)
==&gt; passed

Test 8: check random calls to all methods, including iterator()
  *    5 random calls (0.2, 0.2, 0.1, 0.1, 0.1, 0.1, 0.2)
  *   50 random calls (0.2, 0.2, 0.1, 0.1, 0.1, 0.1, 0.2)
  *  500 random calls (0.2, 0.2, 0.1, 0.1, 0.1, 0.1, 0.2)
  * 1000 random calls (0.2, 0.2, 0.1, 0.1, 0.1, 0.1, 0.2)
  *    5 random calls (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.2)
  *   50 random calls (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.2)
  *  500 random calls (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.2)
  * 1000 random calls (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.2)
==&gt; passed

Test 9: check removeFirst() and removeLast() from an empty deque
  * removeFirst()
  * removeLast()
==&gt; passed

Test 10: check whether two Deque objects can be created at the same time
  * n = 10
  * n = 1000
==&gt; passed

Test 11: check iterator() after n calls to addFirst()
  * n = 10
  * n = 50
==&gt; passed

Test 12: check iterator() after random calls to addFirst(), addLast(),
         removeFirst(), and removeLast() with probabilities (p1, p2, p3, p4)
  * 20 random operations (0.8, 0.0, 0.2, 0.0)
  * 20 random operations (0.8, 0.0, 0.0, 0.2)
  * 20 random operations (0.0, 0.8, 0.0, 0.2)
  * 20 random operations (0.0, 0.8, 0.2, 0.0)
  * 20 random operations (0.4, 0.4, 0.1, 0.1)
  * 20 random operations (0.2, 0.0, 0.8, 0.0)
  * 20 random operations (0.2, 0.0, 0.0, 0.8)
  * 20 random operations (0.0, 0.2, 0.0, 0.8)
  * 20 random operations (0.0, 0.2, 0.8, 0.0)
  * 20 random operations (0.1, 0.1, 0.4, 0.4)
  * 100 random operations (0.4, 0.4, 0.1, 0.1)
  * 1000 random operations (0.4, 0.4, 0.1, 0.1)
==&gt; passed

Test 13: create two nested iterators to same deque of size n
  * n = 10
  * n = 50
==&gt; passed

Test 14: create two parallel iterators to same deque of size n
  * n = 10
  * n = 50
==&gt; passed

Test 15: create an iterator and check calls to next() and hasNext()
  * 10 consecutive calls to hasNext() on a deque of size 10
  * 10 consecutive calls to next() on a deque of size 10
  * 50 random intermixed calls to next() and hasNext() on a deque of size 10
  * 1000 random intermixed calls to next() and hasNext() on a deque of size 100
==&gt; passed

Test 16: create Deque objects of different parameterized types
==&gt; passed

Test 17: call addFirst() and addLast() with null argument
==&gt; passed

Test 18: check that remove() and next() throw the specified exceptions in iterator()
==&gt; passed

Test 19: call iterator() when the deque is empty
==&gt; passed


Total: 19/19 tests passed!


================================================================
Testing correctness of RandomizedQueue
*-----------------------------------------------------------
Running 21 total tests.

Tests 1-6 make random intermixed calls to enqueue(), dequeue(), sample(),
isEmpty(), size(), and iterator(). The probabilities of each operation
are (p1, p2, p3, p4, p5, p6), respectively.

Test 1: check random calls to enqueue() and size()
  *    5 random calls (0.8, 0.0, 0.0, 0.0, 0.2, 0.0)
  *   50 random calls (0.8, 0.0, 0.0, 0.0, 0.2, 0.0)
  *  500 random calls (0.8, 0.0, 0.0, 0.0, 0.2, 0.0)
  * 1000 random calls (0.8, 0.0, 0.0, 0.0, 0.2, 0.0)
==&gt; passed

Test 2: check random calls to enqueue() and dequeue()
  *    5 random calls (0.7, 0.1, 0.0, 0.1, 0.1, 0.0)
  *   50 random calls (0.7, 0.1, 0.0, 0.1, 0.1, 0.0)
  *  500 random calls (0.7, 0.1, 0.0, 0.1, 0.1, 0.0)
  * 1000 random calls (0.7, 0.1, 0.0, 0.1, 0.1, 0.0)
  *    5 random calls (0.1, 0.7, 0.0, 0.1, 0.1, 0.0)
  *   50 random calls (0.1, 0.7, 0.0, 0.1, 0.1, 0.0)
  *  500 random calls (0.1, 0.7, 0.0, 0.1, 0.1, 0.0)
  * 1000 random calls (0.1, 0.7, 0.0, 0.1, 0.1, 0.0)
==&gt; passed

Test 3: check random calls to enqueue() and sample()
  *    5 random calls (0.8, 0.0, 0.2, 0.0, 0.0, 0.0)
  *   50 random calls (0.8, 0.0, 0.2, 0.0, 0.0, 0.0)
  *  500 random calls (0.8, 0.0, 0.2, 0.0, 0.0, 0.0)
  * 1000 random calls (0.8, 0.0, 0.2, 0.0, 0.0, 0.0)
  *    5 random calls (0.2, 0.0, 0.8, 0.0, 0.0, 0.0)
  *   50 random calls (0.2, 0.0, 0.8, 0.0, 0.0, 0.0)
  *  500 random calls (0.2, 0.0, 0.8, 0.0, 0.0, 0.0)
  * 1000 random calls (0.2, 0.0, 0.8, 0.0, 0.0, 0.0)
==&gt; passed

Test 4: check random calls to enqueue() and iterator()
  *    5 random calls (0.8, 0.0, 0.0, 0.0, 0.0, 0.2)
  *   50 random calls (0.8, 0.0, 0.0, 0.0, 0.0, 0.2)
  *  500 random calls (0.8, 0.0, 0.0, 0.0, 0.0, 0.2)
  * 1000 random calls (0.8, 0.0, 0.0, 0.0, 0.0, 0.2)
==&gt; passed

Test 5: check random calls to all methods except iterator()
  *    5 random calls (0.6, 0.1, 0.1, 0.1, 0.1, 0.0)
  *   50 random calls (0.6, 0.1, 0.1, 0.1, 0.1, 0.0)
  *  500 random calls (0.6, 0.1, 0.1, 0.1, 0.1, 0.0)
  * 1000 random calls (0.6, 0.1, 0.1, 0.1, 0.1, 0.0)
  *    5 random calls (0.1, 0.6, 0.1, 0.1, 0.1, 0.0)
  *   50 random calls (0.1, 0.6, 0.1, 0.1, 0.1, 0.0)
  *  500 random calls (0.1, 0.6, 0.1, 0.1, 0.1, 0.0)
  * 1000 random calls (0.1, 0.6, 0.1, 0.1, 0.1, 0.0)
==&gt; passed

Test 6: check random calls to all methods, including iterator()
  *    5 random calls (0.5, 0.1, 0.1, 0.1, 0.1, 0.1)
  *   50 random calls (0.5, 0.1, 0.1, 0.1, 0.1, 0.1)
  *  500 random calls (0.5, 0.1, 0.1, 0.1, 0.1, 0.1)
  * 1000 random calls (0.5, 0.1, 0.1, 0.1, 0.1, 0.1)
  *    5 random calls (0.1, 0.5, 0.1, 0.1, 0.1, 0.1)
  *   50 random calls (0.1, 0.5, 0.1, 0.1, 0.1, 0.1)
  *  500 random calls (0.1, 0.5, 0.1, 0.1, 0.1, 0.1)
  * 1000 random calls (0.1, 0.5, 0.1, 0.1, 0.1, 0.1)
==&gt; passed

Test 7: call dequeue() and sample() from an empty randomized queue
  * dequeue()
  * sample()
==&gt; passed

Test 8: create multiple randomized queue objects at the same time
  * n = 10
  * n = 100
==&gt; passed

Test 9: check that iterator() returns correct items after a sequence
        of n enqueue() operations
  * n = 10
  * n = 50
==&gt; passed

Test 10: check that iterator() returns correct items after intermixed
         sequence of m enqueue() and dequeue() operations
  * m = 10
  * m = 1000
==&gt; passed

Test 11: create two nested iterators over the same randomized queue of size n
  * n = 10
  * n = 50
==&gt; passed

Test 12: create two parallel iterators over the same randomized queue of size n
  * n = 10
  * n = 50
==&gt; passed

Test 13: create two iterators over different randomized queues,
         each of length 10
==&gt; passed

Test 14: create an iterator and check calls to next() and hasNext()
  * 10 consecutive calls to hasNext() on a deque of size 10
  * 10 consecutive calls to next() on a deque of size 10
  * 50 random intermixed calls to next() and hasNext() on a deque of size 10
  * 1000 random intermixed calls to next() and hasNext() on a deque of size 100
==&gt; passed

Test 15: create RandomizedQueue objects of different parameterized types
==&gt; passed

Test 16: check randomness of sample() by enqueueing n items, repeatedly calling
         sample(), and counting the frequency of each item
  * n = 3, trials = 12000
  * n = 5, trials = 12000
  * n = 8, trials = 12000
  * n = 10, trials = 12000
==&gt; passed

Test 17: check randomness of dequeue() by enqueueing n items, dequeueing n items,
         and seeing whether each of the n! permutations is equally likely
  * n = 2, trials = 12000
  * n = 3, trials = 12000
  * n = 4, trials = 12000
  * n = 5, trials = 12000
==&gt; passed

Test 18: check randomness of iterator() by enqueueing n items, iterating over those
         n items, and seeing whether each of the n! permutations is equally likely
  * n = 2, trials = 12000
  * n = 3, trials = 12000
  * n = 4, trials = 12000
  * n = 5, trials = 12000
==&gt; passed

Test 19: call enqueue() with a null argument
==&gt; passed

Test 20: check that remove() and next() throw the specified exceptions in iterator()
==&gt; passed

Test 21: call iterator() when randomized queue is empty
==&gt; passed


Total: 21/21 tests passed!


================================================================
********************************************************************************
*  TESTING CORRECTNESS (substituting reference RandomizedQueue and Deque)
********************************************************************************

Testing correctness of Permutation
*-----------------------------------------------------------
Tests 1-5 call the main() function directly, resetting standard input
before each call.

Running 9 total tests.

Test 1a: check formatting for sample inputs from assignment specification
  % java Permutation 3 &lt; distinct.txt
  C
  B
  F

  % java Permutation 3 &lt; distinct.txt
  D
  G
  H

  % java Permutation 8 &lt; duplicates.txt
  BB
  CC
  BB
  CC
  BB
  BB
  AA
  BB

==&gt; passed

Test 1b: check formatting for other inputs
  % java Permutation 8 &lt; mediumTale.txt
  times
  the
  it
  was
  the
  foolishness
  the
  times

  % java Permutation 0 &lt; distinct.txt
  [no output]

==&gt; passed

Test 2: check that main() reads all data from standard input
  * filename = distinct.txt, k = 3
  * filename = distinct.txt, k = 3
  * filename = duplicates.txt, k = 8
  * filename = mediumTale.txt, k = 8
==&gt; passed

Test 3a: check that main() prints each item from the sequence at most once
         (for inputs with no duplicate strings)
  * filename = distinct.txt, k = 3
  * filename = distinct.txt, k = 1
  * filename = distinct.txt, k = 9
  * filename = permutation6.txt, k = 6
  * filename = permutation10.txt, k = 10
==&gt; passed

Test 3b: check that main() prints each item from the sequence at most once
         (for inputs with duplicate strings)
  * filename = duplicates.txt, k = 8
  * filename = duplicates.txt, k = 3
  * filename = permutation8.txt, k = 6
  * filename = permutation8.txt, k = 2
  * filename = tinyTale.txt, k = 10
==&gt; passed

Test 3c: check that main() prints each item from the sequence at most once
         (for inputs with newlines)
  * filename = mediumTale.txt, k = 10
  * filename = mediumTale.txt, k = 20
  * filename = tale.txt, k = 10
  * filename = tale.txt, k = 50
==&gt; passed

Test 4: check main() when k = 0
  * filename = distinct.txt, k = 0
  * filename = distinct.txt, k = 0
==&gt; passed

Test 5a: check that permutations are uniformly random
         (for inputs with no duplicate strings)
  * filename = permutation4.txt, k = 1
  * filename = permutation4.txt, k = 2
  * filename = permutation4.txt, k = 3
  * filename = permutation4.txt, k = 4
  * filename = permutation6.txt, k = 2
==&gt; passed

Test 5b: check that permutations are uniformly random
         (for inputs with duplicate strings)
  * filename = permutation5.txt, k = 1
  * filename = permutation5.txt, k = 2
  * filename = permutation5.txt, k = 3
  * filename = duplicates.txt, k = 3
  * filename = permutation8.txt, k = 2
==&gt; passed

Total: 9/9 tests passed!


================================================================
********************************************************************************
*  TIMING (substituting reference RandomizedQueue and Deque)
********************************************************************************

Timing Permutation
*-----------------------------------------------------------
Running 23 total tests.

Test 1: count calls to methods in StdIn
  * java Permutation 5 &lt; distinct.txt
  * java Permutation 10 &lt; permutation10.txt
  * java Permutation 1 &lt; mediumTale.txt
  * java Permutation 20 &lt; tale.txt
  * java Permutation 100 &lt; tale.txt
  * java Permutation 16412 &lt; tale.txt
==&gt; passed

Test 2: count calls to methods in Deque and RandomizedQueue
  * java Permutation 5 &lt; distinct.txt
  * java Permutation 10 &lt; permutation10.txt
  * java Permutation 1 &lt; mediumTale.txt
  * java Permutation 20 &lt; tale.txt
  * java Permutation 100 &lt; tale.txt
  * java Permutation 16412 &lt; tale.txt
==&gt; passed

Test 3: count calls to methods in StdRandom
  * java Permutation 5 &lt; distinct.txt
  * java Permutation 10 &lt; permutation10.txt
  * java Permutation 1 &lt; mediumTale.txt
  * java Permutation 20 &lt; tale.txt
  * java Permutation 100 &lt; tale.txt
  * java Permutation 16412 &lt; tale.txt
==&gt; passed

Test 4: Time main() with k = 5, for inputs containing n random strings

                    n  seconds
------------------------------
=&gt; passed        1000     0.00
=&gt; passed        2000     0.00
=&gt; passed        4000     0.00
=&gt; passed        8000     0.00
=&gt; passed       16000     0.01
=&gt; passed       32000     0.01
=&gt; passed       64000     0.02
=&gt; passed      128000     0.04
=&gt; passed      256000     0.08
=&gt; passed      512000     0.16
==&gt; 10/10 tests passed


Test 5: Time main() with k = 1000, for inputs containing n random strings

                    n  seconds
------------------------------
=&gt; passed        1000     0.00
=&gt; passed        2000     0.00
=&gt; passed        4000     0.00
=&gt; passed        8000     0.00
=&gt; passed       16000     0.01
=&gt; passed       32000     0.01
=&gt; passed       64000     0.02
=&gt; passed      128000     0.04
=&gt; passed      256000     0.08
=&gt; passed      512000     0.16
==&gt; 10/10 tests passed


Total: 23/23 tests passed!


================================================================



********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Permutation
*-----------------------------------------------------------
Running 2 total tests.

Test 1: check that only one Deque or RandomizedQueue object is created
  * filename = distinct.txt, n = 9, k = 1
  * filename = distinct.txt, n = 9, k = 2
  * filename = distinct.txt, n = 9, k = 4
  * filename = tinyTale.txt, n = 12, k = 10
  * filename = tale.txt, n = 138653, k = 50
==&gt; passed

Test 2: check that the maximum size of any Deque or RandomizedQueue object
        created is between k and n
  * filename = distinct.txt, n = 9, k = 1
  * filename = distinct.txt, n = 9, k = 2
  * filename = distinct.txt, n = 9, k = 4
  * filename = tinyTale.txt, n = 12, k = 10
  * filename = tale.txt, n = 138653, k = 5
  * filename = tale.txt, n = 138653, k = 50
  * filename = tale.txt, n = 138653, k = 500
  * filename = tale.txt, n = 138653, k = 5000
  * filename = tale.txt, n = 138653, k = 50000
==&gt; passed

Test 3 (bonus): check that maximum size of any or Deque or RandomizedQueue object
                created is equal to k
  * filename = tale.txt, n = 138653, k = 5
    - max size of RandomizedQueue object = 138653

  * filename = tale.txt, n = 138653, k = 50
    - max size of RandomizedQueue object = 138653

  * filename = tale.txt, n = 138653, k = 500
    - max size of RandomizedQueue object = 138653

  * filename = tale.txt, n = 138653, k = 5000
    - max size of RandomizedQueue object = 138653

  * filename = tale.txt, n = 138653, k = 50000
    - max size of RandomizedQueue object = 138653

==&gt; <font color = #990000><b>FAILED</b></font>

Total: 2/2 tests passed!


================================================================



********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Deque
*-----------------------------------------------------------
For tests 1-4, the maximum amount of memory allowed for a Deque
containing n items is 48n + 192.

Running 49 total tests.

Test 1a-1i: total memory usage after inserting n items,
            where n is a power of 2

                 n        bytes
----------------------------------------------------------
=&gt; passed       32         1320         
=&gt; passed       64         2600         
=&gt; passed      128         5160         
=&gt; passed      256        10280         
=&gt; passed      512        20520         
=&gt; passed     1024        41000         
=&gt; passed     2048        81960         
=&gt; passed     4096       163880         
=&gt; passed     8192       327720         
==&gt; 9/9 tests passed

Memory: 40.00 n + 40.00   (R^2 = 1.000)


Test 2a-2i: Total memory usage after inserting n items,
            when n is one more than a power of 2.

                 n        bytes
----------------------------------------------------------
=&gt; passed       33         1360         
=&gt; passed       65         2640         
=&gt; passed      129         5200         
=&gt; passed      257        10320         
=&gt; passed      513        20560         
=&gt; passed     1025        41040         
=&gt; passed     2049        82000         
=&gt; passed     4097       163920         
=&gt; passed     8193       327760         
==&gt; 9/9 tests passed

Memory: 40.00 n + 40.00   (R^2 = 1.000)


Test 3a-3i: Total memory usage after inserting 2n-1 items, and then
            deleting n-1 items, when n is one more than a power of 2.

                 n        bytes
----------------------------------------------------------
=&gt; passed       33         1360         
=&gt; passed       65         2640         
=&gt; passed      129         5200         
=&gt; passed      257        10320         
=&gt; passed      513        20560         
=&gt; passed     1025        41040         
=&gt; passed     2049        82000         
=&gt; passed     4097       163920         
=&gt; passed     8193       327760         
==&gt; 9/9 tests passed

Memory: 40.00 n + 40.00   (R^2 = 1.000)


Test 4a-4e: Total memory usage after inserting n items,
            and then deleting all but one item
            (should not grow with n or be too large of a constant).

                 n        bytes
----------------------------------------------------------
=&gt; passed       32           80         
=&gt; passed       64           80         
=&gt; passed      128           80         
=&gt; passed      256           80         
=&gt; passed      512           80         
=&gt; passed     1024           80         
=&gt; passed     2048           80         
=&gt; passed     4096           80         
=&gt; passed     8192           80         
==&gt; 9/9 tests passed

Memory: 80.00   (R^2 = 1.000)


Test 5a-5e: Total memory usage of iterator after inserting n items
            (should not grow with n or be too large of a constant).

                 n        bytes
----------------------------------------------------------
=&gt; passed       32           32         
=&gt; passed       64           32         
=&gt; passed      128           32         
=&gt; passed      256           32         
=&gt; passed      512           32         
=&gt; passed     1024           32         
=&gt; passed     2048           32         
=&gt; passed     4096           32         
=&gt; passed     8192           32         
==&gt; 9/9 tests passed

Memory: 32.00   (R^2 = 1.000)


Test 6a: Insert n strings; delete them one at a time, checking for
         loitering after each deletion. The probabilities of addFirst()
         and addLast() are (p1, p2), respectively. The probabilities of
         removeFirst() and removeLast() are (q1, q2), respectively.
  * 100 random insertions (1.0, 0.0) and 100 random deletions (1.0, 0.0)
  * 100 random insertions (1.0, 0.0) and 100 random deletions (0.0, 1.0)
  * 100 random insertions (0.0, 1.0) and 100 random deletions (1.0, 0.0)
  * 100 random insertions (0.0, 1.0) and 100 random deletions (0.0, 1.0)
  * 100 random insertions (0.5, 0.5) and 100 random deletions (0.5, 0.5)
==&gt; passed

Test 6b: Perform random operations, checking for loitering after
         each operation. The probabilities of addFirst(), addLast(),
         removeFirst(), and removeLast() are (p1, p2, p3, p4),
         respectively.
  * 100 random operations (0.8, 0.0, 0.2, 0.0)
  * 100 random operations (0.8, 0.0, 0.0, 0.2)
  * 100 random operations (0.0, 0.8, 0.2, 0.0)
  * 100 random operations (0.0, 0.8, 0.0, 0.2)
  * 100 random operations (0.4, 0.4, 0.1, 0.1)
  * 100 random operations (0.2, 0.2, 0.3, 0.3)
==&gt; passed

Test 7: Perform m random add/remove operations in the deque and check
        that only constant memory is allocated/deallocated per operation
  * m = 128
  * m = 256
  * m = 512
==&gt; passed

Test 8: Insert m items into deque; then iterate over deque and check
        that only constant memory is allocated/deallocated per operation
  * m = 64
  * m = 128
  * m = 256
==&gt; passed

Test 9 (bonus): Uses at most 40n + 40 bytes of memory
==&gt; passed


Min observed memory for Deque: 40.00 n + 40.00   (R^2 = 1.000)
Max observed memory for Deque: 40.00 n + 40.00   (R^2 = 1.000)

Total: 50/49 tests passed!


================================================================



Analyzing memory of RandomizedQueue
*-----------------------------------------------------------
For Tests 1-5, the maximum amount of memory allowed for
a RandomizedQueue containing n items is 48n + 192.

For Test 6, the maximum amount of memory allowed for
a RandomizedQueue iterator over n items is 8n + 72.

Test 1a-1i: Total memory usage after inserting n items
            when n is a power of 2.

                 n        bytes
----------------------------------------------------------
=&gt; passed       32          568         
=&gt; passed       64         1080         
=&gt; passed      128         2104         
=&gt; passed      256         4152         
=&gt; passed      512         8248         
=&gt; passed     1024        16440         
=&gt; passed     2048        32824         
=&gt; passed     4096        65592         
=&gt; passed     8192       131128         
==&gt; 9/9 tests passed

Memory: 16.00 n + 56.00   (R^2 = 1.000)


Test 2a-2i: Total memory usage after inserting n items,
            when n is one more than a power of 2.

                 n        bytes
----------------------------------------------------------
=&gt; passed       33          568         
=&gt; passed       65         1080         
=&gt; passed      129         2104         
=&gt; passed      257         4152         
=&gt; passed      513         8248         
=&gt; passed     1025        16440         
=&gt; passed     2049        32824         
=&gt; passed     4097        65592         
=&gt; passed     8193       131128         
==&gt; 9/9 tests passed

Memory: 16.00 n + 40.00   (R^2 = 1.000)


Test 3a-3i: Total memory usage after inserting 2n-1 items, and then
            deleting n-1 items, when n is one more than a power of 2.

                 n        bytes
----------------------------------------------------------
=&gt; passed       33          568         
=&gt; passed       65         1080         
=&gt; passed      129         2104         
=&gt; passed      257         4152         
=&gt; passed      513         8248         
=&gt; passed     1025        16440         
=&gt; passed     2049        32824         
=&gt; passed     4097        65592         
=&gt; passed     8193       131128         
==&gt; 9/9 tests passed

Memory: 16.00 n + 40.00   (R^2 = 1.000)


Test 4a-4i: Total memory usage after inserting n items, deleting n items,
            then inserting n times, when n is a power of 2.

                 n        bytes
----------------------------------------------------------
=&gt; passed       32          568         
=&gt; passed       64         1080         
=&gt; passed      128         2104         
=&gt; passed      256         4152         
=&gt; passed      512         8248         
=&gt; passed     1024        16440         
=&gt; passed     2048        32824         
=&gt; passed     4096        65592         
=&gt; passed     8192       131128         
==&gt; 9/9 tests passed

Memory: 16.00 n + 56.00   (R^2 = 1.000)


Test 5a-5i: Total memory usage after inserting n items,
            and then deleting all but one item.

                 n        bytes
----------------------------------------------------------
=&gt; passed       32           88         
=&gt; passed       64           88         
=&gt; passed      128           88         
=&gt; passed      256           88         
=&gt; passed      512           88         
=&gt; passed     1024           88         
=&gt; passed     2048           88         
=&gt; passed     4096           88         
=&gt; passed     8192           88         
==&gt; 9/9 tests passed

Memory: 88.00   (R^2 = 1.000)


Test 6a-6i: Total memory usage of iterator after inserting n items.

                 n        bytes
----------------------------------------------------------
=&gt; passed       32          320         
=&gt; passed       64          576         
=&gt; passed      128         1088         
=&gt; passed      256         2112         
=&gt; passed      512         4160         
=&gt; passed     1024         8256         
=&gt; passed     2048        16448         
=&gt; passed     4096        32832         
=&gt; passed     8192        65600         
==&gt; 9/9 tests passed

Memory: 8.00 n + 64.00   (R^2 = 1.000)


Test 6j-6r: Total memory usage of iterator after inserting n items.

                 n        bytes
----------------------------------------------------------
=&gt; passed       34          336         
=&gt; passed       66          592         
=&gt; passed      130         1104         
=&gt; passed      258         2128         
=&gt; passed      514         4176         
=&gt; passed     1026         8272         
=&gt; passed     2050        16464         
=&gt; passed     4098        32848         
=&gt; passed     8194        65616         
==&gt; 9/9 tests passed

Memory: 8.00 n + 64.00   (R^2 = 1.000)


Test 7a: Insert 100 strings; delete them one at a time, checking
         for loitering after each deletion.
==&gt; passed

Test 7b: Perform random operations, checking for loitering after
         each operation. The probabilities of enqueue(), dequeue(),
         and sample() are (p1, p2, p3), respectively.
  * 200 random operations (0.8, 0.2, 0.0)
  * 200 random operations (0.2, 0.8, 0.0)
  * 200 random operations (0.6, 0.2, 0.2)
  * 200 random operations (0.2, 0.4, 0.4)
==&gt; passed

Test 8: Insert m items into queue; then iterate over deque and check
        that only constant memory is allocated/deallocated per operation
  * m = 64
  * m = 128
  * m = 256
==&gt; passed

Test 9: Total memory usage after inserting n items, seeking to identify
        values of n where memory usage is minimized as a function of n.

                 n        bytes
----------------------------------------------------------
=&gt; passed       48          568         
=&gt; passed       96         1080         
=&gt; passed      192         2104         
=&gt; passed      384         4152         
=&gt; passed      768         8248         
=&gt; passed     1536        16440         
=&gt; passed     3072        32824         
==&gt; 7/7 tests passed

Memory: 10.67 n + 56.00   (R^2 = 1.000)


Test 10: Total memory usage after inserting 4096 items, then successively
         deleting items, seeking values of n where memory usage is maximized
         as a function of n

                 n        bytes
----------------------------------------------------------
=&gt; passed     3276        65592         
=&gt; passed     1638        32824         
=&gt; passed      819        16440         
=&gt; passed      409         8248         
=&gt; passed      204         4152         
=&gt; passed      102         2104         
=&gt; passed       51         1080         
=&gt; passed       25          568         
=&gt; passed       12          312         
==&gt; 9/9 tests passed

Memory: 20.03 n + 65.91   (R^2 = 1.000)


Min observed memory for RandomizedQueue: 10.67 n + 56.00   (R^2 = 1.000)
Max observed memory for RandomizedQueue: 20.03 n + 65.91   (R^2 = 1.000)

Running 82 total tests.

Total: 82/82 tests passed!


================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing Deque
*-----------------------------------------------------------
Running 103 total tests.

Test 1a-1k: make n calls to addFirst() followed by n calls to removeFirst()
                    n  seconds
----------------------------------
=&gt; passed        1024     0.00
=&gt; passed        2048     0.00
=&gt; passed        4096     0.00
=&gt; passed        8192     0.00
=&gt; passed       16384     0.00
=&gt; passed       32768     0.00
=&gt; passed       65536     0.00
=&gt; passed      128000     0.00
=&gt; passed      256000     0.00
=&gt; passed      512000     0.01
=&gt; passed     1024000     0.02
==&gt; 11/11 tests passed


Test 2a-2k: make n calls to addLast() followed by n calls to removeLast()
                    n  seconds
----------------------------------
=&gt; passed        1024     0.00
=&gt; passed        2048     0.00
=&gt; passed        4096     0.00
=&gt; passed        8192     0.00
=&gt; passed       16384     0.00
=&gt; passed       32768     0.00
=&gt; passed       65536     0.00
=&gt; passed      128000     0.00
=&gt; passed      256000     0.00
=&gt; passed      512000     0.01
=&gt; passed     1024000     0.01
==&gt; 11/11 tests passed


Test 3a-3k: make n calls to addFirst() followed by n calls to removeLast()
                    n  seconds
----------------------------------
=&gt; passed        1024     0.00
=&gt; passed        2048     0.00
=&gt; passed        4096     0.00
=&gt; passed        8192     0.00
=&gt; passed       16384     0.00
=&gt; passed       32768     0.00
=&gt; passed       65536     0.00
=&gt; passed      128000     0.00
=&gt; passed      256000     0.00
=&gt; passed      512000     0.01
=&gt; passed     1024000     0.02
==&gt; 11/11 tests passed


Test 4a-4k: make n calls to addLast() followed by n calls to removeFirst()
                    n  seconds
----------------------------------
=&gt; passed        1024     0.00
=&gt; passed        2048     0.00
=&gt; passed        4096     0.00
=&gt; passed        8192     0.00
=&gt; passed       16384     0.00
=&gt; passed       32768     0.00
=&gt; passed       65536     0.00
=&gt; passed      128000     0.00
=&gt; passed      256000     0.00
=&gt; passed      512000     0.01
=&gt; passed     1024000     0.01
==&gt; 11/11 tests passed


Test 5a-5g: make n random calls to addFirst(), removeFirst(), isEmpty(), and size()
            with probabilities (0.7, 0.1, 0.1, 0.1)

                    n  seconds
------------------------------
=&gt; passed        1024     0.00
=&gt; passed        2048     0.00
=&gt; passed        4096     0.00
=&gt; passed        8192     0.00
=&gt; passed       16384     0.00
=&gt; passed       32768     0.00
=&gt; passed       65536     0.00
=&gt; passed      128000     0.00
=&gt; passed      256000     0.01
=&gt; passed      512000     0.01
=&gt; passed     1024000     0.03
=&gt; passed     2048000     0.06
==&gt; 12/12 tests passed


Test 6a-6g: make n random calls to addLast(), removeLast(), isEmpty(), and size(),
            with probabilities (0.7, 0.1, 0.1, 0.1)

                    n  seconds
------------------------------
=&gt; passed        1024     0.00
=&gt; passed        2048     0.00
=&gt; passed        4096     0.00
=&gt; passed        8192     0.00
=&gt; passed       16384     0.00
=&gt; passed       32768     0.00
=&gt; passed       65536     0.00
=&gt; passed      128000     0.00
=&gt; passed      256000     0.01
=&gt; passed      512000     0.02
=&gt; passed     1024000     0.03
=&gt; passed     2048000     0.07
==&gt; 12/12 tests passed


Test 7a-7g: make n random calls to addFirst(), addLast(), removeFirst(), removeLast(),
            isEmpty(), and size() with probabilities (0.3, 0.3, 0.1, 0.1, 0.1, 0.1)

                    n  seconds
------------------------------
=&gt; passed        1024     0.00
=&gt; passed        2048     0.00
=&gt; passed        4096     0.00
=&gt; passed        8192     0.00
=&gt; passed       16384     0.00
=&gt; passed       32768     0.00
=&gt; passed       65536     0.00
=&gt; passed      128000     0.00
=&gt; passed      256000     0.01
=&gt; passed      512000     0.02
=&gt; passed     1024000     0.04
=&gt; passed     2048000     0.08
==&gt; 12/12 tests passed


Test 8a-8g: make n calls to addFirst(); iterate over the n items by calling
            next() and hasNext()

                    n  seconds
------------------------------
=&gt; passed        1024     0.00
=&gt; passed        2048     0.00
=&gt; passed        4096     0.00
=&gt; passed        8192     0.00
=&gt; passed       16384     0.00
=&gt; passed       32768     0.00
=&gt; passed       65536     0.00
=&gt; passed      128000     0.00
=&gt; passed      256000     0.01
=&gt; passed      512000     0.01
=&gt; passed     1024000     0.02
=&gt; passed     2048000     0.04
==&gt; 12/12 tests passed


Test 9a-9k: make n calls to addFirst()/addLast(); interleave n calls each to
            removeFirst(), removeLast(), addFirst(), and addLast()

                    n  seconds
----------------------------------
=&gt; passed        1025     0.00
=&gt; passed        2049     0.00
=&gt; passed        4097     0.00
=&gt; passed        8193     0.00
=&gt; passed       16385     0.00
=&gt; passed       32769     0.00
=&gt; passed       65537     0.00
=&gt; passed      128001     0.01
=&gt; passed      256001     0.01
=&gt; passed      512001     0.03
=&gt; passed     1024001     0.05
==&gt; 11/11 tests passed

Total: 103/103 tests passed!


================================================================



Timing RandomizedQueue
*-----------------------------------------------------------
Running 67 total tests.

Test 1: make n calls to enqueue() followed by n calls to dequeue();
        count calls to StdRandom
  * n = 10
  * n = 100
  * n = 1000
==&gt; passed

Test 2: make n calls to enqueue() follwed by n calls to sample();
        count calls to StdRandom
  * n = 10
  * n = 100
  * n = 1000
==&gt; passed

Test 3: make n calls to enqueue() and iterate over the n items;
        count calls to StdRandom
  * n = 10
  * n = 100
  * n = 1000
==&gt; passed

Test 4a-k: make n calls to enqueue() followed by n calls to dequeue()

                    n  seconds
----------------------------------
=&gt; passed        1024     0.00
=&gt; passed        2048     0.00
=&gt; passed        4096     0.00
=&gt; passed        8192     0.00
=&gt; passed       16384     0.00
=&gt; passed       32768     0.00
=&gt; passed       65536     0.01
=&gt; passed      128000     0.00
=&gt; passed      256000     0.02
=&gt; passed      512000     0.02
=&gt; passed     1024000     0.04
==&gt; 11/11 tests passed


Test 5a-k: make n calls to enqueue() followed by n random calls to
           enqueue(), sample(), dequeue(), isEmpty(), and size()
           with probabilities (0.2, 0.2, 0.2, 0.2, 0.2)

                    n  seconds
----------------------------------
=&gt; passed        1024     0.00
=&gt; passed        2048     0.00
=&gt; passed        4096     0.00
=&gt; passed        8192     0.00
=&gt; passed       16384     0.00
=&gt; passed       32768     0.00
=&gt; passed       65536     0.01
=&gt; passed      128000     0.01
=&gt; passed      256000     0.02
=&gt; passed      512000     0.04
=&gt; passed     1024000     0.10
==&gt; 11/11 tests passed


Test 6a-k: make n calls to enqueue() followed by n random calls to
           enqueue(), sample(), dequeue(), isEmpty(), and size()
           with probabilities (0.6, 0.1, 0.1, 0.1, 0.1)

                    n  seconds
----------------------------------
=&gt; passed        1024     0.00
=&gt; passed        2048     0.00
=&gt; passed        4096     0.00
=&gt; passed        8192     0.00
=&gt; passed       16384     0.00
=&gt; passed       32768     0.00
=&gt; passed       65536     0.01
=&gt; passed      128000     0.01
=&gt; passed      256000     0.01
=&gt; passed      512000     0.03
=&gt; passed     1024000     0.07
==&gt; 11/11 tests passed


Test 7a-k: make n calls to enqueue() followed by n random calls to
           enqueue(), sample(), dequeue(), isEmpty(), and size()
           with probabilities (0.1, 0.1, 0.6, 0.1, 0.1)

                    n  seconds
----------------------------------
=&gt; passed        1024     0.00
=&gt; passed        2048     0.00
=&gt; passed        4096     0.00
=&gt; passed        8192     0.00
=&gt; passed       16384     0.00
=&gt; passed       32768     0.00
=&gt; passed       65536     0.00
=&gt; passed      128000     0.01
=&gt; passed      256000     0.02
=&gt; passed      512000     0.05
=&gt; passed     1024000     0.11
==&gt; 11/11 tests passed


Test 8a-k: make n calls to enqueue() followed by n calls each to
           next() and hasNext().

                    n  seconds
----------------------------------
=&gt; passed        1024     0.00
=&gt; passed        2048     0.00
=&gt; passed        4096     0.00
=&gt; passed        8192     0.00
=&gt; passed       16384     0.00
=&gt; passed       32768     0.00
=&gt; passed       65536     0.00
=&gt; passed      128000     0.00
=&gt; passed      256000     0.01
=&gt; passed      512000     0.02
=&gt; passed     1024000     0.05
==&gt; 11/11 tests passed


Test 9a-i: make 100 calls to enqueue; 99 calls to dequeue;
           n calls to enqueue(); then call dequeue() three times,
           followed by enqueue() three times, and repeat n times.

                    n  seconds
----------------------------------
=&gt; passed        1024     0.00
=&gt; passed        2048     0.00
=&gt; passed        4096     0.00
=&gt; passed        8192     0.00
=&gt; passed       16384     0.00
=&gt; passed       32768     0.00
=&gt; passed       65536     0.01
=&gt; passed      128000     0.02
=&gt; passed      256000     0.05
==&gt; 9/9 tests passed


Total: 67/67 tests passed!


================================================================




</pre>
</body>
</html>
