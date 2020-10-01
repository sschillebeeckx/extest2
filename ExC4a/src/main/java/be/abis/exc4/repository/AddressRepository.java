package be.abis.exc4.repository;

import be.abis.exc4.model.Address;

import java.io.IOException;
import java.nio.file.Path;

public interface AddressRepository {
    
    void saveAddress(Address a, Path pathToFile) throws IOException;

}
