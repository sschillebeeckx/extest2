package be.abis.exe1.service;

import be.abis.exe1.exception.SalaryTooLowException;
import be.abis.exe1.model.Person;

public interface PaymentService {

    void paySalary(Person person) throws SalaryTooLowException;
    String findEncryptedPassword(String pwd);
}
