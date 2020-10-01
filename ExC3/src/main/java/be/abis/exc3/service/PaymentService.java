package be.abis.exc3.service;

import be.abis.exc3.exception.SalaryTooLowException;
import be.abis.exc3.model.Person;

public interface PaymentService {

    void paySalary(Person person) throws SalaryTooLowException;

}
