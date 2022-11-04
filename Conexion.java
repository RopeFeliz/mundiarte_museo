package Bdd;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class Conexion 
{
    private Connection Con;
    private final String Bdd = "jdbc:mysql://Localhost/usuarios";
    private final String Usu = "root";
    private final String Clave = "";
    private final String Driver = "com.mysql.jdbc.Driver";
    

    public Conexion() 
    {
        Con = null;
        try 
        {
            Class.forName(Driver);
            Con = DriverManager.getConnection(Bdd, Usu, Clave);
        } catch (ClassNotFoundException e) 
        {
            JOptionPane.showMessageDialog(null, "No puede levantar el driver" + e);
        } catch (SQLException s) 
        {
            JOptionPane.showMessageDialog(null, "Error de conexiÃ³n" + s);
        }
        
        
        
    }
    
    public Connection MeConecto()
    {
        return Con;
    }
    
    public void MeDesconecto()
    {
        try 
        {
            JOptionPane.showMessageDialog(null, "Cerrando la conexiÃ³n");
            Con.close();
            
        } catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la base de datos" + e);
        }
        
        
    }
    
}
