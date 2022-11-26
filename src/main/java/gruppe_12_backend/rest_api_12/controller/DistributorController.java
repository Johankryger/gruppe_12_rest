package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.model.Distributor;
import gruppe_12_backend.rest_api_12.service.DistributorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Distributor")
@ResponseBody
@RestController
@RequestMapping("/distributors")
public class DistributorController {

    @Autowired
    private DistributorService distributorService;

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get a distributor by id", notes = "Returns a distributor given the specific id")
    @GetMapping("/{id}")
    public Distributor getDistributor(@PathVariable("id") Long id){
        return distributorService.getDistributor(id);
    }

    @ApiOperation(value = "Get a distributor list", notes = "Returns a distributor given the specific id")
    @GetMapping
    public List<Distributor> getAllDistributors(){
        return distributorService.getAllDistributors();
    }

    @ApiOperation(value = "Save a new distributor", notes = "Saves a new distributor")
    @PostMapping
    public ResponseEntity<Distributor> createDistributor(@RequestBody Distributor distributor) {
        return new ResponseEntity<>(distributorService.createDistributor(distributor), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete a distributor", notes = "Deletes a new distributor")
    @DeleteMapping
    public void deleteDistributor(@RequestBody Distributor distributor) {
        distributorService.deleteDistributor(distributor);
    }

    @ApiOperation(value = "Save a new distributor", notes = "Save a new distributor in the system")
    @PostMapping
    public Distributor saveDistributor(@ModelAttribute("distributor") Distributor distributor) {
        return distributorService.saveDistributor(distributor);
    }

    @ApiOperation(value = "Update an existing distributor", notes = "Update the information for an existing distributor")
    @PutMapping("/{id}")
    public Distributor updateDistributor(@PathVariable Long id, @ModelAttribute("distributor") Distributor distributor) {
        return distributorService.updateDistributor(id, distributor);
    }
}
