import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by Kev on 16/04/2016.
 */


@WebServlet("/CalfDatabase")
public class CalfDatabase extends HttpServlet {
    public  String usrName ="";
    public  String passWord = "";

    @Override

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sts = "";
        String inputString = request.getParameter("CalfDet"); //put the sent json in a string
        try {

            JSONObject inputValues = new JSONObject(inputString);//create json to extract values

            String[] IncomingDet = new String[8];

            IncomingDet[0] = inputValues.getString("Tname");
            IncomingDet[1] = inputValues.getString("jumbo");
            IncomingDet[2] = inputValues.getString("numID");
            IncomingDet[3] = inputValues.getString("BullName");
            IncomingDet[4] = inputValues.getString("Code");
            IncomingDet[5] = inputValues.getString("MateDate");
            IncomingDet[6] = inputValues.getString("Dob");


            //***********************************************************//

            System.out.println(IncomingDet[0]);
            System.out.println(IncomingDet[1]);
            System.out.println(IncomingDet[2]);
            System.out.println(IncomingDet[3]);
            System.out.println(IncomingDet[4]);
            System.out.println(IncomingDet[5]);
            System.out.println(IncomingDet[6]);
            PreparedStatement sqlUpdate;

                // load database driver class
                Class.forName("com.mysql.jdbc.Driver");

                // connect to database
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/FarmData", "root", "burke3");


                Statement stm = connection.createStatement();
                stm.executeUpdate("\n" +
                        "CREATE TABLE IF NOT EXISTS "+ IncomingDet[0]+" (\n" +
                        "  ID     INT AUTO_INCREMENT,\n" +
                        "  jumbo    VARCHAR(30),\n" +
                        "  numID  VARCHAR(30),\n" +
                        "  BullName VARCHAR(30),\n" +
                        "  Code  VARCHAR(30),\n" +
                        "  MateDate VARCHAR(30),\n" +
                        "  Dob VARCHAR(30),\n" +
                        "  CONSTRAINT pk_name PRIMARY KEY (ID)\n" +
                        ");");


                sqlUpdate = connection.prepareStatement(
                        "INSERT INTO "+IncomingDet[0]+" ( jumbo, numID, BullName, Code, MateDate, Dob) " +
                                "VALUES ( ? ,  ? , ? , ? , ? ,?)" );
                int result;
                sqlUpdate.clearParameters();
                sqlUpdate.setString(1, IncomingDet[1]);
                sqlUpdate.setString(2, IncomingDet[2]);
                sqlUpdate.setString(3, IncomingDet[3]);
                sqlUpdate.setString(4, IncomingDet[4]);
                sqlUpdate.setString(5, IncomingDet[5]);
                sqlUpdate.setString(6, IncomingDet[6]);
                result = sqlUpdate.executeUpdate();
                // if insert fails, rollback and discontinue
                if ( result == 0 ) {
                    connection.rollback(); // rollback insert
                    System.out.println("did rollBack");
                }
                // close statement and connection
                connection.close();
                System.out.println("Database saved");

            //***********************************************************//


            PrintWriter out = response.getWriter();
            out.println("");



        } catch (Exception e) {
            System.out.println("Servlet died");
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.println(sts);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

