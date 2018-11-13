package com.vuthanhvt.musicplayer.database.request;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.vuthanhvt.musicplayer.model.Album;

import java.util.ArrayList;

/**
 * Create by FRAMGIA\vu.anh.thanh on 08/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class AlbumLoader.
 */
public class AlbumLoader {

    public static Cursor makeAlbumCursor(Context context, String condition, String[] parameter) {
        String[] projection = {
                MediaStore.Audio.Albums._ID,
                MediaStore.Audio.Albums.ALBUM,
                MediaStore.Audio.Albums.ARTIST,
                MediaStore.Audio.AudioColumns.ARTIST_ID,
                MediaStore.Audio.Albums.NUMBER_OF_SONGS,
                MediaStore.Audio.Albums.FIRST_YEAR,
        };
        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                condition,
                parameter,
                MediaStore.Audio.Albums.ALBUM);

        return cursor;
    }

    public static ArrayList<Album> getAlbumsForCursor(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if ((cursor != null) && (cursor.moveToFirst()))
            do {
                long id = cursor.getLong(0);
                String title = cursor.getString(1);
                String artistName = cursor.getString(2);
                long artistId = cursor.getInt(3);
                int nbSongs = cursor.getInt(4);
                int year = cursor.getInt(5);

                arrayList.add(new Album(id, title, artistName, artistId, nbSongs, year));
            }
            while (cursor.moveToNext());
        if (cursor != null)
            cursor.close();
        return arrayList;
    }
}
