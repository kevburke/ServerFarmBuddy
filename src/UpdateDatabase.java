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

/**
 * Created by Kev on 23/04/2016.
 */
@WebServlet("/UpdateDatabase")
public class UpdateDatabase extends HttpServlet {
    public  String usrName ="";
    public  String passWord = "";

    @Override

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sts = "";
        String inputString = request.getParameter("Update"); //put the sent json in a string
        try {

            JSONObject inputValues = new JSONObject(inputString);//create json to extract values

            String[] IncomingDet = new String[2];

            IncomingDet[0] = inputValues.getString("user");
            IncomingDet[1] = inputValues.getString("delete");


            //***********************************************************//

            System.out.println(IncomingDet[0]);
            System.out.println(IncomingDet[1]);

            PreparedStatement sqlUpdate;

            // load database driver class
            Class.forName("com.mysql.jdbc.Driver");

            // connect to database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FarmData", "root", "burke3");


            int result;


            sqlUpdate = connection.prepareStatement(
                    "DELETE FROM calf"+IncomingDet[0]+" WHERE numID='" + IncomingDet[1]+"';");

            result = sqlUpdate.executeUpdate();
            if ( result == 0 ) {
                connection.rollback(); // rollback insert
                System.out.println("did rollBack");
            }
            // close statement and connection
            connection.close();
            System.out.println("Database saved");

            //***********************************************************//




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
