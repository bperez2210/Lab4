/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab.dao;

import ac.cr.una.lab.model.Universidad;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Bryan
 */
public class UniversidadDAOJdbcImpl implements UniversidadDAO{
    
    private Connection dbConnection = null;
    private Statement statement = null;

    /**
     *
     * @throws SQLException
     */
    public UniversidadDAOJdbcImpl() throws SQLException {
        dbConnection = JdbcUtil.getDBConnection();
        statement = (Statement) dbConnection.createStatement();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Universidad findById(int id) {
        Universidad universidad = null;
        String selectTableSQL = "SELECT id, nombre, direccion, email, telefono from UNIVERSIDAD";

        try {
            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            if (rs != null) {
                universidad = new Universidad();
                while (rs.next()) {

                    universidad.setId(rs.getInt("id"));
                    universidad.setName(rs.getString("nombre"));
                    universidad.setDireccion(rs.getString("direccion"));
                    universidad.setEmail(rs.getString("email"));
                    universidad.setTelefono(rs.getString("telefono"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UniversidadDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UniversidadDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UniversidadDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return universidad;

    }

    /**
     *
     * @param universidad
     * @return
     */
    @Override
    public Universidad save(Universidad universidad) {
        String insertTableSQL = "INSERT INTO UNIVERSIDAD"
                + "(nombre, direccion, email, telefono) " + "VALUES"
                + "('" + universidad.getName() + "','"
                + universidad.getDireccion() + "','"
                + universidad.getEmail()+"','"+ universidad.getTelefono()+ "')";

        try {
            // execute insert SQL stetement
            statement.executeUpdate(insertTableSQL);

        } catch (SQLException ex) {
            Logger.getLogger(UniversidadDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UniversidadDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UniversidadDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return universidad;

    }
    
    /**
     *
     * @param universidad
     * @return
     */
    public Universidad update(Universidad universidad){
        String selectTableSQL = "SELECT id, nombre, direccion, email, telefono from UNIVERSIDAD";
        try {
            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);
            if (rs != null) {
                while (rs.next()) {
                    if(universidad.equals(rs)){
                    rs.updateObject("nombre", universidad.getName());
                    rs.updateObject("direccion", universidad.getDireccion());
                    rs.updateObject("email", universidad.getEmail());
                    rs.updateObject("telefono", universidad.getTelefono());
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UniversidadDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UniversidadDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UniversidadDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return universidad;
    }
    
    /**
     *
     * @param universidad
     * @return
     */
    @Override
    public Universidad erase(Universidad universidad){
            String selectTableSQL = "SELECT id, nombre, direccion, email, telefono from UNIVERSIDAD";
        try {
            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);
            if (rs != null) {
                while (rs.next()) {
                    if(universidad.equals(rs)){
                    rs.deleteRow();
                    universidad = null;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UniversidadDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UniversidadDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UniversidadDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return universidad;
    }
    
    
}
