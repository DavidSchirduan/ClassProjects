<?php
include 'HeaderMenu.php';
include 'Connect.php';

$quizquery = "SELECT idQuizzes, name, numQuestions from Quizzes";
$quizresult = mysql_query($quizquery);
if (!$quizresult) {
    die('Invalid query: ' . mysql_error());

}
$userID = $_REQUEST['idUsers'];
$username = $_REQUEST['name'];

echo "<br><br>Hey ".$username.", select quiz to take:";

echo '<br><br><form action="UserTakeQuiz.php">';
echo"<select name='quizlist'>";
echo "<option value='No Quiz' name='quizChoice'>No Quiz</option>";
while ($quizrow = mysql_fetch_assoc($quizresult)) {
    echo "<option value='" . $quizrow['idQuizzes'] . "' name='quizChoice'>" . $quizrow['name'] . "</option>";
}
echo '</select><input type="hidden" name="userID"  value="'.$userID.'" />
<input type="hidden" name="username"  value="'. $username.'" />';
echo'<input type="submit" value="Take" />
</form>';

mysql_close($connection);

?>
