package be.abis.exe1.ut;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { TestPerson.class, TestAddress.class, TestCompany.class,
           TestPaymentService.class, TestAddressRepositoryFile.class } )
public class MyTestSuite {
}
