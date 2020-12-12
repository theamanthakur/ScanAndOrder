 package com.twg.scanorder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseReference dataRef;
    FirebaseStorage mstoarage;
    FirebaseDatabase mdatabse;
    popularAdapter adapter2;
    recommendAdapter adapter1;
    List<modelPopular> listPopular;
    List<modelRecommend> listRecommend;
    RecyclerView recyclerViewP;
    RecyclerView recyclerViewR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdatabse = FirebaseDatabase.getInstance();
        dataRef =mdatabse.getInstance().getReference().child("rest01");
        dataRef.keepSynced(true);
        mstoarage = FirebaseStorage.getInstance();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewP = (RecyclerView)findViewById(R.id.popular_recycler);
        recyclerViewR =(RecyclerView)findViewById(R.id.recommended_recycler);
//        recyclerView.setHasFixedSize(true);
        recyclerViewP.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewR.setLayoutManager(layoutManager);

        listPopular =  new ArrayList<modelPopular>();
        listRecommend = new ArrayList<modelRecommend>();
        adapter2 = new popularAdapter(MainActivity.this,listPopular);
        adapter1 = new recommendAdapter(MainActivity.this,listRecommend);
//        callPopular();
        dataRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                modelRecommend model = snapshot.getValue(modelRecommend.class);
                listRecommend.add(model);
                Toast.makeText(getApplicationContext(),model.getImageURL(),Toast.LENGTH_LONG).show();
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        recyclerViewR.setAdapter(adapter2);
//    callPopular();
        recyclerViewP.setAdapter(adapter1);
    }
//
//    private void callPopular() {
//        dataRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                modelPopular model = snapshot.getValue(modelPopular.class);
//                listPopular.add(model);
//                 Toast.makeText(getApplicationContext(),model.getImageURL(),Toast.LENGTH_LONG).show();
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
}