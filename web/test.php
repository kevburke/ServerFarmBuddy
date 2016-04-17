
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<?php

$usrlogin =  $_POST["name"];
$usrpass =  $_POST["password"];

echo "In php";
$servername = "localhost:3306";
$username = "root";
$password = "burke3";
$dbname = "farmdata";


// Create connection

if (!function_exists('mysqli_init') && !extension_loaded('mysqli')) {
    echo 'We don\'t have mysqli!!!';
} else {
    echo 'Phew we have it!';
}



$conn = new mysqli("localhost:3306", "root", "burke3",$dbname);
echo "Con To db";
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
$sql = "SELECT * FROM "."calf".$usrlogin;
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "<br>id: " . $row["jumbo"]. " - Name: " . $row["numID"]. " " . $row["BullName"]. " ". $row["Code"]. " " . $row["MateDate"]. " " . $row["Dob"]."<br>";
    }
} else {
    echo "0 results";
}
$conn->close();
?>
</body>
</html>