import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.ZoneId;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FTFSearch {
	public ArrayList<FoodTruck> FindTrucks() {
   		try {
   			//var declaration
			ArrayList<FoodTruck> trucks = new ArrayList<FoodTruck>();
			String line;
			int index;

			//prepare time vars (always assume PST)
			LocalTime currentTime = LocalTime.now(ZoneId.of("America/Los_Angeles"));
			Calendar c = Calendar.getInstance(TimeZone.getTimeZone("PST"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE");
			String day = dateFormat.format(c.getTime());

			//connect and start loop
			URL url = new URL("https://data.sfgov.org/resource/bbb8-hzi6.json");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				//check if open. compare day
				index = line.indexOf("\"dayofweekstr\"");
				if (index == -1) continue;
				if (!day.equals(line.substring(index + 16, line.indexOf("\",", index + 16)))) continue;

				//compare closing
				index = line.indexOf("\"end24\"");
				if (index == -1) continue;
				if ("24:00".equals(line.substring(index + 9, line.indexOf("\",", index + 9)))) {} //base case for midnight
				else if (currentTime.isAfter(LocalTime.parse(line.substring(index + 9, line.indexOf("\",", index + 9)), DateTimeFormatter.ofPattern("HH:mm")))) continue;

				//compare opening
				index = line.indexOf("\"start24\"");
				if (index == -1) continue;
				if (currentTime.isBefore(LocalTime.parse(line.substring(index + 11, line.indexOf("\",", index + 11)), DateTimeFormatter.ofPattern("HH:mm")))) continue;

				//confirmed open, now add the truck to results list
				index = line.indexOf("\"applicant\"");
				if (index == -1) continue;
				String name = line.substring(index + 13, line.indexOf("\",", index + 13));
				index = line.indexOf("\"location\"");
				if (index == -1) continue;
				String address = line.substring(index + 12, line.indexOf("\",", index + 12));
				trucks.add(new FoodTruck(name, address));
			}
			rd.close();
			Collections.sort(trucks, FoodTruck.FoodTruckComparator);
			return trucks;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
   		return null;
	}
}
