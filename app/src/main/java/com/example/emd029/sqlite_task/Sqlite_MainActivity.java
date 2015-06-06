package com.example.emd029.sqlite_task;


import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import SlidingTablayout.SlidingTabLayout;
import SlidingTablayout.ViewPagerAdapter;

public class Sqlite_MainActivity extends ActionBarActivity {
//TextView textView;
    Toolbar toolbar;
    ViewPager viewPager;
    ViewPagerAdapter adapter;
    SlidingTabLayout slidingTabLayout;
    CharSequence Titles[]={"homes","events"};
    int NumofTabs=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite__main);
        database();
        //set a toolbar as a action bar
        toolbar= (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        //seta view pager by passing a adapter of a view page adapter class that contains a position of fragments
        adapter=new ViewPagerAdapter(getSupportFragmentManager(),Titles,NumofTabs,Sqlite_MainActivity.this);

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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sqlite__main, menu);
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
