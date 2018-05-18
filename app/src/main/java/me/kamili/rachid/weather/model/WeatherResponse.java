package me.kamili.rachid.weather.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class WeatherResponse implements Parcelable{

	@SerializedName("dt")
	private int dt;

	@SerializedName("coord")
	private Coord coord;

	@SerializedName("visibility")
	private int visibility;

	@SerializedName("weather")
	private List<Weather> weather;

	@SerializedName("name")
	private String name;

	@SerializedName("cod")
	private int cod;

	@SerializedName("main")
	private Main main;

	@SerializedName("clouds")
	private Clouds clouds;

	@SerializedName("id")
	private int id;

	@SerializedName("sys")
	private Sys sys;

	@SerializedName("base")
	private String base;

	@SerializedName("wind")
	private Wind wind;

	protected WeatherResponse(Parcel in) {
		dt = in.readInt();
		coord = in.readParcelable(Coord.class.getClassLoader());
		visibility = in.readInt();
		weather = in.createTypedArrayList(Weather.CREATOR);
		name = in.readString();
		cod = in.readInt();
		main = in.readParcelable(Main.class.getClassLoader());
		clouds = in.readParcelable(Clouds.class.getClassLoader());
		id = in.readInt();
		sys = in.readParcelable(Sys.class.getClassLoader());
		base = in.readString();
		wind = in.readParcelable(Wind.class.getClassLoader());
	}

	public static final Creator<WeatherResponse> CREATOR = new Creator<WeatherResponse>() {
		@Override
		public WeatherResponse createFromParcel(Parcel in) {
			return new WeatherResponse(in);
		}

		@Override
		public WeatherResponse[] newArray(int size) {
			return new WeatherResponse[size];
		}
	};

	public void setDt(int dt){
		this.dt = dt;
	}

	public int getDt(){
		return dt;
	}

	public void setCoord(Coord coord){
		this.coord = coord;
	}

	public Coord getCoord(){
		return coord;
	}

	public void setVisibility(int visibility){
		this.visibility = visibility;
	}

	public int getVisibility(){
		return visibility;
	}

	public void setWeather(List<Weather> weather){
		this.weather = weather;
	}

	public List<Weather> getWeather(){
		return weather;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCod(int cod){
		this.cod = cod;
	}

	public int getCod(){
		return cod;
	}

	public void setMain(Main main){
		this.main = main;
	}

	public Main getMain(){
		return main;
	}

	public void setClouds(Clouds clouds){
		this.clouds = clouds;
	}

	public Clouds getClouds(){
		return clouds;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setSys(Sys sys){
		this.sys = sys;
	}

	public Sys getSys(){
		return sys;
	}

	public void setBase(String base){
		this.base = base;
	}

	public String getBase(){
		return base;
	}

	public void setWind(Wind wind){
		this.wind = wind;
	}

	public Wind getWind(){
		return wind;
	}

	@Override
 	public String toString(){
		return 
			"WeatherResponse{" + 
			"dt = '" + dt + '\'' + 
			",coord = '" + coord + '\'' + 
			",visibility = '" + visibility + '\'' + 
			",weather = '" + weather + '\'' + 
			",name = '" + name + '\'' + 
			",cod = '" + cod + '\'' + 
			",main = '" + main + '\'' + 
			",clouds = '" + clouds + '\'' + 
			",id = '" + id + '\'' + 
			",sys = '" + sys + '\'' + 
			",base = '" + base + '\'' + 
			",wind = '" + wind + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(dt);
		dest.writeParcelable(coord, flags);
		dest.writeInt(visibility);
		dest.writeTypedList(weather);
		dest.writeString(name);
		dest.writeInt(cod);
		dest.writeParcelable(main, flags);
		dest.writeParcelable(clouds, flags);
		dest.writeInt(id);
		dest.writeParcelable(sys, flags);
		dest.writeString(base);
		dest.writeParcelable(wind, flags);
	}
}