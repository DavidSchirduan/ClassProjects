<?php
include 'HeaderMenu.php';
include 'Connect.php';

$query = "UPDATE Choices SET userChoice = '" . $_REQUEST['newchoice'] . "',"
  . "idChoices = '" . $_REQUEST['newID'] . "'"
  . " where idChoices = '" . $_REQUEST['origID'] . "'";
//echo $query;
//exit;
  
$result = mysql_query($query);

if (!$result) {
    die('Invalid query: ' . mysql_error());
}

mysql_close($connection);

?>
<script>window.location = 'ChoiceHome.php'</script>
