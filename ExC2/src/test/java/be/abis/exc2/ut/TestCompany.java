package be.abis.exc2.ut;


import be.abis.exc2.model.Address;
import be.abis.exc2.model.Company;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCompany {

    @Test
    public void taxForBelgianCompanyShouldBe51() {
        //arrange
        Address a = new Address("Diestsevest","32 bus 4B","3000","Leuven","Belgium","BE");
        Company c = new Company("ABIS",a);
        //act
        double taxToPay = c.calculateTaxToPay();

        //assert
        assertEquals(51.01,taxToPay,0.01);
    }


}
