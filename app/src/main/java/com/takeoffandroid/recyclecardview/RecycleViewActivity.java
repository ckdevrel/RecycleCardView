package com.takeoffandroid.recyclecardview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;


import java.util.ArrayList;


public class RecycleViewActivity extends Activity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private ImageButton img_btn_fab;

    private CardsViewAdapter mAdapter;
    private ArrayList<CardsObject> mCardsList = new ArrayList<CardsObject> ();

    private int[] materialColorCodes;
    private String[] materialColorNames;

    private boolean btnChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        mRecyclerView = (RecyclerView)findViewById(R.id.list);
        img_btn_fab = (ImageButton)findViewById (R.id.fab_button);
        img_btn_fab.setOnClickListener (this);

        materialColorCodes = getResources ().getIntArray (R.array.color_codes);
        materialColorNames = getResources ().getStringArray (R.array.color_names);

        for(int i = 0; i<materialColorNames.length; i++) {
            CardsObject cardsObject = new CardsObject ();
            cardsObject.setColorcode (materialColorCodes[ i ]);
            cardsObject.setColorname (materialColorNames[i]);
            mCardsList.add (cardsObject);
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager (this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator ());

        mAdapter = new CardsViewAdapter (this,mCardsList);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onClick (View view) {

        switch (view.getId ()){

            case R.id.fab_button:

                if(btnChecked) {
                    btnChecked = false;
                    mAdapter.toggleAdapter (true);
                }else{
                    btnChecked = true;
                    mAdapter.toggleAdapter (false);
                }

                break;


        }
    }
}
