package OOP.SchoolSystem.Entities;


public class Book {
    private String name;
    private String author;
    private Integer id;
    private String yearOfPublishing;
    private Boolean isAvailable;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", id=" + id +
                ", yearOfPublishing='" + yearOfPublishing + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isBlank() && !name.isEmpty()){
            this.name = name;}
        else System.out.println("entered name is empty or blank");
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(String yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
