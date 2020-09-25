package com.gribbin.pojo;

import lombok.Data;

@Data
public class Broker {
    private String broker;

    private String brokerabbr;

    private String brokername;

    private String brokertype;

    private int isactive;

    private int isneedsettle;
}
