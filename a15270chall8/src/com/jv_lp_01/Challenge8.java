package com.jv_lp_01;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Tutor {
    private Student student;
    private ReentrantLock lock;

    public synchronized void setStudent(Student student, ReentrantLock lock) {
        this.student = student;
        this.lock = lock;
    }

    public void studyTime() {
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                System.out.println("Tutor has arrived");

                // wait for student to arrive and hand in assignment
                Thread.sleep(300);

                lock.unlock();
            }
        } catch (InterruptedException e) {

        }
        student.startStudy();
        System.out.println("Tutor is studying with student");
    }

    public synchronized void getProgressReport() {
        // get progress report
        System.out.println("Tutor gave progress report");
    }
}

class Student {

    private Tutor tutor;
    private ReentrantLock lock;

    Student(Tutor tutor, ReentrantLock lock) {
        this.tutor = tutor;
        this.lock = lock;
    }

    public synchronized void startStudy() {
        // study
        System.out.println("Student is studying");
    }

    public void handInAssignment() {
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                tutor.getProgressReport();
                System.out.println("Student handed in assignment");
                lock.unlock();
            }
        } catch (InterruptedException e) {

        }
    }
}
