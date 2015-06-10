package com.example.emd029.sqlite_task;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SearchResultsActivity extends Activity {
    private TextView txtQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite__main);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);

        toolbar.setNavigationIcon(R.drawable.ic_search);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavUtils.navigateUpTo(SearchResultsActivity.this, IntentCompat
                        .makeMainActivity(new ComponentName(
                                SearchResultsActivity.this, SearchResultsActivity.class)));
            }
        });*/
      /*  ActionBar actionBar=getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        txtQuery= (TextView) findViewById(R.id.txtQuery);
        handleIntent(getIntent());*/

    }
    @Override
    public void onNewIntent(Intent intent){
        setIntent(intent);
        handleIntent(intent);
    }

    public void handleIntent(Intent intent){
        if (Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query=intent.getStringExtra(SearchManager.QUERY);
            txtQuery.setText("Search Qurry: "+query);
        }
    }
}
