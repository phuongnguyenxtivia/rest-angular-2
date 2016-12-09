/**
 * 
 */
package io.swagger.model;

/**
 * @author pnguyen
 *
 */
public class Book {
	private long   isbn = -1;
	private String title;
	private String author;
	private String summary;
	
	/**
	 * @return the isbn
	 */
	public long getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @param isbn
	 * @param title
	 * @param author
	 * @param summary
	 */
	public Book(long isbn, String title, String author, String summary) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.summary = summary;
	}
	
	/**
	 * 
	 */
	public Book() {
		super();
	}

}
