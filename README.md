# Testing Private Methods

https://www.baeldung.com/powermock-private-method

There is a very simple class that has one public method to generate a lucky number.

If you call the method with a null, it calls a private method to give you the default lucky number.
If you call the method with your name, it calls a private method to save your name and another private method to calculate your lucky number.

When we write tests for this public method, how can we check that it is calling the private methods appropriately?
That's where POWERMOCK leaps to the rescue.  

:wink:  I don't think any of the numbers are actually lucky - I think Baeldung made that up.  If there is some jUnit test that will check if a number really is lucky, then please let me know.



