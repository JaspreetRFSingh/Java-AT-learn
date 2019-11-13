# Design Patterns

### Creational
* __Singleton Pattern__ – This design pattern is used when we require a single instant of a class such that, that single instance can be used by other classes as well.
Singletons are used for centralized management. It is implemented by making the constructor private and creating the only instance of the class within the class itself.
* __Factory Pattern__ – A factory pattern lets you instantiate an abstract classes/interfaces by using subclasses. The Factory Method Pattern is also known as _Virtual Constructor_.
It helps in achieving _loose-coupling_ by eliminating the need of implementing application-specific classes. Factory design pattern is used when a class doesn't know what sub-classes will be required or when a class wants that its sub-classes specify the objects to be created.
* __Abstract Factory__ - Abstract Factory Pattern says that just define an interface or abstract class for creating families of related (or dependent) objects but without specifying their concrete sub-classes. 
An Abstract Factory Pattern is also known as _Kit_. Abstract Factory Pattern isolates the client code from concrete (implementation) classes.
* __Builder Pattern__ - Builder Pattern allows us to construct a complex object from simple objects using step-by-step approach. Most familiar example of a builder design pattern is the _StringBuilder_ class in Java.
It provides clear separation between the construction and representation of an object. It provides better control over construction process.

### Behavioural
* __Strategy Pattern__ - A Strategy Pattern allows us to define a family of functionality, encapsulate each one, and make them interchangeable.
The Strategy Pattern is also known as _Policy_. It defines each behavior within its own class, eliminating the need for conditional statements.
It makes it easier to extend and incorporate new behavior without changing the application. It is used when you need different variations of an algorithm.
* __Command Pattern__ - A Command Pattern says that "encapsulate a request under an object as a command and pass it to invoker object. Invoker object looks for the appropriate object which can handle this command and pass the command to the corresponding object and that object executes the command".
It is also known as Action or Transaction. It is used when you need to parameterize objects according to an action perform or when you need to create and execute requests at different times.
* __Chain of Responsibility__ - Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers.
Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.
For example, an ATM uses the Chain of Responsibility design pattern in money giving process.
In other words, we can say that normally each receiver contains reference of another receiver. If one object cannot handle the request then it passes the same to the next receiver and so on. 
* __Observer__ - Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.
It describes the coupling between the objects and the observer.
It provides the support for broadcast-type communication. </br>
It is used when the change of a state in one object must be reflected in another object without keeping the objects tightly-coupled or when the framework we writes and needs to be enhanced in future with new observers with minimal chamges.

### Structural
* __Adapter__ - Adapter also known as _Wrapper_ is a structural design pattern that allows objects with incompatible interfaces to collaborate.
In other words, to provide the interface according to client requirement while using the services of a class with a different interface. </br>
It allows two or more previously incompatible objects to interact. It also allows reusability of existing functionality. </br>
It is used when an object needs to utilize an existing class with an incompatible interface.
* __Decorator__ - Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.
It provides greater flexibility than static inheritance.
It enhances the extensibility of the object, because changes are made by coding new classes.
It simplifies the coding by allowing you to develop a series of functionality from targeted classes instead of coding all of the behavior into the object.
It is used when you want to transparently and dynamically add responsibilities to objects without affecting other objects.
* __Flyweight__ - Flyweight is a structural design pattern that lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.
A Flyweight Pattern allows us to reuse already existing similar kind of objects by storing them and create new object when no matching object is found.
Its major advantage is it reduces the number of objects and it reduces the amount of memory and storage devices required if the objects are persisted.



