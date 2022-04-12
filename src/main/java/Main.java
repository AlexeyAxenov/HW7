import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String cityName = scanner.nextLine();

        String cityId = RequestSender.getCityId(cityName);
        //System.out.println(cityId);
        System.out.println(RequestSender.getInfo(cityId));
        System.out.println(cityName);
    }
}
