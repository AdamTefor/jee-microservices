package ma.emsi.microservicecommandes.service;

import ma.emsi.microservicecommandes.client.ProduitFeignClient;
import ma.emsi.microservicecommandes.client.dto.ProduitDTO;
import ma.emsi.microservicecommandes.domain.Commande;
import ma.emsi.microservicecommandes.dto.CommandeDetailsDTO;
import ma.emsi.microservicecommandes.repository.CommandeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommandeService {

    private final CommandeRepository repository;
    private final ProduitFeignClient produitClient;

    public CommandeService(CommandeRepository repository, ProduitFeignClient produitClient) {
        this.repository = repository;
        this.produitClient = produitClient;
    }

    // CRUD
    public Commande create(Commande c) {
        return repository.save(c);
    }

    @Transactional(readOnly = true)
    public List<Commande> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Commande findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande introuvable : " + id));
    }

    public Commande update(Long id, Commande c) {
        Commande existing = findById(id);
        existing.setDescription(c.getDescription());
        existing.setQuantite(c.getQuantite());
        existing.setDate(c.getDate());
        existing.setMontant(c.getMontant());
        existing.setIdProduit(c.getIdProduit());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Détails commande + produit (Feign + fallback)
    @Transactional(readOnly = true)
    public CommandeDetailsDTO getDetails(Long id) {
        Commande c = findById(id);

        CommandeDetailsDTO dto = new CommandeDetailsDTO();
        dto.setId(c.getId());
        dto.setDescription(c.getDescription());
        dto.setQuantite(c.getQuantite());
        dto.setDate(c.getDate());
        dto.setMontant(c.getMontant());
        dto.setIdProduit(c.getIdProduit());

        // Si idProduit existe => appel Feign
        if (c.getIdProduit() != null) {
            try {
                ProduitDTO p = produitClient.getProduitById(c.getIdProduit());
                dto.setProduit(p);
            } catch (Exception ex) {
                // Sécurité: même si fallback ne marche pas, on évite le 500
                ProduitDTO fallback = new ProduitDTO();
                fallback.setId(c.getIdProduit());
                fallback.setNom("Produit indisponible");
                fallback.setPrix(0.0);
                dto.setProduit(fallback);
            }
        }

        return dto;
    }
}
