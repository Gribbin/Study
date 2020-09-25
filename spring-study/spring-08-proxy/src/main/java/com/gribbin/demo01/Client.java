package com.gribbin.demo01;

public class Client {
    public static void main(String[] args) {
        Landlord landlord = new Landlord();
        Agent agent = new Agent(landlord);
        agent.rent();
    }
}
