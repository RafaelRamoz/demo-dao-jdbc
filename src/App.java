import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("\n=== TEST 01 = Find By ID ===");
        
        SellerDao sellerdao = DaoFactory.createSellerDao();
        Seller seller = sellerdao.findById(3);
        System.out.println(seller);


        System.out.println("\n\n=== TEST 02 = Find by Department ===");

        Department department = new Department(null, 2);
        List<Seller> list = sellerdao.findByDepartment(department);
        for(Seller obj: list){
            System.out.println(obj);
        }
        


        System.out.println("\n\n=== TEST 03 = Find All ===");

        List<Seller> allList = sellerdao.findAll();
        for(Seller obj: allList){
            System.out.println(obj);
        }

    }
}
