/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ofertas;
import evidencia.conexion.base.EvidenciaConexionBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class eliminar_oferta {
     public static void main(String[] args) {

    //CONEXION
        EvidenciaConexionBase con = new EvidenciaConexionBase();
        Connection cn;
        Statement st;
        ResultSet rs;
   
    //DATO A ELIMINAR
    int id_eliminar=04;
    
    //INSTRUCCION SQL
    String sql = "DELETE FROM ofertas where IdS="+id_eliminar;
                
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(eliminar_oferta.class.getName()).log(Level.SEVERE, null, ex);
        }

         try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // AGREAR DATOS
            rs = st.executeQuery("SELECT * FROM ofertas"); // TRAER DATOS DE LA TABLA ofertas
            rs.next();
  // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA SERVICIOS
            do {
                System.out.println(rs.getInt("IdS")+": "+rs.getString("oferta")+" - "+rs.getString("antiguedad"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(eliminar_oferta.class.getName()).log(Level.SEVERE, null, ex);
        } 
 } 
 } 
