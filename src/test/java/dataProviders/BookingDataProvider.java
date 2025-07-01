package dataProviders;

import java.time.format.DateTimeFormatter;
import org.testng.annotations.DataProvider;
import java.time.LocalDate;

public class BookingDataProvider {

    @DataProvider(name = "bookingPayload")
    public Object[][] getBookingPayload() {

        LocalDate today = LocalDate.now();
        LocalDate twoDaysLater = today.plusDays(2);
        String firstname = today.format(DateTimeFormatter.ofPattern("MMMMdd"));
        String checkin = today.toString();           // e.g., "2025-06-28"
        String checkout = twoDaysLater.toString();   // e.g., "2025-06-30"

        String requestBody1 = "{\n" +
                "  \"firstname\": \"" + "John" + firstname + "\",\n" +
                "  \"lastname\": \"Adam\",\n" +
                "  \"totalprice\": 699,\n" +
                "  \"depositpaid\": false,\n" +
                "  \"bookingdates\": {\n" +
                "    \"checkin\": \"" + checkin + "\",\n" +  // <-- comma here
                "    \"checkout\": \"" + checkout + "\"\n" +
                "  },\n" +
                "  \"additionalneeds\": \"Swimming Pool\"\n" +
                "}";

        String requestBody2 = "{\n" +
                "  \"firstname\": \"" + "Will" + firstname + "\",\n" +
                "  \"lastname\": \"Smith\",\n" +
                "  \"totalprice\": 789,\n" +
                "  \"depositpaid\": false,\n" +
                "  \"bookingdates\": {\n" +
                "    \"checkin\": \"" + checkin + "\",\n" +  // <-- comma here
                "    \"checkout\": \"" + checkout + "\"\n" +
                "  },\n" +
                "  \"additionalneeds\": \"Gym and Saloon \"\n" +
                "}";

        return new Object[][]{
                {requestBody1},
                {requestBody2}
        };
    }
}

