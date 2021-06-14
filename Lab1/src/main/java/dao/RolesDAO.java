package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutils.ConnectionPool;
import entities.Role;

public class RolesDAO {
	public static List<Role> getRolesAll(){
		ConnectionPool cp = ConnectionPool.getConnectionPool();
		try (Connection connection = cp.getConnection();) {
			String sql = 
					"SELECT * "
					+ "FROM roles";
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();			
			List<Role> roles = new ArrayList<Role>();
			while(rs.next()) {				
				long id = rs.getLong(1);
				String title = rs.getString(2);
				roles.add(new Role(id,title));
			}
			st.close();
			cp.releaseConnection(connection);
			return roles;
		} catch (SQLException | InterruptedException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
