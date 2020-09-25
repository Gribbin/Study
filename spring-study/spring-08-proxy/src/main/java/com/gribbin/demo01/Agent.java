package com.gribbin.demo01;

public class Agent implements Rent {
    private Landlord landlord;

    public Agent(Landlord landlord) {
        this.landlord = landlord;
    }

    public void rent() {
        landlord.rent();
        seeHouse();
        fare();
    }

    //看房
    public void seeHouse() {
        System.out.println("带房客看房");
    }
    //收中介费

    public void fare() {
        System.out.println("收中介费");
    }
}
