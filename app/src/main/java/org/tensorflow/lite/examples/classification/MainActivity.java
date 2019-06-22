package org.tensorflow.lite.examples.classification;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    BottomAppBar bottomAppBar;
    FloatingActionButton floatingActionButton;
    ImageButton b_insta;
    Button b_camera;
    ImageButton b_locator;
    Button menuHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_main_activity);
        floatingActionButton = findViewById(R.id.btn_camera);
        bottomAppBar = findViewById(R.id.bottom_navBar);

        b_insta = findViewById(R.id.btn_instagram);
        b_locator = findViewById(R.id.btn_locate);

        //setSupportActionBar(bottomAppBar);

        //BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        //bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new StoreFragment()).commit();

        b_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InstagramFragment()).commit();
                b_locator.setBackgroundResource(R.drawable.bb_icon_location);
                v.setBackgroundResource(R.drawable.instagram2);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginTF();
            }
        });

        b_locator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LocationFragment()).commit();
                b_insta.setBackgroundResource(R.drawable.bb_icon_instagram);
                v.setBackgroundResource(R.drawable.location2);
            }
        });

        //TitleBar
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.nav_home) {
            b_locator.setBackgroundResource(R.drawable.bb_icon_location);
            b_insta.setBackgroundResource(R.drawable.bb_icon_instagram);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new StoreFragment()).commit();
        }
        return super.onOptionsItemSelected(item);
    }


/*private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new StoreFragment();
                            break;

                    }
                    if(selectedFragment != null)
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                    return true;

                }
            };*/

    public void beginTF(){
        Intent intent = new Intent(this, ClassifierActivity.class);
        startActivity(intent);
    }

}
