# E-Commerce System (Java)

This repository contains a Java-based implementation of a simplified e-commerce system that supports key features such as product expiration, shipping management, cart operations, and checkout processing — all designed using clean Object-Oriented Programming principles.


##  Features

- **Product Management**
  - Define products with name, price, quantity
  - Support for:
    -  Expirable products (e.g., Cheese)
    -  Shippable products with weight (e.g., TV, Cheese)
    -  Non-expirable/non-shippable items (e.g., Mobile Scratch Cards)

- **Cart System**
  - Add items to the cart with a specific quantity
  - Prevent adding expired or out-of-stock items

- **Checkout Process**
  - Validate customer balance
  - Calculate:
    - Subtotal
    - Shipping fee (based on total weight at 30 EGP/kg)
    - Final paid amount
  - Deduct balance and reduce product stock
  - Print:
    - Shipment notice
    - Checkout receipt

- **Shipping Logic**
  - Interfaces ensure that only eligible products implement `Shippable`
  - Automatically collects and processes shippable items for shipping service


##  Design & Structure

- `Product` is an abstract base class for all product types.
- `Shippable` and `Expirable` are marker interfaces for optional behavior.
- Concrete products (`Cheese`, `TV`, `MobileScratchCard`) implement relevant interfaces.
- `Cart` and `CartItem` manage purchase operations.
- `Customer` holds balance and handles payment.
- `ShippingService` and `CheckoutService` encapsulate business rules.
- `ECommerceApp` acts as the **composition root** for wiring and executing the use case.


##  Technologies

- Language: **Java 8+**
- No external libraries
- Pure Object-Oriented Programming

