package be.abis.exc4b.repository;

import be.abis.exc4b.model.Address;

import java.io.IOException;
import java.nio.file.Path;

public interface AddressRepository {
    
    void saveAddress(Address a, Path pathToFile) throws IOException;

}
