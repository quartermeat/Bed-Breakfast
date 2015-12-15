Written for school.

This is a netbeans project that only needs to cloned from this repository.

https://github.com/JDatePicker/JDatePicker.git
Files were included in this in order to use the date picker.  I would rather have these just a jar library file, however I haven't figured out how to make his project a library yet.

Also, the oracle jdbc driver needs to be added to the project in order to get it to get oracle database connections.
The connection information can be found in the database manager class.  This can be moved or done differently of course to increase security.

I will also try to upload the sql files used to create the required tables for this project.

Bed and Breakfast Reservations
An application by Jeremy Williamson
CMIS 460 7980 Software Design and Development

Introduction
This application was made in Java using Netbeans.  In my last class, I developed a game with Java Swing and kept the MVC model despite having swing controllers that handle their own events.  Keeping with my same MVC design of a Java Swing application, I decided to make this applicaton in the same way.  The only difference being, that I now had to connect to an Oracle database.  
Design
CONTROLLER
The controller has 2 classes.  One of the classes is a Main class that executes the main Java method.  It is here also where your window class is initialized and the event handler that’s used for that window is used to handle any events on the window.  Even though the implemented event handler is technically within the view, the class itself is defined in the controller package.  It holds the methods necessary to use for any event that may happen to the view or window class.
MODEL
The model of my design consists of a reservation class and a customer class that mirror the reservation and customer tables that are stored in the database.  I have provided sql files to create both my reservation and customer tables.
Speaking of database tables, also in my model is my database manager class.  This class is used to create a connection to an Oracle database.  The connection requirements can be changed here in order to connect to another database, or you could even allow the user to input their own database information through a UI.  
The model also includes the reservation list and the customer list.  In my experience it has always been easier for me to work with Java than SQL, so I just import tables I need to work with into array lists.  That way I can sort or search that list using Java objects.  The nodes of these lists are objects made from the reservation or customer class.
VIEW
My view here is one main window.  Because I still like to use the designer for swing components in Netbeans, but prefer a MVC framework, this class gets big and clucky pretty fast.  Despite being big, the cohesion in the methods is pretty good.

Shortcomings
I have to admit, I didn’t give myself enough time to work on my application and left some serious error checking out.  Most of any errors that have taken place are mostly caught in the system output or stack traces.  And even though the room number is an attribute in the model and the database, the logic as of now does not account for room numbers.  It would need more work, but it would not be hard to add that functionality into the application considering I already keep track of that data. One other thing about this applications that the view is still one window.  I had meant to split it up maybe more into say separate panels.  I could still do this in the future if I spend more time on this application, however the window class really got away from me before I realized it needed to be broken up more.

http://imgur.com/Qkr9vD3
