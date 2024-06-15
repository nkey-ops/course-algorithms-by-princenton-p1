<p><h1>Algorithms, Part I <i>by Princeton University</i></h1>
<i>https://www.coursera.org/learn/algorithms-part1</i>
 
<br><b>About this Course</b>
<br>This course covers the essential information that every serious programmer needs to know about algorithms and data structures, with emphasis on applications and scientific performance analysis of Java implementations. Part I covers elementary data structures, sorting, and searching algorithms. Part II focuses on graph- and string-processing algorithms.

All the features of this course are available for free. People who are interested in digging deeper into the content may wish to obtain the textbook Algorithms, Fourth Edition (upon which the course is based) or visit the website algs4.cs.princeton.edu for a wealth of additional material.

<p><h2>Programming Assignment: Percolation</h2>

<h3>Program in execution</h3>  
 
![hippo](https://github.com/nkey-ops/course-algorithms-by-princenton-p1/assets/81760194/ad3a04e2-5389-4187-9ee2-54b94b7540aa)

<h3>ASSESSMENT SUMMARY</h3>
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


</p><b>Percolation.</b>
Given a composite systems comprised of randomly distributed insulating and metallic
materials: what fraction of the materials need to be metallic so that the composite system is an 
electrical conductor? Given a porous landscape with water on the surface (or oil below),
under what conditions will the water be able to drain through to the bottom (or the
oil to gush through to the surface)?
Scientists have defined an abstract process known as <em>percolation</em>
to model such situations.

</p><b>The model.</b>
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
  
 
 <br>  
  
==============================================================================================================  
 <br>  
  
 
  
<p><h2>Programming Assignment: Queues </h2>
<h3>Program in execution</h3> 
 
 ![hippo](https://github.com/nkey-ops/course-algorithms-by-princenton-p1/assets/81760194/4ee9fcc8-a448-49b7-a96d-556e6d489dd6)


<h2>ASSESSMENT SUMMARY</h3>
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

Write a generic data type for a deque and a randomized queue. The goal of this assignment is to implement elementary data structures using arrays and linked lists, and to introduce you to generics and iterators.   

<p><b>Dequeue.</b>
A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue that supports adding and removing items from either the front or the back of the data structure. 

 <p><b>Randomized queue.</b> A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random among items in the data structure.
 
   
<br>  
  
==============================================================================================================  
 <br>  
  
<p><h2>Programming Assignment: Collinear Points </h2>
<h3>Program in execution</h3>

![hippo](https://github.com/nkey-ops/course-algorithms-by-princenton-p1/assets/81760194/7a5460ae-670c-47dd-9066-106d7efa96a1)
  
<h3>ASSESSMENT SUMMARY</h3>
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
 
<p>
<b>The problem.</b>
Given a set of <em>n</em> distinct points in the plane, 
find every (maximal) line segment that connects a subset of 4 or more of the points.
<p>


![image](https://github.com/nkey-ops/course-algorithms-by-princenton-p1/assets/81760194/485dc9c3-f239-4001-8628-3adfdfc3f33d)

 
<b> Brute force. </b> Write a program BruteCollinearPoints.java that examines 4 points at a time and checks whether they all lie on the same line segment, returning all such line segments. The order of growth of the running time of the program will be n4 in the worst case and it will use space proportional to n plus the number of line segments returned. 
</p>
<b>A faster, sorting-based solution.</b> Remarkably, it is possible to solve the problem much faster than the brute-force solution described above. The growth of the running time of the program will be n2 log n in the worst case and it will use space proportional to n plus the number of line segments returned.
   
<br>  
  
==============================================================================================================  
 <br>  
  
<p><h2>Programming Assignment: Priority Queues </h2>
<h3>Program in execution</h3>

![hippo](https://github.com/nkey-ops/course-algorithms-by-princenton-p1/assets/81760194/14c669ef-6a31-4255-87ea-6095a5091b9a)

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
