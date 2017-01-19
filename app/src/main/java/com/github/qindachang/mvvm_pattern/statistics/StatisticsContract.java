package com.github.qindachang.mvvm_pattern.statistics;

import com.github.qindachang.mvvm_pattern.BaseICommand;

/**
 * Created by admin on 2017/1/19.
 */

public interface StatisticsContract {
    interface ICommand extends BaseICommand {
        // Send notifications to View When Model be updated by ViewModel.
        // DataBinding get the Model form here.
        StatisticsModel getModel();

        void onButtonAddClick();

        void onButtonControlClick();
    }

    // Some of the View that you have to use ID update it.
    interface INotifyPropertyChanged {
        void onIdViewControlChange(boolean control);
    }

}
