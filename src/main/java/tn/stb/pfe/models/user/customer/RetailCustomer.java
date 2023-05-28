package tn.stb.pfe.models.user.customer;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity
@Table(name = "retail_customers")
@PrimaryKeyJoinColumn(name = "id_customer")
public class RetailCustomer extends Customer {

    public RetailCustomer() {
    }


}
