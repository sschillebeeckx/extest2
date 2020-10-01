package be.abis.exc4b.service;

import be.abis.exc4b.exception.SalaryTooLowException;
import be.abis.exc4b.model.Person;

public interface PaymentService {

    void paySalary(Person person) throws SalaryTooLowException;

}
