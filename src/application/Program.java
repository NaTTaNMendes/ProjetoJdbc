package application;

import java.util.Date;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("TESTE 1: seller findById");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
				
		System.out.println("\nTESTE 2: seller findByDepartment");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nTESTE 3: seller findByAll");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nTESTE 4: seller insert");
		Seller newSeller = new Seller(null, "Pablo", "pablo@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\nTESTE 5: seller update");
		seller = sellerDao.findById(1);
		seller.setName("Andr� Alexandre");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\nTESTE 6: seller delete");
		sellerDao.deleteById(10);
		System.out.println("Deletion completed");
		
		//*****************************************************************************************
		System.out.println();
		System.out.println();
		System.out.println();
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao(); 
		
		System.out.println("TESTE 1: Insert Department");
		Department departmentT = new Department(null, "Compras");
		departmentDao.insert(departmentT);
		System.out.println("Inserted! New id = " + departmentT.getId());		
		
		System.out.println("TESTE 2: Update Department");
		department.setName("Frios");
		departmentDao.update(department);
		System.out.println("Update completed");	
		
		System.out.println("TESTE 3: Delete Department");
		departmentDao.deleteById(8);
		System.out.println("Deletion completed");	
		
		System.out.println("TESTE 4: findById Department");
		department = departmentDao.findById(4);
		System.out.println(department);	
		
		System.out.println("TESTE 5: findAll Department");
		List<Department> listD = departmentDao.findAll();
		for (int i = 0; i < listD.size(); i++) {
			System.out.println(listD.get(i));
		}
		
		DB.closeConnection();
	}

}