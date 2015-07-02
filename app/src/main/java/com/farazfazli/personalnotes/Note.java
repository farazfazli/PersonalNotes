package com.farazfazli.personalnotes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by USER on 6/25/2015.
 */
public class Note {
    private String mTitle, mDescription, mDate, mTime, mImagePath, mType;
    private int mId;
    private boolean mHasNoImage = false;
    private int mStorageSelection;

    // Contains the image (if any) attached to this note
    private Bitmap mBitmap;

    public Note(String mTitle, String mDescription, String mDate, String mTime, int mId, int mStorageSelection, String mType) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mDate = mDate;
        this.mTime = mTime;
        this.mId = mId;
        this.mStorageSelection = mStorageSelection;
        this.mType = mType;
    }

    // Create note from a reminderString (contains contents in a single string
    // delimited by a $ sign - see convertToString method later which
    // creates this.
    public Note(String reminderString) {
        // using \\ before a character tells the function
        // to NOT treat the character as a special regular expression
        // $ is normally interpreted as end of line or end of string
        String[] fields = reminderString.split("\\$");
        this.mType = fields[0];
        this.mId = Integer.parseInt(fields[1]);
        this.mTitle = fields[2];
        this.mDate = fields[5];
        this.mTime = fields[3];
        this.mImagePath = fields[4];
        this.mStorageSelection = Integer.parseInt(fields[6]);
        if (mType.equals(AppConstant.NORMAL)) {
            this.mDescription = fields[7];
            Note aNote = new Note(this.mTitle, this.mDescription, this.mDate, this.mTime, this.mId, this.mStorageSelection, this.mType);
            // Previous constructor does not set this, so we do it manually after invoking
            // the constructor
            aNote.setImagePath(this.mImagePath);
        } else {
            String list = "";
            for(int i = 7;i<fields.length;i++)
                list = list+fields[i];
            this.mDescription = list;
        }
    }

    public String convertToString() {
        return mType + "$"
                + mId + "$"
                + mTitle + "$"
                + mTime + "$"
                + mImagePath + "$"
                + mDate + "$"
                + mStorageSelection + "$"
                + mDescription;
    }

    public void setBitmap(String path) {
        setImagePath(path);
        this.mBitmap = BitmapFactory.decodeFile(path);
    }
    public Bitmap getBitmap() {
        return mBitmap;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getImagePath() {
        return mImagePath;
    }

    public void setImagePath(String imagePath) {
        mImagePath = imagePath;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public boolean isHasNoImage() {
        return mHasNoImage;
    }

    public void setHasNoImage(boolean hasNoImage) {
        mHasNoImage = hasNoImage;
    }

    public int getStorageSelection() {
        return mStorageSelection;
    }

    public void setStorageSelection(int storageSelection) {
        mStorageSelection = storageSelection;
    }
}