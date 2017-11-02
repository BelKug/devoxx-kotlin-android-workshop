1. Lazy initialization (views, adapter)
2. Lambda extensions (Adapter with onClick)
3. Extension functions (Activity Toast)
4. Inline functions (Inline reified for Activity findViewById)
5. Companion object (Start activity)
6. Object (Singleton Beers repository)
7. Invoking functions (GetBeers use case from presenter)
8. Sealed classes (ViewState from presenter -> when(state))
9. Property delegation
10. infix functions for testing (only applicable to extensions / member functions with single parameters
fun String shouldBeEqualsTo(value: String) = this == value
val output = "Hello"
output shouldBeEqualsTo "Hello"
13. Operator overload
    - ViewGroup
14. Coroutines

let / apply / with
show method().also()
reified
anonymous functions?
