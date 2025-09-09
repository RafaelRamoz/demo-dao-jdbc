package model.dao;

import db.DB;
import model.Impl.SellerDaoJDBC;

public class DaoFactory {
    
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }
}
