package com.example.redenes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder>{

    private List<Item> items;
    private int selectedPos = RecyclerView.NO_POSITION;
    private Context context;

    public ItemAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from
                (parent.getContext())
                .inflate(R.layout.item, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.MyViewHolder holder, int position) {
        holder.itemView.setSelected(selectedPos == position);
        Item item = items.get(position);

        if (item.getText() != null) {
            holder.text.setVisibility(View.VISIBLE);
            holder.lay.setVisibility(View.VISIBLE);
            holder.text.setText(item.getText());
            holder.image.setImageResource(item.getImage());
            holder.lay.setCardBackgroundColor(Color.parseColor("#ffffff"));
            holder.text.setTextColor(Color.parseColor("#000018"));
            holder.layout.setBackground(context.getDrawable(R.drawable.spinner_bg));
        } else {
            holder.lay.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView  image;
        TextView text;
        LinearLayout layout;
        CardView lay;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_mainn);
            text = itemView.findViewById(R.id.text);
            layout = itemView.findViewById(R.id.layout);
            lay = itemView.findViewById(R.id.layy);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            notifyItemChanged(selectedPos);

            selectedPos = getAdapterPosition();
            Item item = items.get(selectedPos);
            if (item.getText() != null) {
                image.setImageResource(item.getAlt_image());
                text.setTextColor(Color.parseColor("#ffffff"));
                lay.setCardBackgroundColor(Color.parseColor("#fe0000"));
                layout.setBackground(context.getDrawable(R.drawable.register_button));
            }

            if (item.getImage() == R.drawable.ic_contacts) {
                ((MainActivity)context).loadFragment(new UserFragment(), "user");
            }
        }
    }


}
