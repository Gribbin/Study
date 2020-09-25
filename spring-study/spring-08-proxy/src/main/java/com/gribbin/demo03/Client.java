package com.gribbin.demo03;

public class Client {
    public static void main(String[] args) {
        Landlord landlord = new Landlord();
        RentHandler rh = new RentHandler();
        rh.setRent(landlord);
        Rent proxy = (Rent) rh.getProxy();
        proxy.rent();
    }
}
