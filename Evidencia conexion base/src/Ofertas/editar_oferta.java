/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ofertas;

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
public class editar_oferta {
    public static void main(String[] args) {
 //CONEXION
        EvidenciaConexionBase con = new EvidenciaConexionBase();
        Connection cn;
        Statement st;
        ResultSet rs;
        
    //DATOS A EDITAR
        int id_editar=3;  
        String new_oferta="cinecanal";
        String new_antiguedad="cuatro";
        
    //INSTRUCCION SQL
        String sql= "UPDATE ofertas set oferta= '"+new_oferta+"',antiguedad='"+ new_antiguedad+"'where IdS="+id_editar;
               
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editar_oferta.class.getName()).log(Level.SEVERE, null, ex);
        }

         try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // AGREAR DATOS
            rs = st.executeQuery("SELECT * FROM ofertas"); // EDITAR DATOS DE LA TABLA OFERTAS
            rs.next();
  // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA OFERTAS
            do {
                System.out.println(rs.getInt("IdS")+": "+rs.getString("oferta")+" - "+rs.getString("antiguedad"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(editar_oferta.class.getName()).log(Level.SEVERE, null, ex);
        } 
 }
 }