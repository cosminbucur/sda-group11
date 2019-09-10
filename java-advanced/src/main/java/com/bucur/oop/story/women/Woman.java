package com.bucur.oop.story.women;

// women are abstract because nobody understands them
public abstract class Woman {

    // composition - women can't live without these
    Love love;
    FinancialSecurity financialSecurity;

    public Woman(Love love, FinancialSecurity financialSecurity) {
        this.love = love;
        this.financialSecurity = financialSecurity;
        System.out.println("I only need " + love.getClass().getName() +
                " and " + financialSecurity.getClass().getName());
    }

    // i have no clue how they feel
    public abstract void feel();

    public abstract void dream();

    public abstract void relax();
}
