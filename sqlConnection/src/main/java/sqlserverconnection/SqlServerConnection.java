/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sqlserverconnection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author anibal
 */
public class SqlServerConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        /* CONEXIOON CON UN SELECT DE PRUEBA */
        // traerme todos los datos de la tabla de la base de datos de sql server base de
        // datos = DB_EJEMPLO_SERVLET tabla = USUARIOS
        // 1. Cargar el driver de sql server
        // try {
        // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // } catch (ClassNotFoundException ex) {
        // Logger.getLogger(SqlServerConnection.class.getName()).log(Level.SEVERE, null,
        // ex);
        // }
        // // 2. Crear la conexion
        // Connection conexion = DriverManager
        // .getConnection("jdbc:sqlserver://localhost:1433;databaseName=DB_EJEMPLO_SERVLET",
        // "sa", "123456");
        // // 3. Crear el statement
        // Statement statement = conexion.createStatement();
        // // 4. Ejecutar la consulta
        // ResultSet resultSet = statement.executeQuery("SELECT * FROM USUARIOS");
        // // 5. Recorrer el resultset
        // while (resultSet.next()) {
        // System.out.println("NOMBRE: " + resultSet.getString("USUARIO"));
        // System.out.println("PASSWORD: " + resultSet.getString("PASS"));
        // System.out.println("===================================");
        // }
        // // 6. Cerrar la conexion
        // conexion.close();

        // /* PRUEBA DEL MODEL con LINEDLIST */
        // LinkedList usuarios = new LinkedList();

        // try {
        //     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // } catch (ClassNotFoundException ex) {
        //     Logger.getLogger(SqlServerConnection.class.getName()).log(Level.SEVERE, null, ex);
        // }
        // // 2. Crear la conexion
        // Connection conexion = DriverManager
        //         .getConnection("jdbc:sqlserver://localhost:1433;databaseName=DB_EJEMPLO_SERVLET", "sa", "123456");

        // // 3. Crear el statement
        // Statement statement = conexion.createStatement();

        // // 4. Ejecutar la consulta
        // ResultSet resultSet = statement.executeQuery("SELECT * FROM USUARIOS");

        // // 5. Recorrer el resultset
        // while (resultSet.next()) {
        //     Usuario usuario = new Usuario();
        //     usuario.setUsuario(resultSet.getString("USUARIO"));
        //     // verlo en consola
        //     // System.out.println("NOMBRE: " + resultSet.getString("USUARIO"));
        //     // System.out.println("PASSWORD: " + resultSet.getString("PASS"));

        //     usuario.setPass(resultSet.getString("PASS"));
        //     usuarios.add(usuario);
        // }
        // // 6. Cerrar la conexion
        // conexion.close();

        // // return usuarios;
        // // ver el contenido del objeto usuario
        // for (int i = 0; i < usuarios.size(); i++) {
        //     Usuario usuario = (Usuario) usuarios.get(i);
        //     System.out.println("NOMBRE: " + usuario.getUsuario());
        //     System.out.println("PASSWORD: " + usuario.getPass());
        // }


        // // ver el contenido del objeto usuario directamente
        // Usuario usuario = (Usuario) usuarios.get(0);
        // System.out.println("NOMBRE: " + usuario.getUsuario());
        // System.out.println("PASSWORD: " + usuario.getPass());
        

        // // traerme los datos del xtml de la clase usuario
        // // ver el contenido del objeto usuario
        // for (int i = 0; i < usuarios.size(); i++) {
        //     Usuario usuarioo = (Usuario) usuarios.get(i);
        //     System.out.println("NOMBRE del xhtml: " + usuarioo.getPass_html());

        //     System.out.println("PASSWORD del xhtml: " + usuarioo.getPass_html());
        // }




        // 1. Cargar el driver de sql server
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SqlServerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 2. Crear la conexion
        Connection conexion = DriverManager
                .getConnection("jdbc:sqlserver://localhost:1433;databaseName=DB_EJEMPLO_SERVLET", "sa", "123456");

        // 3. Crear el statement
        Statement statement = conexion.createStatement();

        // 4. Ejecutar la consulta
        ResultSet resultSet = statement.executeQuery("SELECT * FROM USUARIOS");

        // 5. Recorrer el resultseY generarme un string con los datos
        String datos = "";
        while (resultSet.next()) {
            datos += resultSet.getString("USUARIO") + " " + resultSet.getString("PASS") + " ";
        }
        // 6. Cerrar la conexion
        conexion.close();

        // return datos;
        System.out.println("DATOS: " + datos);


        // si en los datos hay una palabra igual a 'anibal' entonces mostrar un mensaje
        if (datos.contains("anibal")) {
            System.out.println("SI HAY UN USUARIO CON EL NOMBRE ANIBAL");
        } else {
            System.out.println("NO HAY UN USUARIO CON EL NOMBRE ANIBAL");
        }

        

    }
}
