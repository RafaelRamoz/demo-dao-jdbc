package model.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.dbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

    private Connection conn;

    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

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
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT seller.*, department.Name as DepName "
                + "FROM seller INNER JOIN department "
                + "ON seller.DepartmentId = department.id "
                + "WHERE seller.id = ?");

            st.setInt(1, id); 
            rs = st.executeQuery();

            if(rs.next()){
                Department dep = instanciateDepartment(rs);
                Seller obj = instaciateSeller(rs, dep);
                return obj;
            }

            return null;

        }catch(SQLException e){
            throw new dbException(e.getMessage());
        }
        
        finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findAll() {

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("SELECT seller.*, department.Name as DepName "
            + "FROM seller INNER JOIN department "
            + "ON seller.DepartmentId = department.id "
            + "ORDER BY Name ");

            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while(rs.next()){

                Department dep = map.get(rs.getInt("DepartmentId"));

                if(dep == null){
                     dep = instanciateDepartment(rs);
                     map.put(rs.getInt("DepartmentId"), dep);
                }
                
                Seller obj = instaciateSeller(rs, dep);
                list.add(obj);
            }
            return list;

            }catch(SQLException e){
            throw new dbException(e.getMessage());
            }
            finally{
                DB.closeResultSet(rs);
                DB.closeStatement(st);
            }
    }


    public Department instanciateDepartment(ResultSet rs) throws SQLException{
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }


    public Seller instaciateSeller(ResultSet rs, Department dep) throws SQLException{
        Seller obj = new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthDate(rs.getDate("BirthDate") != null ? rs.getDate("BirthDate").toLocalDate() : null);
        obj.setDepartment(dep);
        
        return obj;
    }

    @Override
    public List<Seller> findByDepartment(Department department) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("SELECT seller.*, department.Name as DepName "
            + "FROM seller INNER JOIN department "
            + "ON seller.DepartmentId = department.id "
            + "WHERE DepartmentId = ? "
            + "ORDER BY Name ");

            st.setInt(1, department.getId());
            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while(rs.next()){

                Department dep = map.get(rs.getInt("DepartmentId"));

                if(dep == null){
                     dep = instanciateDepartment(rs);
                     map.put(rs.getInt("DepartmentId"), dep);
                }
                
                Seller obj = instaciateSeller(rs, dep);
                list.add(obj);
            }
            return list;

            }catch(SQLException e){
            throw new dbException(e.getMessage());
            }
            finally{
                DB.closeResultSet(rs);
                DB.closeStatement(st);
            }


    }
       

    
    

}
