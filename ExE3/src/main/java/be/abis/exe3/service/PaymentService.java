package be.abis.exe3.service;

import be.abis.exe3.exception.SalaryTooLowException;
import be.abis.exe3.model.Person;

public interface PaymentService {

    void paySalary(Person person) throws SalaryTooLowException;
    String findEncryptedPassword(String pwd);
}
