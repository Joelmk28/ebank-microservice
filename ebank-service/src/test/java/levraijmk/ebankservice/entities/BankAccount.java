package levraijmk.ebankservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue
    private String id;
    private Date createdAt;
    private double balance;

    private String type;
    private long customerId;// clé entragere de la table customer dans le customer service


    @Transient // pour que JPA ne le reprensete pas comme une Table dans la bd
    private Customer customer;

}
