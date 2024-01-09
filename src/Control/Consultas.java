/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class Consultas {
    public Consultas(){
        
    }
    
    public int obtenerTablas(){
        //En este caso no vamos a agregar tablas, asi que no hace falta ninguna funcion
        int x=5; //no contamos la tabla "dirigir" ya que se utiliza unicamente de forma interna
        return x;
    }
    
    public String[] obtenerTablasName(){
        //Las tablas son fijas y no hace falta hacer una consulta
        String[] tablas = new String[]{"autor","creditos","documental","festival","secciones"};
        return tablas;
    }
    
    public String consultaTabla(String tabla){
        String result = "";
        boolean bandera = true;
        Connection con = Conexion.obtenerConexion();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String q;
        try {
            q = "SELECT * FROM "+tabla+"";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                //dependiendo de la tabla que sea hay que adaptar los gets
                if(tabla.equals("autor")){
                    result += rs.getInt("AutorID");
                    result += " | ";
                    result += rs.getString("Nombre");
                    result += " | ";
                    result += rs.getString("Ap_Paterno");
                } else if(tabla.equals("creditos")){
                    result += rs.getString("TITULO");
                    result += " | ";
                    result += rs.getString("Fotografias");
                    result += " | ";
                    result += rs.getString("Produccion");
                    result += " | ";
                    result += rs.getString("Guion");
                    result += " | ";
                    result += rs.getString("Produccion_Ejecutiva");
                    result += " | ";
                    result += rs.getString("Edicion");
                    result += " | ";
                    result += rs.getString("Sonido");
                    result += " | ";
                    result += rs.getString("Compania_Productora");
                } else if(tabla.equals("documental")){
                    result += rs.getString("Titulo");
                    result += " | ";
                    result += rs.getInt("Año");
                    result += " | ";
                    result += rs.getString("Paises");
                    result += " | ";
                    result += rs.getInt("Duracion_en_minutos");
                    result += " | ";
                    result += rs.getString("Director");
                    result += " | ";
                    result += rs.getString("Sinopsis");
                    result += " | ";
                    result += rs.getString("Semblanza");
                    result += " | ";
                    result += rs.getString("Iniciativas");
                    result += " | ";
                    result += rs.getString("TEMATICA");
                    result += " | ";
                    result += rs.getString("Festivales_y_premios");
                } else if(tabla.equals("festival")){
                    result += rs.getString("Nombre");
                    result += " | ";
                    result += rs.getString("Lugar");
                    result += " | ";
                    result += rs.getDate("Fecha");
                    result += " | ";
                    result += rs.getString("Descripcion");
                    result += " | ";
                    result += rs.getInt("Costo");                 
                } else if(tabla.equals("secciones")){
                    result += rs.getString("Nombre_de_la_seccion");
                    result += " | ";
                    result += rs.getDate("Calendario");
                    result += " | ";
                    result += rs.getString("Descripcion");
                    result += " | ";
                    result += rs.getString("Documental");
                    result += " | ";
                    result += rs.getString("Festival");    
                }
                result += "\n\n";
            }
        }catch (Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
                rs.close();
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        if(bandera)
            return result;
        return "";
    }
    
    public boolean borrarDocumental(String llave){
        boolean bandera=true;
        Connection con = Conexion.obtenerConexion();
        PreparedStatement ps = null;
        String q="";
        try {
            q = "DELETE FROM documental WHERE Titulo = ?";
            ps = con.prepareStatement(q);
            ps.setString(1,llave);
            ps.executeUpdate();
        }catch (Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        if(bandera)
            return true;
        return false;
    }
    
    public boolean borrarAutor(String llave){
        boolean bandera=true;
        int id = 0;
        Connection con = Conexion.obtenerConexion();
        PreparedStatement ps = null;
        String q="";
        try {
            System.out.println("Entro a autor");
            id = Integer.parseInt(llave);
            System.out.println("El id es "+id);
            q = "DELETE FROM autor WHERE AutorID = ?";
            ps = con.prepareStatement(q);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (Exception ex) {
            bandera = false;
            ex.printStackTrace();
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
            } catch (SQLException ex) {
                bandera = false;
                ex.printStackTrace();
            }
        }
        
        if(bandera)
            return true;
        return false;
    }
    
    public boolean borrarCreditos(String llave){
        boolean bandera=true;
        Connection con = Conexion.obtenerConexion();
        PreparedStatement ps = null;
        String q="";
        try {
            q = "DELETE FROM creditos WHERE TITULO = ?";
            ps = con.prepareStatement(q);
            ps.setString(1,llave);
            ps.executeUpdate();
        }catch (Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        if(bandera)
            return true;
        return false;
    }
    
    public boolean borrarFestival(String llave){
        boolean bandera=true;
        Connection con = Conexion.obtenerConexion();
        PreparedStatement ps = null;
        String q="";
        try {
            q = "DELETE FROM festival WHERE Nombre = ?";
            ps = con.prepareStatement(q);
            ps.setString(1,llave);
            ps.executeUpdate();
        }catch (Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        if(bandera)
            return true;
        return false;
    }
    
    public boolean borrarSecciones(String llave){
        boolean bandera=true;
        Connection con = Conexion.obtenerConexion();
        PreparedStatement ps = null;
        String q="";
        try {
            q = "DELETE FROM secciones WHERE Nombre_de_la_seccion = ?";
            ps = con.prepareStatement(q);
            ps.setString(1,llave);
            ps.executeUpdate();
        }catch (Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        if(bandera)
            return true;
        return false;
    }
    
    public boolean insertarAutor(int id, String a1, String a2){
        boolean bandera = true;
        
        Connection con = Conexion.obtenerConexion();
        Statement ps = null;
        String q;
        try {
            q = "INSERT INTO autor values ("+id+",'"+a1+"', '"+a2+"')";
            ps = con.createStatement();
            ps.executeUpdate(q);
        }catch (Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        return bandera;
    }
    
    public boolean insertarCreditos(String a1, String a2, String a3, String a4, String a5, String a6, String a7, String a8){
        boolean bandera = true;
        
        Connection con = Conexion.obtenerConexion();
        Statement ps = null;
        String q;
        try {
            q = "INSERT INTO creditos values ('"+a1+"','"+a2+"', '"+a3+"', '"+a4+"', '"+a5+"', '"+a6+"', '"+a7+"', '"+a8+"')";
            ps = con.createStatement();
            ps.executeUpdate(q);
        }catch (Exception ex) {
            bandera = false;
            ex.printStackTrace();
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
            } catch (SQLException ex) {
                bandera = false;
                ex.printStackTrace();
            }
        }
        
        return bandera;
    }
    
    public boolean insertarDocumental(int e1, int e2, String a1, String a2, String a3, String a4, String a5, String a6, String a7, String a8){
        boolean bandera = true;
        
        Connection con = Conexion.obtenerConexion();
        Statement ps = null;
        String q;
        try {
            q = "INSERT INTO documental values ('"+a1+"', "+e1+", '"+a2+"', "+e2+", '"+a3+"', '"+a4+"', '"+a5+"', '"+a6+"', '"+a7+"', '"+a8+"')";
            ps = con.createStatement();
            ps.executeUpdate(q);
        }catch (Exception ex) {
            bandera = false;
            ex.printStackTrace();
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
            } catch (SQLException ex) {
                bandera = false;
                ex.printStackTrace();
            }
        }
        
        return bandera;
    }
    
    public boolean insertarFestival(String a1, String a2, String a3, String a4, int e1){
        boolean bandera = true;
        
        Connection con = Conexion.obtenerConexion();
        Statement ps = null;
        String q;
        try {
            q = "INSERT INTO festival values ('"+a1+"','"+a2+"', '"+a3+"', '"+a4+"', "+e1+")";
            ps = con.createStatement();
            ps.executeUpdate(q);
        }catch (Exception ex) {
            bandera = false;
            ex.printStackTrace();
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
            } catch (SQLException ex) {
                bandera = false;
                ex.printStackTrace();
            }
        }
        
        return bandera;
    }
    
    public boolean insertarSeccion(String a1, String a2, String a3, String a4, String a5){
        boolean bandera = true;
        
        Connection con = Conexion.obtenerConexion();
        Statement ps = null;
        String q;
        try {
            q = "INSERT INTO secciones values ('"+a1+"','"+a2+"', '"+a3+"', '"+a4+"', '"+a5+"')";
            ps = con.createStatement();
            ps.executeUpdate(q);
        }catch (Exception ex) {
            bandera = false;
            ex.printStackTrace();
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
            } catch (SQLException ex) {
                bandera = false;
                ex.printStackTrace();
            }
        }
        
        return bandera;
    }
    
    public String[] consultaAutor(int id){
        String[] consulta = new String[3];
        
        boolean bandera = true;
        Connection con = Conexion.obtenerConexion();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String q;
        
        try {
            q = "SELECT * FROM autor where AutorID = "+id+"";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                consulta[0] = rs.getInt("AutorID")+"";
                consulta[1] = rs.getString("Nombre");
                consulta[2] = rs.getString("Ap_Paterno");
            }
        } catch(Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
                rs.close();
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        if (bandera)
            return consulta;
        return null;
    }
    
    public boolean updateAutor(int id, String a1, String a2){
        boolean bandera = true;
        Connection con = Conexion.obtenerConexion();
        Statement ps = null;
        String q;
        try {
            q = "UPDATE autor SET Nombre = '"+a1+"', Ap_Paterno = '"+a2+"' where AutorID = "+id;
            ps = con.createStatement();
            ps.executeUpdate(q);
            
        }catch (Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        return bandera;
    }
    
    
    public String[] consultaSecciones(String nombre){
        String[] consulta = new String[5];
        
        boolean bandera = true;
        Connection con = Conexion.obtenerConexion();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String q;
        
        try {
            q = "SELECT * FROM secciones where Nombre_de_la_seccion = '"+nombre+"'";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                consulta[0] = rs.getString("Nombre_de_la_seccion");
                consulta[1] = rs.getString("Calendario");
                consulta[2] = rs.getString("Descripcion");
                consulta[3] = rs.getString("Documental");
                consulta[4] = rs.getString("Festival");
            }
        } catch(Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
                rs.close();
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        if (bandera)
            return consulta;
        return null;
    }
    
    public String[] consultaCreditos(String nombre){
        String[] consulta = new String[8];
        
        boolean bandera = true;
        Connection con = Conexion.obtenerConexion();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String q;
        
        try {
            q = "SELECT * FROM creditos where TITULO = '"+nombre+"'";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                consulta[0] = rs.getString("TITULO");
                consulta[1] = rs.getString("Fotografias");
                consulta[2] = rs.getString("Produccion");
                consulta[3] = rs.getString("Guion");
                consulta[4] = rs.getString("Produccion_Ejecutiva");
                consulta[5] = rs.getString("Edicion");
                consulta[6] = rs.getString("Sonido");
                consulta[7] = rs.getString("Compania_productora");
            }
        } catch(Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
                rs.close();
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        if (bandera)
            return consulta;
        return null;
    }
    
    public String[] consultaDocumental(String nombre){
        String[] consulta = new String[10];
        
        boolean bandera = true;
        Connection con = Conexion.obtenerConexion();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String q;
        
        try {
            q = "SELECT * FROM documental where Titulo = '"+nombre+"'";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                consulta[0] = rs.getString("Titulo");
                consulta[1] = rs.getInt("Año")+"";
                consulta[2] = rs.getString("Paises");
                consulta[3] = rs.getInt("Duracion_en_minutos")+"";
                consulta[4] = rs.getString("Director");
                consulta[5] = rs.getString("Sinopsis");
                consulta[6] = rs.getString("Semblanza");
                consulta[7] = rs.getString("Iniciativas");
                consulta[8] = rs.getString("TEMATICA");
                consulta[9] = rs.getString("Festivales_y_premios");
            }
        } catch(Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
                rs.close();
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        if (bandera)
            return consulta;
        return null;
    }
    
    public String[] consultaFestival(String nombre){
        String[] consulta = new String[5];
        
        boolean bandera = true;
        Connection con = Conexion.obtenerConexion();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String q;
        
        try {
            q = "SELECT * FROM festival where Nombre = '"+nombre+"'";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                consulta[0] = rs.getString("Nombre");
                consulta[1] = rs.getString("Lugar");
                consulta[2] = rs.getString("Fecha");
                consulta[3] = rs.getString("Descripcion");
                consulta[4] = rs.getInt("Costo")+"";
            }
        } catch(Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
                rs.close();
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        if (bandera)
            return consulta;
        return null;
    }
    
    //xd
    public boolean updateSecciones(String llave, String a1, String a2, String a3, String a4){
        boolean bandera = true;
        Connection con = Conexion.obtenerConexion();
        Statement ps = null;
        String q;
        try {
            q = "UPDATE secciones SET Calendario = '"+a1+"', Descripcion = '"+a2+"', Documental = '"+a3+"', Festival = '"+a4+"' where Nombre_de_la_seccion = '"+llave+"'";
            ps = con.createStatement();
            ps.executeUpdate(q);
            
        }catch (Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        return bandera;
    }
    
    public boolean updateCreditos(String llave, String a1, String a2, String a3, String a4, String a5, String a6, String a7){
        boolean bandera = true;
        Connection con = Conexion.obtenerConexion();
        Statement ps = null;
        String q;
        try {
            q = "UPDATE creditos SET Fotografias = '"+a1+"', Produccion = '"+a2+"', Guion = '"+a3+"', Produccion_Ejecutiva = '"+a4+"', Edicion = '"+a5+"', Sonido = '"+a6+"', Compania_productora = '"+a7+"' where TITULO = '"+llave+"'";
            ps = con.createStatement();
            ps.executeUpdate(q);
            
        }catch (Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        return bandera;
    }
    
    public boolean updateFestival(String llave, String a1, String a2, String a3, int a4){
        boolean bandera = true;
        Connection con = Conexion.obtenerConexion();
        Statement ps = null;
        String q;
        try {
            q = "UPDATE festival SET Lugar = '"+a1+"', Fecha = '"+a2+"', Descripcion = '"+a3+"', Costo = "+a4+" where Nombre = '"+llave+"'";
            ps = con.createStatement();
            ps.executeUpdate(q);
            
        }catch (Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        return bandera;
    }
    
     public boolean updateDocumental(String llave, String a1, String a2, String a3, String a4, String a5, String a6, String a7, int e2, int e4){
        boolean bandera = true;
        Connection con = Conexion.obtenerConexion();
        Statement ps = null;
        String q;
        try {
            q = "UPDATE documental SET Año = "+e2+", Paises = '"+a1+"', Duracion_en_minutos = '"+e4+"', Director = '"+a2+"', Sinopsis = '"+a3+"', Semblanza = '"+a4+"', Iniciativas = '"+a5+"', TEMATICA = '"+a6+"', Festivales_y_premios = '"+a7+"' where Titulo = '"+llave+"'";
            ps = con.createStatement();
            ps.executeUpdate(q);
            
        }catch (Exception ex) {
            bandera = false;
        }finally{
            try {
                con.close();
                ps.close();
                q = "";
            } catch (SQLException ex) {
                bandera = false;
            }
        }
        
        return bandera;
    }
}
