package be.abis.exc4.utility;

import be.abis.exc4.model.Person;

public class SecurityChecker {

    public boolean isAbisEmployee(Person p){
        boolean isAbisEmployee=false;
        if (p.getCompany().getName().equalsIgnoreCase("Abis")){
            isAbisEmployee=true;
        }
        return isAbisEmployee;
    }
}
