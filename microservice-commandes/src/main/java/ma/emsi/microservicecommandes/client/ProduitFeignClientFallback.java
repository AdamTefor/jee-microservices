package ma.emsi.microservicecommandes.client;

import ma.emsi.microservicecommandes.client.dto.ProduitDTO;
import org.springframework.stereotype.Component;

@Component
public class ProduitFeignClientFallback implements ProduitFeignClient {

    @Override
    public ProduitDTO getProduitById(Long id) {
        ProduitDTO p = new ProduitDTO();
        p.setId(id);
        p.setNom("Produit indisponible");
        p.setPrix(0.0);
        return p;
    }
}
