package ma.emsi.microservicecommandes.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer quantite;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal montant;


    private Long idProduit;


    public Commande() {
    }

    public Commande(String description, Integer quantite, LocalDate date, BigDecimal montant) {
        this.description = description;
        this.quantite = quantite;
        this.date = date;
        this.montant = montant;
    }

    public Long getId() { return id; }
    public String getDescription() { return description; }
    public Integer getQuantite() { return quantite; }
    public LocalDate getDate() { return date; }
    public BigDecimal getMontant() { return montant; }

    // getters
    public Long getIdProduit() { return idProduit; }

    public void setId(Long id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setQuantite(Integer quantite) { this.quantite = quantite; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setMontant(BigDecimal montant) { this.montant = montant; }

    //setters
    public void setIdProduit(Long idProduit) { this.idProduit = idProduit; }
}
