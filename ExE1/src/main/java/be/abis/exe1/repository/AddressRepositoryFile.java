package be.abis.exe1.repository;

import be.abis.exe1.model.Address;

import java.io.IOException;
import java.nio.file.Path;

public class AddressRepositoryFile implements AddressRepository {

    @Override
    public void saveAddress(Address a, Path pathToFile) throws IOException {
        a.writeToFile(pathToFile);
    }
}
