package com.capgemini.javaAdvancedAssessment1.EmployeeIdCardManagementSystem;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeIdCard-persistence-unit");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction transaction = em.getTransaction();
        
        try {
        	transaction.begin();
        	//create employee 1
        	Employee employee1 = new Employee();
        	employee1.setName("John");
        	employee1.setEmail("john@example.com");
        	
        	
        	
        
        	IDCard idcard1 = new IDCard();
        	idcard1.setIssueDate("2026-02-14");
        	idcard1.setCardNumber("IDC101");
        	idcard1.setEmployee(employee1);
        	
    
        	
        	em.persist(employee1);
        	System.out.println("Employee Created Successfully");
        	em.persist(idcard1);
        
        	
        	transaction.commit();
        	
        	//retrieve employee
        	Employee e1 = em.find(Employee.class, employee1.getId());
        	System.out.println("Employee Details: ");
        	System.out.println("ID: "+ e1.getId());
        	System.out.println("Name: " + e1.getName());
        	System.out.println("EmailId: " + e1.getEmail());
        	
        	
        	
        	//retrieve id
        	IDCard i1 = em.find(IDCard.class, idcard1.getId());
        	
        	System.out.println("ID Card details: ");
        	System.out.println("Card Number: " + i1.getCardNumber());
        	System.out.println("Issue Date: " + i1.getIssueDate());
        	
        	
        }catch(Exception e) {
        	transaction.rollback();
        	e.printStackTrace();
        }
        
        em.close();
        emf.close();
    }
}
