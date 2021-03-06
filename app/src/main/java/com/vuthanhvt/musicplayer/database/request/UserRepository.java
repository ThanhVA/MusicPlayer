package com.vuthanhvt.musicplayer.database.request;

import android.content.Context;
import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.database.source.IUserLocalDataSource;
import com.vuthanhvt.musicplayer.database.source.UserLocalDataSource;

/**
 * Create by FRAMGIA\vu.anh.thanh on 02/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class UserRepository.
 */
public class UserRepository implements IUserLocalDataSource {
    
    public static final String TAG = "UserRepository";

    private static UserRepository mInstance = new UserRepository(UserLocalDataSource.getInstance());

    private IUserLocalDataSource mUserLocalDataSource;

    private UserRepository(UserLocalDataSource userLocalDataSource) {
        this.mUserLocalDataSource = userLocalDataSource;
    }

    public static UserRepository getInstance() {
        return mInstance;
    }

    @Override
    public void loadDataFirstStart(Context context) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "loadDataFirstStart: ");
        }
        mUserLocalDataSource.loadDataFirstStart(context);
    }
}
