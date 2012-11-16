<?php include 'header.php'?>
<form action="">

<h1>Test Generator</h1>
Title: <input type="text" size="30" />
Date(M|D|Y): <input type="text" size="5"/><input type="text" size="5" /><input type="text" size="7" align="right"/></br>
</form>
<p>&nbsp;</p>
<table width="71%" border="0" align="left">
  <tr>
    <th height="23" align="left" valign="top" scope="col"><input type="button" onClick="parent.location='basicgeneration.php'" value="Add a Question" /></th>
    <th align="left" valign="top" scope="col"><input type="button"  onclick="parent.location='attribute_text.php'" value="Add an Attribute" /></th>
  </tr>
  <tr>
  
    <th width="45%" height="193" align="left" valign="top" scope="col"><table width="400" height="150" border="1" >
      <tr>
        <th width="38" height="10%" scope="col">Index</th>
        <th width="55" height="10%" scope="col">Course</th>
        <th width="306" height="10%" scope="col">Question</th>
        <th width="8" height="10%" scope="col">...</th>
      </tr>
      <tr>
        <td>1</td>
        <td>CPE 103</td>
        <td>The traversal of a binary tree yields the sequence 5, 2, 1, 3, 6, 7. What type of traversal is being performed?</td>
        <td></td>
      </tr>
      <tr>
        <td>2</td>
        <td>CPE 103</td>
        <td>Contains vertices and edges.</td>
        <td></td>
      </tr>
      <tr>
        <td>3</td>
        <td>CPE 103</td>
        <td>Bubble Sort is the most efficient known sorting algorithm.</td>
        <td></td>
      </tr>
    </table>	   
    </th>
    
    <th width="55%" align="left" valign="top" scope="col"><table width="400" height="150" border="1" >
      <tr>
        <th width="38" height="20" scope="col">Index</th>
        <th width="60" height="20" scope="col">Attribute</th>
        <th width="98" height="20" scope="col">...</th>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
      </tr>
  </table>
  </th>
  
  </tr>
  <tr>
    <th height="20" align="right" valign="top" scope="col"><input type="button" onClick="alert('Upon clicking this button, the add question/attribute dialog will open and the selected question/attribute will be replaced.');" value="Replace" /></th>
    <th height="20" align="left" valign="top" scope="col"><input type="button" onClick="alert('Upon clicking this button, the selected question/attribute will be removed from the test.');" value="Delete" /></th>
  </tr>
  <tr>
    <th height="20" align="left" valign="top" scope="col"><input type="button" align"right" onclick="parent.location='manual_test_creation.php'" value="Fully Manual" /></th>
    <th height="20" align="right" valign="top" scope="col"><input type="button" align"right" onclick="alert('Upon clicking this button, the user will go through a preview of the created test.');" value="Preview" />
       &nbsp;&nbsp;&nbsp;&nbsp;<input type="button" align"right" onclick="alert('Upon clicking this button, the test will be saved to the database.');" value="Save" /></th>
  </tr>
</table>
<center>
<p>
  <?php include 'footer.php'?>
