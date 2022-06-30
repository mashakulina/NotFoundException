package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    Book book1 = new Book(1, "Harry Potter", "J.K. Rowling", 800);
    Smartphone smartphone1 = new Smartphone(2, "Iphone 13", "Apple", 150_000);
    Book book2 = new Book(3, "A Game of Thrones", "George R.R.Martin", 1500);
    Smartphone smartphone2 = new Smartphone(4, "Redmi Note 11S", "Xiaomi", 8000);
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    @Test
    public void addProducts() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, smartphone1, book2, smartphone2};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFind2Elements() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("te");
        Product[] expected = {book1, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNonElements() {
        Product[] actual = manager.searchBy("te");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneElements() {
        manager.add(book1);

        Product[] actual = manager.searchBy("te");
        Product[] expected = {book1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindElement() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Ha");
        Product[] expected = {book1};

        assertArrayEquals(expected, actual);
    }

}
