import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class RequestSender {

        private static OkHttpClient okHttpClient = new OkHttpClient();
        private static ObjectMapper objectMapper = new ObjectMapper();

        private static final String API_KEY = "U2supnJ6luhCWZ7mG2N1stgz14eEguXH;

        public static DayInfo getInfo(String cityId) throws IOException {

                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme("http")
                        .host("dataservice.accuweather.com")
                        .addPathSegment("forecasts")
                        .addPathSegment("v1")
                        .addPathSegment("daily")
                        .addPathSegment("5day")
                        .addPathSegment(cityId)
                        .addQueryParameter("apikey", API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response response = okHttpClient.newCall(request).execute();

                String json = response.body().string();

                String maxTemp = null;
                String minTemp = null;
                String date = null;
                String weather = null;
                String city = null;
                try {
                         for (int i = 0; i < 5; i++) {
                                 date = objectMapper.readTree(json)
                                         .at("/DailyForecasts")
                                         .get(i)
                                         .at("/Date")
                                         .asText();


                                 maxTemp = objectMapper.readTree(json)
                                         .at("/DailyForecasts")
                                         .get(i)
                                         .at("/Temperature/Maximum/Value")
                                         .asText();

                                 minTemp = objectMapper.readTree(json)
                                         .at("/DailyForecasts")
                                         .get(i)
                                         .at("/Temperature/Minimum/Value")
                                         .asText();


                                 weather = objectMapper.readTree(json)
                                         .at("/DailyForecasts")
                                         .get(i)
                                         .at("/Day/IconPhrase")
                                         .asText();

                                 System.out.println(" Дата " + date );
                                 System.out.println(" Погода " + weather);
                                 System.out.println(" Максимильная температура " + maxTemp + "F" );
                                 System.out.println(" Минимальная температура " + minTemp + "F");
                                 System.out.println("-------------------------------------------");
                         }

                } catch (NullPointerException e) {
                        System.out.println("Cant get a weather");
                        e.printStackTrace();
                }


                        return new DayInfo (date, weather, maxTemp, minTemp, city);
        }


                public static String getCityId (String cityInText) throws IOException {

                        HttpUrl httpUrl = new HttpUrl.Builder()
                                .scheme("http")
                                .host("dataservice.accuweather.com")
                                .addPathSegment("locations")
                                .addPathSegment("v1")
                                .addPathSegment("cities")
                                .addPathSegment("search")
                                .addQueryParameter("apikey", API_KEY)
                                .addQueryParameter("q", cityInText)
                                .build();

                        Request request = new Request.Builder()
                                .url(httpUrl)
                                .build();

                        Response response = okHttpClient.newCall(request).execute();

                        String cityId = null;
                        try {
                                cityId = objectMapper.readTree(response.body().string())
                                        .get(0)
                                        .at("/Key")
                                        .asText();

                        } catch (NullPointerException e) {
                                System.out.println("Cant get a weather");
                                e.printStackTrace();
                        }
                        return cityId;

                }
        }
