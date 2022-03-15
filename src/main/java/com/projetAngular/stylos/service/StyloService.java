package com.projetAngular.stylos.service;

import com.projetAngular.stylos.exceptions.StyloNotFoundException;
import com.projetAngular.stylos.model.Stylo;
import com.projetAngular.stylos.repo.StyloRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StyloService {
    private final StyloRepo styloRepo;

    @Autowired
    public StyloService(StyloRepo styloRepo) {
        this.styloRepo = styloRepo;
    }

    public Stylo saveStylo(Stylo s){
        String url = s.getCollection().toString().concat("/".concat(s.getNom()));
        s.setImageUrl(url);
        return styloRepo.save(s);
    }

    public List<Stylo> findAllStylos(){
        return styloRepo.findAll();
    }

    public Stylo findStyloById(Long styloID){
        return styloRepo.findStyloById(styloID)
                .orElseThrow(() -> new StyloNotFoundException("Stylo" + styloID + "pas trouvé"));
    }

    public void deleteStylo(Long styloID){
        styloRepo.deleteById(styloID);
    }
}
