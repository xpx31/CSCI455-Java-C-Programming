// Name: Pengxiang Xu
// USC NetID: pengxiax
// CSCI 455 PA5
// Fall 2017


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.


#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H
  
using namespace std;

struct Node {
  string key;
  int value;

  Node *next;

  Node(const string &theKey, int theValue);

  Node(const string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.

/**
 * initializes the given list to NULL
 * @param targetList
 */
void listInit(ListType & list);

/**
 * looks up the address of the value of target key in the target list
 *
 * @param targetKey target key
 * @param targetList target list
 * @return the address of the value that the key is associated in the list if not NULL
 *          otherwise, NULL.
 */
int * listLookup(const string &targetKey, const ListType &targetList);

/**
 * removes the value that associates with the target key in the list
 * @param targetKey the target key
 * @param targetList the target list
 * @return return true iff the value is removed from the list
 */
bool listRemove(const string &targetKey, ListType &targetList);

/**
 * inserts a defined value into the target list for the target key
 * @param targetKey target key
 * @param value input value
 * @param targetList target list
 * @return returns true iff the value is inserted into the list for the target key
 */
bool listInsert(const string &targetKey, const int value, ListType &targetList);

/**
 * get number of entries in the list
 * @param targetList the list
 * @return number of entries
 */
int listNumEntries(ListType &targetList);

/**
 * prints all entries in the list
 * @param targetList the list
 */
void listPrintAll(ListType &targetList);

// keep the following line at the end of the file
#endif
