package ma.emsi.microservicecommandes.controller;

import ma.emsi.microservicecommandes.client.ProduitFeignClient;
import ma.emsi.microservicecommandes.client.dto.ProduitDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestFeignController {

    private final ProduitFeignClient produitFeignClient;

    public TestFeignController(ProduitFeignClient produitFeignClient) {
        this.produitFeignClient = produitFeignClient;
    }

    @GetMapping("/produit/{id}")
    public ProduitDTO test(@PathVariable Long id) {
        return produitFeignClient.getProduitById(id);
    }
}
