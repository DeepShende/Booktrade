package com.example.booktrade;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity implements PersonAdapter.ItemClicked {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    FloatingActionButton BTN;
    Button btnlogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    ArrayList<Person> people;
    final int ACTIVITY2=2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        recyclerView=findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        BTN=findViewById(R.id.BT);
        btnlogout = findViewById(R.id.logout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intout = new Intent(MainActivity1.this, MainActivity.class);
                startActivity(intout);
            }

        });
        BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addad=new Intent(MainActivity1.this,com.example.booktrade.Add_Advertise.class);
                startActivityForResult(addad,ACTIVITY2);



            }
        });

        people=new ArrayList<Person>();
        people.add(new Person("Harry Potter","1500","Deep","9011204949","Deep Shende","hadapsar","book"));
        people.add(new Person("Rich Dad Poor Dad","500","Abhinav","7066713413","Abhinav Gaikwad","SB road","book"));
        people.add(new Person("Meluha","100","Chaitanya","8888888888","Chaitanya Pardeshi","Nana Peth","book"));


        myAdapter=new PersonAdapter(this,people);
        recyclerView.setAdapter(myAdapter);


    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this,"book name:"+people.get(index).getBook_name(),Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(MainActivity1.this,com.example.booktrade.View_Advertise.class);
        intent.putExtra("pref",people.get(index).getPref());
        intent.putExtra("bookname",people.get(index).getBook_name());
        intent.putExtra("price",people.get(index).getPrice());
        intent.putExtra("sellername",people.get(index).getSeller_name());
        intent.putExtra("no",people.get(index).getPhno());
        intent.putExtra("web",people.get(index).getWeb());
        intent.putExtra("add",people.get(index).getAdd());
        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ACTIVITY2)
        {
            if(resultCode == RESULT_OK)
            {

                String bookname = data.getStringExtra("bookname");
                String price = data.getStringExtra("price");
                String sellername = data.getStringExtra("sellername");
                String phno = data.getStringExtra("phno");
                String web = data.getStringExtra("web");
                String add = data.getStringExtra("add");
                String pref = data.getStringExtra("resource");
                people.add(new Person(bookname,price,sellername,phno,web,add,"book"));
                myAdapter.notifyDataSetChanged();
            }
            if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(MainActivity1.this,"please enter details again",Toast.LENGTH_SHORT).show();
            }
        }
    }

}
