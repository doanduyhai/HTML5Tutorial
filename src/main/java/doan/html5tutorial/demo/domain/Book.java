package doan.html5tutorial.demo.domain;

public class Book
{

	private String isbn;

	private String title;

	private String description;

	private String category;

	private String[] authors;

	private String editor;

	private int quantity;

	private boolean status;

	public Book(String isbn, String title, String description, String category, String[] authors, String editor, int quantity, boolean status) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.category = category;
		this.authors = authors;
		this.editor = editor;
		this.quantity = quantity;
		this.status = status;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String[] getAuthors()
	{
		return authors;
	}

	public void setAuthors(String[] authors)
	{
		this.authors = authors;
	}

	public String getEditor()
	{
		return editor;
	}

	public void setEditor(String editor)
	{
		this.editor = editor;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public boolean getStatus()
	{
		return status;
	}

	public void setStatus(boolean status)
	{
		this.status = status;
	}

}
