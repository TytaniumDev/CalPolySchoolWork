<?
$coolColor = "#CCC";
$coolColorDark = "#AAA";
?>

<html>
<head>
<style>
* {
   padding: 0px;
   margin: 0px;
   font-family: sans-serif;
}
body {
   text-align: center;
   background-color: <?= $coolColor ?>;
}
.container {
   text-align: left;
   margin: 0px auto;
   width: 600px;
   background-color:white;
   border: 2px #333 solid;
   border-top: 0;
}
h1 {
   padding: 3px 5px;
}
h2 {
   margin: 8px 5px;
}
h3 {
   margin: 3px 5px;
}
div.test_list {
   padding-left:10px;
   padding-right:5px;
}
a {
   color: #333;
   text-decoration: none;
}

a:hover {
   text-decoration: underline;
}

a.test {
   display: block;
   background-color: <?=$coolColor?>;
   margin: 2px 0px;
   padding: 2px;
}
a.test:hover {
   background-color: <?=$coolColor?>;
}
table {
   margin: 5px auto;
}
th {
   background-color: <?=$coolColorDark?>;
   padding: 0px 3px;
}
td {
   background-color: <?= $coolColor ?>;
   padding: 0px 3px;
   text-align:right;
}
ul.navigation {
   list-style-type: none;          
   border-bottom: 2px #333 solid;
}
ul.navigation .nlink {
   float:left;
   padding: 0px 3px;
}
ul.navigation .nofloat {
   float:none;
}
ul.navigation .nlink a {
   color: #333;
   background-color: #EEE;
   padding: 0px 10px;
   text-decoration: none;
   border: #333 solid 1px;
   border-bottom: #333 solid 2px;
}

ul.navigation .nlinkactive a {
   background-color:white;
   border-bottom: white solid 2px;
}

ul.navigation .nlink a:hover {
   background-color: <?= $coolColor ?>;
}
ul.navigation .clear {
   margin-top: 10px;
   clear: both;
}
div.footer {
   padding-top: 5px;
   margin: 5px;
   font-size:12px;
   text-align:center;
   border-top:1px #333 solid;
}
div.panel .left {
   width: 100px;
   float: left;
}
div.panel .middle {
   text-align:center;
   margin: 0px 100px;
   float:left;
}
div.panel .right {
   text-align:right;
   width: 100px;
}
div.question {
   border: black solid 2px;
   margin: 5px;
   text-align:left;
}
div.questionhead {
   background-color:<?= $coolColor ?>;
   padding: 3px;
}
div.questiontext {
   padding: 3px;
}
div.questionbody {
   text-align:left;
   padding: 3px;
}
table.matching tr td {
   background-color:white;
   text-align:left;

}
div.questionfoot {
   padding: 3px 20px;
}

</style>
</head>
<body>
<div class="container">
<div class="header">
<h1>Test Tool</h1>
<ul class="navigation">
   <li class="nlink"><a href="../question_bank.php">Question Bank</a></li>
   <li class="nlink"><a href="../testgenerating.php">Generate Test</a></li>
   <li class="nlink"><a href="../handle_test.php">Handle Test</a></li>
   <li class="nlink nlinkactive"><a>Grade Book</a></li>
   <li class="clear"></li>
</ul>
</div>
