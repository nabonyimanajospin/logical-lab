package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "book_copies")
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "copy_id")
    private Long copyId;

    @ManyToOne
    @JoinColumn(name = "book_code", unique = true) 
    private Book book;

    @Column(name = "available")
    private boolean available = true;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;



    public Long getCopyId() {
        return copyId;
    }

    public void setCopyId(Long copyId) {
        this.copyId = copyId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

}
