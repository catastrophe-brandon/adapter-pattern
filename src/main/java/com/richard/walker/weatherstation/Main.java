package weatherstation;

import com.richard.walker.weatherstation.domain.WeatherStation;
import com.richard.walker.weatherstation.vendor.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        StandardRegionalWeather regionalWeather = new StandardRegionalWeatherImpl();
        NoaaRegionalWeather noaaRegionalWeather = new NoaaRegionalWeatherImpl();

        StandardRegionalWeather regionalWeatherAdapter = new StandardRegionalWeatherAdapter(noaaRegionalWeather);

        printWeatherStationData(regionalWeather.getWeatherStations());
        printWeatherStationData(regionalWeatherAdapter.getWeatherStations());
    }

    private static void printWeatherStationData(List<WeatherStation> weatherStations) {
        System.out.printf("%20s | %6s | %7s | %8s\n", "City", "Temp", "Wind", "Humidity");
        for (WeatherStation station: weatherStations) {

            System.out.println("     ---------------------------------------------");
            System.out.println(station);
        }
        System.out.println("     ---------------------------------------------");
    }
}