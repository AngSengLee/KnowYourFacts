package com.example.a16004798.knowyourfacts;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class frag1 extends Fragment {

    TextView tv1;
    Button btnChange1;

    public frag1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_frag1, container, false);

        final View view = inflater.inflate(R.layout.fragment_frag1, container, false);

        tv1 = (TextView) view.findViewById(R.id.tv1);
        btnChange1 = (Button) view.findViewById(R.id.btnChange1);


        tv1.setText("The purpose of the fairy tale 'Beauty and the Beast' was to help young girls accept arranged marriages.");

        btnChange1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { ;
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                view.setBackgroundColor(color);
            }
        });
        return view;
    }

}
