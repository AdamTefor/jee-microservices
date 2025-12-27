package ma.emsi.microservicecommandes.dto;

import ma.emsi.microservicecommandes.client.dto.ProduitDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CommandeDetailsDTO {

    private Long id;
    private String description;
    private Integer quantite;
    private LocalDate date;
    private BigDecimal montant;

    private Long idProduit;
    private ProduitDTO produit; // infos récupérées depuis microservice-produits

    public CommandeDetailsDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getQuantite() { return quantite; }
    public void setQuantite(Integer quantite) { this.quantite = quantite; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public BigDecimal getMontant() { return montant; }
    public void setMontant(BigDecimal montant) { this.montant = montant; }

    public Long getIdProduit() { return idProduit; }
    public void setIdProduit(Long idProduit) { this.idProduit = idProduit; }

    public ProduitDTO getProduit() { return produit; }
    public void setProduit(ProduitDTO produit) { this.produit = produit; }
}
