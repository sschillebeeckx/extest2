package be.abis.exc4.service;

import be.abis.exc4.exception.SalaryTooLowException;
import be.abis.exc4.model.Person;

public interface PaymentService {

    void paySalary(Person person) throws SalaryTooLowException;

}
