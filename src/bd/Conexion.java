/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Conexion {

    public Connection crerDB() {
        Connection conexion;
        String barra = File.separator;
        String address = System.getProperty("user.dir") + barra + "BD";
        File url = new File(address);

        if (!url.exists()) {
            System.out.println("Creando base de datos");

            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                String bd = "jdbc:derby:" + address + ";create=true";
                conexion = DriverManager.getConnection(bd);

                String Tabla = "create table Usuarios (Id INT PRIMARY KEY, Nombre Varchar(40),Apellidos Varchar(50))";
                PreparedStatement comando = conexion.prepareStatement(Tabla);
                comando.execute();
                comando.close();

                System.out.println("Base de datos creada");

                return conexion;
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("Error: " + ex);
            }
        }

        return null;
    }

    public Connection Cargardatos() {
        Connection conexion;
        String barra = File.separator;
        String address = System.getProperty("user.dir") + barra + "BD";
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String bd = "jdbc:derby:" + address;
            conexion = DriverManager.getConnection(bd);
            
            System.out.println("BD cargada");
            return conexion;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return null;
    }

}
