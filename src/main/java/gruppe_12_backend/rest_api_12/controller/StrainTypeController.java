package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.model.StrainType;
import gruppe_12_backend.rest_api_12.service.StrainTypeService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "StrainType")
@ResponseBody
@RestController
@RequestMapping("/strains/type")
public class StrainTypeController {
    private final StrainTypeService strainTypeService;

    public StrainTypeController(StrainTypeService strainTypeService) {
        this.strainTypeService = strainTypeService;
    }

    @GetMapping
    public List<StrainType> getAllStrainTypes() {
        return strainTypeService.findAll();
    }


}
