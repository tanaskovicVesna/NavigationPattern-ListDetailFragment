package com.example.android.navigationpatternlistdetail.activity;

import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.android.navigationpatternlistdetail.R;
import com.example.android.navigationpatternlistdetail.fragments.DetailFragment;
import com.example.android.navigationpatternlistdetail.fragments.ListFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemSelectedListener{

    private boolean landscapeMode = false;
    private boolean listShown = false;
    private boolean detailShown = false;



    private int itemId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int orientation = getResources().getConfiguration().orientation;
            setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {

            // avoid end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            ListFragment listFragment = new ListFragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, listFragment).commit();
        }


        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.i("TAG", "landscape");
            // In landscape
            landscapeMode = true;
            getFragmentManager().popBackStack();

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            ListFragment listFragment = new ListFragment();
            transaction.replace(R.id.displayList, listFragment);
            transaction.addToBackStack(null);
            transaction.commit();

            FragmentTransaction transaction1 = getFragmentManager().beginTransaction();
            DetailFragment  detailFragment = new DetailFragment();
            transaction1.replace(R.id.displayDetail, detailFragment);
            transaction1.addToBackStack(null);
            transaction1.commit();
            detailShown = true;

        }


        listShown = true;
        detailShown = false;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Toast.makeText(this, getString(R.string.about_app) , Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


   @Override
   public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
  }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    public void onItemSelected(int id) {
        itemId = id;

        if (landscapeMode) {

            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.displayDetail);
            detailFragment.updateItem(id);

        } else {
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setListItem(id);

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, detailFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            listShown = false;
            detailShown = true;
        }
    }

    @Override
    public void onBackPressed() {

        if (landscapeMode) {
            finish();
        } else if (listShown == true) {
            finish();
        } else if (detailShown == true) {
            getFragmentManager().popBackStack();

            ListFragment listFragment = new ListFragment();
            //  FragmentTransaction ft = getFragmentManager().beginTransaction();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, listFragment, "List_Fragment").commit();
            listShown = true;
            detailShown = false;


        }
    }


}
