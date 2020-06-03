package com.example.android.navigationpatternlistdetail.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.navigationpatternlistdetail.R;
import com.example.android.navigationpatternlistdetail.model.Item;
import com.example.android.navigationpatternlistdetail.provider.ItemProvider;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created by Tanaskovic on 3/30/2018.
 */

public class DetailFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private Item listItem = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (listItem == null) { listItem = ItemProvider.getItemById(0); }
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            listItem = new Item();

            listItem.setName(savedInstanceState.getString("name"));
            listItem.setDescription(savedInstanceState.getString("description"));
            listItem.setImage(savedInstanceState.getString("image"));

        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        if (savedInstanceState != null) {

            savedInstanceState.putString("name", listItem.getName());
            savedInstanceState.putString("description", listItem.getDescription());
            savedInstanceState.putString("image", listItem.getImage());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v("DetailFragment", "onCreateView()");

        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(listItem.getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(listItem.getName());

        TextView description = (TextView) view.findViewById(R.id.description);
        description.setText(listItem.getDescription());


        return view;
    }

    public void setListItem(int id) {
        listItem = ItemProvider.getItemById(id);
    }

    public void updateItem(int id) {
        listItem = ItemProvider.getItemById(id);

        ImageView imageView = (ImageView) getActivity().findViewById(R.id.image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(listItem.getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView name = (TextView) getActivity().findViewById(R.id.name);
        name.setText(listItem.getName());

        TextView description = (TextView) getActivity().findViewById(R.id.description);
        description.setText(listItem.getDescription());
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
