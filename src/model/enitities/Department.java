package model.enitities;

import java.io.Serializable;

public class Department implements Serializable {
    private String name;
    private Integer id; 

    public Department(){

    }

    public Department(String name, Integer id){
        this.name = name;
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }    

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Department other = (Department) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Department [name=" + name + ", id=" + id + "]";
    }

    
    

}
