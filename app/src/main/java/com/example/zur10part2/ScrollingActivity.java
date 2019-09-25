package com.example.zur10part2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class ScrollingActivity extends AppCompatActivity implements toraDataSorce.OnDataArrivedListener {

    TextView tvShow = null;
    private BottomNavigationItemView bnv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tvShow = findViewById(R.id.tvShow);
        toolbar.toString();

    }


    public void callbacke(ArrayList<String> data, Exception e) {

        runOnUiThread(() -> {
            if (e == null) {
                System.out.println(data);
                tvShow.setText(data.toString());
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String sefer = null;
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.actionBerashit:
                sefer = "bereasit.json";
                tvShow.setText("Beresit");
                break;
            case R.id.actionShemot:
                sefer = "shemot.json";
                tvShow.setText("Semot");
                break;
            case R.id.actionVaikra:
                sefer = "vaickra.json";
                tvShow.setText("Vaikra");
                break;
            case R.id.actionDevario:
                sefer = "devarim.json";
                tvShow.setText("Devarim");
                break;
            case R.id.actionBamidbar:
                sefer = "bamidbar.json";
                tvShow.setText("Bamidbar");
                break;
            case R.id.actionThilim:
                sefer = "tehilim.json";
                tvShow.setText("Thilim");
                break;
            default:
                return false;
        }


        try {

            toraDataSorce.getData(getAssets(), this, sefer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("Filenot found");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void callbaack(ArrayList<String> data, Exception e) {
        if (e == null) {
            System.out.println(data);
        } else {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
        }
    }
}
