/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ofertas;

import evidencia.conexion.base.EvidenciaConexionBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
/**
 *
 * @author angel
 */
public class agregar_oferta {
  public static void main(String[] args) {
        // CONEXION
        EvidenciaConexionBase con = new EvidenciaConexionBase();
        Connection cn;
        Statement st;
        ResultSet rs;
        
        // AGREGAR DATOS
        String oferta= "movycity";
        String antiguedad= "tres";
        
        // INSTRUCCION SQL
        String sql="INSERT INTO ofertas(oferta, antiguedad)values ('"+oferta+"','"+antiguedad+"')";
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar_oferta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // AGREAR DATOS
            rs = st.executeQuery("SELECT * FROM ofertas"); // TRAER DATOS DE LA TABLA ofertas
            rs.next();
  // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA OFERTAS
            do {
                System.out.println(rs.getInt("IdS")+": "+rs.getString("oferta")+" - "+rs.getString("antiguedad"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(agregar_oferta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
   

