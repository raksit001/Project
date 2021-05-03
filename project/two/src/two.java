import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class two {

    public static void main(String[] args) throws IOException, JSONException {
        String url = "https://covid19.th-stat.com/api/open/cases/sum";
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
        System.out.println("\nรายงาน COVID-19 ข้อมูลสรุปจากเคส "+ myResponse.getString("UpdateDate"));
        System.out.println("ผู้ชาย " + myResponse.getJSONObject("Gender").getInt("Female"));
        System.out.println("ผู้หญิง " + myResponse.getJSONObject("Gender").getInt("Male"));
        System.out.println("ไม่ทราบ " + myResponse.getJSONObject("Gender").getInt("Unknown"));
        System.out.println("============================================\n");
    }

}