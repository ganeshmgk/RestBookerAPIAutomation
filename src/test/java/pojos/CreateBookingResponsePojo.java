package pojos;



public class CreateBookingResponsePojo {
    private int bookingid;
    private String additionalneeds;
    private BookingPojo bookingPojo;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public BookingPojo getBooking() {
        return bookingPojo;
    }

    public void setBooking(BookingPojo bookingPojo) {
        this.bookingPojo = bookingPojo;
    }

}

