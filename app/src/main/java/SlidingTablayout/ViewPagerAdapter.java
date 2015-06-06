package SlidingTablayout;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by EMD029 on 6/4/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter{
    CharSequence Titles[];
    int NumofTabs;
    Context context;

    public ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[],int mNumofTabs,Context context){
        //passing a titles and number of tab view
        super(fm);
        this.Titles=mTitles;
        this.NumofTabs=mNumofTabs;
        this.context = context;
    }
    //set a fragment depend on a position
    @Override
     public Fragment getItem(int position) {
        if (position==0){
            Tab1 tab1=new Tab1(context);
            return tab1;

        }else{
            Tab2 tab2=new Tab2(context);
            return tab2;
        }

    }
@Override
public CharSequence getPageTitle(int position){
    return Titles[position];
}

    @Override
    public int getCount() {
        return NumofTabs;
    }
}
