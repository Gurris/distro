package Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created by Gurris on 2016-10-03.
 */
public class userController extends  HttpServlet{

    public void doGet( HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().write("<html><body>GET response</body></html>");

        //testhhh
    }

}
