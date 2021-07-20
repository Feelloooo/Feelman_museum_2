package com.example.feelman_museum;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Frag_heritage2 extends Fragment {
    private View view;
    RecyclerView recyclerView;
    MyAdapter myAdapter;

    SearchView searchView;

    public static Frag_heritage2 newInstance(){

        Frag_heritage2 frag_heritage2 = new Frag_heritage2();
        return frag_heritage2;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_heritage2, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myAdapter = new MyAdapter(getContext(), getMylist());
        recyclerView.setAdapter(myAdapter);

        setHasOptionsMenu(true);
        return view;
    }

    private ArrayList<Heritage> getMylist() {
        ArrayList<Heritage> heritage = new ArrayList<>();

        DataAdapter mDbHelper = new DataAdapter(getContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        // db에 있는 값들을 model을 적용해서 넣는다.
        heritage = mDbHelper.getTableData2();

        // db 닫기
        mDbHelper.close();

        return heritage;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_1, menu);

            SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
            searchView = (SearchView) menu.findItem(R.id.action_search)
                    .getActionView();
            searchView.setSearchableInfo(searchManager
                    .getSearchableInfo(getActivity().getComponentName()));
            searchView.setMaxWidth(Integer.MAX_VALUE);
            searchView.setQueryHint("검색어를 입력하세요.");
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    myAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String query) {
                    myAdapter.getFilter().filter(query);
                    return false;
                }
            });
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            int id = item.getItemId();
            //or switch문을 이용하면 될듯 하다.
            if (id == R.id.action_camera) {
                Intent homeIntent = new Intent(getContext(), MainActivity.class);
                startActivity(homeIntent);
            }
            return super.onOptionsItemSelected(item);
        }
}

