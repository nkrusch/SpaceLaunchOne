package io.github.nkrusch.spacelaunchone.features;

import android.os.Bundle;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import io.github.nkrusch.spacelaunchone.R;

/**
 * This activity shows a list of completed launches
 */
public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }
}