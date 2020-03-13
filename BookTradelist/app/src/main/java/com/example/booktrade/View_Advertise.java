package com.example.booktrade;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class View_Advertise extends AppCompatActivity {
    TextView TV3_1,TV3_2,TV3_3;
    ImageView IV3_1,IV3_2,IV3_3,IV3_4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__advertise);
        TV3_1=findViewById(R.id.TV3_1);
        TV3_2=findViewById(R.id.TV3_2);
        TV3_3=findViewById(R.id.TV3_3);
        IV3_1=(ImageView) findViewById(R.id.IV3_1);
        IV3_2=findViewById(R.id.IV3_2);
        IV3_3=findViewById(R.id.IV3_3);
        IV3_4=findViewById(R.id.IV3_4);
        String resource=getIntent().getStringExtra("pref");
        String bookname=getIntent().getStringExtra("bookname");
        String price=getIntent().getStringExtra("price");
        String sellername=getIntent().getStringExtra("sellername");
        String no=getIntent().getStringExtra("no");
        String web=getIntent().getStringExtra("web");
        String add=getIntent().getStringExtra("add");
        /*if(resource.equals("happy")) {
            IV3_1.setImageResource(R.drawable.happy);
        }
        else if (resource.equals("okay")){
            IV3_1.setImageResource(R.drawable.okay);
        }
        else
        {
            IV3_1.setImageResource(R.drawable.sad);
        }*/
        IV3_1.setImageResource(R.drawable.book);
        TV3_1.setText(bookname);
        TV3_2.setText( "₹"+price);
        TV3_3.setText(sellername);
        final Intent intent1=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+no));
        final Intent intent2=new Intent(Intent.ACTION_VIEW,Uri.parse("http://m.me/"+web));
        final Intent intent3=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+add));
        IV3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
        IV3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });
        IV3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        });




    }
}
