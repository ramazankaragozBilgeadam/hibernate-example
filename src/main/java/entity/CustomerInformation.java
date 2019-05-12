package entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "customer_information")
public class CustomerInformation extends BaseEntity{

    @Column(name = "phone_number",length = 16,nullable = false)
    private String phoneNumber;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    /**
     * Büyük text verileri kayıt ederken @Lob kullanıyoruz.
     */
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "detail_address")
    private String detailAddress;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
}
