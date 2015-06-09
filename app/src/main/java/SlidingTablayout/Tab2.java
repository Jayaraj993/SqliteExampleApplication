package SlidingTablayout;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.emd029.sqlite_task.DbHandler;
import com.example.emd029.sqlite_task.Global;
import com.example.emd029.sqlite_task.BaseAdapter_list;
import com.example.emd029.sqlite_task.R;

import java.util.ArrayList;

/**
 * Created by EMD029 on 6/4/2015.
 */
public class Tab2 extends Fragment {
    //creating a fragment for a viewpager tabview
    ListView listView2;
    BaseAdapter_list baseAdapterlist;
    Context context;
    ArrayList<String > na;
    public Tab2(Context context){
        this.context=context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup group,Bundle savedInstanceState){
        ViewGroup view= (ViewGroup) inflater.inflate(R.layout.tab2,group,false);
        listView2= (ListView) view.findViewById(R.id.listView2);
        DbHandler dbHandler=new DbHandler(context);
        if (Global.search_STATUS){
            na=dbHandler.searchByInputText(Global.ssignment_STATUS);
        }else {
            //get a data into a arraylist by calling a method in a DbHandler
            na = dbHandler.getalldatas();
        }
        //pass a arraylist into a base adapter class Hai
        baseAdapterlist =new BaseAdapter_list(context,na);
        //set a adapter into a listview using a baseadapter class object hai
        listView2.setAdapter(baseAdapterlist);
        return view;
    }
}
