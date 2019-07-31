
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DBConnection;
import utils.PropReader;
import utils.SuperMapper;

@WebServlet(name="LogoutServlet",urlPatterns={"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

    private SuperMapper mapper;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
     
    }
}
