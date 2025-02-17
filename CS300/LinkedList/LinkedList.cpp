//============================================================================
// Name        : LinkedList.cpp
// Author      : Amaro Terrazas
// Version     : 1.0
// Copyright   : Copyright � 2023 SNHU COCE
// Description : Lab 3-2 Lists and Searching
//============================================================================

#include <algorithm>
#include <iostream>
#include <time.h>
#include <string>

#include "CSVparser.hpp"

using namespace std;

//============================================================================
// Global definitions visible to all methods and classes
//============================================================================

// forward declarations
double strToDouble(string str, char ch);

// define a structure to hold bid information
struct Bid {
    string bidId; // unique identifier
    string title;
    string fund;
    double amount;
    Bid() {
        amount = 0.0;
    }
};

//============================================================================
// Linked-List class definition
//============================================================================

/**
 * Define a class containing data members and methods to
 * implement a linked-list.
 */
class LinkedList {

private:
    //Internal structure for list entries, housekeeping variables
    struct Node {
        Bid bid;
        Node *next;

        // default constructor
        Node() {
            next = nullptr;
        }

        // initialize with a bid
        Node(Bid aBid) {
            bid = aBid;
            next = nullptr;
        }
    };

    Node* head;
    Node* tail;
    int size = 0;

public:
    LinkedList();
    virtual ~LinkedList();
    void Append(Bid bid);
    void Prepend(Bid bid);
    void PrintList() const;
    void Remove(string bidId);
    Bid Search(string bidId) const;
    int Size();
};

/**
 * Default constructor
 */
LinkedList::LinkedList() : head(nullptr), tail(nullptr) {
}



/**
 * Destructor
 */
LinkedList::~LinkedList() {
    // start at the head
    Node* current = head;
    Node* temp;

    // loop over each node, detach from list then delete
    while (current != nullptr) {
        temp = current; // hang on to current node
        current = current->next; // make current the next node
        delete temp; // delete the orphan node
    }
}

/**
 * Append a new bid to the end of the list
 */
void LinkedList::Append(Bid bid) {
    Node* newNode = new Node(bid);
    if (tail) {
        tail ->next = newNode;
    } else {
        head = newNode;
    }
    tail = newNode;
    size++; //Increment size
}

/**
 * Prepend a new bid to the start of the list
 */
void LinkedList::Prepend(Bid bid) {
    Node* newNode = new Node(bid);
    newNode->next = head;
    head = newNode;
    if(!tail) {
        tail = newNode;
    }
    size++; // Increment size

}

/**
 * Simple output of all bids in the list
 */
void LinkedList::PrintList() const {
    Node* current = head;
    while (current) {
        std::cout << current->bid.bidId << ": " << current->bid.title
            << " | " << current->bid.amount << " | " << current->bid.fund << std::endl;
        current = current->next;
    }
}

/**
 * Remove a specified bid
 *
 * @param bidId The bid id to remove from the list
 */
void LinkedList::Remove(string bidId) {
    Node* current = head;
    Node* previous = nullptr;

    while(current) {
        if (current->bid.bidId == bidId) {
            if (previous) {
                previous->next = current->next;
            } else {
                head = current->next;
            }
            if (current == tail) {
                tail = previous;
            }
            delete current;
            size--; //Decrement size
            return;
        }
        previous = current;
        current = current->next;
    }
}

/**
 * Search for the specified bidId
 *
 * @param bidId The bid id to search for
 */
Bid LinkedList::Search(std::string bidId) const {
    Node* current = head;
    while (current) {
        if (current->bid.bidId == bidId) {
            return current->bid;
        }
        current = current->next;
    }
    return Bid(); // Return an empty bid if not found
}

/**
 * Returns the current size (number of elements) in the list
 */
int LinkedList::Size() {
    return size;
}

//============================================================================
// Static methods used for testing
//============================================================================

/**
 * Display the bid information
 *
 * @param bid struct containing the bid info
 */
void displayBid(Bid bid) {
    cout << bid.bidId << ": " << bid.title << " | " << bid.amount
         << " | " << bid.fund << endl;
    return;
}

/**
 * Prompt user for bid information
 *
 * @return Bid struct containing the bid info
 */
