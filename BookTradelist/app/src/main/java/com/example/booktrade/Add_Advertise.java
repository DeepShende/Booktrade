package com.example.booktrade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Advertise extends AppCompatActivity implements View.OnClickListener {
    TextView TV2_1,TV2_2,TV2_3,TV2_4,TV2_5,TV2_6;
    Button BT2_1;
    DatabaseReference databaseRegistration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__advertise);

        databaseRegistration = FirebaseDatabase.getInstance().getReference("Books");

        TV2_1=findViewById(R.id.TV2_1);
        TV2_2=findViewById(R.id.TV2_2);
        TV2_3=findViewById(R.id.TV2_3);
        TV2_4=findViewById(R.id.TV2_4);
        TV2_5=findViewById(R.id.TV2_5);
        TV2_6=findViewById(R.id.TV2_6);
        BT2_1=findViewById(R.id.BT2_1);


        BT2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TV2_1.getText().toString().isEmpty() || TV2_2.getText().toString().isEmpty() || TV2_3.getText().toString().isEmpty() || TV2_4.getText().toString().isEmpty())
                {
                    Toast.makeText(Add_Advertise.this,"please enter details",Toast.LENGTH_SHORT).show();
                }
                else {
                    String bookname = TV2_1.getText().toString().trim();
                    String price = TV2_2.getText().toString().trim();
                    String seller = TV2_3.getText().toString().trim();
                    String phno = TV2_4.getText().toString().trim();
                    String web = TV2_5.getText().toString().trim();
                    String add = TV2_6.getText().toString().trim();
                    //Intent intent = new Intent(Add_Advertise.this, MainActivity1.class);
                    Intent intent = new Intent();
                    intent.putExtra("bookname", bookname);
                    intent.putExtra("price", price);
                    intent.putExtra("sellername", seller);
                    intent.putExtra("phno", phno);
                    intent.putExtra("web", web);
                    intent.putExtra("add", add);

                    uploadToFirebase();

                    setResult(RESULT_OK,intent);
                    Add_Advertise.this.finish();
                }
            }
        });





    }

    public void uploadToFirebase() {
        //  public Books(String bookname, String price, String seller, String phno, String web, String add) {
        String id = databaseRegistration.push().getKey();
        String bookname = TV2_1.getText().toString().trim();
        String price = TV2_2.getText().toString().trim();
        String seller = TV2_3.getText().toString().trim();
        String phno = TV2_4.getText().toString().trim();
        String web = TV2_5.getText().toString().trim();
        String add = TV2_6.getText().toString().trim();
        Books books = new Books(bookname, price, seller, phno, web, add);
        databaseRegistration.child(id).setValue(books);
        Toast.makeText(this,"Uploaded",Toast.LENGTH_SHORT).show();
    }

}
