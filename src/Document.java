public abstract class Document {
    private static int counter = 0;

    private final int id;
    private final String title;
    private final int year;
    private final String category;
    private final int quantity;

    protected Document(String title, int year, String category, int quantity) {
        this.id = ++counter;
        this.title = title;
        this.year = year;
        this.category = category;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", tytuł='" + title + '\'' +
                ", rok=" + year +
                ", kategoria='" + category + '\'' +
                ", ilość=" + quantity +
                '}';
    }
}
