# Project Overview
A simple Todo List application built in Java and run from the command line. 
Users can add tasks, remove tasks, mark tasks as done, and filter tasks by 
category. All tasks are saved to a text file so they persist between sessions.

## Approach and Design 
There are 4 main classes and 1 interface.

- Task: The blueprint for every task, containing an id, title, category, and status.
- TaskStorage: An interface that defines the contract for saving and loading tasks. 
  This was designed so that the storage type can easily be swapped out for a 
  database in the future without changing any other class.
- Storage: Implements the TaskStorage interface. Handles reading and writing tasks 
  to a plain text file. Each task is saved as one line in the format: 
  id,title,category,status
- TaskManager: Contains all the business logic of the application. Methods include 
  addTask, removeTask, setTaskStatus, printTasks, and printTasksByCategory.
- Main: The entry point of the application. Acts as the bridge between the user 
  and the code, displaying the menu and calling the correct TaskManager method 
  based on the user's input.

## Key Files and Folders

- src/Task.java — The Task class, blueprint for every task object
- src/TaskStorage.java — Interface defining the save and load contract
- src/Storage.java — Implements TaskStorage, reads and writes to tasks.txt
- src/TaskManager.java — All logic for add, remove, list, filter tasks
- src/Main.java — Entry point, displays menu and handles user input
- src/TaskManagerTest.java — Unit tests for all core TaskManager methods
- tasks.txt — Data file where all tasks are saved and loaded from

## How to Run

**Requirements:** Java 25 (openjdk 25 2025-09-16 LTS) or higher

**Steps:**

1. Open terminal and navigate to the project folder
2. Compile the code:
````
   javac src/*.java -d out
````
3. Run the application:
````
   java -cp out Main
````
4. Follow the menu prompts to manage your tasks

## How to Test

1. Compile the code (if not already done):
````
   javac src/*.java -d out
 ````
2. Run the tests:
````
   java -cp out TaskManagerTest
````
3. All 5 tests should print PASSED

## Seed Data

The tasks.txt file contains sample tasks to demonstrate the app on first run.
Tasks are saved in this format: id,title,category,status

Example:
````
1,clean,home,false
2,clean,home,true
3,gym,personal,false
4,buy groceries,shopping,false
5,cook,personal,false
````