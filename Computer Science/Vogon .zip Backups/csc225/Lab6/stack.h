/*
 *  stack.h
 *  Lab6
 *
 *  Created by Tyler Holland on 11/11/09.
 */

#ifndef STACK_H
#define STACK_H

int push(int value);
int pop(int *value);
void printStack(int value);

extern int myStack[10];
extern int *top;
extern int *max;

#endif