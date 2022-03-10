package com.projetAngular.stylos;

import com.projetAngular.stylos.model.Stylo;
import com.projetAngular.stylos.service.StyloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stylo")
public class StyloResource {
    private final StyloService styloService;

    public StyloResource(StyloService styloService) {
        this.styloService = styloService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Stylo>> getAllStylos(){
        List<Stylo> stylos = styloService.findAllStylos();
        return new ResponseEntity<>(stylos, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Stylo> getStyloByID(@PathVariable("id") Long id){
        Stylo stylo = styloService.findStyloById(id);
        return new ResponseEntity<>(stylo, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Stylo> addStylo(@RequestBody Stylo stylo){
        Stylo newStylo = styloService.saveStylo(stylo);
        return new ResponseEntity<>(newStylo, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Stylo> updateStylo(@RequestBody Stylo stylo){
        Stylo updStylo = styloService.saveStylo(stylo);
        return new ResponseEntity<>(updStylo, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStylo(@PathVariable("id") Long id){
        styloService.deleteStylo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
