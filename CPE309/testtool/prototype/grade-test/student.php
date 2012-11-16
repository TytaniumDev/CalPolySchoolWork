<?php
require "data.php";
require "header.php";

$currentTest = $tests[$_GET['id']]; 
$currentStudent = $currentTest['tests'][$_GET['test']];

?>
<div class="panel">
<div class="left"><h2><a href="./test.php?id=<?=$_GET['id']?>">&lt;Back</a>
</h2></div>
<div class="middle">
   <h2><?=$currentStudent['student']?></h2>
</div>
<div class="right"></div>
</div>
<div style="clear:both;text-align:center;">
<div class="question">
   <div class="questionhead">
      Question 1
      <span style="float:right"><a href="all.php?id=2">All Responses</a></span>
   </div>
   <div class="questiontext">What is the average search time for a binary tree?</div>
   <div class="questionbody">
   Student's Response: D. Logarithmic.
   Correct Response: D. Logarithmic.
   </div>
   <div class="questionfoot">
   <input type="text" width="2" style="width:15px" value="5"/> / 5
   <div style="float:right">
      Notes:
      <textarea></textarea>
   </div>
   <div style="clear:both"></div>
   </div>
</div>

<div class="question">
   <div class="questionhead">
      Question 2
      <span style="float:right"><a href="all.php?id=1">All Responses</a></span>
   </div>
   <div class="questiontext">Match each sort with its worst order case of
   complexity.</div>
   <div class="questionbody">
   <table class="matching">
      <tr><td width=100>A. Quick</td><th>C</th><td>N * log<sup>2</sup>N</td></tr>
      <tr><td width=100>B. Merge</td><th>B</th><td>N * log N</td></tr>
      <tr><td width=100>C. Shell</td><th>A</th><td>N<sup>2</sup></td></tr>
   </table>
   </div>
   <div class="questionfoot">
   <input type="text" width="2" style="width:15px" value="3"/> / 3
   <div style="float:right">
      Notes:
      <textarea></textarea>
   </div>
   <div style="clear:both"></div>
   </div>
</div>

<div class="question">
   <div class="questionhead">
      Question 3
      <span style="float:right"><a href="all.php?id=2">All Responses</a></span>
   </div>
   <div class="questiontext">Describe a hash table.</div>
   <div class="questionbody">
   <em>Student's Response</em>
   <p>
   A hash table is a data structure in which data values are hashed using a hash
function, which gives it an index into an array.
   </p>
   </div>
   <div class="questionfoot">
   <input type="text" width="2" style="width:15px" value=""/> / 10
   <div style="float:right">
      Notes:
      <textarea></textarea>
   </div>
   <div style="clear:both"></div>
</div>
</div>

<input type="submit"/>
</div>
<?
require "footer.php";
?>
