package lab2.Services;

import lab2.entities.Developing;
import lab2.repositories.DevelopingRepository;
import lab2.services.DevelopingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class DevelopingServiceTest {

    @Autowired
    private DevelopingService service;
    @MockBean
    private DevelopingRepository repository;

  @Test
    void testGetAll() {
        var dev = new Developing(3, 5, 40, true);
        ArrayList<Developing> devs = new ArrayList<>();
        devs.add(dev);
        doReturn(devs).when(repository).findAll();
        List<Developing> returnedWidget = service.GetDevelopings();
        assertEquals(returnedWidget.size(), 1);
    }

    @Test
    void testUpdate() {
        var dev = new Developing(3, 5, 40, true);
        ArrayList<Developing> devs = new ArrayList<>();
        devs.add(dev);
        doReturn(devs).when(repository).findAll();
        doReturn(Optional.of(dev)).when(repository).findById(3L);

        service.updateDeveloping(3L, new Developing(3, 5, 64, false));
        List<Developing> returnedWidget = service.GetDevelopings();
        assertEquals(returnedWidget.get(0).getTask_id(), 5);
        assertEquals(returnedWidget.get(0).getEmployee_id(), 3);
    }

    @Test
    void testAdd() {
        var dev = new Developing(3, 5, 40, true);
        ArrayList<Developing> devs = new ArrayList<>();
        devs.add(dev);
        doReturn(devs).when(repository).findAll();
        service.addNewDeveloping(new Developing(2, 1, 8, false));
        List<Developing> returnedWidget = service.GetDevelopings();
        assertEquals(returnedWidget.get(0).getTask_id(), 5);
        assertEquals(returnedWidget.get(0).getEmployee_id(), 3);
  }

    @Test
    void testDelete() {
        var dev = new Developing(3, 5, 40, true);
        ArrayList<Developing> devs = new ArrayList<>();
        devs.add(dev);
        doReturn(devs).when(repository).findAll();
        doReturn(true).when(repository).existsById(3L);
        service.deleteDeveloping(3L);
        List<Developing> returnedWidget = service.GetDevelopings();
        assertEquals(returnedWidget.size(), 1);
    }

}
