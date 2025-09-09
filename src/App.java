import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        
        SellerDao sellerdao = DaoFactory.createSellerDao();

        Seller seller = sellerdao.findById(3);

        System.out.println(seller);

        Department department = new Department(null, 2);
        List<Seller> list = sellerdao.findByDepartment(department);

        System.out.println(list);
    }
}
