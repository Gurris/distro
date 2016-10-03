package Controller;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created by Gurris on 2016-10-03.
 */
public class ControllerServlet extends  HttpServlet{

    public void doGet( HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String input = request.getParameter("controllerInput");

        if(input.split(":").length > 0){
            String action = input.split(":")[0];

            switch (action){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Could not find action");
                    break;
            }
        }

    }

    public void doPost( HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(request.getParameter("controllerInput"));
        System.out.println("Post");

        //response.getWriter().write("<html><body>Welcome to the shop</body></html>");

    }
}
