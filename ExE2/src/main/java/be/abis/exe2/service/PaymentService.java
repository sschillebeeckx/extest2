package be.abis.exe2.service;

import be.abis.exe2.exception.SalaryTooLowException;
import be.abis.exe2.model.Person;

public interface PaymentService {

    void paySalary(Person person) throws SalaryTooLowException;
    String findEncryptedPassword(String pwd);
}
