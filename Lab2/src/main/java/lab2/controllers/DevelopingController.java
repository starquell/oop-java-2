package lab2.controllers;

import lab2.services.DevelopingService;
import lab2.entities.Developing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "api/developings")
public class DevelopingController {

    private final DevelopingService developingService;

    @Autowired
    public DevelopingController(DevelopingService developingService){
        this.developingService = developingService;
    }

    @GetMapping
    public List<Developing> GetDevelopings(){
        return developingService.GetDevelopings();
    }

    @GetMapping(path="{developingId}")
    public Developing GetDeveloping(@PathVariable("developingId") Long developingId){
        return developingService.GetDevelopingById(developingId);
    }

    @PostMapping
    public void registerNewDeveloping(@RequestBody Developing developing){
        developingService.addNewDeveloping(developing);
    }

    @DeleteMapping(path="{developingId}")
    public void deleteDeveloping(@PathVariable("developingId") Long developingId){
        developingService.deleteDeveloping(developingId);
    }

    @PutMapping(path={"{developingId}"})
    public void updateDeveloping(
            @PathVariable("developingId") Long developingId,
            @RequestBody Developing developing){
        developingService.updateDeveloping(developingId, developing);
    }
}
