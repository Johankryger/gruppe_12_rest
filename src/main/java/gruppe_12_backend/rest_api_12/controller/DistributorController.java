package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.model.Distributor;
import gruppe_12_backend.rest_api_12.service.DistributorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

}
