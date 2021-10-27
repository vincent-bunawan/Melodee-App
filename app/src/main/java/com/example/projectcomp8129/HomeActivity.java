package com.example.projectcomp8129;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class HomeActivity extends AppCompatActivity {

    private TextView textView;
    String[] titles = {
            "Butter",
            "Positions",
            "No Song Without You"
    };

    int[] covers = {
            R.drawable.butter,
            R.drawable.positions,
            R.drawable.nswy
    };

    String[] artists = {
            "BTS", "Ariana Grande", "HONNE"
    };

    String[] genres = {
            "K-Pop", "Pop", "Pop"
    };

    String[] totalSold = {
            "Sold : 150K", "Sold : 97K", "Sold : 90K"
    };

    String[] price =  {
            "Rp.570.000","Rp.455.000","Rp.400.000"
    };

    int[] images = {
            R.drawable.slide1,
            R.drawable.slide2,
            R.drawable.slide3
    };

    ListView listView;
    ViewFlipper viewFlipper;
    private EditText usernameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initializeItems();

        for(int image : images){
            slideImages(image);
        }

        //
        listView = findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), AlbumDetailActivity.class);
                intent.putExtra("albumName",titles[position]);
                intent.putExtra("albumImage",covers[position]);
                intent.putExtra("artistName",artists[position]);
                intent.putExtra("albumGenre",genres[position]);
                intent.putExtra("albumPrice",price[position]);
                intent.putExtra("totalSold",totalSold[position]);
                startActivity(intent);

            }
        });
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
        startActivity(intent);
    }

    public void goLogout(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return covers.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom_list, null);
            ImageView imageView = convertView.findViewById(R.id.ivList);
            TextView textView1 = convertView.findViewById(R.id.tvList);
            TextView textView2 = convertView.findViewById(R.id.tvList1);
            TextView textView3 = convertView.findViewById(R.id.tvList2);
            TextView textView4 = convertView.findViewById(R.id.tvList3);
            TextView textView5 = convertView.findViewById(R.id.tvList4);

            imageView.setImageResource(covers[position]);
            textView1.setText(titles[position]);
            textView2.setText(artists[position]);
            textView3.setText(genres[position]);
            textView4.setText(totalSold[position]);
            textView5.setText(price[position]);

            return convertView;
        }
    }



    private void initializeItems() {
        this.usernameText = findViewById(R.id.username);
        this.textView = findViewById(R.id.textView);
        this.viewFlipper = findViewById(R.id.vfMainCarousel);
        String username = getIntent().getStringExtra("USERNAME_KEY");
        textView.setText("Welcome, " + username);
    }

    private void slideImages(int image){
        ImageView imageView  = new ImageView(HomeActivity.this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(HomeActivity.this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(HomeActivity.this, android.R.anim.slide_out_right);
    }

}