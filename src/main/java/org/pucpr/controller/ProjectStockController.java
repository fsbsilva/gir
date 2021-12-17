package org.pucpr.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.pucpr.domain.*;
import org.pucpr.dto.ProductDTO;
import org.pucpr.dto.ProjectDTO;
import org.pucpr.dto.ProjectStockDTO;

import org.pucpr.service.ProjectStockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@Slf4j
public class ProjectStockController {
    private final ProjectStockService service;

    public ProjectStockController(ProjectStockService service) {this.service = service;}

    @PostMapping("/projectstock")
    public ResponseEntity createProjectStock(@RequestBody ProjectStockDTO dto) {
        log.info("Request : {}", dto);
        UUID uudi = UUID.randomUUID();
        dto.getProject().setId(uudi.toString());
        if ( dto.getProject().getTypes().size() > 0 ){
            for ( Type type : dto.getProject().getTypes() ){
                uudi = UUID.randomUUID();
                type.setId(uudi.toString());
                if ( type.getProducts().size() > 0 ){
                    for ( Product product : type.getProducts() ){
                        uudi = UUID.randomUUID();
                        product.setId(uudi.toString());
                        if ( product.getCompany() != null ) {
                            uudi = UUID.randomUUID();
                            product.getCompany().setId(uudi.toString());
                            product.setType_id(type.getId());
                            Company company = getCEP(product.getCompany());
                            product.setCompany(company);
                        }
                    }
                }
            }
        }
        service.save(dto.toProjectStock());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private Company getCEP(Company company)    {
        final String uri = "https://viacep.com.br/ws/" + company.getCep() + "/json/";
        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(uri, String.class);
        JSONObject obj = new JSONObject(json);
        company.setEndereco(obj.getString("logradouro"));
        return company;
    }

    @GetMapping("/projectstocks")
    public List<ProjectStock> getAll() {
        return service.findAll();
    }



}
