// Name: Pengxiang Xu
// USC NetID: pengxiax
// CSCI 455 PA5
// Fall 2017

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>

// Command Strings
const string PROMPT_CMD = "cmd>";
const string INSERT_CMD = "insert";
const string CHANGE_CMD = "change";
const string LOOKUP_CMD = "lookup";
const string REMOVE_CMD = "remove";
const string PRINT_CMD = "print";
const string SIZE_CMD = "size";
const string STATS_CMD = "stats";
const string HELP_CMD = "help";
const string QUIT_CMD = "quit";

// insert grades
void gradeInsert(Table *gradeTable);

// change grades
void gradeChange(Table *gradeTable);

// lookup grades
void gradeLookup(Table *gradeTable);

// remove grades
void gradeRemove(Table *gradeTable);

// print grades
void gradePrint(Table * gradeTable);

// print the size of the grade table
void gradeSize(Table *gradeTable);

// print the stats of the grade table
void gradeStats(Table *gradeTable);

// prints out a brief command summary
void help();

// checks if the input command is valid
void validCmd(Table *gradeTable);

// direct user to the correct command
void directCmd(string cmd, Table *gradeTable);

int main(int argc, char * argv[]) {

    // gets the hash table size from the command line

    int hashSize = Table::HASH_SIZE;

    Table * grades;  // Table is dynamically allocated below, so we can call
    // different constructors depending on input from the user.

    if (argc > 1) {
        hashSize = atoi(argv[1]);  // atoi converts c-string to int

        if (hashSize < 1) {
            cout << "Command line argument (hashSize) must be a positive number"
                    << endl;
            return 1;
        }

        grades = new Table(hashSize);

    }
    else {   // no command line args given -- use default table size
        grades = new Table();
    }


    grades->hashStats(cout);

    // add more code here
    // Reminder: use -> when calling Table methods, since grades is type Table*
    validCmd(grades);
    return 0;
}

/**
 * insert grades
 * @param gradeTable grade table
 */
void gradeInsert(Table *gradeTable){
    string name;
    string scoreStr;
    int scoreInt;

    cin >> name >> scoreStr;
    scoreInt = atoi(scoreStr.c_str());

    if(gradeTable->insert(name, scoreInt) == false){
        cout << "Name already present, no insertion performed." << endl;
    }
    else{
        cout << name << " " << scoreInt << " is inserted." << endl;
    }
}

/**
 * change grades
 * @param gradeTable grade table
 */
void gradeChange(Table *gradeTable){
    string name;
    string scoreStr;
    int scoreInt;

    cin >> name >> scoreStr;
    scoreInt = atoi(scoreStr.c_str());

    if(gradeTable->lookup(name) == NULL){
        cout << name << " is not present in the table." << endl;
    }
    else{
        gradeTable->remove(name);
        gradeTable->insert(name, scoreInt);
        cout << "Grade of " << name << " is changed to " << scoreInt << "." << endl;
    }
}

/**
 * lookup grades
 * @param gradeTable grade table
 */
void gradeLookup(Table *gradeTable){
    string name;
    int *score;

    cin >> name;
    score = gradeTable->lookup(name);

    if(score == NULL){
        cout << name << " is not present in the table." << endl;
    }
    else{
        cout << "Score of " << name << ": " << *score << endl;
    }
}

/**
 * remove grades
 * @param gradeTable grade table
 */
void gradeRemove(Table *gradeTable){
    string name;

    cin >> name;

    if(gradeTable->lookup(name) == NULL){
        cout << name << " is not present in the table." << endl;
    }
    else{
        gradeTable->remove(name);
        cout << name << " is removed." << endl;
    }
}

/**
 * print grades
 * @param gradeTable grade table
 */
void gradePrint(Table * gradeTable){
    gradeTable->printAll();
}

/**
 * print the size of grade table
 * @param gradeTable grade table
 */
void gradeSize(Table *gradeTable){
    cout << "Size of the grade table is: " << gradeTable->numEntries() << endl;
}

/**
 * print the stats of the grade table
 * @param gradeTable grade table
 */
void gradeStats(Table *gradeTable){
    gradeTable->hashStats(cout);
}

/**
 * prints out a brief command summary
 */
void help(){
    cout << "Help" << endl;
    cout << "insert name score" << endl;
    cout << "\tInsert this name and score in the grade table." << endl;
    cout << "change name newscore" << endl;
    cout << "\tChange the score for name." << endl;
    cout << "lookup name" << endl;
    cout << "\tLookup the name, and print out his or her score, or a message indicating that student is not in table." << endl;
    cout << "remove name" << endl;
    cout << "\tRemove this student." << endl;
    cout << "print" << endl;
    cout << "\tPrints out all names and scores in the table." << endl;
    cout << "size" << endl;
    cout << "\tPrints out all the number of entries in the table." << endl;
    cout << "stats" << endl;
    cout << "\tPrints out statistics about the hash table at this point." << endl;
    cout << "quit" << endl;
    cout << "\tExits the program" << endl;
}

/**
 * checks if the input command is valid
 * @param gradeTable grade table
 */
void validCmd(Table *gradeTable){
    string cmd;
    cout << PROMPT_CMD;
    cin >> cmd;

    while(cmd != QUIT_CMD){
        directCmd(cmd, gradeTable);
        cout << PROMPT_CMD;
        cin >> cmd;
    }
}

/**
 * direct user to the correct command
 * @param cmd command
 * @param gradeTable grade table
 */
void directCmd(string cmd, Table *gradeTable){
    if (cmd == INSERT_CMD){
        gradeInsert(gradeTable);
    }
    else if (cmd == CHANGE_CMD){
        gradeChange(gradeTable);
    }
    else if (cmd == LOOKUP_CMD){
        gradeLookup(gradeTable);
    }
    else if (cmd == REMOVE_CMD){
        gradeRemove(gradeTable);
    }
    else if (cmd == PRINT_CMD){
        gradePrint(gradeTable);
    }
    else if (cmd == SIZE_CMD){
        gradeSize(gradeTable);
    }
    else if (cmd == STATS_CMD){
        gradeStats(gradeTable);
    }
    else if (cmd == HELP_CMD){
        help();
    }
    else{
        cout << "ERROR: invalid command." << endl;
        help();
    }
}

