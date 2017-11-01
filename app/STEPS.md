1. Lazy initialization
    - Toolbar
    - Presenter

2. Operator overload
    - ViewGroup

3. Functions
    - Infix functions
    - Inline functions

4. Lambda extensions (Adapter with onClick)
5. Object (Singleton Beers repository)
6. Companion object (Start activity)
7. Object (Singleton Beers repository)
8. Invoking functions (GetBeers use case from presenter)
9. Sealed classes (ViewState from presenter -> when(state))
10. Property delegation

12. infix functions for testing (only applicable to extensions / member functions with single parameters
fun String shouldBeEqualsTo(value: String) = this == value

val output = "Hello"
output shouldBeEqualsTo "Hello"


11. Coroutines

let / apply / with
show method().also()
reified
anonymous functions?
