<?php
require "data.php";
require "header.php";

?>
<div class="panel">
<div class="left"><h2><a href="./test.php?id=<?=$_GET['id']?>">&lt;Back</a>
</h2></div>
<div class="middle">
   <h2>Question <?=$_GET['id']?></h2>
</div>
<div class="right"></div>
</div>

<div style="clear:both;text-align:center;">

<div class="question">
   <div class="questionhead">
      Joseph Kruskal
      <span style="float:right"><a href="all.php?id=2">All Questions</a></span>
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
      Johnny Dogood
      <span style="float:right"><a href="all.php?id=2">All Questions</a></span>
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
      Edsger Dijkstra
      <span style="float:right"><a href="all.php?id=2">All Questions</a></span>
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



<input type="submit"/>
</div>
<?
require "footer.php";
?>
