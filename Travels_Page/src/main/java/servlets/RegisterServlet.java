/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ResponseModel;
import models.UserModel;
import utils.DBConnection;
import utils.PropReader;
import utils.Encrypter;
import utils.SuperMapper;

/**
 *
 * @author XxlrgamersxX
// */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    
    private DBConnection db;
    private PropReader propr;
    private SuperMapper mapper;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        db = new DBConnection();
        mapper = new SuperMapper();
        propr = PropReader.getInstance();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        UserModel user = mapper.jsonToPlainObj(request, UserModel.class);
        
        
        try {
            //Verificar si el usuario no existe
            if(!db.validate(propr.getValue("validateUser"), user.getUsername(), user.getEmail())){
                //Si no existe agregarlo a la base de datos
                db.update(propr.getValue("registerUser"),user.getUsername(),Encrypter.getMD5(user.getPassword()),
                        user.getEmail(),user.getName(),user.getNumber(),user.getAddress());
                db.closeCon();
                //Responder al usuario
                ResponseModel message = new ResponseModel();
                message.setStatus(200);
                message.setMsg("Successful user regist");
                user.setPassword(null);
                message.setData(user);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                out.write(mapper.plainObjToJson(message));
            }
            else{
                //Responder al usuario
                ResponseModel message = new ResponseModel();
                message.setStatus(405);
                message.setMsg("The user already exist");
                out.write(mapper.plainObjToJson(message));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
