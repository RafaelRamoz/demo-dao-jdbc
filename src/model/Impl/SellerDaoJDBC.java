package model.Impl;

import java.util.List;

import model.dao.SellerDao;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

    @Override
    public void insert(Seller obj) {
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Seller obj) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void DeleteById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'DeleteById'");
    }

    @Override
    public Seller findById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Seller> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
    

}
