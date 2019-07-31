
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ResponseModel;
import models.UserModel;
import utils.DBConnection;
import utils.Encrypter;
import utils.PropReader;
import utils.SuperMapper;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
    private DBConnection db;
    private PropReader propr;
    private SuperMapper mapper;
    private ResultSet regist;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        db = new DBConnection();
        mapper = new SuperMapper();
        propr = PropReader.getInstance();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        String user_id = request.getParameter("email");
        String user_password = request.getParameter("password");
        UserModel user = new UserModel();
        
        try{
            if(user_id!= null){
                regist = db.execute(propr.getValue("loginEmail"), user_id, Encrypter.getMD5(user_password));
            }
            else{
                user_id = request.getParameter("username");
                regist = db.execute(propr.getValue("loginUsername"), user_id, Encrypter.getMD5(user_password));
            }
        
        if(regist.next()){
            user.setName(regist.getString("name"));
            user.setUsername(regist.getString("username"));
            user.setNumber(regist.getString("number"));
            user.setAddress(regist.getString("address"));
            user.setEmail(regist.getString("email"));
            user.setPassword(null);
            ResponseModel msg = new ResponseModel();
            msg.setStatus(200);
            msg.setMsg("Succesfull login");
            msg.setData(user);
            out.write(mapper.plainObjToJson(msg));
        }
        else{
            ResponseModel msg = new ResponseModel();
            msg.setStatus(404);
            msg.setMsg("Fail login");
            out.write(mapper.plainObjToJson(msg));
        }
        }catch(SQLException e){
            
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

    }
}
