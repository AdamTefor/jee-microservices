package ma.emsi.microservicecommandes.controller;

import ma.emsi.microservicecommandes.domain.Commande;
import ma.emsi.microservicecommandes.dto.CommandeDetailsDTO;
import ma.emsi.microservicecommandes.service.CommandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    private final CommandeService service;

    public CommandeController(CommandeService service) {
        this.service = service;
    }

    @PostMapping
    public Commande create(@RequestBody Commande c) {
        return service.create(c);
    }

    @GetMapping
    public List<Commande> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Commande one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Commande update(@PathVariable Long id, @RequestBody Commande c) {
        return service.update(id, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // Endpoint détails avec produit
    @GetMapping("/{id}/details")
    public CommandeDetailsDTO details(@PathVariable Long id) {
        return service.getDetails(id);
    }
}
