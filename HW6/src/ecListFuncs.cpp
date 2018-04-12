/*  Name: Pengxiang Xu
 *  USC NetID: pengxiax
 *  CS 455 Fall 2017
 *
 *  See ecListFuncs.h for specification of each function.
 */

#include <iostream>

#include <cassert>

#include "ecListFuncs.h"

using namespace std;


int numRuns(ListType list) {
    int runCounts = 0;
    bool isRunning = false;

    if(list != NULL){
        for(Node *p = list; p->next != NULL; p = p->next){
            if(p->data == p->next->data){
                if(isRunning == false){
                    runCounts++;
                    isRunning = true;
                }
            }
            else{
                isRunning = false;
            }
        }
    }

    return runCounts;
}

ListType reverseCopy(ListType list) {
    ListType listNew = NULL;

    for(Node *p = list; p != NULL; p = p->next){
        insertFront(listNew, p->data);
    }

    return listNew;
}



void removeMiddleElmt(ListType &list) {
    int numCount = 0;
    int middleInd;

    if(list != NULL){ // list has at least 1 element
        for(Node *p = list; p != NULL; p = p->next){
            numCount++;
        }
        if(numCount > 1){
            Node *ptr = list;
            if(numCount > 2){ // list has 2+ elements
                numCount % 2 == 0 ? middleInd = numCount / 2 : middleInd = numCount / 2 + 1;

                for(int i = 1; i < middleInd - 1; i++){
                    ptr = ptr->next;
                }

                Node *tmp = ptr->next->next;
                delete ptr->next;
                ptr->next = tmp;
            }
            else{ // list has exactly 2 elements
                list = ptr->next;
                delete ptr;
            }
        }
        else{ // list has exactly 1 element
            list = NULL;
        }
    }
}

void splitOn(ListType &list, int splitVal, ListType &a, ListType &b) {
    if(list == NULL){ // list has no element
        a = b = NULL;
    }
    else{ // list contain elements
        a = list;
        Node *pa = a;
        bool doneSearch = false;

        if(list->data == splitVal){ // the first element in the list is the splitVal
            a = NULL;
        }
        else{ // all other cases
            while(doneSearch == false){
                list = list->next;
                if(list == NULL || list->data == splitVal){
                    doneSearch = true;
                }
                else{
                    pa = pa->next;
                }
            }
        }

        list == NULL ? list = NULL : list = list->next;
        b = list;
        pa->next = NULL;
        list = NULL;
    }
}
