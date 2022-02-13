package ooptest;

public class VIPCustomer extends Customer{

    double salesRatio;
    private String agentId;


    public VIPCustomer(int customerId, String customerName) {
        super(customerId, customerName);

        customerGrade = "VIP";
        bounusRatio = 0.05;
        salesRatio = 0.1;
    }


    @Override
    public int calcPrice(int price) {
        System.out.println(" ========> VIP " );
        bonusPoint += price * bounusRatio;
        price -= (int) (price * salesRatio);
        return price;
    }


}
