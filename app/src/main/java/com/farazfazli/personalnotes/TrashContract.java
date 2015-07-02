package com.farazfazli.personalnotes;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by USER on 6/25/2015.
 */
public class TrashContract {
    interface TrashColumns {
        String TRASH_ID = "_ID";
        String TRASH_TITLE = "trash_title";
        String TRASH_DESCRIPTION = "trash_description";
        String TRASH_DATE_TIME = "trash_date_time";
    }

    public static final String CONTENT_AUTHORITY = "com.farazfazli.personalnotes.provider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    private static final String PATH_TRASH = "trash";
    public static final Uri URI_TABLE = BASE_CONTENT_URI.buildUpon().appendEncodedPath(PATH_TRASH).build();



    public static class Trash implements TrashColumns, BaseColumns {

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd." + CONTENT_AUTHORITY + ".trash";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd." + CONTENT_AUTHORITY + ".trash";

        public static Uri buildTrashUri(String trashId) {
            return URI_TABLE.buildUpon().appendEncodedPath(trashId).build();
        }

        public static String getTrashId(Uri uri) {
            return uri.getPathSegments().get(1);
        }
    }
}