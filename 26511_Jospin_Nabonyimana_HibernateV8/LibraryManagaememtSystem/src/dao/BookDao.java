package dao;

import model.Book;
import model.BookCopy;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query; 
import java.util.List;

public class BookDao {

    private static final String PREFIX = "B";
    private static final int START = 10000;

    private synchronized String generateNextBookCode(Session session) {
        String hql = "SELECT b.bookCode FROM Book b WHERE b.bookCode LIKE :pref ORDER BY b.bookCode DESC";
        Query query = session.createQuery(hql);
        query.setParameter("pref", PREFIX + "%");
        query.setMaxResults(1);

        List<String> results = query.list();
        String last = results.isEmpty() ? null : results.get(0);

        int next = START;
        if (last != null && last.startsWith(PREFIX)){
            next = Integer.parseInt(last.substring(PREFIX.length())) + 1;
        }
        return PREFIX + next;
    }

  
  public Book createBook(Book book, int numberOfCopies){
    Transaction tx = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
        tx = session.beginTransaction();

        book.setBookCode(generateNextBookCode(session));
        session.save(book);

       
        for (int i =0; i< numberOfCopies; i++){
            BookCopy copy = new BookCopy();
            copy.setBook(book);
            copy.setAvailable(true);
            session.save(copy);
        }

        tx.commit();
        return book;

    } catch (Exception e){
        if (tx != null) tx.rollback();
        e.printStackTrace();
        return null;
    } finally {
        session.close();
    }
}

}
