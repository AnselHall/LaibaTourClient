package com.laibatour.laibatourclient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.laibatour.laibatourclient.R;
import com.laibatour.laibatourclient.utils.ToastUtil;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle actionBarDrawerToggle;
    private ActionBar actionBar;
    private DrawerLayout drawerLayout;
    private ListView navdrawer;
    String[] array;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        array = new String[]{"Stop Animation", "Start Animation", "ChangeColor", "GitHub Page", "Share", "Rate"};

        initSideView();

    }

    public void click(View view){
        startActivity(new Intent(MainActivity.this,SecondActivity.class));
    }

    private void initSideView() {

        actionBar = getSupportActionBar();

        actionBar.setTitle("Menu Opened");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navdrawer = (ListView) findViewById(R.id.navdrawer);
        navdrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtil.showToast(MainActivity.this,array[position] + "被点击了");
                drawerLayout.closeDrawers();
            }
        });


        navdrawer.setAdapter(new NavdrawerAdapter());
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, 0, 0);
        actionBarDrawerToggle.syncState();
        //滑动draw_layout，让三条线也滑动
        drawerLayout.setDrawerListener(new DrawerListener() {
            @Override
            public void onDrawerStateChanged(int state) {
                //将draw_layout的滑动状态告诉drawerToggle
                actionBarDrawerToggle.onDrawerStateChanged(state);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //将draw_layout的滑动slideOffset告诉drawerToggle
                actionBarDrawerToggle.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                //将draw_layout的滑动开的状态告诉drawerToggle
                actionBarDrawerToggle.onDrawerOpened(drawerView);
                actionBar.setTitle("Menu Closed");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                //将draw_layout的滑动关闭的状态告诉drawerToggle
                actionBarDrawerToggle.onDrawerClosed(drawerView);
                actionBar.setTitle("Menu Opened");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        actionBarDrawerToggle.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.action_account:
                Toast.makeText(this, "action_account", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_search:
                Toast.makeText(this, "action_search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "action_settings", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class NavdrawerAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return array.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(MainActivity.this);
            textView.setTextSize(20);
            textView.setText(array[position]);

            return textView;
        }
    }
}
