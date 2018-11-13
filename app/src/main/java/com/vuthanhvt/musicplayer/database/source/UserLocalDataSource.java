package com.vuthanhvt.musicplayer.database.source;

import android.content.Context;
import android.util.Log;

import com.vuthanhvt.musicplayer.BuildConfig;
import com.vuthanhvt.musicplayer.database.request.AlbumLoader;
import com.vuthanhvt.musicplayer.database.data.MusicDB;
import com.vuthanhvt.musicplayer.database.request.SongLoader;
import com.vuthanhvt.musicplayer.model.Album;
import com.vuthanhvt.musicplayer.model.Song;

import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 02/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class UserLocalDataSource.
 */
public class UserLocalDataSource implements IUserLocalDataSource {

    public static final String TAG = "UserLocalDataSource";
    
    private static UserLocalDataSource mInstance = new UserLocalDataSource();

    private UserLocalDataSource() {
    }

    public static UserLocalDataSource getInstance() {
        return mInstance;
    }

    @Override
    public void loadDataFirstStart(Context context) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "loadDataFirstStart: ");
        }
        /*List<Song> mListSongs = SongLoader.getSongsForCursor(SongLoader.makeSongCursor(context));
        int siteListSongs = mListSongs.size();
        for (int i = 0; i < siteListSongs; i++) {
            MusicDB.getMusicDB(context).getSongDAOAccess().insertAll(mListSongs.get(i));
        }

        List<Album> mListAlbums = AlbumLoader.getAlbumsForCursor(AlbumLoader.makeSongCursor(context));
        int siteListAlbums = mListAlbums.size();
        for (int i = 0; i < siteListAlbums; i++) {
            MusicDB.getMusicDB(context).getAlbumDAOAccess().insertAll(mListAlbums.get(i));
        }*/
        
        for (;;) {
            Log.d(TAG, "loadDataFirstStart: 111111111111111111111111111");
        }
    }
}
