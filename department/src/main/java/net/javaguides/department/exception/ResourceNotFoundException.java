package net.javaguides.department.exception;

public class ResourceNotFoundException extends RuntimeException{
    String message;
    public ResourceNotFoundException(String message){
        super();
        this.message=message;
    }
}
