package tn.stb.pfe.models;

import lombok.*;
import tn.stb.pfe.models.user.provider.Provider;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Banque implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numBanque;

    private String nomBanque;
    @ManyToOne
    private Provider provider;
    @ManyToMany
    private Set<Work> works;
}