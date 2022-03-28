package com.company;

interface Process {
    int getId();
    int getSpace();
    String getIdMemory();
    String getType();
    void CreateSpace();
    void DeleteSpace(Memory x);

}
