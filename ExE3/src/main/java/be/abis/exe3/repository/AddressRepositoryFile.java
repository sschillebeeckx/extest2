package be.abis.exe3.repository;

import be.abis.exe3.model.Address;

import java.io.IOException;
import java.nio.file.Path;

public class AddressRepositoryFile implements AddressRepository {

    @Override
    public void saveAddress(Address a, Path pathToFile) throws IOException {
        a.writeToFile(pathToFile);
    }
}
