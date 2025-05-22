# Voting System in Java

## Overview
This project implements a **simple voting machine** using **Java**, allowing users to vote for **President and Mayor**. The system ensures fairness by preventing **double voting** using **custom exception handling**, tracks votes in real time, and periodically displays election results.

## Features
- **Secure Voting Process**: Users vote with a **unique Voter ID**.
- **Double Voting Prevention**: Custom exceptions (e.g., `DoubleVoteException`) prevent multiple votes.
- **Live Election Results**: Real-time vote tracking with background result updates.
- **Object-Oriented Design**: Implements **inheritance, polymorphism, and abstraction**.
- **Multi-threading Support**: Displays results while votes are being cast.
- **Modular Code Structure**: Organized into separate **classes and packages** for clarity.

## How It Works
1. **User Authentication**: Each voter enters their **unique Voter ID**.
2. **Voting Process**: Select a candidate from predefined options.
3. **Vote Storage & Validation**: The system ensures the voter hasn’t already voted.
4. **Real-Time Result Display**: Votes are continuously counted and updated.

## Technologies Used
- **Java (Core & OOP concepts)**
- **Multi-threading**
- **Custom Exceptions**
- **Collections Framework**

