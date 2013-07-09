<?php

include 'HeaderMenu.php';
include 'Connect.php';

$query = 'SELECT idUsers, name FROM Users WHERE idUsers=' . $_REQUEST['origid'];
//echo $query;
//exit;
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
while ($row = mysql_fetch_assoc($result)) {
    $userID = $row['idUsers'];
    $userName = $row['name'];
}

$query = 'SELECT idUsers, name FROM Users WHERE idUsers=' . $_REQUEST['quizid'];
//echo $query;
//exit;
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
while ($row = mysql_fetch_assoc($result)) {
    $userID = $row['idQuizzes'];
    $userName = $row['name'];
}

echo $_REQUEST['origid'] . " wants"
?>
