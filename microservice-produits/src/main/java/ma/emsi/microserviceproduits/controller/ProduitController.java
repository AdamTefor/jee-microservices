package ma.emsi.microserviceproduits.controller;

import ma.emsi.microserviceproduits.domain.Produit;
import ma.emsi.microserviceproduits.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @PostMapping
    public Produit create(@RequestBody Produit p) { return service.create(p); }

    @GetMapping
    public List<Produit> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Produit one(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public Produit update(@PathVariable Long id, @RequestBody Produit p) { return service.update(id, p); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
