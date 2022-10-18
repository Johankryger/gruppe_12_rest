package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.service.StrainService;
import gruppe_12_backend.rest_api_12.model.Strain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class StrainController {

    private StrainService strainService;

    StrainController(StrainService strainService){
        this.strainService = strainService;
    }


    @GetMapping("/strain/{id}")
    public Strain getStrain(@PathVariable("id") int id){
        return strainService.getStrain(id);
    }

    @GetMapping("/strain/{name}")
    public Set<Strain> getStrains(@PathVariable("name") String name){
        return strainService.getStrains(name);
    }

}
