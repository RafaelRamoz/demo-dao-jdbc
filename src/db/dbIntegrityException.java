package db;

public class dbIntegrityException extends RuntimeException {
    
    public dbIntegrityException(String msg){
        super(msg);
    }
}
