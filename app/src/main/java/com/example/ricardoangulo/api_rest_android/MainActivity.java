package com.example.ricardoangulo.api_rest_android;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    ApiRestAdapterRecyclerView crudAdapterRecyclerView;
    private static final String URL = "http://172.16.1.104:8080/API_REST/api/selectUsers";
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.swipeRefresh) SwipeRefreshLayout swipeRefreshLayout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupRecycleView();
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override public void onRefresh() {
                crudAdapterRecyclerView.clearItems();
                fetchRecyclerView(1);
            }
        });

    }

    private void setupRecycleView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override protected void onStart() {
        super.onStart();
        fetchRecyclerView(0);
        //fetchRecyclerPost();
    }

    private void fetchRecyclerView(final int actualiza) {
        AndroidNetworking.get(URL)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsObjectList(ApiRestUsers.class, new ParsedRequestListener<ArrayList<ApiRestUsers>>() {
                    @Override
                    public void onResponse(ArrayList<ApiRestUsers> response) {
                        crudAdapterRecyclerView = new ApiRestAdapterRecyclerView(response, R.layout.cardview);
                        if(actualiza == 1) {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                        recyclerView.setAdapter(crudAdapterRecyclerView);
                    }

                    @Override
                    public void onError(ANError anError) {
                        if(actualiza == 1) {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                        anError.printStackTrace();
                        Toast.makeText(MainActivity.this, anError.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void fetchRecyclerPost() {
        AndroidNetworking.post("https://fierce-cove-29863.herokuapp.com/createAnUser")
                .addBodyParameter("firstname", "Amit")
                .addBodyParameter("lastname", "Shekhar")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // do anything with response
                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                        error.printStackTrace();
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
