package com.example.productapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.rules.TestWatcher
import org.junit.runner.Description


//The MainCoroutineRule class is used to replace the main dispatcher
// (usually the UI thread) with a test dispatcher.
// This is essential for unit testing coroutines that use Dispatchers.Main.
@ExperimentalCoroutinesApi
//@ExperimentalCoroutinesApi: This annotation is used because
// we're using experimental features from the kotlinx.coroutines library.
class MainCoroutineRule(
   //dispatcher: The dispatcher parameter is of type
   //TestDispatcher, which is used to control the execution
   // of coroutines in tests. The default is StandardTestDispatcher.
    private val dispatcher: TestDispatcher = StandardTestDispatcher()
      //Inheritance from TestWatcher: TestWatcher is a JUnit rule
      //that allows us to add behavior before and after each test method.
) : TestWatcher() {
    //starting Method: This method is called before each test.
    // It sets the main dispatcher to our test dispatcher
    //using Dispatchers.setMain(dispatcher).
    override fun starting(description: Description) {
        Dispatchers.setMain(dispatcher)
    }
    //finished Method: This method is called after each test.
    // It resets the main dispatcher to its original state
    // using Dispatchers.resetMain().
    override fun finished(description: Description) {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
    }
}
