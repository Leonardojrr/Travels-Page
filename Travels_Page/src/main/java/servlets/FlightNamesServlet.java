
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.FlightListModel;
import models.ResponseModel;
import utils.DBConnection;
import utils.PropReader;
import utils.SuperMapper;

@WebServlet(name="FlightNamesServlet",urlPatterns={"/FlightNamesServlet"})
public class FlightNamesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
       DBConnection db = new DBConnection();
       PropReader propr = PropReader.getInstance();
       SuperMapper mapper = new SuperMapper();
       FlightListModel flight_list = new FlightListModel();
       
       ResponseModel msg = new ResponseModel();
       response.setContentType("application/json");
       PrintWriter out = response.getWriter();
       
             
       ResultSet a = db.execute(propr.getValue("getFlightOrigins"));
       ResultSet b = db.execute(propr.getValue("getFlightDestinys"));
       
       
        try {
            
            while(a.next()){
                flight_list.getSalidas().add(a.getString("salidas"));
            }
            while(b.next()){
                flight_list.getDestinos().add(b.getString("destinos"));
            }           
        } catch (SQLException ex) {
            Logger.getLogger(FlightNamesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        msg.setStatus(200);
        msg.setMsg("Vuelos");
        msg.setData(flight_list);
        
        out.write(mapper.plainObjToJson(msg));
    }
    
 

}
