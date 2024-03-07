package org.example.m165backend.Bands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bands")
public class BandsController {

    @Autowired
    private BandsService bandsService;

    @GetMapping
    public ResponseEntity<List<Bands>> getAllBands() {
        List<Bands> bands = bandsService.getAllBands();
        return new ResponseEntity<>(bands, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bands> getBandById(@PathVariable String id) {
        Bands band = bandsService.getBandById(id);
        if (band != null) {
            return new ResponseEntity<>(band, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Bands> createBand(@RequestBody Bands band) {
        Bands createdBand = bandsService.createBand(band);
        return new ResponseEntity<>(createdBand, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bands> updateBand(@PathVariable String id, @RequestBody Bands band) {
        Bands updatedBand = bandsService.updateBand(id, band);
        if (updatedBand != null) {
            return new ResponseEntity<>(updatedBand, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBand(@PathVariable String id) {
        bandsService.deleteBand(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
