package ma.emsi.microserviceproduits.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    private BigDecimal prix;
    private Integer quantiteStock;

    public Produit() {}

    public Produit(String nom, BigDecimal prix, Integer quantiteStock) {
        this.nom = nom;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
    }

    public Long getId() { return id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public BigDecimal getPrix() { return prix; }
    public void setPrix(BigDecimal prix) { this.prix = prix; }

    public Integer getQuantiteStock() { return quantiteStock; }
    public void setQuantiteStock(Integer quantiteStock) { this.quantiteStock = quantiteStock; }
}
