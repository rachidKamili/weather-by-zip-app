package me.kamili.rachid.weather.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Clouds implements Parcelable{

	@SerializedName("all")
	private int all;

	protected Clouds(Parcel in) {
		all = in.readInt();
	}

	public static final Creator<Clouds> CREATOR = new Creator<Clouds>() {
		@Override
		public Clouds createFromParcel(Parcel in) {
			return new Clouds(in);
		}

		@Override
		public Clouds[] newArray(int size) {
			return new Clouds[size];
		}
	};

	public void setAll(int all){
		this.all = all;
	}

	public int getAll(){
		return all;
	}

	@Override
 	public String toString(){
		return 
			"Clouds{" + 
			"all = '" + all + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(all);
	}
}