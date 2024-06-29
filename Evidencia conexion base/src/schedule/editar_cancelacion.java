/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schedule;
import evidencia.conexion.base.EvidenciaConexionBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

/**
 *
 * @author angel
 */
public class editar_cancelacion {
     public static void main(String[] args) {
 //CONEXION
        EvidenciaConexionBase con = new EvidenciaConexionBase();
        Connection cn;
        Statement st;
        ResultSet rs;
        
    //DATOS A EDITAR
        int id_editar=0002;  
        String new_activar="suspender";
        String new_rango="tresmeses";
        
    //INSTRUCCION SQL
        String sql= "UPDATE schedule set activar= '"+new_activar+"',rango='"+ new_rango+"'where IdS="+id_editar;
               
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editar_cancelacion.class.getName()).log(Level.SEVERE, null, ex);
        }

         try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // AGREAR DATOS
            rs = st.executeQuery("SELECT * FROM schedule"); // EDITAR DATOS DE LA TABLA OFERTAS
            rs.next();
  // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA OFERTAS
            do {
                System.out.println(rs.getInt("IdS")+": "+rs.getString("activar")+" - "+rs.getString("rango"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(editar_cancelacion.class.getName()).log(Level.SEVERE, null, ex);
        } 
 }
 }
