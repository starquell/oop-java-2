package dao;

import static org.mockito.Mockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Connection.class, ConnectionPool.class})
public class EmployeesDAOTest {

	@Test
	public void test() {
		PowerMockito.mockStatic(Connection.class);
		PowerMockito.mockStatic(ConnectionPool.class);
	}
}
