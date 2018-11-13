package com.vuthanhvt.musicplayer.database.request;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.vuthanhvt.musicplayer.model.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 13/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class ArtistLoader.
 */
public class ArtistLoader {
    public static Cursor makeArtistCursor(Context context, String condition, String[] parameter) {
        String[] projection = {
                MediaStore.Audio.Artists._ID,
                MediaStore.Audio.Artists.ARTIST,
                MediaStore.Audio.Artists.NUMBER_OF_ALBUMS,
                MediaStore.Audio.Artists.NUMBER_OF_TRACKS
        };

        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                condition,
                parameter,
                MediaStore.Audio.Artists.ARTIST);
        return cursor;
    }

    public static List<Artist> getArtistsForCursor(Cursor cursor) {
        List<Artist> arrayList = new ArrayList();
        if ((cursor != null) && (cursor.moveToFirst()))
            do {
                long id = cursor.getLong(0);
                String nameArtist = cursor.getString(1);
                int nbAlbums = cursor.getInt(2);
                int nbTracks = cursor.getInt(3);

                arrayList.add(new Artist(id, nameArtist, nbAlbums, nbTracks));
            }
            while (cursor.moveToNext());
        if (cursor != null) {
            cursor.close();
        }
        return arrayList;
    }
}
