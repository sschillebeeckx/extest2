package be.abis.exa3.ut;


import be.abis.exa3.model.Address;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestAddress {

    @Test
    public void testThatBelgianZipCodeIsNumeric() {
        //arrange
        Address a = new Address("Diestsevest","32 bus 4B","3000","Leuven","Belgium","BE");

        //act
        boolean b = a.checkBelgianZipCode();

        //assert
        assertTrue(b);
    }
}
