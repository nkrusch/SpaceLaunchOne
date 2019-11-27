package io.github.nkrusch.spacelaunchone.features;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import io.github.nkrusch.spacelaunchone.R;


public class AgencyDetails extends AppCompatActivity {

    private static final String EXTRA_ID = "extra_launch";
    private static final String EXTRA_NAME = "extra_name";

    public static Intent getIntent(Context ctx, int id, String name) {
        Intent intent = new Intent(ctx, AgencyDetails.class);
        intent.putExtra(EXTRA_ID, id);
        intent.putExtra(EXTRA_NAME, name);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int agencyId = getIntent().getIntExtra(EXTRA_ID, -1);
        String title = getIntent().getStringExtra(EXTRA_NAME);
        setContentView(R.layout.activity_agency);
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(title);
        setupViewModel(agencyId);
     }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewModel(final int agencyId) {
        //        vm = ViewModelProviders.of(this).get(LaunchDetailsViewModel.class);
        //        vm.loadLaunch(launchId).observe(this, new Observer<LaunchDetails>() {
        //            @Override
        //            public void onChanged(@Nullable LaunchDetails result) {
        //                Log.d("VM", "result: " + result);
        //                if (result != null) {
        //                    mPager.setVisibility(View.VISIBLE);
        //                    mProgress.setVisibility(GONE);
        //                }
        //            }
        //        });
    }


}
