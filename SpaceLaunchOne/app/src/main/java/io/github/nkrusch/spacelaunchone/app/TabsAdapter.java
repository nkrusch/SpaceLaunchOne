package io.github.nkrusch.spacelaunchone.app;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Base class for tabbed activity adapter
 */
public abstract class TabsAdapter extends FragmentStatePagerAdapter {

    private final int NUM_ITEMS;

    /**
     * @param numItems Provide total number of tabs in the layout
     */
    protected TabsAdapter(int numItems, FragmentManager fm) {
        super(fm);
        NUM_ITEMS = numItems;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    /**
     * This function should return fragment in specified
     * position in a tabLayout
     */
    public abstract Fragment getItem(int position);
}
