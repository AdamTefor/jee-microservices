package ma.emsi.microserviceproduits.service;

import ma.emsi.microserviceproduits.domain.Produit;
import ma.emsi.microserviceproduits.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    private final ProduitRepository repo;

    public ProduitService(ProduitRepository repo) {
        this.repo = repo;
    }

    public Produit create(Produit p) { return repo.save(p); }
    public List<Produit> findAll() { return repo.findAll(); }

    public Produit findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Produit introuvable: " + id));
    }

    public Produit update(Long id, Produit data) {
        Produit p = findById(id);
        p.setNom(data.getNom());
        p.setPrix(data.getPrix());
        p.setQuantiteStock(data.getQuantiteStock());
        return repo.save(p);
    }

    public void delete(Long id) { repo.deleteById(id); }
}
