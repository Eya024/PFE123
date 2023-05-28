package tn.stb.pfe.models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exchanges")
public class ExchangeRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "exchange_status")
    private ExchangeStatus status;

    @OneToOne
    @JoinColumn(name = "id_appointment_requestor")
    private Appointment requestor;

    @OneToOne
    @JoinColumn(name = "id_appointment_requested")
    private Appointment requested;


    public ExchangeRequest(Appointment requestor, Appointment requested, ExchangeStatus status) {
        this.status = status;
        this.requestor = requestor;
        this.requested = requested;
    }



}
