package io.transportproject.Transport.controller;

import io.transportproject.Transport.entity.Trip;
import io.transportproject.Transport.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService service;

    
    @PostMapping
    public ResponseEntity<Trip> create(@RequestBody Trip trip) {
        return ResponseEntity.ok(service.create(trip));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Trip> update(@PathVariable Long id, @RequestBody Trip trip) {
        return ResponseEntity.ok(service.update(id, trip));
    }


    @GetMapping
    public ResponseEntity<List<Trip>> list() {
        return ResponseEntity.ok(service.listAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Trip> search(@PathVariable Long id) {
        return ResponseEntity.ok(service.searchById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
}
}
