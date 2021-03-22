package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {


    DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("select ip_address from people where first_name=? and last_name=?")) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            return getIpByNameByPreparedStatement(ps);
        } catch (SQLException sqe) {
            throw new IllegalStateException("Cannot query", sqe);
        }

    }

    private String getIpByNameByPreparedStatement(PreparedStatement ps) throws SQLException {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString(1);
            }
            throw new IllegalArgumentException("No record exist with given name");
        }
    }
}
