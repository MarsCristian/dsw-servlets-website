package br.ufscar.dc.dsw.Model.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


abstract public class GenericDAO {

    public GenericDAO(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    protected Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/SiteConsultas";

        return DriverManager.getConnection(url, "root", "root");
    }


}