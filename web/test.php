
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Farm Buddy Application</title>
    <link rel="stylesheet" href="css/data.css">
    <link rel="stylesheet" href="css/style.css">

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

$sql = "SELECT * FROM "."calf".$usrlogin;
$result = $conn->query($sql);

echo "<table class=\"responstable\">";

echo "<tr>
        <th>Jumbo</th>
        <th>numID</th>
        <th>BullName</th>
        <th>Code</th>
        <th>MateDate</th>
        <th>Dob</th>
    </tr>";

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {


    echo"   <tr>
        <td>". $row["jumbo"]."</td>
        <td>". $row["numID"]."</td>
        <td>". $row["BullName"]."</td>
        <td>". $row["Code"]."</td>
        <td>". $row["MateDate"]."</td>
        <td>". $row["Dob"]."</td>
          </tr>";
    }
    echo "</table>";

} else {
    echo "0 results";
}
$conn->close();
?>
</body>
</html>


