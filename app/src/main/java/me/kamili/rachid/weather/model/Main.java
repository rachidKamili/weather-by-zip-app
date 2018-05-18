package me.kamili.rachid.weather.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Main implements Parcelable{

	@SerializedName("temp")
	private double temp;

	@SerializedName("temp_min")
	private int tempMin;

	@SerializedName("humidity")
	private int humidity;

	@SerializedName("pressure")
	private int pressure;

	@SerializedName("temp_max")
	private int tempMax;

	protected Main(Parcel in) {
		temp = in.readDouble();
		tempMin = in.readInt();
		humidity = in.readInt();
		pressure = in.readInt();
		tempMax = in.readInt();
	}

	public static final Creator<Main> CREATOR = new Creator<Main>() {
		@Override
		public Main createFromParcel(Parcel in) {
			return new Main(in);
		}

		@Override
		public Main[] newArray(int size) {
			return new Main[size];
		}
	};

	public void setTemp(double temp){
		this.temp = temp;
	}

	public double getTemp(){
		return temp;
	}

	public void setTempMin(int tempMin){
		this.tempMin = tempMin;
	}

	public int getTempMin(){
		return tempMin;
	}

	public void setHumidity(int humidity){
		this.humidity = humidity;
	}

	public int getHumidity(){
		return humidity;
	}

	public void setPressure(int pressure){
		this.pressure = pressure;
	}

	public int getPressure(){
		return pressure;
	}

	public void setTempMax(int tempMax){
		this.tempMax = tempMax;
	}

	public int getTempMax(){
		return tempMax;
	}

	@Override
 	public String toString(){
		return 
			"Main{" + 
			"temp = '" + temp + '\'' + 
			",temp_min = '" + tempMin + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",pressure = '" + pressure + '\'' + 
			",temp_max = '" + tempMax + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeDouble(temp);
		dest.writeInt(tempMin);
		dest.writeInt(humidity);
		dest.writeInt(pressure);
		dest.writeInt(tempMax);
	}
}