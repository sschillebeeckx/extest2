package be.abis.exe2.utility;

import be.abis.exe2.model.Person;

public class SecurityChecker {

    public final boolean isAbisEmployee(Person p){
        boolean isAbisEmployee=false;
        if (p.getCompany().getName().equalsIgnoreCase("Abis")){
            isAbisEmployee=true;
        }
        return isAbisEmployee;
    }

    public static String encryptPassword(String password){
        StringBuilder sb = new StringBuilder(password);
        sb.reverse();
        return sb.toString();
    }
}
