package OOP.CinemaSystem.Entities;

public class Seat extends Base{

    private String type;
    private Short seatNumber;
    private Short price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Short getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Short seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Short getPrice() {
        return price;
    }

    public void setPrice(Short price) {
        this.price = price;
    }
}
