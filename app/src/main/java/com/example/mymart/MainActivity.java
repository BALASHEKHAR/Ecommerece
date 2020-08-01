package com.example.mymart;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.GridLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    public static final  int HOME_FRAG=0;
    public static final  int CART_FRAG=1;
FrameLayout defaultframe;
private static int currentfrag;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
       navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        defaultframe=findViewById(R.id.mainframlayout);
        setfragment(new HomeFragment(),HOME_FRAG);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);

        }
        else
        {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(currentfrag==HOME_FRAG)
       { getMenuInflater().inflate(R.menu.main, menu);
     }   return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mainsearchicon)
        {
            //TODO:
            return true;

        }
        else if(item.getItemId()==R.id.mainnotificationitem)
        {
            //TODO:
            return true;
        }
        else  if(item.getItemId()==R.id.maincart)
        {
            mycart();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
    private void mycart()
    {
        invalidateOptionsMenu();
        setfragment(new MyCartFragment(),CART_FRAG);
        navigationView.getMenu().getItem(3).setChecked(true);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.nav_orders)
        {

        }
       else if(id==R.id.nav_rewards)
        {

        }
        else  if(id==R.id.nav_cart)
        {
            mycart();

        }
        else if(id==R.id.nav_whatlist)
        {

        }
        else if(id==R.id.nav_account)
        {

        }
        else if(id==R.id.nav_home)
        {
setfragment(new HomeFragment(),HOME_FRAG);
        }
        else if(id==R.id.nav_signout)
        {

        }
        DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void setfragment(Fragment fragment,int fragnumber)
    {
        currentfrag=fragnumber;
       getSupportFragmentManager().beginTransaction().replace(defaultframe.getId(),fragment).commit();
    }
}