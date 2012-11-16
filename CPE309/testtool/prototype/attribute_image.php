<?php include 'header.php'?>
<form action="">

<h1>Adding An Attribute</h1>
</form>
<p>&nbsp;</p>
<table width="357" border="0">
  <tr>
    <td width="112"><form name="form1" method="post" action="">
        <label for="type">Type:</label>
        <select name="type" id="type">
        	<option value="Image">Image</option>
        	<option value="Text">Text</option>
        </select>
    </form></td>
    <td width="235"><form name="form2" method="post" action="">
        <label for="index">Index: </label>
        <input name="index" type="text" id="index" value="1">
    </form></td>
  </tr>
  <tr>
    <td height="122" colspan="2" align="center"><input type="file" name="browse" value="C:/Courses/CPE103/binarysort.jpg" id="browse" /></td>
  </tr>
  <tr>
    <td height="23"><a href="attribute_text.php">See Text</a></td>
    <td align="right"><input type="submit" name="add_attribute" id="add_attribute" value="Add Attribute" tabindex="4"></td>
  </tr>
</table>
<center>
<p>
  <?php include 'footer.php'?>
