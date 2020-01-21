 package com.sajal.tasktwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;

 public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener authStateListener;
     private GoogleSignInClient mGoogleSignInClient;
     private ViewPager viewPager;
     private PageAdapter adapter;
     private LinearLayout dotsLayout;
     private TextView[] dots;
     private RecyclerView recyclerView;
     private RecyclerView.Adapter recyclerAdapter;
     private int[] layouts={R.layout.slider1, R.layout.slider2, R.layout.slider3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

//        if (Build.VERSION.SDK_INT>=19) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
//        else {
//            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }


        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()==null){
                    startActivity(new Intent(HomeActivity.this,MainActivity.class));
                    finish();
                }
            }
        };
        dotsLayout = findViewById(R.id.dotsLayout);
        viewPager = findViewById(R.id.viewPager);
        adapter=new PageAdapter(layouts,this);
        viewPager.setAdapter(adapter);
        setViewPager();
        createDots(0);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView =findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter= new MyAdapter(this);
        recyclerView.setAdapter(recyclerAdapter);
    }

     public void signOut() {
         FirebaseAuth.getInstance().signOut();
         SaveSharedPreference.clearUserName(getApplication());
         startActivity(new Intent(HomeActivity.this,MainActivity.class));
         finish();
     }

     private void setViewPager() {
         adapter=new PageAdapter(layouts,this);
         viewPager.setAdapter(adapter);
         viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
             @Override
             public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

             }

             @Override
             public void onPageSelected(int position) {
                 createDots(position);
/*                 currentPage=position;
                 if (currentPage==0){
                     back.setEnabled(false);
                     next.setEnabled(true);
                     back.setVisibility(View.INVISIBLE);
                 }
                 else if (currentPage==dots.length-1){
                     back.setEnabled(true);
                     next.setEnabled(true);
                     back.setVisibility(View.VISIBLE);
                     next.setText("FINISH");
                 }
                 else{
                     back.setEnabled(true);
                     next.setEnabled(true);
                     back.setVisibility(View.VISIBLE);
                     next.setText("NEXT");
                 }*/
             }

             @Override
             public void onPageScrollStateChanged(int state) {

             }
         });
     }

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         // Inflate the menu; this adds items to the action bar if it is present.
         getMenuInflater().inflate(R.menu.navigation, menu);
         return true;
     }

     @Override
     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         switch (item.getItemId())
         {
             case R.id.action_logout :
                 signOut();
                 return true;

             case R.id.my_orders :
                 startActivity(new Intent(this,MyOrdersActivity.class));
                 return true;

             default:
                 return super.onOptionsItemSelected(item);
         }
     }

     private void  createDots(int position){
         dots = new TextView[layouts.length];
         dotsLayout.removeAllViews();
         for (int i=0;i<layouts.length;i++){
             dots[i]=new TextView(this);
             dots[i].setText(Html.fromHtml("&#8226"));
             dots[i].setTextSize(35);

             if (i==position){
                 dots[i].setTextColor(getResources().getColor(R.color.colorAccent));
             }
             else
                 dots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
             dotsLayout.addView(dots[i]);
         }
     }

     /*@Override
     protected void onStart() {
         super.onStart();
         mAuth.addAuthStateListener(authStateListener);
     }*/
 }
