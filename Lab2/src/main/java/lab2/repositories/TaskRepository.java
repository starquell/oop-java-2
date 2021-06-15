package lab2.repositories;

import lab2.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

    @Query("Select r from Task r where r.id = ?1")
    Optional<Task> findTaskById(Long id);
}
