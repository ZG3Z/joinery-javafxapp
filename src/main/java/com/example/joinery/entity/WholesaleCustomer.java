package com.example.joinery.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "wholesaleCustomer")
@PrimaryKeyJoinColumn(name = "idCW")
public class WholesaleCustomer extends Customer {
    private String companyName;
    private String nip;
    private static int FIXED_BUSINESS_DISCOUNT = 5;

    public WholesaleCustomer(){}

    public WholesaleCustomer(Long id, String companyName, String nip, LocalDate dateJoined, String paymentPreference, String contactPreference,
                             String telephone, String email){
        super();
        setIdC(id);
        setDateJoined(dateJoined);
        setPaymentPreference(paymentPreference);
        setContactPreference(contactPreference);
        setTelephone(telephone);
        setEmail(email);

        this.companyName = companyName;
        this.nip = nip;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Override
    public int calculateDiscount() {
        return getMembershipAge() + FIXED_BUSINESS_DISCOUNT;
    }

    @Override
    public String toString() {
        return getCompanyName();

    }
}
