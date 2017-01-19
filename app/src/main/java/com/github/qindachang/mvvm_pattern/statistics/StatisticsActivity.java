package com.github.qindachang.mvvm_pattern.statistics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.qindachang.mvvm_pattern.R;
import com.github.qindachang.mvvm_pattern.util.ActivityUtils;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        StatisticsFragment statisticsFragment = (StatisticsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_statistics);
        if (statisticsFragment == null) {
            statisticsFragment = new StatisticsFragment();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    statisticsFragment, R.id.frameLayout_statistics);
        }
    }

}
