
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio_tecnico;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author angel
 */
public class Servicio_tecnico {
    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;
        
        // AGREGAR DATOS
        String Nombre= "asistencia";
        String Tipo= "net";
        String Cantidad= "2";
        String Direccion_Residencia ="calle9";
        
        // INSTRUCCION SQL
        string sql="INSER INTO servicios(nombre, tipo, cantidad, direccion_residencia)values ('"+nombre+"','"+tipo+"','"+cantidad+"','"+Direccion_residencia+"')";
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servicio.tecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // AGREAR DATOS
            rs = st.executeQuery("SELECT * FROM servicios"); // TRAER DATOS DE LA TABLA servios
            rs.next();
  // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA SERVICIOS
            do {
                System.out.println(rs.getInt("ids")+": "+rs.getString("nombre")+" - "+rs.getString("tipo")+" - "+rs.getString("cantidad"+": "+rs.getString("direcion_residencia"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(Servicio_tecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
