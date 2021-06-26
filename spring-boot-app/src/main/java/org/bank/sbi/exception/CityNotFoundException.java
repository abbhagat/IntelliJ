package org.bank.sbi.exception;

public class CityNotFoundException extends Exception{

    @Override
    public String toString(){
        return "City Name Not Found";
    }
}
