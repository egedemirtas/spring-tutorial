# spring-tutorial
Everything I have learned about spring framework

- Dependency Injection:
    - before spring:
        ```
        public class flatEngine implements Engine(){}
        
        public class Car {
            Engine engine = new flatEngine(); // tight coupling
        }
        ```
        - Dependency: what a class needs to function properly. Engine class is a dependency of Car
        - uses "new" to directly instantiate the dependency. This is tight coupling. Car is tightly coupled with Engine.
        - Tight Coupling is Problematic: what if you wanted to use another engine? -> need to modify the code with new engine.
        - Best practice is to have loose coupling. How to achieve it?:
            ```
            public class Car {
                Engine engine;
                
                public Car (Engine engine){
                    this.engine = engine;
                }
            }
            ```
            - Depedency(Engine) is not instantiated directly in class. Engine is set in constructor, thus you can create a car with any engine you want by calling Car's constructor.
                
                - Ex: 

                    ```
                    Engine vEngine = new VEngine();

                    Car car = new Car(vEngine);
                    ```
                    - Spring actually performs this above code: instantiates objects(Engine) and populates the correct dependencies(for Car's constructor). 
                    - For this we need to help spring. what are the objects that it needs to manage and what are the dependencies of each class
                    - looking at above, 
                        - how should spring know to create an instance of VEngine? 
                        - how should spring know to create an instance of Engine and populate instance of VEngine? 

- Helping Spring
    - you need to help spring identify: what are the objects it needs to mange and what are their dependencies
    - ```@Component```: tell spring to manage instances of the classes attached 
    - ```@Autowired```: tell spring to start looking for attached class as dependency among @Component classes
    - spring makes sure all the instances of objects it manages are created and with dependencies populated
        ```
        @Component
        public class flatEngine implements Engine(){}
        
        @Component
        public class Car {
            @Autowired
            Engine engine;
        }
        ```
- Core Logic of Spring = Dependency Injection 


- TERMINOLOGY
    - BEANS: instances of classes that spring maneges are called beans
    - Autowiring: process where spring identifies the dependencies, identifies the matches for dependencies, and populates them
    - dependency injection: we are injecting Engine as a dependency to Car (pattern to implemnet IOC)
    - Inversion of control: 
        ```
        public class flatEngine implements Engine(){}
        public class Car {
            Engine engine = new flatEngine();
        }
        ```
        - the class which needs a dependency creates an instance of dependency
        - However in Spring, the dependency is instantiated by sprring
        - So we are taking the control from the class which needs dependency and giving the control to framework
        - dependency injection is a type of IOC application
        - IoC enables a framework to take control of the flow of a program and make calls to our custom code.
        - The advantages of this architecture are:
            - decoupling the execution of a task from its implementation
            - making it easier to switch between different implementations
            - greater modularity of a program
            - greater ease in testing a program by isolating a component or mocking its dependencies, and allowing components to communicate through contracts
    - IOC Container: represent anything that implements IOC (application context in spring)
        - The IoC container is responsible to instantiate, configure and assemble the objects. The IoC container gets informations from the XML file and works accordingly. 
        - The main tasks performed by IoC container are:
            - to instantiate the application class
            - to configure the object
            - to assemble the dependencies between the objects
            - There are two types of IoC containers. They are:
                - BeanFactory
                - ApplicationContext
                (The ApplicationContext interface is built on top of the BeanFactory interface)

- Why Spring is popular?
    - Enables testable code (because of dependecy injection). Also good integration with Junit and mockito
    - no plumping code: spring handles most of the exceptions by itself
    - flexible architecture


- BEAN scope
    ```
    BinarySearchWithSpring binarySearchWithSpring = appContext.getBean(BinarySearchWithSpring.class);
    BinarySearchWithSpring binarySearchWithSpring1 = appContext.getBean(BinarySearchWithSpring.class);
    ```
    - Both of the variables refer to the same object. When you try to get different instances of a bean from context, by default you get the same bean instance. This is called singleton bean (one instance per context)
    - prototype: new bean instance whenever requested from app context
    - request & session: one bean per HHTP request/session
    - Singleton pattern and singleton bean are different:
        - a singleton in a singleton pattern means a singular/only once instantiated class per JVM
        - singleton bean is one instance per application context

- CDI 
    - Java EE Dependency Injection Standard
    - CDI is an interface that defines how to do dependency injection
    - @Inject (for @Autowired), @Named(for @component, @qualifier), @Singleton
    - You need to add a new dependency(javax.inject) in pom.xml to use @Inject, @Named etc

- From SpringBoot to Spring
    - You need to delete springboot dependencies from pom.xml and add core/context dependencies from spring
    - You app won't run with @SpringBootApplication, thus you you need to define application configuration with @Configuration
    - Also spring cannot do component scan autoamtically, thus you need to add @ComponentScan in main file

- Resolving Disambiguation
    - IOC: 
        ```
        // before spring
        public class Car {
            Engine engine = new flatEngine(); // control of creating the Engine(dependency of Car) is with the Car(bean). Car decides when/how to create Engine
        }
        ```
        ```
        // after spring
        @Component
        public class flatEngine implements Engine(){}
        
        @Component
        public class Car {
            @Autowired
            Engine engine; // the responsibility of when/how to create Engine(dependency) shifted to framework(Spring)
        }
        ```
    - The program/concept which provides/manages IOC is IOC Container. In spring there are 2 implementations of IOC Container: Application Context(recommended by spring), Bean factory(suggested only if memory is scarce).
    - Application context:
        - All features provided by Bean Factory and 
        - AOPs and 
        - I18N(process of planning and implementing products and services so that they can easily be adapted to specific local languages and cultures, a process called localization) and
        - WebApplicationContext

- Component Annotations
    - @Component: nonspecific, generic
    - @Repository: for DB layer specific files (entities, dao)
    - @Service: service layer, business service facade
    - @Controller: controller in MVC pattern

