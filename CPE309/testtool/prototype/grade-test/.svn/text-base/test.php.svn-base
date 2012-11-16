<?php
require "data.php";
require "header.php";

$currentTest = $tests[$_GET['id']]; 
?>
<div class="panel">
<div class="left"><h2><a href="./">&lt;Back</a></h2></div>
<div class="middle">
   <h2><?=$currentTest['name']?></h2>
</div>
<div class="right"></div>
</div>
<div style="clear:both;text-align:center;">
<table>
<?
echo "<tr><th>Student</th>";
foreach ( $currentTest['tests'][0]['sectiongrade'] as $key=>$section ) {
   echo "<th>".$key."</th>";
}
echo "</tr>";
foreach ( $currentTest['tests'] as $key=>$test ) {
   echo "<tr><td><a href='student.php?id=".$_GET['id']."&test=".$key."'>";
   echo $test['student']."</a></td>";
   foreach ( $test['sectiongrade'] as $section ) {
      echo "<td>".(100*$section)."%</td>";
   }
   echo "</tr>";
}
?>
</table>
</div>
<?
require "footer.php";
?>
