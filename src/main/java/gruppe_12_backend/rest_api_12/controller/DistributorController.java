package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.model.Distributor;
import gruppe_12_backend.rest_api_12.service.DistributorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Distributor")
@ResponseBody
@RestController
@RequestMapping("/distributors")
public class DistributorController {

    private final DistributorService distributorService;

    public DistributorController(DistributorService distributorService) {
        this.distributorService = distributorService;
    }

    @ApiOperation(value = "Get a distributor by id", notes = "Returns a distributor given the specific id")
    @GetMapping("/{id}")
    public Distributor getDistributor(@PathVariable("id") long id){
        return distributorService.getDistributor(id);
    }

    @ApiOperation(value = "Get a distributor list", notes = "Returns a distributor given the specific id")
    @GetMapping
    public Iterable<Distributor> getAllDistributors(){
        return distributorService.getAllDistributors();
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
