package io.github.nkrusch.spacelaunchone.features;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import io.github.nkrusch.spacelaunchone.R;

/**
 * This activity shows a list of completed launches
 */
public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_history, menu);
        return true;
    }

    /**
     * Handle menu option clicks
     *
     * @param item selected item
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.future) {
            Class mainActivityClass = getResources().getBoolean(R.bool.is_large_device) ?
                    ImageListActivity.class : MainActivity.class;
            startActivity(new Intent(this, mainActivityClass));
            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            return true;
        }
        if (id == R.id.settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        if (id == R.id.filters) {
            startActivity(new Intent(this, FilterActivity.class));
            return true;
        }
        if (id == R.id.top) {
            scrollToTop();
            return true;
        }
        if(id==R.id.search){
            startActivity(new Intent(this, SearchActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Scroll to top of list
     */
    private void scrollToTop() {
        ((RecyclerView) findViewById(R.id.recyclerView)).scrollToPosition(0);
    }
}