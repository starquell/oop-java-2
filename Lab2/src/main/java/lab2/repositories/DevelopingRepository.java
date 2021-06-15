package lab2.repositories;

import lab2.entities.Developing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DevelopingRepository extends JpaRepository<Developing, Long> {

    @Query("Select s from Developing s where s.employee_id = ?1 and s.task_id = ?2")
    Optional<Developing> findDevelopingByDevAndTask(long emp_id, long task_id);

}
