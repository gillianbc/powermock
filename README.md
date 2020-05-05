# Testing Private Methods

https://www.baeldung.com/powermock-private-method

There is a very simple class that has one public method to generate a lucky number.

* If you call the method with a null, it calls a private method to give you the default lucky number.
* If you call the method with your name, it calls a private method to save your name and another private method to calculate your lucky number.

When we write tests for this public method, how can we check that it is calling the private methods appropriately?
That's where POWERMOCK leaps to the rescue.  

:wink:  I don't think any of the numbers are actually lucky - I strongly suspect Baeldung made that up.  If there is some jUnit test that will check if a number really is lucky, then please let me know so I can do the lotto.

# But...

If you're having to use powermock, then it could be a workaround to get around code that has not been written with testing in mind.  

For example, if the class under test privately does some saving to the database that you need to mock, then the solution maybe to refactor the code so that it calls a separate class that takes care of the saving to the database.  It's then easy to mock out that new class.



