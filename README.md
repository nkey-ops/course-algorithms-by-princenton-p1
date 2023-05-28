<p><b>Programming Assignment:</b> 
  Percolation

Program in execution

![hippo](https://user-images.githubusercontent.com/81760194/225597366-573bb944-81cd-42c9-9c3c-d972b2ce1f7a.gif)

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
  
 
 <br>  
  
==============================================================================================================  
 <br>  
  
  
  
<p><b>Programming Assignment:</b>
  Queues 
  
Program in execution

![hippo](https://github.com/nkey-ops/course-algorithms-by-princenton-p1/assets/81760194/4ee9fcc8-a448-49b7-a96d-556e6d489dd6)

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

Write a generic data type for a deque and a randomized queue. The goal of this assignment is to implement elementary data structures using arrays and linked lists, and to introduce you to generics and iterators.   

<p><b>Dequeue.</b>
A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue that supports adding and removing items from either the front or the back of the data structure. 

 <p><b>Randomized queue.</b> A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random among items in the data structure.
