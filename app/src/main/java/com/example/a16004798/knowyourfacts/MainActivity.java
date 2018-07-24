package com.example.a16004798.knowyourfacts;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList <Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;

    Button btnRL;

    AlarmManager am;
    int reqCode = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = (ViewPager) findViewById(R.id.viewpager1);
        btnRL = (Button) findViewById(R.id.btnReadLater);
        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<Fragment>();
        al.add(new frag1());
        al.add(new frag2());
        al.add(new frag3());

        adapter = new MyFragmentPagerAdapter(fm, al);

        vPager.setAdapter(adapter);

        btnRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MINUTE, 5);
                Intent intent = new Intent(MainActivity.this, ScheduledNotificationReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,reqCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.previous) {
            if (vPager.getCurrentItem() > 0){     //get the first page (page1)
                int previousPage = vPager.getCurrentItem() - 1;    //if it is not the first page, then user can still go 'back'
                vPager.setCurrentItem(previousPage, true);
            }
            return true;

        } else if (id == R.id.next) {
            int max = vPager.getChildCount();
            if (vPager.getCurrentItem() < max-1){    //get the last page (e.g page 10)
                int nextPage = vPager.getCurrentItem() + 1; //if is it not the last page, user can still go to 'next page'
                vPager.setCurrentItem(nextPage, true);
            }
            return true;
        }
        else{
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(3);
            vPager.setCurrentItem(randomInt, true);
            }
        return true;
    }
}
