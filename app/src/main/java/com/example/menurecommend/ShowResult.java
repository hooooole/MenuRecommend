package com.example.menurecommend;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ShowResult extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_result);
        Intent intent = getIntent();
        int menuNumber = intent.getIntExtra("random",0);

        String[] array = getResources().getStringArray(R.array.name);
        TextView txtMenu = findViewById(R.id.txtMenu);
        txtMenu.setText(array[menuNumber]);

        TypedArray typedArray = getResources().obtainTypedArray(R.array.image);
        ImageView imgMenu = findViewById(R.id.imgMenu);
        imgMenu.setImageDrawable(typedArray.getDrawable(menuNumber));

        Button btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://search.naver.com/search.naver?query="
                                +array[menuNumber]+"%20맛집"));
                startActivity(searchIntent);
            }
        });


        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




    }

}