Bid getBid() {
    Bid bid;

    cout << "Enter Id: ";
    cin.ignore();
    getline(cin, bid.bidId);

    cout << "Enter title: ";
    getline(cin, bid.title);

    cout << "Enter fund: ";
    cin >> bid.fund;

    cout << "Enter amount: ";
    cin.ignore();
    string strAmount;
    getline(cin, strAmount);
    bid.amount = strToDouble(strAmount, '$');

    return bid;
}

/**
 * Load a CSV file containing bids into a LinkedList
 *
 * @return a LinkedList containing all the bids read
 */
void loadBids(string csvPath, LinkedList *list) {
    cout << "Loading CSV file " << csvPath << endl;

    // initialize the CSV Parser
    csv::Parser file = csv::Parser(csvPath);

    try {
        // loop to read rows of a CSV file
        for (int i = 0; i < file.rowCount(); i++) {

            // initialize a bid using data from current row (i)
            Bid bid;
            bid.bidId = file[i][1];
            bid.title = file[i][0];
            bid.fund = file[i][8];
            bid.amount = strToDouble(file[i][4], '$');

            //cout << bid.bidId << ": " << bid.title << " | " << bid.fund << " | " << bid.amount << endl;

            // add this bid to the end
            list->Append(bid);
        }
    } catch (csv::Error &e) {
        std::cerr << e.what() << std::endl;
    }
}

/**
 * Simple C function to convert a string to a double
 * after stripping out unwanted char
 *
 * credit: http://stackoverflow.com/a/24875936
 *
 * @param ch The character to strip out
 */
double strToDouble(string str, char ch) {
    str.erase(remove(str.begin(), str.end(), ch), str.end());
    return atof(str.c_str());
}

/**
 * The one and only main() method
 *
 * @param arg[1] path to CSV file to load from (optional)
 * @param arg[2] the bid Id to use when searching the list (optional)
 */
int main(int argc, char* argv[]) {

    // process command line arguments
    string csvPath;
    string bidKey = "98109";  // Default search key if none is provided
    clock_t ticks;

    LinkedList bidList;

    // Menu for selecting file and operations
    int choice = 0;
    while (choice != 9) {
        cout << "Menu:" << endl;
        cout << "  1. Enter a Bid" << endl;
        cout << "  2. Load Bids" << endl;
        cout << "  3. Display All Bids" << endl;
        cout << "  4. Find Bid" << endl;
        cout << "  5. Remove Bid" << endl;
        cout << "  9. Exit" << endl;
        cout << "Enter choice: ";
        cin >> choice;

        switch (choice) {
        case 1:
            bidList.Append(getBid());
            break;

        case 2:
            // Prompt the user to choose which file to load
            int fileChoice;
            cout << "Choose CSV file to load:" << endl;
            cout << "1. eBid_Monthly_Sales.csv" << endl;
            cout << "2. eBid_Monthly_Sales_Dec_2016.csv" << endl;
            cout << "Enter choice: ";
            cin >> fileChoice;

            if (fileChoice == 1) {
                csvPath = "eBid_Monthly_Sales.csv";
            } else if (fileChoice == 2) {
                csvPath = "eBid_Monthly_Sales_Dec_2016.csv";
            } else {
                cout << "Invalid choice. Please try again." << endl;
                break;
            }

            // Load bids from the selected file
            ticks = clock();
            loadBids(csvPath, &bidList);
            ticks = clock() - ticks;

            cout << bidList.Size() << " bids read" << endl;
            cout << "time: " << ticks * 1.0 / CLOCKS_PER_SEC << " seconds" << endl;
            break;

        case 3:
            bidList.PrintList();
            break;

        case 4:
            cout << "Enter Bid ID to search: ";
            cin >> bidKey;
            ticks = clock();
            displayBid(bidList.Search(bidKey));
            ticks = clock() - ticks;
            cout << "Search time: " << ticks * 1.0 / CLOCKS_PER_SEC << " seconds" << endl;
            break;

        case 5:
            cout << "Enter Bid ID to remove: ";
            cin >> bidKey;
            bidList.Remove(bidKey);
            cout << "Bid removed." << endl;
            break;
        }
    }

    cout << "Goodbye." << endl;
    return 0;
}

