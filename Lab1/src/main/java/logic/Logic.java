package logic;

import java.util.List;

import dao.DevelopingDAO;

public class Logic {

	public static long calculateCost(long projectId) {
		List<List<Long>> info = DevelopingDAO.getCostAndHoursByProjectId(projectId);
		long cost = 0;
		assert info != null;
		for (List<Long> longs : info) {
			cost += longs.get(0) * longs.get(1);
		}
		return cost;
	}
}
