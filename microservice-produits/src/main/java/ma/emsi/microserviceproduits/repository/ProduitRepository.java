package ma.emsi.microserviceproduits.repository;

import ma.emsi.microserviceproduits.domain.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {}
