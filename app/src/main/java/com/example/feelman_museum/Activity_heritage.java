package com.example.feelman_museum;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class Activity_heritage extends AppCompatActivity {

    private FragmentPagerAdapter fragmentPagerAdapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heritage);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("소장유물");

        ViewPager viewPager = findViewById(R.id.viewPager);
        fragmentPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu, menu);
//
//        MenuItem menuItem = menu.findItem(R.id.menu_main_search);
//        searchView = (SearchView) menuItem.getActionView();
//        searchView.setQueryHint(getResources().getString(R.string.query_hint));
//        searchView.setOnQueryTextListener(queryTextListener);
//
//        return super.onCreateOptionsMenu(menu);
//    }
//    private SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
//        @Override
//        public boolean onQueryTextSubmit(String query) {
//            // 텍스트 입력 후 검색 버튼이 눌렸을 때의 이벤트
//            return true;
//        }
//
//        @Override
//        public boolean onQueryTextChange(String newText) {
//            // 검색 글 한자 한자 눌렸을 때의 이벤트
//            return false;
//        }
//    };
}