/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio_tecnico;


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
public class Agregar_Servicio_tecnico {
    public static void main(String[] args) {
        // CONEXION
        EvidenciaConexionBase con = new EvidenciaConexionBase();
        Connection cn;
        Statement st;
        ResultSet rs;
        
        // AGREGAR DATOS
        String Nombre= "asistencia";
        String Tipo= "net";
        int Cantidad= 2;
        String Direccion_Residencia ="calle9";
        
        // INSTRUCCION SQL
        String sql="INSERT INTO servicios(Nombre, Tipo, Cantidad, Direccion_Residencia)values ('"+Nombre+"','"+Tipo+"','"+Cantidad+"','"+Direccion_Residencia+"')";
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Agregar_Servicio_tecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // AGREAR DATOS
            rs = st.executeQuery("SELECT * FROM servicios"); // TRAER DATOS DE LA TABLA servicios
            rs.next();
  // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA SERVICIOS
            do {
                System.out.println(rs.getInt("IdS")+": "+rs.getString("Nombre")+" - "+rs.getString("Tipo")+" - "+rs.getInt("Cantidad")+": "+rs.getString("Direccion_Residencia"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(Agregar_Servicio_tecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
