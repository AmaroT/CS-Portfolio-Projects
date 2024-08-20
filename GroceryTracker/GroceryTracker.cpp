#include <iostream>
#include <fstream>
#include <string>
#include <map>
#include <vector>

class GroceryTracker {
    private:
        std::map<std::string, int> itemFrequencies;
    
    public:
    // Method to load data from the input file and populate the map
    void loadDataFromFile(const std::string& filename);

    // Method to get the frequency of a specific item
    int getItemFrequency(const std::string& item);

    // Method to print all items and their frequencies
    void printAllFrequencies();

    // Method to print a histogram of item frequencies
    void printHistogram();

    // Method to create a backup file with the item frequencies
    void createBackupFile(const std::string& filename);
};

// Implementations
void GroceryTracker::loadDataFromFile(const std::string& filename) {
    std::ifstream inputFile(filename);
    std::string item;

    if (!inputFile) {
        std::cerr << "Error opening file: " << filename << std::endl;
        return;
    }
    while (inputFile >> item) {
        itemFrequencies[item]++;
    }
    inputFile.close();

}
// Getting the frequency of specific item
int GroceryTracker::getItemFrequency(const std::string& item) {
    if (itemFrequencies.find(item) != itemFrequencies.end()) {
        return itemFrequencies[item];
    } else {
        return 0; // Item not found
    }
}

// Printing all Frequencies
void GroceryTracker::printAllFrequencies() {
    for(const auto& pair : itemFrequencies) {
        std::cout << pair.first << ": " << pair.second << std::endl;
    }
}

// Printing a Histogram
void GroceryTracker::printHistogram() {
    for (const auto& pair : itemFrequencies) {
        std::cout << pair.first << ": ";
        for (int i = 0; i < pair.second; i++) {
            std::cout << "*";
        }
        std::cout << std::endl;
    }
}

// Creating a backup file
void GroceryTracker::createBackupFile(const std::string& filename) {
    std::ofstream outputFile(filename);

    if (!outputFile) {
        std::cerr << "Error creating file: " << filename << std::endl;
        return;
    }
    for (const auto& pair : itemFrequencies) {
        outputFile << pair.first << " " << pair.second << std::endl;
    }
    outputFile.close();
}

// Main Function
int main() {
    GroceryTracker tracker;
    tracker.loadDataFromFile("CS210_Project_Three_Input_File.txt");
    tracker.createBackupFile("frequency.dat");

    int choice;
    std::string item;

    do {
        std::cout << "\nMenu Options:" << std:: endl;
        std::cout << "1. Get frequency of an item" << std::endl;
        std::cout << "2. Print all item frequencies" << std::endl;
        std::cout << "3. Print histogram of item frequencies" << std::endl;
        std::cout << "4. Exit\n" << std::endl;
        std::cout << "Enter your choice (1 - 4): \n";
        std::cin >> choice;

        //Input Validation
        while (std::cin.fail() || choice < 1 || choice > 4) {
            std::cin.clear(); // Clear the error flag
            std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n'); // Ignore invalid input
            std::cout << "Invalid input. Please enter a number between 1 and 3, or type 4 to exit the program: ";
            std::cin >> choice;
        }

        switch (choice) {
            case 1:
                std::cout << "Enter the item: ";
                std::cin >> item;
                std::cout << item << ": " << tracker.getItemFrequency(item) << std:: endl;
                break;

            case 2:
                tracker.printAllFrequencies();
                break;

            case 3: 
                tracker.printHistogram();
                break;

            case 4:
                std::cout << "Thank you for using the Corner Grocer Item Tracking Program! Goodbye!" << std::endl;
                break;
        }

    } while (choice != 4);

    return 0;
}