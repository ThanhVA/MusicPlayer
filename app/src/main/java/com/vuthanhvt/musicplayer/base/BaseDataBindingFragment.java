package com.vuthanhvt.musicplayer.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vuthanhvt.musicplayer.BR;

/**
 * Create by FRAMGIA\vu.anh.thanh on 22/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class BaseDataBindingFragment.
 */
public abstract class BaseDataBindingFragment<V extends ViewDataBinding, P extends BasePresenter>
        extends BaseFragment {

    public V mBinding;

    protected P mPresenter;

    public abstract int getContentViewLayoutId();

    protected abstract void initData();

    //check is first show fragment
    public boolean isFirstLoad = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getContentViewLayoutId(), container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        mBinding.setVariable(BR.presenter, mPresenter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mPresenter != null) {
            mPresenter.subscribe();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
    }

    public void onCreateFragment() {

    }
}
