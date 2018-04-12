// Name: Pengxiang Xu
// USC NetID: pengxiax
// CSCI 455 PA5
// Fall 2017

// Table.cpp  Table class implementation


/*
 * Modified 11/22/11 by CMB
 *   changed name of constructor formal parameter to match .h file
 */

#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************

/**
 * Table constructor without parameter
 * it has a size of HASH_SIZE
 */
Table::Table() {
    hashSize = HASH_SIZE;
    table = new ListType[hashSize];

    for(unsigned int i = 0; i < hashSize; i++){
        table[i] = NULL;
    }
}

/**
 * Table constructor has a parameter, hSize
 * it has a size of hSize
 * @param hSize the client defined table size
 */
Table::Table(unsigned int hSize) {
    hashSize = hSize;
    table = new ListType[hashSize];

    for(unsigned int i = 0; i < hashSize; i++){
        table[i] = NULL;
    }
}

/**
 * looks up a key in the table
 * @param key the key
 * @return the address of the corresponding score in the table
 */
int * Table::lookup(const string &key) {
    return listLookup(key, table[hashCode(key)]);
}

/**
 * removes the entry from the table associate with the key
 * @param key the key
 * @return returns true iff the entry is removed from the table
 */
bool Table::remove(const string &key) {
    return listRemove(key, table[hashCode(key)]);
}

/**
 * inserts the entry into the table with the key and value
 * @param key the key
 * @param value the value
 * @return returns true iff the entry is inserted into the table
 */
bool Table::insert(const string &key, int value) {
    return listInsert(key, value, table[hashCode(key)]);
}

/**
 * get the number of entries in the table
 * @return the number of entries in the table
 */
int Table::numEntries() const {
    int numEntries = 0;
    for(unsigned int i = 0; i < hashSize; i++){
        numEntries += listNumEntries(table[i]);
    }
    return numEntries;
}

/**
 * prints all entries in the table
 */
void Table::printAll() const {
    for(unsigned int i = 0; i < hashSize; i++){
        listPrintAll(table[i]);
    }
}

/**
 * prints the hash stats of the table
 * @param out system output
 */
void Table::hashStats(ostream &out) const {
    out << "number of buckets: " << hashSize << endl;
    out << "number of entries: " << numEntries() << endl;
    out << "number of non-empty buckets: " << numNonEmptyBuckets() << endl;
    out << "longest chain: " << longestChainLength() <<endl;
}


// add definitions for your private methods here

/**
 * get the number of non empty buckets in the table
 * @return number of non empty buckets in the table
 */
int Table::numNonEmptyBuckets() const{
    int numNonEmpty = 0;
    for(unsigned int i = 0; i < hashSize; i++){
        if(table[i] != NULL){
            numNonEmpty++;
        }
    }
    return numNonEmpty;
}

/**
 * get the longest chain length in the table
 * @return the longest chain length in the table
 */
int Table::longestChainLength() const{
    int chainLength = 0;
    int longestLength = 0;

    for(unsigned int i = 0; i < hashSize; i++){
        chainLength = listNumEntries(table[i]);
        longestLength = chainLength > longestLength ? chainLength : longestLength;
    }
    return longestLength;
}
