package com.example.sahiljindal.myfirst;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView logo1 = (TextView) findViewById(R.id.textView2);
        final TextView logo2 = (TextView) findViewById(R.id.textView2);
        final TextView logo1 = (TextView) findViewById(R.id.textView2);
        final Animation fade1 = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        TableLayout pics = (TableLayout) findViewById(R.id.TableLayout);
        Animation rotation = AnimationUtils.loadAnimation(this,R.anim.rotate);
        logo1.startAnimation(fade1);
        pics.startAnimation(rotation);
        ImageView centerImage = (ImageView) findViewById(R.id.imageView1);
        centerImage.startAnimation(rotation);
//        setContentView(R.layout.menu);
        final Animation fade2 = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        logo2.startAnimation(fade2);
        fade2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(MainActivity.this,MenuActivity.class));
                MainActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

//    @Override
//    protected void onPause(){
//        TextView logo2 = (TextView) findViewById(R.id.textView2);
//        Animation fade2 = AnimationUtils.loadAnimation(this,R.anim.fade_out);
//        logo2.startAnimation(fade2);
//    }

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
