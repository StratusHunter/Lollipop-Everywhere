package com.stratushunter.lollipopeverywhere.classes;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Terence Baker on 23/10/14.
 */
public class ViewModel implements Parcelable {

    private String text;
    private String image;

    public ViewModel(String text, String image) {

        this.text = text;
        this.image = image;
    }

    public String getText() {

        return text;
    }

    public String getImage() {

        return image;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.text);
        dest.writeString(this.image);
    }

    private ViewModel(Parcel in) {

        this.text = in.readString();
        this.image = in.readString();
    }

    public static final Parcelable.Creator<ViewModel> CREATOR = new Parcelable.Creator<ViewModel>() {

        public ViewModel createFromParcel(Parcel source) {

            return new ViewModel(source);
        }

        public ViewModel[] newArray(int size) {

            return new ViewModel[size];
        }
    };
}
