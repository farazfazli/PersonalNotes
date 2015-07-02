package com.farazfazli.personalnotes;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by USER on 6/25/2015.
 */
public class NotesContract {
    interface NotesColumns {
        String NOTE_ID = "_ID";
        String NOTES_TITLE = "notes_title";
        String NOTES_DESCRIPTION = "notes_description";
        String NOTES_DATE = "note_date";
        String NOTES_TIME = "notes_time";
        String NOTES_IMAGE = "notes_image";
        String NOTES_TYPE = "notes_type";
        String NOTES_IMAGE_STORAGE_SELECTION = "notes_image_storage_selection";
    }

    public static final String CONTENT_AUTHORITY = "com.farazfazli.personalnotes.provider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    private static final String PATH_NOTES = "notes";
    public static final Uri URI_TABLE = BASE_CONTENT_URI.buildUpon().appendEncodedPath(PATH_NOTES).build();

    public static class Notes implements  NotesColumns, BaseColumns {
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd." + CONTENT_AUTHORITY + ".notes";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd." + CONTENT_AUTHORITY + ".notes";

        public static Uri buildNoteUri(String noteId) {
            return URI_TABLE.buildUpon().appendEncodedPath(noteId).build();
        }

        public static String getNoteId(Uri uri) {
            return uri.getPathSegments().get(1);
        }


    }
}