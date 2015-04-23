package com.takeoffandroid.recyclecardview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;


public class CardsViewAdapter extends RecyclerView.Adapter<CardsViewAdapter.ViewHolder>{

    private List<CardsObject> mCardsList;
    private int rowLayout;
    private Context mContext;
    private int[] mMaterialColorCodes;
    private String[] mMaterialColorNames;
    private boolean toggle = true;

    public CardsViewAdapter ( Context context,List<CardsObject> cardsList) {
        this.mCardsList = cardsList;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_cardview, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


       if(toggle){

           holder.cardImage.setBackgroundColor (Color.TRANSPARENT);
           holder.cardName.setTextColor (mCardsList.get (position).getColorcode ());

       }else {
           holder.cardName.setTextColor (Color.WHITE);
           holder.cardImage.setBackgroundColor (mCardsList.get (position).getColorcode ());

       }
        holder.cardName.setText (mCardsList.get (position).getColorname ().toUpperCase ());
       }

    @Override
    public int getItemCount() {
        return mCardsList == null ? 0 : mCardsList.size();
    }

    public void toggleAdapter(boolean toggle){

        this.toggle = toggle;
        notifyDataSetChanged ();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView cardName;
        public ImageView cardImage;

        public ViewHolder(View itemView) {
            super(itemView);
            cardName = (TextView) itemView.findViewById(R.id.card_name);
            cardImage = (ImageView)itemView.findViewById(R.id.card_image);
        }

    }
}
