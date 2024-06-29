/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package evidencia.conexion.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author angel
 */
public class EvidenciaConexionBase {
    Connection con;

   public EvidenciaConexionBase(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tecnico","root","20958000");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("No conectado");
        }
 
}
       public Connection getConection(){
        return con;}
 
}
