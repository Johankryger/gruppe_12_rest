package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.service.StrainService;
import gruppe_12_backend.rest_api_12.model.Strain;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Strain")
@ResponseBody
@RestController
@RequestMapping("/strains")
public class StrainController {

    private StrainService strainService;

    public StrainController(StrainService strainService) {
        this.strainService = strainService;
    }

    @GetMapping
    public List<Strain> getAllStrains() {
        return strainService.findAll();
    }

    @ApiOperation(value = "Get a strain by id", notes = "Returns a strain given the specific id")
    @GetMapping("/{id}")
    public ResponseEntity<Strain> getStrain(@PathVariable("id") long id){
        return ResponseEntity.ok(strainService.getStrain(id));
    }

    @ApiOperation(value = "Save a new strain", notes = "Saves a new strain")
    @PostMapping
    public ResponseEntity<Strain> createStrain(@RequestBody Strain strain) {
        return new ResponseEntity<>(strainService.createStrain(strain), HttpStatus.CREATED);
    }
}

