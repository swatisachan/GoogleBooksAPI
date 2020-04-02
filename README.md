# GoogleBooksAPI
This is an API Automation for Google Book API which consumes all the API's provided by Google Book API.
API Documenation: https://developers.google.com/books/docs/v1/using

Steps to follow:
1. Create your own API Key from Google developer console and Consume the same while calling Google Book API.
ApiKey provides the Basic Authentication.
Google Developer Console to generate the ApiKey/OAuth Token: https://console.developers.google.com/

2.These API's provides you the flexiblity to get book information, bookShelves, Private BookShelves etc.
For all the GET API, no authentication is needed.
API Related to BookShelves needs to have UID which is user specifc ID, follow below steps to obtain the saame:

Steps followed:
1. Login with your Google Cred.
2. Naviagte to the Url: https://books.google.co.in/books
3. Search your fav book.
4. In left hand side navigation bar, click on my library.
5. Select any bookShelf and verify the application Url, obtain the UID.
