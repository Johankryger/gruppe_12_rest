package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.service.StrainService;
import gruppe_12_backend.rest_api_12.model.Strain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@RestController
@RequestMapping("/strains")
public class StrainController {

    @Autowired
    private StrainService strainService;

    @GetMapping("/{id}")
    public int getStrain(@PathVariable("id") int id){
        return strainService.getStrain(id).getId();
    }

    @PostMapping("/")
    public Strain createStrain(@RequestBody Strain strain) {
        return strainService.createStrain(strain);
    }


}
