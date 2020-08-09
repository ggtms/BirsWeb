package com.cqupt.bcirs.domain;

import com.cqupt.bcirs.service.Status;

/**
 * @author ggtms
 * @ 2020-04-14 10:29
 */
public class Card {
    private Integer number;                  //编号
    private String issuer;               //发卡行
    private String account;             //卡号
    private String date;                 //日期
    private Status status = Status.DEFAULT;   //状态

    public Card() {

    }

    public Card(Integer number, String issuer, String account, String date, Status status) {
        this.number = number;
        this.issuer = issuer;
        this.account = account;
        this.date = date;
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getAccout() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Status getStatu() {
        return status;
    }

    public void setStatu(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", issuer='" + issuer + '\'' +
                ", account='" + account + '\'' +
                ", date='" + date + '\'' +
                ", status=" + status +
                '}';
    }
}
