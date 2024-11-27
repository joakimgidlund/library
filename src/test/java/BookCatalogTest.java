import se.yrgo.library.models.Book;
import se.yrgo.library.models.BookCatalog;
import se.yrgo.library.models.BookNotFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookCatalogTest {

	private BookCatalog bc;
	private Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		book1 = new Book(1,"Learning Java","","","",0);
		bc.addBook(book1);
	}

	//G
	@Test
	public void testAddABook() {
		Book testBook = new Book(
				2,
				"Lord of the Rings",
				"J.R.R Tolkien",
				"978-0544003415",
				"",
				1216);
		BookCatalog testCatalog = new BookCatalog();
		testCatalog.addBook(testBook);
		Book[] testArray = testCatalog.getBookArray();

		assertNotNull(testArray[0]);
		assertEquals(testBook, testArray[0]);
	}

	//G
	@Test
	public void testFindBook() throws BookNotFoundException {
		assertEquals(book1, bc.findBook(book1.getTitle()));
	}

	//G
	@Test
	public void testFindBookIgnoringCase() throws BookNotFoundException {
		assertEquals(book1, bc.findBook("LEarnInG JaVA"));
	}

	//G
	@Test
	public void testFindBookWithExtraSpaces() throws BookNotFoundException {
		assertEquals(book1, bc.findBook("    Learning Java     "));
	}

	//VG
	// This test should throw BookNotFoundException in order to pass.
	@Test
	public void testFindBookThatDoesntExist() throws BookNotFoundException {
		assertThrows(BookNotFoundException.class, () ->
					bc.findBook("Test exception"));
	}

}
