import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class API {

    public static void main(String[] args) throws IOException, JSONException {
        String url = "https://covid19.th-stat.com/api/open/today";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent","");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("\nรายงานแสดงจำนวนผู้ป่วย COVID-19 ประจำวันที่ "+ myResponse.getString("UpdateDate"));
        System.out.println("ยอดผู้ป่วยสะสม " + myResponse.getInt("Confirmed") + " คน");
        System.out.println("ที่รักษาหายแล้วทั้งหมด " + myResponse.getInt("Recovered") + " คน");
        System.out.println("อยู่ในระหว่างการรักษา " + myResponse.getInt("Hospitalized")+ " คน");
        System.out.println("ตายสะสม " + myResponse.getInt("Deaths")+ " คน");
        System.out.println("ผู้ป่วยรายใหม่ " + myResponse.getInt("NewConfirmed")+ " คน");
        System.out.println("รักษาหายเพิ่ม " + myResponse.getInt("NewRecovered")+ " คน");
        System.out.println("อยู่ในระหว่างการรักษาเพิ่ม " + myResponse.getInt("NewHospitalized")+ " คน");
        System.out.println("ตายเพิ่ม " + myResponse.getInt("NewDeaths")+ " คน");
        System.out.println("============================================\n");
    }

}