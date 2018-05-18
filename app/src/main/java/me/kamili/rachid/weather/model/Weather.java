package me.kamili.rachid.weather.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Weather implements Parcelable{

	@SerializedName("icon")
	private String icon;

	@SerializedName("description")
	private String description;

	@SerializedName("main")
	private String main;

	@SerializedName("id")
	private int id;

	protected Weather(Parcel in) {
		icon = in.readString();
		description = in.readString();
		main = in.readString();
		id = in.readInt();
	}

	public static final Creator<Weather> CREATOR = new Creator<Weather>() {
		@Override
		public Weather createFromParcel(Parcel in) {
			return new Weather(in);
		}

		@Override
		public Weather[] newArray(int size) {
			return new Weather[size];
		}
	};

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setMain(String main){
		this.main = main;
	}

	public String getMain(){
		return main;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Weather{" +
			"icon = '" + icon + '\'' + 
			",description = '" + description + '\'' + 
			",main = '" + main + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(icon);
		dest.writeString(description);
		dest.writeString(main);
		dest.writeInt(id);
	}
}