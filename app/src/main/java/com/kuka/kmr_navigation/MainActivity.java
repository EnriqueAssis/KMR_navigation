package com.kuka.kmr_navigation;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;

    private ImageButton goto1;
    private ImageButton goto2;
    private ImageButton goto3;
    private ImageButton goto4;
    private ImageButton goto5;
    private ImageButton goto6;

    private Button it_is_at1;
    private Button it_is_at2;
    private Button it_is_at3;
    private Button it_is_at4;
    private Button it_is_at5;
    private Button it_is_at6;

    private ImageView kmr1;
    private ImageView kmr2;
    private ImageView kmr3;
    private ImageView kmr4;
    private ImageView kmr5;
    private ImageView kmr6;

//    private boolean goToNode1 = false;
//    private boolean goToNode2 = false;
//    private boolean goToNode3 = false;
//    private boolean goToNode4 = false;
//    private boolean goToNode5 = false;
//    private boolean goToNode6 = false;

    private boolean at_node1 = false;
    private boolean at_node2 = false;
    private boolean at_node3 = false;
    private boolean at_node4 = false;
    private boolean at_node5 = false;
    private boolean at_node6 = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goto1 = (ImageButton) findViewById(R.id.imageButton1);
        goto2 = (ImageButton) findViewById(R.id.imageButton2);
        goto3 = (ImageButton) findViewById(R.id.imageButton3);
        goto4 = (ImageButton) findViewById(R.id.imageButton4);
        goto5 = (ImageButton) findViewById(R.id.imageButton5);
        goto6 = (ImageButton) findViewById(R.id.imageButton6);

        it_is_at1 = (Button) findViewById(R.id.button11);
        it_is_at2 = (Button) findViewById(R.id.button12);
        it_is_at3 = (Button) findViewById(R.id.button13);
        it_is_at4 = (Button) findViewById(R.id.button14);
        it_is_at5 = (Button) findViewById(R.id.button15);
        it_is_at6 = (Button) findViewById(R.id.button16);

        kmr1 = (ImageView) findViewById(R.id.kmr1);
        kmr2 = (ImageView) findViewById(R.id.kmr2);
        kmr3 = (ImageView) findViewById(R.id.kmr3);
        kmr4 = (ImageView) findViewById(R.id.kmr4);
        kmr5 = (ImageView) findViewById(R.id.kmr5);
        kmr6 = (ImageView) findViewById(R.id.kmr6);

        //handler check for KMR feedback every 250 milliseconds

        final Handler handler = new Handler();
        final int delay = 250; //milliseconds

        handler.postDelayed(new Runnable() {
            public void run() {

                // check which node is active to show the solid icon at the position.
                if (at_node1) {
                    clearIcons();
                    kmr1.setVisibility(View.VISIBLE);
                    at_node1 = true;
                } else if (at_node2) {
                    clearIcons();
                    kmr2.setVisibility(View.VISIBLE);
                    at_node2 = true;

                } else if (at_node3) {
                    clearIcons();
                    kmr3.setVisibility(View.VISIBLE);
                    at_node3 = true;

                } else if (at_node4) {
                    clearIcons();
                    kmr4.setVisibility(View.VISIBLE);
                    at_node4 = true;

                } else if (at_node5) {
                    clearIcons();
                    kmr5.setVisibility(View.VISIBLE);
                    at_node5 = true;

                } else if (at_node6) {
                    clearIcons();
                    kmr6.setVisibility(View.VISIBLE);
                    at_node6 = true;

                }
                handler.postDelayed(this, delay);
            }
        }, delay);

        /* Listener waits a command to move the KMR. After the command, the first
        action is to verify the current position in order to run the proper animation */
        /*It has to be added here the command to send the robot to the node*/

        goto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPosition();
            }
        });

        goto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPosition();
            }
        });

        goto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPosition();
            }
        });

        goto4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPosition();
            }
        });

        goto5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPosition();
            }
        });

        goto6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPosition();
            }
        });

        /* Listener checks if the KMR is at a specific node. If so, all animations
         * are cleared, and a solid icon will be shown at the right node.*/
        it_is_at1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearIcons();
                at_node1 = true;
            }
        });

        it_is_at2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearIcons();
                at_node2 = true;
            }
        });

        it_is_at3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearIcons();
                at_node3 = true;
            }
        });

        it_is_at4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearIcons();
                at_node4 = true;
            }
        });

        it_is_at5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearIcons();
                at_node5 = true;
            }
        });

        it_is_at6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearIcons();
                at_node6 = true;
            }
        });





    }



    // This method clears all animations, but the one where the KMR currently is.
    public void checkPosition(){
            if (at_node1){
                final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                kmr1.startAnimation(animation);

                kmr2.clearAnimation();
                kmr3.clearAnimation();
                kmr4.clearAnimation();
                kmr5.clearAnimation();
                kmr6.clearAnimation();

                kmr2.setVisibility(View.INVISIBLE);
                kmr3.setVisibility(View.INVISIBLE);
                kmr4.setVisibility(View.INVISIBLE);
                kmr5.setVisibility(View.INVISIBLE);
                kmr6.setVisibility(View.INVISIBLE);

                at_node1 = false;
            }
                else if (at_node2){
                final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                kmr2.startAnimation(animation);

                kmr1.clearAnimation();
                kmr3.clearAnimation();
                kmr4.clearAnimation();
                kmr5.clearAnimation();
                kmr6.clearAnimation();

                kmr1.setVisibility(View.INVISIBLE);
                kmr3.setVisibility(View.INVISIBLE);
                kmr4.setVisibility(View.INVISIBLE);
                kmr5.setVisibility(View.INVISIBLE);
                kmr6.setVisibility(View.INVISIBLE);

                at_node2 = false;

            }
                else if (at_node3) {
                final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                kmr3.startAnimation(animation);

                kmr1.clearAnimation();
                kmr2.clearAnimation();
                kmr4.clearAnimation();
                kmr5.clearAnimation();
                kmr6.clearAnimation();

                kmr1.setVisibility(View.INVISIBLE);
                kmr2.setVisibility(View.INVISIBLE);
                kmr4.setVisibility(View.INVISIBLE);
                kmr5.setVisibility(View.INVISIBLE);
                kmr6.setVisibility(View.INVISIBLE);

                at_node3 = false;

            }
                else if (at_node4) {
                final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                kmr4.startAnimation(animation);

                kmr1.clearAnimation();
                kmr2.clearAnimation();
                kmr3.clearAnimation();
                kmr5.clearAnimation();
                kmr6.clearAnimation();

                kmr1.setVisibility(View.INVISIBLE);
                kmr2.setVisibility(View.INVISIBLE);
                kmr3.setVisibility(View.INVISIBLE);
                kmr5.setVisibility(View.INVISIBLE);
                kmr6.setVisibility(View.INVISIBLE);

                at_node4 = false;

            }
                else if (at_node5) {
                final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                kmr5.startAnimation(animation);

                kmr1.clearAnimation();
                kmr2.clearAnimation();
                kmr3.clearAnimation();
                kmr4.clearAnimation();
                kmr6.clearAnimation();

                kmr1.setVisibility(View.INVISIBLE);
                kmr2.setVisibility(View.INVISIBLE);
                kmr3.setVisibility(View.INVISIBLE);
                kmr4.setVisibility(View.INVISIBLE);
                kmr6.setVisibility(View.INVISIBLE);

                at_node5 = false;

            }
                else if (at_node6) {
                final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                kmr6.startAnimation(animation);

                kmr1.clearAnimation();
                kmr2.clearAnimation();
                kmr3.clearAnimation();
                kmr4.clearAnimation();
                kmr5.clearAnimation();

                kmr1.setVisibility(View.INVISIBLE);
                kmr2.setVisibility(View.INVISIBLE);
                kmr3.setVisibility(View.INVISIBLE);
                kmr4.setVisibility(View.INVISIBLE);
                kmr5.setVisibility(View.INVISIBLE);

                at_node6 = false;

            }
    }

    public void clearIcons() {

        at_node1 = false;
        at_node2 = false;
        at_node3 = false;
        at_node4 = false;
        at_node5 = false;
        at_node6 = false;

        kmr1.clearAnimation();
        kmr2.clearAnimation();
        kmr3.clearAnimation();
        kmr4.clearAnimation();
        kmr5.clearAnimation();
        kmr6.clearAnimation();

        kmr1.setVisibility(View.INVISIBLE);
        kmr2.setVisibility(View.INVISIBLE);
        kmr3.setVisibility(View.INVISIBLE);
        kmr4.setVisibility(View.INVISIBLE);
        kmr5.setVisibility(View.INVISIBLE);
        kmr6.setVisibility(View.INVISIBLE);
    }

    }

