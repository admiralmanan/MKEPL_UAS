/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.aplikasistreaming.subscription;

/**
 *
 * @author legion
 */
public abstract class Subscription {
    protected String subscriptionID;
    protected String planType;
    protected String startDate;
    protected String endDate;
    protected double price;

    public Subscription(String subscriptionID, String planType, String startDate, String endDate, double price) {
        this.subscriptionID = subscriptionID;
        this.planType = planType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public void choosePlan() {
        System.out.println("Pilih paket langgannan: " + planType);
    }

    public void renewSubs() {
        System.out.println("Langganan diperbarui");
    }

    public void cancelSubs() {
        System.out.println("Langganan dibatalkan.");
    }

    public String getPlanType() {
        return planType;
    }

    public abstract void price();
}

