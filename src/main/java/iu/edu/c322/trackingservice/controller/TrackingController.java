package iu.edu.c322.trackingservice.controller;
import iu.edu.c322.trackingservice.model.Tracker;
import iu.edu.c322.trackingservice.model.*;
import iu.edu.c322.trackingservice.repository.TrackingRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trackings")
public class TrackingController {
    private TrackingRepository repository;


    public TrackingController(TrackingRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Tracker> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{orderId}/{itemId}")
    public Item getTracker(@PathVariable int orderId, @PathVariable int itemId) {
        return repository.getReferenceById(orderId).getItemById(itemId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@Valid @RequestBody Tracker tracker){
        Tracker newTracker = repository.save(tracker);
        return newTracker.getId();
    }

    // PUT localhost:808/customers/2
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Tracker tracker, @PathVariable int id) {
        tracker.setId(id);
        repository.save(tracker);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Tracker tracker = new Tracker();
        tracker.setId(id);
        repository.delete(tracker);
    }
}