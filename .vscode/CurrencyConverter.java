import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.util.Scanner;
public class CurrencyConverter{
    //create a function to get the exchange rates.
    private static double getExchangeRates(String baseCurrency, String targetCurrency)throws Exception{
        String apiKey = "b7972e036383d536b74f53069e2573ba";
        String urlString = String.format("http://data.fixer.io/api/latest?access_key=%s&symbols=%s,%s",  apiKey, baseCurrency, targetCurrency);
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        conn.disconnect();

        JSONObject json = new JSONObject(content.toString());
        if (json.getBoolean("success")) {
            JSONObject rates = json.getJSONObject("rates");
            // Exchange rate is the ratio of the target currency to the base currency
            return rates.getDouble(targetCurrency) / rates.getDouble(baseCurrency);
        } else {
            throw new Exception("API request failed.");
        }
    }

    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            // Get base currency (e.g., USD)
            System.out.print("Enter base currency (e.g., USD): ");
            String baseCurrency = scanner.nextLine().toUpperCase();
            
            // Get target currency (e.g., EUR)
            System.out.print("Enter target currency (e.g., EUR): ");
            String targetCurrency = scanner.nextLine().toUpperCase();
            
            // Get amount to convert
            System.out.print("Enter the amount in " + baseCurrency + ": ");
            double amount = scanner.nextDouble();

            double exchangeRate = getExchangeRates(baseCurrency, targetCurrency);

            double convertedAmount = amount * exchangeRate;

            // Step 7: Display the result
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}