import dao.BookingDao;
import dao.BookingDaoImpl;
import dao.ProductDao;
import dao.ProductDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import model.Booking;
import model.Product;
import model.User;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoImpl();
        Product product = new Product();
        product.setName("iPhone X");
        product.setPrice(BigInteger.valueOf(1252));
        productDao.save(product);
        Optional<Product> productFromDb = productDao.get(1L);

        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setLogin("Andrey@");
        user.setPassword("123");
        userDao.save(user);
        Optional<User> userFromDb = userDao.get(1L);

        Booking booking = new Booking();
        booking.setLocalDateTime(LocalDateTime.now());
        booking.setOwner(userFromDb.get());
        booking.setProducts(List.of(productFromDb.get()));
        BookingDao bookingDao = new BookingDaoImpl();
        bookingDao.add(booking);

        System.out.println(bookingDao.get(1L));
    }
}
