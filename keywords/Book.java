/*
Create a Book class to manage library books with the following features:
Static:
A static variable libraryName shared across all books.
A static method displayLibraryName() to print the library name.
This:
Use this to initialize title, author, and isbn in the constructor.
Final:
Use a final variable isbn to ensure the unique identifier of a book cannot be changed.
Instanceof:
Verify if an object is an instance of the Book class before displaying its details.
 */
package keywords;

class Book{
    //Static variable
    static String libraryName="National Library";

    //Instance variables
    private String title;
    private String author;
    private final int isbn;
    
    //Constructor using this keyword
    Book(String title,String author,int isbn){
        this.title=title;
        this.author=author;
        this.isbn=isbn;
    }
    static void displayLibraryName(){
        System.out.println("Welcome to "+libraryName);
    }

    //Static method to show book details
    public static void showDetails(Object obj){
        if(obj instanceof Book){
            Book bk1=(Book) obj;
            System.out.println("Title of Book: "+bk1.title);
            System.out.println("Author of Book: "+bk1.author);
            System.out.println("Title of Book: "+bk1.isbn);
        }else{
            System.out.println("It is not Book Object");
        }
    }
    public static void main(String[] args){
        Book bk1=new Book("thief","Parel",289);
        
        bk1.displayLibraryName();
        showDetails(bk1);
    }
}