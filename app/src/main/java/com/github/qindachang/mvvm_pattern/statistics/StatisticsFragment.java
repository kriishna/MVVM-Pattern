package com.github.qindachang.mvvm_pattern.statistics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.qindachang.mvvm_pattern.R;
import com.github.qindachang.mvvm_pattern.databinding.FragmentStatisticsBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class StatisticsFragment extends Fragment implements StatisticsContract.INotifyPropertyChanged {

    private StatisticsContract.ICommand mICommand;
    private FragmentStatisticsBinding mViewDataBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        mViewDataBinding = FragmentStatisticsBinding.bind(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mICommand = new StatisticsViewModel(getContext(), this);
        mViewDataBinding.setCommand(mICommand);
    }

    @Override
    public void onResume() {
        super.onResume();
        mICommand.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mICommand.destroy();
    }

    @Override
    public void onIdViewControlChange(boolean control) {
        if (control) {
            mViewDataBinding.tvSomethingUseId.setVisibility(View.VISIBLE);
        } else {
            mViewDataBinding.tvSomethingUseId.setVisibility(View.INVISIBLE);
        }
    }
}
