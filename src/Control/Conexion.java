/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 
 */
public class Conexion {
    public static Connection obtenerConexion(){
        Connection con = null;
        String user = "root";//Nombre de usuario registrado para la BD
        String password = "n0m3l0";//Contraseña registrada para la BD
        String url = "jdbc:mysql://localhost:3306/proyectov3";//URL de donde esté alojada la BD, en este caso es en el servidor local puerto 3306"jdbc:mysql://us-cdbr-east-02.cleardb.com:3306/heroku_9ad0f74b62bb348?characterEncoding=utf8";//"jdbc:mysql://bn0u7lmchdieamnqsf74-mysql.services.clever-cloud.com";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                System.out.println("Conexion a la BD exitosa");
            }else{
                System.out.println("Fallo conexion BD UnU");
            }
        } catch (Exception ex) {
            System.out.println("Falló la conexión");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }finally{
            return con;
        }
    }
}
