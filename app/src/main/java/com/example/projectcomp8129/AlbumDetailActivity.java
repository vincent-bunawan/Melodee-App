package com.example.projectcomp8129;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class AlbumDetailActivity extends AppCompatActivity {
    TextView albumName, artistName, albumGenre, albumPrice, totalSold;
    ImageView albumImage;
    private TextView usernameText;
    EditText inputQty;
    Button orderButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);



        albumName = findViewById(R.id.albumName);
        artistName = findViewById(R.id.artistName);
        albumImage = findViewById(R.id.albumImage);
        albumGenre = findViewById(R.id.albumGenre);
        albumPrice = findViewById(R.id.albumPrice);
        totalSold = findViewById(R.id.totalSold);
        this.usernameText = findViewById(R.id.textView);

        Intent intent = getIntent();

        albumName.setText(intent.getStringExtra("albumName"));
        artistName.setText(intent.getStringExtra("artistName"));
        albumImage.setImageResource(intent.getIntExtra("albumImage", 0));
        albumGenre.setText(intent.getStringExtra("albumName"));
        albumPrice.setText(intent.getStringExtra("albumPrice"));
        totalSold.setText(intent.getStringExtra("totalSold"));

        orderButton = findViewById(R.id.orderBtn);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateQty();
            }
        });

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

    public void goBack(View view){
        finish();
    }

    public void validateQty(){
        inputQty = findViewById(R.id.inputQty);
        int number = Integer.parseInt(inputQty.getText().toString());
        inputQty.setText(String.valueOf(number));
        if(number < 1){
            showAlertDialog();
        }else{
            showConfirmationDialog();
        }
    }

    private void showConfirmationDialog() {
        ConfirmDialog confirmDialog = new ConfirmDialog();
        confirmDialog.show(getSupportFragmentManager(), "");
    }

    private void showAlertDialog() {
    MyDialog myDialog = new MyDialog();
    myDialog.show(getSupportFragmentManager(), "");
    }

}