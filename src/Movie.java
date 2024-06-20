import java.time.LocalDate;

public class Movie extends Document {
    private int userId;
    private LocalDate rentalDate;
    private LocalDate returnDate;

    private Movie(MovieBuilder builder) {
        super(builder.title, builder.year, builder.category, builder.quantity);
        this.userId = builder.userId;
        this.rentalDate = builder.rentalDate;
        this.returnDate = builder.returnDate;
    }


    @Override
    public String toString() {
        return "Film{" +
                "id=" + getId() +
                ", tytuł='" + getTitle() + '\'' +
                ", rok produkcji=" + getYear() +
                ", kategoria='" + getCategory() + '\'' +
                ", ilość=" + getQuantity() +
                '}';
    }

    public static class MovieBuilder {
        private String title;
        private int year;
        private String category;
        private int quantity;
        private int userId;
        private LocalDate rentalDate;
        private LocalDate returnDate;

        public MovieBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public MovieBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public MovieBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        public MovieBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
