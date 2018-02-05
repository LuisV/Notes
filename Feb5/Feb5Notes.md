# Feb 5
### ToString( )
A user can define his own *classes*.
```
ex main {
  myDate today = new Date();
  Scanner sc;
  sc = new Scanner
}
```
`toString()` returns a String that represents an object

Print works together with the `toString()` method. *It will call that function when printing an object*

example: `System.out.println(myDate today)` will actually call the `.toString()` function inside `myDate`
### Equals Method

Need to be created in order to check the equality of two objects


```java
Ex:
public boolean equals (MyDate otherObj)
{
  return(( month.equals(otherObj.month)) &&
   (year == otherobj.year) &&
   (day == otherObj.day));
}
```

```java
  Usage:
  if ( today.equals(anotherDay))
  System.out.println("Dates are equal");
```

## Bank Account Exercise
#### Accesors and mutators
- getHolderName ( )
- setHolderName ( )
- deporit ( )
- withdrawl ( )

## Overloading and Constructors

#### Overloading
Same method name, different arguments
```
String substring (Start)
String substring (Start, End)
```
Not valid- cannot have same function with different return types:

```
public void setAccount( String aName);
public boolean setAccount( String name);
```
#### Constructors
`ClassName objectVariable ( String parameter);`

If you don't provide a constructor it will create one automatically.
**However** if you create one, you lose the default constructor.

`this` must be used if a parameter or local variable has the same name as an instance objectVariable
```java
public void setAccount (String name, int balance)
{
  this.name = name;
  this.balance = balance
}
```

Constructor chaining:
```
Inside Constructor {
  this( name = "Joe");
}
```
_**Didn't quite  understant this. I'll have to ask later**_

##### Recap
`this` has two different uses
- refering to instance variables
- used to look for another constructor with matching parameters

## Talk about UML Diagrams
##### Pretty sure everyone already knows this tho
