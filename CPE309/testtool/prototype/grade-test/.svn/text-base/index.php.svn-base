<?php
require "data.php";
require "header.php";
?>
<h2>Grading</h2>
<h3>In Progress</h3>
<div class="test_list">
   <em>No tests currently in progress</em>
</div>

<h3>Pending</h3>
<div class="test_list">
<?php
$numshown = 0;
foreach( $tests as $key => $test ) {
   if ( $test['pending'] ) {
      echo "<a href='test.php?id=$key' class='test'>".$test['name']."</a>\n";
      $numshown++;
   }
}
if ( !$numshown ) {
   echo "<em>No tests currently pending</em>";
}
?>
</div>

<h3>Completed</h3>
<div class="test_list">
<?php
$numshown = 0;
foreach( $tests as $key=>$test ) {
   if ( !$test['pending'] ) {
      echo "<a href='test.php?id=$key' class='test'>".$test['name']."</a>\n";
      $numshown++;
   }
}
if (!$numshown ) {
   echo "<em>No tests currently completed</em>";
}
?>

</div>

<?php
require "footer.php";
?>
