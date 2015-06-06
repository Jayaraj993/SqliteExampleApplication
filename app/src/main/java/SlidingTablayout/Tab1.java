package SlidingTablayout;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.emd029.sqlite_task.DbHandler;
import com.example.emd029.sqlite_task.Hai;
import com.example.emd029.sqlite_task.R;

import java.util.ArrayList;

/**
 * Created by EMD029 on 6/4/2015.
 */
public class Tab1 extends Fragment {
    //creating a fragment for a viewpager tabview
    Context context;
    public ListView listView1;

    ArrayList<String> na;
    Hai hai;

    public Tab1(Context context){
        this.context=context;

    }
    public Tab1(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup group,Bundle savedInstanceState){
        ViewGroup view= (ViewGroup) inflater.inflate(R.layout.tab1,group,false);
        DbHandler dbHandler=new DbHandler(context);
        //get a data into a arraylist by calling a method in a DbHandler
        na = dbHandler.getalldata();
        //pass a arraylist to abase adapter class hai
        hai=new Hai(context,na);
        listView1= (ListView) view.findViewById(R.id.listView1);
        //set a adapter using a base adapter class object hai
        listView1.setAdapter(hai);
        return view;
    }
}
