package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutils.ConnectionPool;
import entities.Project;

public class ProjectsDAO {
	public static List<Project> getProjectsAll(){
		var cp = ConnectionPool.getConnectionPool();
		try (var conn = cp.getConnection();) {
			String sql = 
					"SELECT * "
					+ "FROM projects";		
			var st = conn.prepareStatement(sql);
			var rs = st.executeQuery();
			List<Project> projects = new ArrayList<Project>();
			while(rs.next()) {				
				long id = rs.getLong(1);
				String name = rs.getString(2);
				projects.add(new Project(id,name));
			}
			st.close();
			cp.releaseConnection(conn);
			return projects;
		} catch (SQLException | InterruptedException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
