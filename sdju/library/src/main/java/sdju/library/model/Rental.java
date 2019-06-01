package sdju.library.model;

import java.time.LocalDate;

public class Rental {

    private int rentalId;
    private int customerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private RentalPaymentStatus paymentStatus;
    private int bookId;
    private double penalty;


    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public Rental(){
        this.paymentStatus = RentalPaymentStatus.no_charge;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public RentalPaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(RentalPaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", customerId=" + customerId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", paymentStatus=" + paymentStatus +
                ", bookId=" + bookId +
                '}';
    }
}
