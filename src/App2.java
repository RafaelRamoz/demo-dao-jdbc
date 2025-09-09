import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;


public class App2 {

    public static void main(String[] args) throws Exception {
        
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n=== TEST 01 = Department Insert ===");

        Department department = new Department("Office", 21121);
        departmentDao.insert(department);
        System.out.println("Department inserted! New Id =" + department.getId());


        System.out.println("\n\n=== TEST 02 = Delete by ID ===");

        Scanner sc = new Scanner(System.in);
        System.out.print( "Enter the ID to delete: ");
        int id = sc.nextInt();
        departmentDao.DeleteById(id);
        System.out.println("ID Deleted");
        sc.close();


        System.out.println("\n\n=== TEST 03 = FIND by ID ===");
        
        Department foundDep = departmentDao.findById(3);
        System.out.println(foundDep);


        System.out.println("\n\n=== TEST 04 = FIND ALL ===");

        List<Department> list = departmentDao.findAll();
        for(Department dep: list){
            System.out.println(dep);
        }
        

        System.out.println("\n\n=== TEST 05 = Update departement ===");
        Department departmentid = departmentDao.findById(1);
        departmentid.setName("executive");
        departmentDao.update(departmentid);
        System.out.println("Update Completed!");




        




    }
    
}
