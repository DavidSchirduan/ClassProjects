<?php
include 'HeaderMenu.php';
include 'Connect.php';

$query = "UPDATE Users SET name = '" . $_REQUEST['newname'] . "',"
  . "password = '" . $_REQUEST['newpassword'] . "',"
  . "idUsers = '" . $_REQUEST['newID'] . "'"
  . " where idUsers = '" . $_REQUEST['origID'] . "'";
//echo $_REQUEST['quizlist'];
///exit;
$result = mysql_query($query);

if (!$result) {
    die('Invalid query: ' . mysql_error());
}

?>
<script>window.location = 'UserHome.php'</script>
