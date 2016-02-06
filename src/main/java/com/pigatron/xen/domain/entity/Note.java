package com.pigatron.xen.domain.entity;

public class Note {

    private int octaveNumber;
    private int noteNumber;


    public Note(int octaveNumber, int noteNumber) {
        this.octaveNumber = octaveNumber;
        this.noteNumber = noteNumber;
    }

    public int getOctaveNumber() {
        return octaveNumber;
    }

    public void setOctaveNumber(int octaveNumber) {
        this.octaveNumber = octaveNumber;
    }

    public int getNoteNumber() {
        return noteNumber;
    }

    public void setNoteNumber(int noteNumber) {
        this.noteNumber = noteNumber;
    }
}
