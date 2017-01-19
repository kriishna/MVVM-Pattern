package com.github.qindachang.mvvm_pattern.statistics;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by admin on 2017/1/19.
 */

public class StatisticsModel extends BaseObservable {
    private String text;

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }
}
