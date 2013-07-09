<?php
include 'HeaderMenu.php';
include 'Connect.php';

$query = "UPDATE Creators SET name = '" . $_REQUEST['newname'] . "',"
  . "password = '" . $_REQUEST['newpassword'] . "',"
  . "idCreators = '" . $_REQUEST['newID'] . "'"
  . " where idCreators = '" . $_REQUEST['origID'] . "'";
//echo $query;
//exit;
  
$result = mysql_query($query);

if (!$result) {
    die('Invalid query: ' . mysql_error());
}

mysql_close($connection);

?>
<script>window.location = 'CreatorHome.php'</script>
