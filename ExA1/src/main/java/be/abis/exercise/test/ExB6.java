package be.abis.exercise.test;

import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class ExB6 {

	public static void main(String[] args) {

       Address a = new Address("Diestsevest","32 bus 4B","3000","Leuven","Belgi�","BE");
       Company c = new Company("ABIS",a);
       
       Person p1 = new Person(1,"Ann","Smits",LocalDate.of(1985, 6, 28),c);
       Person p2 = new Person(2,"John","Doe",LocalDate.of(1967, 8, 10));
       
       try ( BufferedWriter bw = Files.newBufferedWriter(Paths.get("personinfo.txt"));){
    	   bw.write(p1 + "\n");
    	   bw.write(p2 + "\n");
    	   System.out.println("persons written to file");
       } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
       

	}

}
