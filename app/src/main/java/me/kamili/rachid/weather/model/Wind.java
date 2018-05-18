package me.kamili.rachid.weather.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Wind implements Parcelable{

	@SerializedName("speed")
	private double speed;

	protected Wind(Parcel in) {
		speed = in.readDouble();
	}

	public static final Creator<Wind> CREATOR = new Creator<Wind>() {
		@Override
		public Wind createFromParcel(Parcel in) {
			return new Wind(in);
		}

		@Override
		public Wind[] newArray(int size) {
			return new Wind[size];
		}
	};

	public void setSpeed(double speed){
		this.speed = speed;
	}

	public double getSpeed(){
		return speed;
	}

	@Override
 	public String toString(){
		return 
			"Wind{" + 
			"speed = '" + speed + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeDouble(speed);
	}
}