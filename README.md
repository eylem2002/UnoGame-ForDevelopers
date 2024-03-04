Uno Game Engine
This project is an Uno game engine designed for developers to create their own variations of the popular card game. 
Uno is typically played by 2-10 players and consists of 108 cards including numbered cards, action cards (Reverse, Skip, Draw Two), and wild cards (Wild, Wild Draw Four).

Background
The Uno game engine is built using Java and Object-Oriented Programming principles.
The goal is to provide a flexible framework that allows developers to easily create custom Uno game variations. 
The engine includes a set of predefined game rules that developers can choose from when creating their own versions.

Features
Abstract class Game: Developers can extend this class to create new Uno game variations. By implementing abstract methods, developers can define specific rules and gameplay mechanics.
Predefined game rules: The engine includes a set of predefined game rules that developers can choose from, minimizing the effort required to create new game variations.
play method: Inside the Game class, there is a method called play that simulates the Uno game. Developers can customize this method to fit the rules of their specific game variation.
Extensibility: The code is designed to allow easy extension and customization. Developers can add new game rules, cards, or card dealing mechanisms with minimal effort.
GameDriver class: Contains the main method for running the game. Developers only need to instantiate a game object and invoke the play method to start the game.
