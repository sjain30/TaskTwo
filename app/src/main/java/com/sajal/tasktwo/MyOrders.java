package com.sajal.tasktwo;

public class MyOrders {

    private int imageResource, orderId, orderAmount, quantity;
    private String paymentMethod, Status, productName, productDescription;

    public static MyOrders[] orders = {new MyOrders(1,100,2, R.drawable.cookies,"Cash", "In transit", "Cookies", "Fresh Oat Cookies"),
                                new MyOrders(2,100, 3, R.drawable.sandwich,"PayTm", "Delivered", "Sandwhich", "Vegetable Sandwhich"),
            new MyOrders(3,150, 4, R.drawable.pancakes,"Debit Card", "Delivered", "Pancakes", "Soft pancakes with maple syrup")};

    public MyOrders(int orderId, int orderAmount, int quantity, int imageResource, String paymentMethod, String status, String productName, String productDescription) {
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.paymentMethod = paymentMethod;
        this.Status = status;
        this.productName = productName;
        this.productDescription = productDescription;
        this.imageResource = imageResource;
        this.quantity=quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return Status;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getImageResource() {
        return imageResource;
    }
}
