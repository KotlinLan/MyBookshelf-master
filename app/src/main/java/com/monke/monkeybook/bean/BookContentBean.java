//Copyright (c) 2017. 章钦豪. All rights reserved.
package com.monke.monkeybook.bean;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * 书本缓存内容
 */
public class BookContentBean implements Parcelable {
    private String noteUrl; //对应BookInfoBean noteUrl;

    private String durChapterUrl;

    private int durChapterIndex;   //当前章节  （包括番外）

    private String durChapterName;

    private String durChapterContent; //当前章节内容

    private Boolean isRight = true;

    public BookContentBean() {

    }

    protected BookContentBean(Parcel in) {
        durChapterUrl = in.readString();
        durChapterIndex = in.readInt();
        durChapterContent = in.readString();
        isRight = in.readByte() != 0;
        noteUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(durChapterUrl);
        dest.writeInt(durChapterIndex);
        dest.writeString(durChapterContent);
        dest.writeByte((byte) (isRight ? 1 : 0));
        dest.writeString(noteUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BookContentBean> CREATOR = new Creator<BookContentBean>() {
        @Override
        public BookContentBean createFromParcel(Parcel in) {
            return new BookContentBean(in);
        }

        @Override
        public BookContentBean[] newArray(int size) {
            return new BookContentBean[size];
        }
    };

    public String getDurChapterUrl() {
        return durChapterUrl;
    }

    public void setDurChapterUrl(String durChapterUrl) {
        this.durChapterUrl = durChapterUrl;
    }

    public int getDurChapterIndex() {
        return durChapterIndex;
    }

    public void setDurChapterIndex(int durChapterIndex) {
        this.durChapterIndex = durChapterIndex;
    }

    public String getDurChapterName() {
        return durChapterName;
    }

    public void setDurChapterName(String durChapterName) {
        this.durChapterName = durChapterName;
    }

    public String getDurChapterContent() {
        return durChapterContent;
    }

    public void setDurChapterContent(String durChapterContent) {
        this.durChapterContent = durChapterContent;
        if (durChapterContent == null || durChapterContent.length() == 0)
            this.isRight = false;
    }

    public void appendDurChapterContent(String durChapterContent) {
        if (this.durChapterContent == null) {
            setDurChapterContent(durChapterContent);
        } else {
            this.durChapterContent = this.durChapterContent + "\n" + durChapterContent;
        }
    }

    public Boolean getRight() {
        return isRight;
    }

    public String getNoteUrl() {
        return this.noteUrl;
    }

    public void setNoteUrl(String noteUrl) {
        this.noteUrl = noteUrl;
    }

    @NonNull
    @Override
    public String toString() {
        return "BookContentBean{" +
                "noteUrl='" + noteUrl + '\'' +
                ", durChapterUrl='" + durChapterUrl + '\'' +
                ", durChapterIndex=" + durChapterIndex +
                ", durChapterName='" + durChapterName + '\'' +
                ", durChapterContent='" + durChapterContent + '\'' +
                ", isRight=" + isRight +
                '}';
    }
}
