package com.vuthanhvt.musicplayer.database.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.vuthanhvt.musicplayer.Constants;
import com.vuthanhvt.musicplayer.model.Album;
import com.vuthanhvt.musicplayer.model.Artist;
import com.vuthanhvt.musicplayer.model.Playlist;
import com.vuthanhvt.musicplayer.model.SearchHistory;
import com.vuthanhvt.musicplayer.model.Song;

/**
 * Create by FRAMGIA\vu.anh.thanh on 07/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class MusicDB.
 */
@Database(entities = {Album.class, Artist.class, Playlist.class, Song.class, SearchHistory.class},
        version = 1)
public abstract class MusicDB extends RoomDatabase {

    public static final String TAG = "MusicDB";

    public abstract AlbumDAO getAlbumDAOAccess();

    public abstract ArtistDAO getArtistDAOAccess();

    public abstract PlaylistDAO getPlaylistDAOAccess();

    public abstract SongDAO getSongDAOAccess();


    private static MusicDB mInstance;

    public static MusicDB getMusicDB(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(),
                    MusicDB.class, Constants.DBConstant.DATABASE_NAME).allowMainThreadQueries().build();
        }
        return mInstance;
    }

    public static void clearMusicDB() {
        mInstance = null;
    }
}