package io.github.nkrusch.spacelaunchone.features.launches;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import io.github.nkrusch.spacelaunchone.R;
import viewmodels.SearchLaunchesViewModel;

/**
 * Search future and completed launches by query term
 */
public class SearchActivity extends AppCompatActivity {
    private SearchLaunchesViewModel vm = null;

    /**
     * Initialize views and setup search view
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        vm = new ViewModelProvider(this).get(SearchLaunchesViewModel.class);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SearchView searchView = findViewById(R.id.search_view);
        searchView.setQuery("", true);
        searchView.setSubmitButtonEnabled(false);
        searchView.setOnQueryTextListener(onQueryTextListener);
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.setContentDescription(getString(R.string.search_launches));
        searchView.requestFocusFromTouch();
    }

    /**
     * Handle query text change
     */
    private final SearchView.OnQueryTextListener onQueryTextListener =
            new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    queryLaunches(query);
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    queryLaunches(newText);
                    return true;
                }

                private void queryLaunches(String searchText) {
                    searchText = "%" + searchText + "%";
                    vm.setQuery(searchText);
                }
            };

    /**
     * Handle up action by finishing activity
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
