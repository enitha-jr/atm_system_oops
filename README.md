# ATM SYSTEM USING OOPS

Designed and implemented an ATM (Automated Teller Machine) system that allows users to perform basic banking operations such as balance inquiry, cash withdrawal, and cash deposit, with secure authentication.


## Overview
### Encapsulation :
The process of wrapping data (variables) and methods (functions) together inside a class.

-- It protects sensitive information by making variables private.

--Data can only be accessed or modified using public getter and setter methods.

--It improves security and data integrity.

--It reduces direct dependency on internal implementation.

*  `accountId`,`pin`, `accountHolderName`, `balance` are private
*  Access is provided through methods like : 
`getAccountId()`,`getBalance()`,`verifyPin()`
---
### Inheritance:
Inheritance is the mechanism by which one class acquires the properties and behaviors of another class. It promotes code reusability and establishes a hierarchical relationship between classes.

-- It allows child classes to reuse fields and methods of the parent class.

-- It supports method overriding for specialized behavior.

-- It represents an “is-a” relationship between classes.

* `CurrentAccount` and `SavingsAccount` extend the `Account` class

* They inherit common properties like `accountId` and `balance`

* They reuse methods like `deposit()` and `getBalance()`

```java
public class CurrentAccount extends Account
public class SavingsAccount extends Account
```
---

### Polymorphism

Polymorphism means “many forms”. It allows methods to behave differently based on the object or parameters used.

1. **Method Overloading (Compile-Time Polymorphism) :**
   Method overloading occurs when multiple methods in the same class have the same name but different parameters. It does not require inheritance.

* `getBalance()` and `getBalance(boolean isCurrentAccount)` are overloaded methods in the Account class

2. **Method Overriding (Runtime Polymorphism)**: 
Method overriding occurs when a child class provides a specific implementation of a method that is already defined in its parent class. It requires inheritance.

* `withdraw(double amount)` is defined in the Account class
* `CurrentAccount` overrides `withdraw()` to allow overdraft
* `SavingsAccount` overrides `withdraw()` to restrict withdrawal beyond balance

---
### Abstraction 
Abstraction is the concept of hiding implementation details and showing only the essential features of an object. It focuses on what an object does, not how it does it.

-- It hides internal implementation logic.

-- It is commonly achieved using **interfaces** or **abstract classes.**

* `ATMOperations` interface defines methods like `deposit()`, `withdraw()`, and `checkBalance()`
* `ATMService` implements the `ATMOperations` interface

```java
ATMOperations atm = new ATMService();  // upcasting 
```
---

### Interface
An interface in Java is an abstract type that defines a set of methods a class must implement. 

It acts as a contract that specifies what a class should do, but not how it should do it. 

Interfaces are used to achieve abstraction and support multiple inheritance in Java.

```java
class ATMService implements ATMOperations
```

* `class` -- `class` : **extends**
* `class` -- `interface` : **implements**
* `interface` -- `interface` : **extends**
---
### `super` and `this`
-- `this` refers to the current object of the class.

-- `super` refers to the parent class object.
