package Controller;

import Model.Entitys.Product;
import com.sun.org.apache.xpath.internal.SourceTree;

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
                        request.getSession().setAttribute("Username", request.getParameter("Username"));
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }else{
                        System.out.println("Login failed");
                        //BACK BUTTON
                    }
                    break;
                case "2": // get product from DB(so it is correct). And add to shopping cart!
                    ProductController PC = new ProductController();
                    int P_id =  Integer.parseInt(request.getParameter("P_id"));

                    Product p = new Product();
                    p = PC.getProductById(P_id);

                    ArrayList<Product> P_list = new ArrayList<>();
                    P_list = (ArrayList<Product>)request.getSession().getAttribute("CART");
                    P_list.add(p); // if not null or something like that!

                    request.getSession().setAttribute("CART", P_list);
                    System.out.println("-----------");
                    for(int i=0; i<P_list.size(); i++){
                        System.out.println(P_list.get(i).getName());
                    }
                    System.out.println("-----------");

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
