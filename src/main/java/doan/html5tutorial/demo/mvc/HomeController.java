package doan.html5tutorial.demo.mvc;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import doan.html5tutorial.demo.domain.Book;

@Controller
public class HomeController
{

	private List<Book> books;

	public HomeController() {
		super();

		Book jee6 = new Book(
				"9781430219545",
				"Beginning Java EE 6 Platform with GlassFish 3",
				"Sun's enterprise Java™ platform, Java EE (Enterprise Edition), is getting a facelift! Beginning Java EE 6 Platform with GlassFish 3 is one of the first tutorial books on the forthcoming Java EE 6 Platform. Step–by–step and easy to follow, this book describes many of the Java EE 6 specifications and reference implementations and shows them in action using practical examples. This book uses the new version of GlassFish™ 3 to deploy and administer the code examples. Written by an expert member of the Java EE 6 specification request and review board in the Java Community Process (JCP), this book contains the best information possible, from an expert's perspective in enterprise Java technologies and platform. What you’ll learn Get started with the new Java EE 6 Platform from Sun. Explore and use the new EJB 3.1 and JPA 2.0 APIs from entities to session beans to message–driven beans, and more. Discover the new web–tier development APIs including JSPs, JSTL, and Expression Language, and especially the new JSF 2.0 and Facelets. Uncover the new web services, RESTful services, and more available in Java EE 6. Create dynamic user interfaces for your enterprise and transactional Java applications. And more... Who is this book for? This book is suitable for advanced Java programmers as well as Java EE 6 beginners. Architects will also find information about how to layer their Java EE applications. About the Apress Beginning Series The Beginning series from Apress is the right choice to get the information you need to land that crucial entry–level job. These books will teach you a standard and important technology from the ground up because they are explicitly designed to take you from “novice to professional.” You’ll start your journey by seeing what you need to know—but without needless theory and filler. You’ll build your skill set by learning how to put together real–world projects step by step. So whether your goal is your next career challenge or a new learning opportunity, the Beginning series from Apress will take you there—it is your trusted guide through unfamiliar territory!",
				"PROGRAMMING", new String[]
				{
					"Antonio GONCALVES"
				}, "Manning Publications", 2, true);

		Book spring = new Book(
				"9781933988139",
				"Spring in Action",
				"Spring in Action 2E is an expanded, completely updated second edition of the best selling Spring in Action. Written by Craig Walls, one of Manning's best writers, this book covers the exciting new features of Spring 2.0, which was released in October 2006. Spring is a lightweight container framework that represents an exciting way to build enterprise components with simple Java objects. By employing dependency injection and AOP, Spring encourages loosely coupled code and enables plain-old Java objects with capabilities that were previously reserved for EJBs. This book is a hands-on, example-driven exploration of the Spring Framework. Combining short code snippets and an ongoing example developed throughout the book, it shows readers how to build simple and efficient J2EE applications, how to solve persistence problems, handle asynchronous messaging, create and consume remote services, build web applications, and integrate with most popular web frameworks. Readers will learn how to use Spring to write simpler, easier to maintain code so they can focus on what really matters-- critical business needs. Spring in Action, 2E is for Java developers who are looking for ways to build enterprise-grade applications based on simple Java objects, without resorting to more complex and invasive EJBs. Even hard-core EJB users will find this book valuable as Spring in Action, 2E will describe ways to use EJB components alongside Spring. Software architects will also find Spring in Action, 2E useful as they assess and apply lightweight techniques prescribed by Spring. and learn how Spring can be applied at the various layers of enterprise applications.",
				"PROGRAMMING", new String[]
				{
						"Craig WALLS",
						"Ryan BREIDENBACH"
				}, "Manning Publications", 3, false);

		Book marvel = new Book(
				"9780756655303",
				"Marvel Encyclopedia",
				"Celebrate 70 years of Marvel Comics with The Marvel Encyclopedia! Fully updated with new images and text, this one-volume encyclopedia contains more than 1,000 of Marvel's greatest-from well-known characters such as Spider-Man, the Hulk and Wolverine to lesser known heroes and villains. An essential book both for new fans and for those who grew up loving the comics, The Marvel Encyclopedia is full of artwork, stats, and history for every character in the Marvel Universe. Updates on characters include information from the story arcs of Civil War and Annihilation, and brings fans up to date with the aftermath of Secret Invasion. TM & © 2009 Marvel Entertainment, Inc. and its subsidiaries. Licensed by Marvel Characters B.V. All rights reserved.",
				"COMICS", new String[]
				{
						"Peter SANDERSON",
						"Tom BREVOORT",
						"Michael TEITELBAUM",
						"Daniel WALLACE",
						"Andrew DARLING",
						"Matt FORBECK"
				}, "DK Publishing", 1, true);

		Book harryPotter = new Book(
				"9780545139700",
				"Harry Potter and Deathly Hallows",
				"Readers beware. The brilliant, breathtaking conclusion to J.K. Rowling's spellbinding series is not for the faint of heart--such revelations, battles, and betrayals await in Harry Potter and the Deathly Hallows that no fan will make it to the end unscathed. Luckily, Rowling has prepped loyal readers for the end of her series by doling out increasingly dark and dangerous tales of magic and mystery, shot through with lessons about honor and contempt, love and loss, and right and wrong. Fear not, you will find no spoilers in our review--to tell the plot would ruin the journey, and Harry Potter and the Deathly Hallows is an odyssey the likes of which Rowling's fans have not yet seen, and are not likely to forget. But we would be remiss if we did not offer one small suggestion before you embark on your final adventure with Harry--bring plenty of tissues.",
				"FANTASY", new String[]
				{
					"Joanne Kathleen ROWLING"
				}, "Scholastic Paperbacks", 5, true);

		Book foundationAndEarth = new Book(
				"9780553587579",
				"Foundation and Earth",
				"The fifth novel in Asimov's popular Foundation series opens with second thoughts. Councilman Golan Trevize is wondering if he was right to choose a collective mind as the best possible future for humanity over the anarchy of contentious individuals, nations and planets. To test his conclusion, he decides he must know the past and goes in search of legendary Earth, all references to which have been erased from galactic libraries. The societies encountered along the way become arguing points in a book-long colloquy about man's fate, conducted by Trevize and traveling companion Bliss, who is part of the first world/mind, Gaia.",
				"SCIENCE-FICTION", new String[]
				{
					"Isaac ASIMOV"
				}, "Spectra", 2, true);

		this.books = Arrays.asList(jee6, spring, marvel, harryPotter, foundationAndEarth);
	}

	@RequestMapping(value =
	{
			"/",
			"/home"
	}, method = RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("books", this.books);
		return "home";

	}

	@RequestMapping(value = "book/find/{isbn}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Book finbBookByIsbn(@PathVariable(value = "isbn") String isbn)
	{
		for (Book book : this.books)
		{
			if (book.getIsbn().equals(isbn))
			{
				return book;
			}
		}
		return null;
	}
}
