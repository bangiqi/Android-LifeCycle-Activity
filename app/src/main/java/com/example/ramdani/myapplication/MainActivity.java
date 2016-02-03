package com.example.ramdani.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final Context context = this;

    private Button _btnIm;
    private Button _btnEx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("posisi", "saya berada pada method onCreate");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        _btnIm = (Button) findViewById(R.id.btn_im);
        _btnEx = (Button) findViewById(R.id.btn_ex);

        _btnIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //implicit intent
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "hello nama saya rizki");
                sendIntent.setType("text/plain");

                // Verify that the intent will resolve to an activity
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }
            }
        });

        _btnEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //explicit intent
                Intent intenSaya = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intenSaya);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                //set title
                alertDialogBuilder.setTitle("testing alert");

                //set dialog message

                alertDialogBuilder
                        .setMessage("ini alert dialog")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                        AlertDialog alertdialognew = alertDialogBuilder.create();
                        alertdialognew.show();


            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("posisi", "Saatnya restart activity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("posisi", "saya berada pada method onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("posisi", "saya berada pada method onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("posisi", "saya berada pada method onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("posisi", "saya berada pada method onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("posisi", "saya berada pada method onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
