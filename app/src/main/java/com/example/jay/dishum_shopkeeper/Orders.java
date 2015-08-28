package com.example.jay.dishum_shopkeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;




public class Orders extends ActionBarActivity implements NavigationDrawerCallbacks {

    private Toolbar mToolbar;
    private TextView tvHome;
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private TabHost tabHost;
    private  int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        Intent intent = getIntent();

        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        tvHome = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(mToolbar);

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        // Tab for Photos

        TabSpec compat = tabHost.newTabSpec("Completed");
        compat.setIndicator("Completed");
        compat.setContent(R.id.tab1);
        tabHost.addTab(compat);

        TabSpec compat1 = tabHost.newTabSpec("Pending");
        compat1.setIndicator("Pending");
        compat1.setContent(R.id.tab2);
        tabHost.addTab(compat1);

        TabSpec compat12 = tabHost.newTabSpec("Cancelled");
        compat12.setIndicator("Cancelled");
        compat12.setContent(R.id.tab3);
        tabHost.addTab(compat12);

        tvHome.setText("Orders");

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
        // populate the navigation drawer

    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        //Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();

        if(i>0){

            if(position==0) { // home
                Intent search = new Intent(this, MainActivity.class);
                startActivity(search);
            }
            if(position==1) { // orders
                Intent search = new Intent(this, Orders.class);
                startActivity(search);
            }
            if(position==2) { // orders
                Intent search = new Intent(this, Profile.class);
                startActivity(search);
            }
            if(position==3) { // orders
                Intent search = new Intent(this, Orders.class);
                startActivity(search);
            }
        }
        i++;

    }


    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}

