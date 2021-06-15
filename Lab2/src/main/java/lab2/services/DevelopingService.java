package lab2.services;

import lab2.entities.Developing;
import lab2.repositories.DevelopingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevelopingService {

    private final DevelopingRepository repository;

    public DevelopingService(DevelopingRepository repository){
        this.repository = repository;
    }

    public List<Developing> GetDevelopings(){
        return repository.findAll();
    }

    public Developing GetDevelopingById(Long developingId){
        Optional<Developing> developing = repository.findById(developingId);
        if (developing.isEmpty()){
            throw new IllegalStateException("No developing with id = " + developingId);
        }
        return developing.get();
    }

    public void addNewDeveloping(Developing developing) {
        var developingByName = repository.findDevelopingByDevAndTask(
                developing.getEmployee_id(), developing.getTask_id());
        if (developingByName.isPresent()){
            throw new IllegalStateException("Developing name is already taken!");
        } else {
            repository.save(developing);
        }
    }

    public void deleteDeveloping(Long developingId){
        if (repository.existsById(developingId)){
            repository.deleteById(developingId);
        } else {
            throw new IllegalStateException("Developing with id = " + developingId + " doesn't exist.");
        }
    }

    public void updateDeveloping(Long developingId, Developing newDeveloping){
        Developing developing = repository.findById(developingId).orElseThrow(() -> new IllegalStateException(
                "Developing with id = " + developingId + " doesn't exist"
        ));
        developing.setEmployee_id(newDeveloping.getEmployee_id());
        developing.setTask_id(newDeveloping.getTask_id());
        developing.setHrs(newDeveloping.getHrs());
        developing.setActive(newDeveloping.isActive());
        repository.save(developing);
    }
}
