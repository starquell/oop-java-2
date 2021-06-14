package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import logic.Logic;
import dao.DevelopingDAO;
import dao.EmployeesDAO;
import dao.ProjectsDAO;
import dao.TasksDAO;
import entities.Employee;
import entities.Project;
import entities.Task;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/mng")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);
		String json = null;
		switch (data.get("action").getAsString()) {
			case "listprojects" -> {
				response.setContentType("application/json");
				List<Project> projects = ProjectsDAO.getProjectsAll();
				json = new Gson().toJson(projects);
				response.getWriter().write(json);
			}
			case "listtasks" -> {
				response.setContentType("application/json");
				long prId = data.get("projectId").getAsLong();
				List<Task> tasks = TasksDAO.getTasksByProjectId(prId);
				json = new Gson().toJson(tasks);
				response.getWriter().write(json);
			}
			case "listdevs" -> {
				response.setContentType("application/json");
				long taskId = data.get("taskId").getAsLong();
				Task task = TasksDAO.getTask(taskId);
				Response r = new Response(
						EmployeesDAO.getEmployeesByQualification(task.getQualification()),
						EmployeesDAO.getActiveEmployeeIdsByTaskId(taskId),
						DevelopingDAO.getEmployeeIdsAndHoursByTaskId(taskId),
						task.getWorkers_num()
				);
				json = new Gson().toJson(r);
				response.getWriter().write(json);
			}
			case "calc" -> {
				response.setContentType("text/plain");
				long cost = Logic.calculateCost(data.get("projectId").getAsLong());
				response.getWriter().write(Long.toString(cost));
			}
			case "save" -> {
				Type ListType = new TypeToken<ArrayList<Long>>() {
				}.getType();
				List<Long> empIds = new Gson().fromJson(data.get("selectedIDs"), ListType);
				DevelopingDAO.updateActiveDevelopers(data.get("taskId").getAsLong(), empIds);
			}
		}
	}
	
	private static class Response{
		public List<Employee> allDevs;
		public List<Long> chDevs;
		public Map<Long,Long> hours;
		public long required;
		public Response(List<Employee> allDevs, List<Long> chDevs, Map<Long, Long> hours, long required) {
			super();
			this.allDevs = allDevs;
			this.chDevs = chDevs;
			this.hours = hours;
			this.required = required;
		}
	}

}
