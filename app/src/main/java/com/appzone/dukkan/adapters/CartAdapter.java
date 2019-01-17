package com.appzone.dukkan.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.appzone.dukkan.R;
import com.appzone.dukkan.activities_fragments.home_activity.client_home.fragment.fragment_cart.Fragment_Review_Purchases;
import com.appzone.dukkan.models.OrderItem;
import com.appzone.dukkan.tags.Tags;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class CartAdapter extends RecyclerView.Adapter <CartAdapter.MyHolder> {

    private Context context;
    private List<OrderItem> orderItemList;
    private Fragment_Review_Purchases fragment_review_purchases;
    ScaleAnimation animation;
    public CartAdapter(Context context, List<OrderItem> orderItemList,Fragment_Review_Purchases fragment_review_purchases) {
        this.context = context;
        this.orderItemList = orderItemList;
        this.fragment_review_purchases = fragment_review_purchases;
        animation = new ScaleAnimation(.7f, 1.0f, .7f, 1.0f,1.0f,1.0f);
        animation.setDuration(300);

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_row,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {

        final OrderItem orderItem = orderItemList.get(position);
        holder.BindData(orderItem);
        holder.image_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("pos",position+"__pos");
                fragment_review_purchases.RemoveItem(orderItem);
            }
        });
        holder.image_increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.image_increment.clearAnimation();
                holder.image_decrement.clearAnimation();
                holder.image_increment.startAnimation(animation);
                int counter = Integer.parseInt(holder.tv_counter.getText().toString().trim())+1;
                holder.tv_counter.setText(String.valueOf(counter));
                fragment_review_purchases.Increment_Decrement(orderItem,counter);
            }
        });
        holder.image_decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.image_decrement.clearAnimation();
                holder.image_increment.clearAnimation();
                holder.image_decrement.startAnimation(animation);

                int counter = Integer.parseInt(holder.tv_counter.getText().toString().trim())-1;
                if (counter <1)
                {
                    counter = 1;
                }
                holder.tv_counter.setText(String.valueOf(counter));
                fragment_review_purchases.Increment_Decrement(orderItem,counter);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderItemList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageView image_delete,image,image_increment,image_decrement;
        private TextView tv_name,tv_price,tv_counter;

        public MyHolder(View itemView) {
            super(itemView);
            image_delete = itemView.findViewById(R.id.image_delete);
            image = itemView.findViewById(R.id.image);
            image_increment = itemView.findViewById(R.id.image_increment);
            image_decrement = itemView.findViewById(R.id.image_decrement);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_counter = itemView.findViewById(R.id.tv_counter);

        }

        public void BindData(OrderItem orderItem)
        {
            Paper.init(context);
            String lang = Paper.book().read("lang", Locale.getDefault().getLanguage());
            if (lang.equals("ar"))
            {
                tv_name.setText(orderItem.getProduct_name_ar()+" "+orderItem.getProduct_size_ar());
            }else
            {
                tv_name.setText(orderItem.getProduct_name_en()+" "+orderItem.getProduct_size_en());

            }

            tv_counter.setText(String.valueOf(orderItem.getProduct_quantity()));
            tv_price.setText(String.valueOf(orderItem.getProduct_total_price())+" " + context.getString(R.string.rsa));
            if (!TextUtils.isEmpty(orderItem.getProduct_image()))
            {
                Picasso.with(context).load(Uri.parse(Tags.IMAGE_URL+orderItem.getProduct_image())).fit().into(image);
            }
        }
    }
}
