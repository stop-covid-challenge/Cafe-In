package stop.covid.project.cafein;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationBarView;

import stop.covid.project.cafein.main.Fragment_cafe;
import stop.covid.project.cafein.main.Fragment_home;
import stop.covid.project.cafein.main.Fragment_profile;
import stop.covid.project.cafein.main.Fragment_subscribe;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Fragment_home homeFragment;
    private Fragment_cafe cafeFragment;
    private Fragment_profile profileFragment;
    private Fragment_subscribe subscribeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new Fragment_home();
        cafeFragment = new Fragment_cafe();
        profileFragment = new Fragment_profile();
        subscribeFragment = new Fragment_subscribe();

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, homeFragment).commit();
        NavigationBarView nav = findViewById(R.id.tab_menu);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tab_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, homeFragment).commit();
                        return true;
                    case R.id.tab_cafe:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, cafeFragment).commit();
                        return true;
                    case R.id.tab_subscribe:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, subscribeFragment).commit();
                        return true;
                    case R.id.tab_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, profileFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}