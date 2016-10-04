package Controller;

import Model.Entitys.Product;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

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
                case "1": // Login
                    LoginAuthenticator LA = new LoginAuthenticator(request.getParameter("Username"), request.getParameter("Password"));
                    if(LA.isAuthentic()){
                        request.getSession().setAttribute("LoginStatus", "Login success");
                        request.getSession().setAttribute("Username", request.getParameter("Username"));
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }else{

                        request.getSession().setAttribute("LoginStatus", "Login failed");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                    break;
                case "2": // get product from DB(so it is correct). And add to shopping cart!
                    ProductController PC = new ProductController();
                    int P_id = Integer.parseInt(request.getParameter("P_id"));
                    Product p = new Product();
                    p = PC.getProductById(P_id);

                    ArrayList<Product> P_list = new ArrayList<>();
                    ArrayList<Product> tmp =  (ArrayList<Product>)request.getSession().getAttribute("CART"); //current cart
                    if(tmp != null){ // Verification so it is not null
                        P_list = tmp;
                    }
                    if(p != null){
                        P_list.add(p);
                    }

                    request.getSession().setAttribute("CART", P_list); // Add's the product to the cart

                    request.getRequestDispatcher("Browse.jsp").forward(request, response);

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

    }
}
