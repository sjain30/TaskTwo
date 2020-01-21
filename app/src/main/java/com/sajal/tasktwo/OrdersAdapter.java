package com.sajal.tasktwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {

    private Context context;

    public OrdersAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.orderId.setText("Order Id: "+Integer.toString(MyOrders.orders[position].getOrderId()));
        holder.paymentMethod.setText("Mode of Payment: "+MyOrders.orders[position].getPaymentMethod());
        holder.deliveryStatus.setText("Delivery Status: "+MyOrders.orders[position].getStatus());
        holder.orderAmount.setText("Order Amount: "+MyOrders.orders[position].getOrderAmount());
        holder.productName.setText("Product Name: "+MyOrders.orders[position].getProductName());
        holder.description.setText("Description:\n"+MyOrders.orders[position].getProductDescription());
        holder.imageView.setImageResource(MyOrders.orders[position].getImageResource());
        holder.quantity.setText("Quantity: "+MyOrders.orders[position].getQuantity());
    }

    @Override
    public int getItemCount() {
        return MyOrders.orders.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView orderId, paymentMethod, deliveryStatus, orderAmount, productName, description, quantity;
        public ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            orderId=itemView.findViewById(R.id.orderId);
            paymentMethod=itemView.findViewById(R.id.paymentMethod);
            deliveryStatus=itemView.findViewById(R.id.deliveryStatus);
            orderAmount=itemView.findViewById(R.id.orderAmount);
            productName=itemView.findViewById(R.id.productName);
            description=itemView.findViewById(R.id.description);
            imageView=itemView.findViewById(R.id.imageView2);
            quantity=itemView.findViewById(R.id.quantity);
        }
    }
}
