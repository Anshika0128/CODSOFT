import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Welcome to the Currency Converter!");
            System.out.print("Please enter the base currency code: ");
            String baseCurrency = reader.readLine();

            System.out.print("Please enter the target currency code: ");
            String targetCurrency = reader.readLine();

            System.out.print("Enter the amount you want to convert: ");
            double amount = Double.parseDouble(reader.readLine());

            double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
            double convertedAmount = amount * exchangeRate;

            System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
            System.out.println("Thank you for using the Currency Converter. Have a great day!");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static double getExchangeRate(String baseCurrency, String targetCurrency) throws IOException {
        String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
        }

        String jsonResponse = response.toString();
        int startIdx = jsonResponse.indexOf(targetCurrency) + targetCurrency.length() + 4;
        int endIdx = jsonResponse.indexOf(",", startIdx);
        String rateStr = jsonResponse.substring(startIdx, endIdx);

        return Double.parseDouble(rateStr);
    }
}
