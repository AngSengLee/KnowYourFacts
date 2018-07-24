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
public class frag2 extends Fragment {

    TextView tv2;
    Button btnChange2;

    public frag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_frag1, container, false);

        final View view = inflater.inflate(R.layout.fragment_frag2, container, false);

        tv2 = (TextView) view.findViewById(R.id.tv2);
        btnChange2 = (Button) view.findViewById(R.id.btnChange2);


        tv2.setText("The gaming industry makes more revenue than the film industry and music industry combined.");

        btnChange2.setOnClickListener(new View.OnClickListener() {
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

