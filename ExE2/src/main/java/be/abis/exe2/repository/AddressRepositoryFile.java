package be.abis.exe2.repository;

import be.abis.exe2.model.Address;

import java.io.IOException;
import java.nio.file.Path;

public class AddressRepositoryFile implements AddressRepository {

    @Override
    public void saveAddress(Address a, Path pathToFile) throws IOException {
        a.writeToFile(pathToFile);
    }
}
