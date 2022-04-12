import java.util.Objects;

public class DayInfo {
    private String minTemp;
    private String maxTemp;
    private String date;
    private String weather;
    private String city;


    public DayInfo(String minTemp, String maxTemp, String date, String weather, String city) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.date = date;
        this.weather = weather;
        this.city = city;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "DayInfo{" +
                "minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                ", date=" + date +
                ", weather=" + weather +
                ", city=" + city +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayInfo dayInfo = (DayInfo) o;
        return Objects.equals(minTemp, dayInfo.minTemp) && Objects.equals(maxTemp, dayInfo.maxTemp) && Objects.equals(date, dayInfo.date) && Objects.equals(weather, dayInfo.weather) && Objects.equals(city, dayInfo.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minTemp, maxTemp, date, weather, city);
    }
}
