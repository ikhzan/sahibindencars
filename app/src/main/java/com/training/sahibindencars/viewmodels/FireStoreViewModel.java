package com.training.sahibindencars.viewmodels;

import androidx.lifecycle.ViewModel;

import com.training.sahibindencars.util.Filters;

public class FireStoreViewModel extends ViewModel {

    private boolean mIsSigningIn;
    private Filters mFilters;

    public FireStoreViewModel() {
        mIsSigningIn = false;
        mFilters = Filters.getDefault();
    }

    public boolean getIsSigningIn() {
        return mIsSigningIn;
    }

    public void setIsSigningIn(boolean mIsSigningIn) {
        this.mIsSigningIn = mIsSigningIn;
    }

    public Filters getFilters() {
        return mFilters;
    }

    public void setFilters(Filters mFilters) {
        this.mFilters = mFilters;
    }
}
