package com.example.projectcomp8129;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class AboutUsActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tab1,tab2;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    TextView usernameText, textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        initializeItems();
        pagerAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                pagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void initializeItems() {
        this.tabLayout = findViewById(R.id.tabLayout);
        this.viewPager = findViewById(R.id.viewPager);
        this.usernameText = findViewById(R.id.username);
        this.textView = findViewById(R.id.textView);
        String username = getIntent().getStringExtra("USERNAME_KEY");
        textView.setText("Welcome, " + username);
        this.tab1 = findViewById(R.id.tab1);
        this.tab2 = findViewById(R.id.tab2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("USERNAME_KEY",usernameText.getText().toString());
        startActivity(intent);
    }

    public void goAlbums(View view) {
        Intent intent = new Intent(this, AlbumsActivity.class);
        startActivity(intent);
    }

    public void goAboutUs(View view) {
        Intent intent = new Intent(this, AboutUsActivity.class);
        intent.putExtra("USERNAME_KEY",usernameText.getText().toString());
        startActivity(intent);
    }

    public void goLogout(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


}