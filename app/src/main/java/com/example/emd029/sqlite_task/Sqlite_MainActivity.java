package com.example.emd029.sqlite_task;


import android.support.v4.view.ViewPager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.EditText;

import com.example.emd029.sqlite_task.SlidingTablayout.SlidingTabLayout;
import com.example.emd029.sqlite_task.SlidingTablayout.ViewPagerAdapter;

public class Sqlite_MainActivity extends AppCompatActivity {
//TextView textView;
    EditText editText;
    Toolbar toolbar;
    ViewPager viewPager;
    ViewPagerAdapter adapter;
    SlidingTabLayout slidingTabLayout;
    int NumofTabs=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_sqlite__main);
        DbHandler handler=new DbHandler(this);
        handler.deletealldata();
        database();
        //set a toolbar as a action bar
        toolbar= (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        Global.search_STATUS = false;
        //seta view pager by passing a adapter of a view page adapter class that contains a position of fragments
        adapter=new ViewPagerAdapter(getSupportFragmentManager());

        viewPager= (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        //set a sliding tab layout
        slidingTabLayout= (SlidingTabLayout) findViewById(R.id.slidingtablayout);
        slidingTabLayout.setDistributeEvenly(true);
       slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
           @Override
           public int getIndicatorColor(int position) {
               return getResources().getColor(R.color.tabscrollcolor);
           }
       });
        slidingTabLayout.setViewPager(viewPager);
        ///////////////////////////////////////////////////////////////////////////////////////////
        // Set an OnMenuItemClickListener to handle menu item clicks
      /**********  toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_search:
                        Toast.makeText(Sqlite_MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(Sqlite_MainActivity.this,SearchResultsActivity.class));
                        break;
                    case R.id.action_settings:
                        Toast.makeText(getApplicationContext(), "Filter", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });********************************/
        // Inflate a menu to be displayed in the toolbar
       // toolbar.inflateMenu(R.menu.menu_sqlite__main);
    }
    public void database(){
        //calling a DbHandler database class
        DbHandler handler=new DbHandler(Sqlite_MainActivity.this);
        //adding data into a table in database000000
        handler.addName(new StudentNames(1, "jayaraj","Maths", "Completed"));
        handler.addName(new StudentNames(1,"ragu","Maths","NotCompleted"));
        handler.addName(new StudentNames(1,"vijay","Maths","Completed"));
        handler.addName(new StudentNames(1,"dhana","Maths","NotCompleted"));
        handler.addName(new StudentNames(1,"rajesh","Maths","NotCompleted"));
        handler.addName(new StudentNames(1,"raja","Maths","Completed"));
        handler.addName(new StudentNames(1,"ramesh","Maths","Completed"));
        handler.addName(new StudentNames(1,"vicky","Maths","NotCompleted"));
        handler.addName(new StudentNames(1,"madan","Maths","Completed"));
        handler.addName(new StudentNames(1,"vinay","Maths","Completed"));
        handler.addName(new StudentNames(1,"babu","Maths","NotCompleted"));
        handler.addName(new StudentNames(1,"baskar","Maths","Completed"));
        handler.addName(new StudentNames(1,"vinoth","Maths","Completed"));
        handler.addName(new StudentNames(1,"mani","Maths","NotCompleted"));
        //the below array list is used to get the details of the table
        //create arraylist
        //the below list will adding all data in to a buffer string
       /* List<StudentNames> namesList=handler.getalldata();
        StringBuffer buffer=new StringBuffer();
        for (StudentNames names:namesList){
            buffer.append("id"+names.getId()+"name"+names.getName()+"subject"+names.getSubject()+
                    "assignment"+names.getAssignmentTask()).append("\n");

        }
        textView.setText(buffer.toString());*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        toolbar.inflateMenu(R.menu.menu_sqlite__main);
        SearchView mSearchView = (SearchView) toolbar.getMenu().findItem(R.id.action_search).getActionView();
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            DbHandler dbHandler=new DbHandler(Sqlite_MainActivity.this);
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Toast.makeText(Sqlite_MainActivity.this, query, Toast.LENGTH_SHORT).show();
               // displayResults(query);

                return true;
            }
            private void displayResults(String query) {
               // Cursor cursor = dbHandler.searchByInputText((query != null ? query : "@@@@"));
// int cnt = cursor.getCount();
                   // Toast.makeText(Sqlite_MainActivity.this,Integer.toString(cnt),Toast.LENGTH_LONG).show();
                    Global.search_STATUS = true;
                    Global.ssignment_STATUS = query;
                    adapter=new ViewPagerAdapter(getSupportFragmentManager());
                    viewPager.setAdapter(adapter);


            }
            @Override
            public boolean onQueryTextChange(String query) {
                displayResults(query);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
    }

    //@Override
  /*  public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }*/

