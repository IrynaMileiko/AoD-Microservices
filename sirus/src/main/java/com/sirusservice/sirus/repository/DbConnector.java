package com.sirusservice.sirus.repository;

import com.sirusservice.sirus.entity.SirusNew;

import java.sql.*;

public class DbConnector {
    private final String db_name = "guild_site_db";
    private final String url = "jdbc:mysql://localhost:3307/" + db_name + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection con;
    private final String user = "root", password = "root";
    private String sql;

    public void connect() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateSirus(SirusNew sirusNew) {
        try {
            String sql = "INSERT INTO new (date, name, url)" +
                    "\nVALUES(?,?,?)";
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, sirusNew.getDate());
            stat.setString(2, sirusNew.getName());
            stat.setString(3, sirusNew.getHref());
            stat.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean isNew(SirusNew sirusNew){
        try {
            String sql = "SELECT * FROM new" +
                    "\nWHERE date=? AND name=? AND url=?";
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, sirusNew.getDate());
            stat.setString(2, sirusNew.getName());
            stat.setString(3, sirusNew.getHref());
            ResultSet rs = stat.executeQuery();
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
