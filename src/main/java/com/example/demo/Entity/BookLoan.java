package com.example.demo.Entity;

import java.time.LocalDate;

public class BookLoan {

    //Constructor and Setter,Getter
    private int bookLoanID;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;
    private AppUser borrower;
    private Book book;

}
