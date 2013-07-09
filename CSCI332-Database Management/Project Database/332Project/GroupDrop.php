<?php

include 'HeaderMenu.php';
include 'Connect.php';

//need group ID and user ID

$groupid = $_REQUEST['groupid'];
$userid = $_REQUEST['userid'];

$query = "DELETE FROM Groups_has_Users WHERE Groups_idGroups='$groupid' AND Users_idUsers='$userid'";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

?>
<script>window.location = 'GroupHome.php'</script>
