<?php

$connection = mysql_connect('localhost', 'root', 'root');
if (!$connection) {
    die('Could not connect: ' . mysql_error());
}
$db_selected = mysql_select_db('332Project', $connection);
if (!$db_selected) {
    die ('Can\'t use db : ' . mysql_error());
}
?>
