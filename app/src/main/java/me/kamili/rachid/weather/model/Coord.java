package me.kamili.rachid.weather.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Coord implements Parcelable{

	@SerializedName("lon")
	private double lon;

	@SerializedName("lat")
	private double lat;

	protected Coord(Parcel in) {
		lon = in.readDouble();
		lat = in.readDouble();
	}

	public static final Creator<Coord> CREATOR = new Creator<Coord>() {
		@Override
		public Coord createFromParcel(Parcel in) {
			return new Coord(in);
		}

		@Override
		public Coord[] newArray(int size) {
			return new Coord[size];
		}
	};

	public void setLon(double lon){
		this.lon = lon;
	}

	public double getLon(){
		return lon;
	}

	public void setLat(double lat){
		this.lat = lat;
	}

	public double getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"Coord{" + 
			"lon = '" + lon + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeDouble(lon);
		dest.writeDouble(lat);
	}
}