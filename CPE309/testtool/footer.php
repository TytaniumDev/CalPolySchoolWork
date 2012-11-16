<?
if ( isset($links) ) {
?><ul id="footernav"><? 
foreach ( $links as $type => $link ) { 
   if ( strlen($link[0]>0) )
      echo "<li>".$type.": <a href='".$link[0]."'>".$link[1]."</a></li>";
   else
      echo "<li>".$type.": [none]</li>";
}
?></ul><?
}
?>
</div>
</body>
</html>
