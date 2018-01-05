package com.example.sahar.cppandey22;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DrawerBaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    Button login,register;
    LinearLayout fullLayout;
    CoordinatorLayout actContent;
    NavigationView navigationView;



    @Override
    public void setContentView(final int layoutResId){
        fullLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
        actContent = (CoordinatorLayout) fullLayout.findViewById(R.id.coordinator_layout);

        // Setting the content of layout
        getLayoutInflater().inflate(layoutResId, actContent, true);
        super.setContentView(fullLayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView mTitle = (TextView) toolbar.findViewById(R.id.title);
        Typeface myFont = Typeface.createFromAsset(this.getAssets(), "font/Poppins-Regular.ttf");
        mTitle.setTypeface(myFont);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initViews();
        initListener();

        //navigation drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initViews() {
        login = (Button) fullLayout.findViewById(R.id.login);
        register = (Button) fullLayout.findViewById(R.id.register);
    }

    private void initListener() {
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    public void changeViews()
    {

        login.setText("Logout");
        register.setVisibility(View.GONE);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_view);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            finish();
           drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handling navigation view item clicks here
        int id = item.getItemId();
        String url = "";
        navigationView.setCheckedItem(id);

        switch (id) {
            case R.id.nav_home:
                navigationView.setCheckedItem(id);
                startActivity(new Intent(DrawerBaseActivity.this, MainActivity.class));
                break;

            case R.id.nav_team:
                navigationView.setCheckedItem(id);
                url = "http://demo.technowebmart.com/pandeyji_mob_app/doctors.html";
                goToNewActivity(url);
                break;

            case R.id.nav_enquiry:
                navigationView.setCheckedItem(id);
                url = "http://demo.technowebmart.com/pandeyji_mob_app/apointment.html";
                goToNewActivity(url);
                break;

            case R.id.nav_departments:
                navigationView.setCheckedItem(id);
                url = "http://demo.technowebmart.com/pandeyji_mob_app/departments.html";
                goToNewActivity(url);
                break;

            case R.id.nav_contact:
                navigationView.setCheckedItem(id);
                url = "http://demo.technowebmart.com/pandeyji_mob_app/contact.html";
                goToNewActivity(url);
                break;

            default:
                url = "http://demo.technowebmart.com/pandeyji_mob_app/main.html";
                goToNewActivity(url);
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_view);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void goToNewActivity(String url) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
        overridePendingTransition(R.anim.enter_from_right,R.anim.exit_out_left);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                if(login.getText().toString().equals("Login")) {

                    new LoginClass().showDialogContent(DrawerBaseActivity.this);

                }else{
                   login.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_login,0,0,0);
                   login.setText("Login");
                   register.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.register:
                new RegisterClass().showDialogContent(DrawerBaseActivity.this);
                break;
        }
    }
}