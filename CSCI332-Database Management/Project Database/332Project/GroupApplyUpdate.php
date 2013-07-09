<?php
include 'HeaderMenu.php';
include 'Connect.php';

$query = "UPDATE Groups SET idGroups = '" . $_REQUEST['newID'] . "',"
  . "name = '" . $_REQUEST['newname'] . "' ,"
  . "description = '" . $_REQUEST['description'] . "' ,"
  . "Creators_idCreators = '" . $_REQUEST['creator'] . "' "
  . " where idGroups = '" . $_REQUEST['origID'] . "'";
//echo $query;
//exit;
  
$result = mysql_query($query);

if (!$result) {
    die('Invalid query: ' . mysql_error());
}

mysql_close($connection);

?>
<script>window.location = 'GroupHome.php'</script>
