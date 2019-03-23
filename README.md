# NY-Times
Simple Android App that implements Clean Code Architecture and SOLID Principles

Tools and Technologies are Used :
Using Some Cool Tools from Android Architecture Components and Android Jetpack :
ViewModel is a class that is responsible for preparing and managing the data for an Activity or a Fragment. It also handles the communication of the Activity / Fragment with the rest of the application (e.g. calling the business logic classes).
LiveData is a data holder class that can be observed within a given lifecycle. This means that an Observer can be added in a pair with a LifecycleOwner, and this observer will be notified about modifications of the wrapped data only if the paired LifecycleOwner is in active state. Rather than hiding the detail of SQLite, Room tries to embrace them by providing convenient APIs to query the database and also verify such queries at compile time. This allows you to access the full power of SQLite while having the type safety provided by Java SQL query builders.
Using Another Some Cool Tools and Libraries :
RxJava is Java implementation of Reactive Extension (from Netflix). Basically it’s a library that composes asynchronous events by following Observer Pattern. You can create asynchronous data stream on any thread, transform the data and consumed it by an Observer on any thread. The library offers wide range of amazing operators like map, combine, merge, filter and lot more that can be applied onto data stream.
Dagger is a fully static, compile-time dependency injection framework for both Java and Android. It is an adaptation of an earlier version created by Square and now maintained by Google.
Retrofit is a REST Client for Android and Java by Square. It makes it relatively easy to retrieve and upload JSON (or other structured data) via a REST based web service. In Retrofit you configure which converter is used for the data serialization. Typically for JSON you use GSON, but you can add custom converters to process XML or other protocols. Retrofit uses the OkHttp library for HTTP requests.
Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object. Gson can work with arbitrary Java objects including pre-existing objects that you do not have source-code of.
Project Structure :
Clean Architecture:
Trying to follow and implement as much as I can The Clean Code Architecture :

Presentation Layer contains UI (Activities & Fragments) that are coordinated by Presenters/ViewModels which execute 1 or multiple Use cases. Presentation Layer depends on Domain Layer.
Domain Layer is the most INNER part of the onion (no dependencies with other layers) and it contains Entities, Use cases & Repository Interfaces. Use case combines data from 1 or multiple Repository Interfaces.
Data Layer contains Repository Implementations and 1 or multiple Data Sources. Repositories are responsible to coordinate data from the different Data Sources. Data Layer depends on Domain Layer.
The Guide to App Architecture proposes an architecture with the following main components:

A local database that serves as a single source of truth for data presented to the user and the actions the user has taken to change that data.
A web API service.
A repository that works with the database and the API service, providing a unified data interface
A ViewModel that provides data specific for the UI
The UI, which shows a visual representation of the data in the ViewModel
So, our app follows the architecture recommended in the Guide to App Architecture, using Room as local data storage. Here's what you will find in each package:

api - contains Github API calls, using Retrofit
db - database cache for network data
data - contains the repository class, responsible for triggering API requests and saving the response in the database
ui - contains classes related to displaying an Activity with a RecyclerView
model - contains the Repo data model, which is also a table in the Room database; and RepoSearchResult, a class that is used by the UI to observe both search results data and network errors
Architecture Used


The following diagram shows all the modules in our recommended architecture and how they interact with one another:
