!function ( $ )
{
	bindListeners('#booksTable');
	
	bindListeners('#bookDetails');
	
}(window.jQuery);

function bindListeners(selector)
{
	$(selector).find('[data-authors]').each(function(index, element)
	{
		var authors = $(element).attr('data-authors');
		createToolTip($(element),authors);
		
	});
	
	$(selector).find('[data-isbn]').click(function(e)
	{
		var isbn = $(e.currentTarget).attr('data-isbn');
		displayDetails(isbn);
		
	});
}

function createToolTip($element, message)
{
	$element.tooltip(
	{
			title: message
	});
}

function displayDetails(isbn)
{
	$.ajax({
		type: 'GET',
		url: 'book/find/'+isbn,
		dataType: 'json',
		success: function(book) {
			
			$('#bookDetails')
			.find('.bookIsbn').html(book.isbn).end()
			.find('.bookTitle').html(book.title).end()
			.find('.bookDescription').html(book.description).end()
			.find('.bookAuthors').html(book.authors.toString()).end()
			.find('.bookCategory').html(book.category).end()
			.find('.bookEditor').html(book.editor).end()
			.find('.bookQuantity').html(book.quantity).end()
			.modal('show');
			
			if(book.status)
			{
				$('.bookStatusOk').show();
				$('.bookStatusKo').hide();
			}
			else
			{
				$('.bookStatusKo').show();
				$('.bookStatusOk').hide();				
			}
		}
	});
}