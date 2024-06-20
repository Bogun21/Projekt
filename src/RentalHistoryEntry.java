import java.time.LocalDate;

public class RentalHistoryEntry {
    private int movieId;
    private int userId;
    private LocalDate rentalDate;
    private LocalDate returnDate;

    public RentalHistoryEntry(int movieId, int userId, LocalDate rentalDate, LocalDate returnDate) {
        this.movieId = movieId;
        this.userId = userId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public int getMovieId() {
        return movieId;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
