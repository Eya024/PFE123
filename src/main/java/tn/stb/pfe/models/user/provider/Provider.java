package tn.stb.pfe.models.user.provider;

import tn.stb.pfe.models.Appointment;
import tn.stb.pfe.models.Banque;
import tn.stb.pfe.models.Work;
import tn.stb.pfe.models.WorkingPlan;
import tn.stb.pfe.models.user.User;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "providers")
@PrimaryKeyJoinColumn(name = "id_provider")
public class Provider extends User {

    /* 
    @OneToMany(mappedBy = "provider")
    private List<Appointment> appointments;*/

    @OneToMany(mappedBy = "provider")
    private List<Banque> banques;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "works_providers", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_work"))
    private List<Work> works;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "working_plan_id")
    private WorkingPlan workingPlan;

    


}
