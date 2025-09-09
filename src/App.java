import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        
        SellerDao sellerdao = DaoFactory.createSellerDao();

        Seller seller = sellerdao.findById(3);

        System.out.println(seller);
    }
}
