package com.github.qindachang.mvvm_pattern.statistics;

import android.content.Context;

/**
 * Created by admin on 2017/1/19.
 */

public class StatisticsViewModel implements StatisticsContract.ICommand {

    private int number;
    private boolean control;

    private Context mContext;
    private StatisticsContract.INotifyPropertyChanged mINotifyPropertyChanged;
    private StatisticsModel mModel;

    public StatisticsViewModel(Context context, StatisticsContract.INotifyPropertyChanged INotifyPropertyChanged) {
        mContext = context;
        mINotifyPropertyChanged = INotifyPropertyChanged;
        mModel = new StatisticsModel();
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {
        mContext = null;
    }

    @Override
    public StatisticsModel getModel() {
        return mModel;
    }

    @Override
    public void onButtonAddClick() {
        number += 1;
        mModel.setText(String.valueOf(number));
    }

    @Override
    public void onButtonControlClick() {
        control = !control;
        mINotifyPropertyChanged.onIdViewControlChange(control);
    }
}
