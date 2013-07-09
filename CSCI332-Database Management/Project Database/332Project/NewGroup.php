<?php

include 'HeaderMenu.php';
require 'Connect.php';


$query = "INSERT into Groups (idGroups, name, description, Creators_idCreators)
	   VALUES ('" . $_REQUEST["idGroups"] . "', '" . $_REQUEST["newname"] . "', '" . $_REQUEST["description"] . "', '" . $_REQUEST["creator"] . "')";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

?>

<script>window.location = 'GroupHome.php'</script>