// Name: Pengxiang Xu
// USC NetID: pengxiax
// CSCI 455 PA5
// Fall 2017


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
    key = theKey;
    value = theValue;
    next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
    key = theKey;
    value = theValue;
    next = n;
}




//*************************************************************************
// put the function definitions for your list functions below

/**
 * initializes the given list to NULL
 * @param targetList
 */
void listInit(ListType & targetList){
    targetList = NULL;
}

/**
 * looks up the address of the value of target key in the target list
 *
 * @param targetKey target key
 * @param targetList target list
 * @return the address of the value that the key is associated in the list if not NULL
 *          otherwise, NULL.
 */
int * listLookup(const string &targetKey, const ListType &targetList){
    for(ListType list = targetList; list != NULL; list = list->next){
        if(list->key == targetKey){
            return &list->value;
        }
    }
    return NULL;
}

/**
 * removes the value that associates with the target key in the list
 * @param targetKey the target key
 * @param targetList the target list
 * @return return true iff the value is removed from the list
 */
bool listRemove(const string &targetKey, ListType &targetList){
    if(targetList == NULL){ // targetList is empty
        return false;
    }
    else{
        ListType list = targetList;

        // the first entry on the targetList is the target entry to be removed
        if(list->key == targetKey){
            targetList = list->next;
            delete list;
            return true;
        }
        else{
            // the later entries on the targetList is the target entry to be removed
            for(; list != NULL; list = list->next){
                if(list->next->key == targetKey){
                    ListType listNext = list->next;
                    list->next = listNext->next;
                    delete listNext;
                    return true;
                }
            }
        }
    }
    return false;
}

/**
 * inserts a defined value into the target list for the target key
 * @param targetKey target key
 * @param value input value
 * @param targetList target list
 * @return returns true iff the value is inserted into the list for the target key
 */
bool listInsert(const string &targetKey, const int value, ListType &targetList){
    if(targetList == NULL){
        targetList = new Node(targetKey, value);
        return true;
    }
    else{
        for(ListType list = targetList; list != NULL; list = list->next){
            if(list->key == targetKey){
                return false;
            }
            else{
                if(list->next == NULL){
                    list->next = new Node(targetKey, value);
                    return true;
                }
            }
        }
    }
    return false;
}

/**
 * get number of entries in the list
 * @param targetList the list
 * @return number of entries
 */
int listNumEntries(ListType &targetList){
    int numEntries = 0;
    for(ListType list = targetList; list != NULL; list = list->next){
        numEntries++;
    }

    return numEntries;
}

/**
 * prints all entries in the list
 * @param targetList the list
 */
void listPrintAll(ListType &targetList){
    for(ListType list = targetList; list != NULL; list = list->next){
        cout << list->key << " " << list->value << endl;
    }
}

