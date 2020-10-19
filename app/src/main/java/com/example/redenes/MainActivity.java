package com.example.redenes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    RelativeLayout layout;
    ImageView b, c, d, e;
    Spinner spinner;
    Fragment fragment;
    String tag;
    int background, two, three, four, five;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.main);
        b = findViewById(R.id.two);
        c = findViewById(R.id.three);
        d = findViewById(R.id.four);
        e = findViewById(R.id.five);

        if (savedInstanceState != null) {
            switch (savedInstanceState.getInt("background")) {
                case 1:
                    case1();
                    break;
                case 2:
                    case2();
                    break;
                case 3:
                    case3();
                    break;
                case 4:
                    case4();
                    break;
                case 5:
                    case5();
                    break;
            }
//            b.setImageResource(savedInstanceState.getInt("two"));
//            c.setImageResource(savedInstanceState.getInt("three"));
//            d.setImageResource(savedInstanceState.getInt("four"));
//            e.setImageResource(savedInstanceState.getInt("five"));
        } else {
            background = 1;
        }

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_options, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_main, new HomeFragment())
                .commit();
    }

    public void loadFragment(Fragment fragment, String tag) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_main, fragment)
                    .addToBackStack(tag)
                    .commit();
        }
    }

    public void load(View view) {

        switch (view.getId()) {

            case R.id.two:
                case2();
                break;

            case R.id.three:
                case3();
                break;

            case R.id.four:
                case4();
                break;

            case R.id.five:
                case5();
                break;

            default:
                case1();
        }

        loadFragment(fragment, tag);
    }

    public void case2() {
        fragment = new HomeFragment2();
        tag = "two";
        b.setImageResource(R.drawable.ic_list_sel);
        c.setImageResource(R.drawable.menu_icon);
        d.setImageResource(R.drawable.ic_group);
        e.setImageResource(R.drawable.ic_management);
        two = R.drawable.ic_list_sel;
        three = R.drawable.menu_icon;
        four = R.drawable.ic_group;
        five = R.drawable.ic_management;
        layout.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_bg_home2));
//                background = R.drawable.ic_bg_home2;
        background = 2;
    }

    public void case3() {
        fragment = new HomeFragment3();
        tag = "three";
        b.setImageResource(R.drawable.ic_list_sel);
        c.setImageResource(R.drawable.logo_menu_sel);
        d.setImageResource(R.drawable.ic_group);
        e.setImageResource(R.drawable.ic_management);
        two = R.drawable.ic_list_sel;
        three = R.drawable.logo_menu_sel;
        four = R.drawable.ic_group;
        five = R.drawable.ic_management;
        layout.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_bg_home_3));
//                background = R.drawable.ic_bg_home_3;
        background = 2;
    }

    public void case4() {
        fragment = new HomeFragment4();
        tag = "four";
        b.setImageResource(R.drawable.ic_list_sel);
        c.setImageResource(R.drawable.logo_menu_sel);
        d.setImageResource(R.drawable.ic_group_sel);
        e.setImageResource(R.drawable.ic_management);
        two = R.drawable.ic_list_sel;
        three = R.drawable.logo_menu_sel;
        four = R.drawable.ic_group_sel;
        five = R.drawable.ic_management;
        layout.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_bg_home4));
//                background = R.drawable.ic_bg_home4;
        background = 4;
    }

    public void case5() {
        fragment = new HomeFragment5();
        tag = "five";
        layout.setBackgroundColor(getColor(R.color.dark_background));
        b.setImageResource(R.drawable.ic_list_sel);
        c.setImageResource(R.drawable.logo_menu_sel);
        d.setImageResource(R.drawable.ic_group_sel);
        e.setImageResource(R.drawable.ic_management_sel);
        two = R.drawable.ic_list_sel;
        three = R.drawable.logo_menu_sel;
        four = R.drawable.ic_group_sel;
        five = R.drawable.ic_management_sel;
//                background = R.color.dark_background;
        background = 5;
    }
    public void case1() {
        fragment = new HomeFragment();
        tag = "home";
        layout.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_bg_home1));
        b.setImageResource(R.drawable.ic_list);
        c.setImageResource(R.drawable.menu_icon);
        d.setImageResource(R.drawable.ic_group);
        e.setImageResource(R.drawable.ic_management);
        two = R.drawable.ic_list;
        three = R.drawable.menu_icon;
        four = R.drawable.ic_group_sel;
        five = R.drawable.ic_management;

//                background = R.drawable.ic_bg_home1;
        background = 1;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        outState.putInt("background", background);
        outState.putInt("two", two);
        outState.putInt("three", three);
        outState.putInt("four", four);
        outState.putInt("five", five);
        super.onSaveInstanceState(outState, outPersistentState);
    }
}