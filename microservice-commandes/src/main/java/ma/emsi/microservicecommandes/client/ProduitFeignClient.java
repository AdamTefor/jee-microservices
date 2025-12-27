package ma.emsi.microservicecommandes.client;

import ma.emsi.microservicecommandes.client.dto.ProduitDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "MICROSERVICE-PRODUITS",
        fallback = ProduitFeignClientFallback.class
)
public interface ProduitFeignClient {

    @GetMapping("/api/produits/{id}")
    ProduitDTO getProduitById(@PathVariable("id") Long id);
}
