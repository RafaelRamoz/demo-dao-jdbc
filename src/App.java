import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("\n=== TEST 01 = Find By ID ===");
        
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);


        System.out.println("\n\n=== TEST 02 = Find by Department ===");

        Department department = new Department(null, 2);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj: list){
            System.out.println(obj);
        }
        


        System.out.println("\n\n=== TEST 03 = Find All ===");

        List<Seller> allList = sellerDao.findAll();
        for(Seller obj: allList){
            System.out.println(obj);
        }


        System.out.println("\n\n=== TEST 04 = Seller Insert ===");

        Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", LocalDate.parse("01/01/2000", fmt), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

    }
}
