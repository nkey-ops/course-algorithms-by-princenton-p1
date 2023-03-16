Programming Assignment: Percolation

Program in execution

![hippo](https://user-images.githubusercontent.com/81760194/225597366-573bb944-81cd-42c9-9c3c-d972b2ce1f7a.gif)

==============================================================================================================


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
