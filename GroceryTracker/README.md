# Grocery Tracker Application

## Overview
The Grocery Tracker application is a C++ program designed to assist grocery stores in analyzing daily sales data. The program tracks the frequency of items purchased throughout the day, generates a comprehensive list of all item frequencies, displays this data in a histogram format, and creates a backup of the frequency data. This tool is particularly useful for optimizing store layouts and managing inventory based on customer purchasing trends.

## Features
- **Item Frequency Lookup**: Allows users to input a specific item and returns the frequency of that item in the sales data.
- **List All Frequencies**: Prints a list of all items and their respective purchase frequencies.
- **Histogram Display**: Generates a text-based histogram that visually represents the frequency of each item.
- **Data Backup**: Creates a backup file (`frequency.dat`) containing the frequency data for all items.

## Project Structure
- **`main.cpp`**: The main driver of the program, containing the menu system and user interaction logic.
- **`GroceryTracker.h`**: The header file defining the `GroceryTracker` class, including all necessary methods for data processing and output.
- **`GroceryTracker.cpp`**: The implementation file for the `GroceryTracker` class, where the core functionalities are defined.
- **`frequency.dat`**: The output file that stores the frequency data for all items as a backup.

## How to Use
1. **Run the Program**: Execute the compiled `GroceryTracker` program.
2. **Menu Options**:
   - **Option 1**: Enter the name of an item to see how many times it was purchased.
   - **Option 2**: Display a list of all items and their frequencies.
   - **Option 3**: View a histogram representation of the item frequencies.
   - **Option 4**: Exit the program.

3. **Input Validation**: The program includes input validation to ensure that users enter a valid menu option (1-4). If an invalid option is entered, the program will prompt the user to try again.

## Installation and Setup
1. **Clone the Repository**: 
git clone https://github.com/AmaroT/CS-Portfolio-Projects.git

2. **Compile the Program**: Use a C++ compiler to compile the source files.
g++ -o GroceryTracker main.cpp GroceryTracker.cpp

3. **Run the Program**: Execute the compiled program.
./GroceryTracker


## Future Enhancements
- **Improved Input Validation**: Enhance the input validation to handle additional edge cases and unexpected inputs.
- **Expanded Data Analysis**: Add features for more complex data analysis, such as identifying the most popular items or detecting trends over time.
- **GUI Interface**: Develop a graphical user interface to make the application more user-friendly.






