package entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Column(name = "first_name",nullable =false,length = 35)
    private String firsName;
    @Column(name = "last_name",length = 35)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "customer_order_id")
    private CustomerOrder customerOrder;

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }
}
