package ooptest;

public class Customer {

    protected int customerId;
    protected String customerName;
    protected String customerGrade;
    int bonusPoint;
    double bounusRatio;


    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;

        customerGrade = "SILVER";
        bounusRatio = 0.01;
    }

    public int calcPrice(int price) {
        System.out.println(" ========> CUSTOMER " );
        bonusPoint += price * bounusRatio;
        return price;
    }

    public int getCustomerId() {
        return customerId;
    }

}
