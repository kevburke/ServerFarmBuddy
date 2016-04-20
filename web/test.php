
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Farm Buddy Application</title>

</head>
<body>

<?php

$usrlogin =  $_POST["name"];
$usrpass =  $_POST["password"];
$servername = "localhost:3306";
$username = "root";
$password = "burke3";
$dbname = "farmdata";


// Create connection

if (!function_exists('mysqli_init') && !extension_loaded('mysqli')) {
    echo '';
} else {
    echo '';
}



$conn = new mysqli("localhost:3306", "root", "burke3",$dbname);
//echo "Con To db";
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
echo "<b>
<center>Current List For user .$usrlogin </center>
</b>
<br>
</br>";
$sql = "SELECT * FROM "."calf".$usrlogin;
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "<br>Dam Jumbo: " . $row["jumbo"]. " - Dam id: " . $row["numID"]. " -Sire: " . $row["BullName"]. " -Sire Id ". $row["Code"]. " -Mated: " . $row["MateDate"]. " -Due Date " . $row["Dob"]."<br>";

    }
} else {
    echo "0 results";
}
$conn->close();
?>
</body>
</html>