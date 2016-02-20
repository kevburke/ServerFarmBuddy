/**
 * Created by Kev on 19/02/2016.
 */

/**
 * Created by Kev on 02/12/2015.
 */
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/InputOutput")
public class InputOutput extends HttpServlet {
    public  String usrName ="";
    public  String passWord = "";

    @Override

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sts = "";
        String inputString = request.getParameter("login"); //put the sent json in a string
        try {

            JSONObject inputValues = new JSONObject(inputString);//create json to extract values

            String[] validiateUsr = new String[2];

            validiateUsr[0] = inputValues.getString("username");
            validiateUsr[1] = inputValues.getString("password");

            usrName = validiateUsr[0];
            passWord = validiateUsr[1];

            //***********************************************************//
            GetRemoteDetails ids = new GetRemoteDetails(usrName,passWord);



            System.out.println(validiateUsr[0]);
            System.out.println(validiateUsr[1]);

            //***********************************************************//

            JSONObject jsn =ids.returnJSON();
            PrintWriter out = response.getWriter();
            out.println(jsn);





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

