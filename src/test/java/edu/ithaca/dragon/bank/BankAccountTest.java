package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance());
        assertThrows(IllegalArgumentException.class, ()->bankAccount.withdraw(200));
        assertThrows(IllegalArgumentException.class, ()->bankAccount.withdraw(-200));
    }

    @Test
    /**
     *  it needs to have @ . with characters inbetween
     *  can't involve more than @
     *  can involve ! & ' * + - = ? . before @ as
     *  can involve digits
     *  no spaces are valid
     *  can involve both uppercase and lowercase letters
     */
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse( BankAccount.isEmailValid(""));

        assertTrue(BankAccount.isEmailValid("a-b@c.com"));
        assertTrue(BankAccount.isEmailValid("a.b@c.com"));
        assertTrue(BankAccount.isEmailValid("a_b@c.com"));
        assertTrue(BankAccount.isEmailValid("a?b@c.com"));
        assertTrue(BankAccount.isEmailValid("a*b@c.com"));
        assertTrue(BankAccount.isEmailValid("a+b@c.com"));
        assertTrue(BankAccount.isEmailValid("22@c.com"));
        assertTrue(BankAccount.isEmailValid("ab22@c.com"));
        assertTrue(BankAccount.isEmailValid( "A@b.com"));


        assertFalse( BankAccount.isEmailValid("  "));
        assertFalse( BankAccount.isEmailValid("@."));
        assertFalse( BankAccount.isEmailValid(" @ . "));
        assertFalse( BankAccount.isEmailValid("a.com"));
        assertFalse( BankAccount.isEmailValid("22"));
        assertFalse( BankAccount.isEmailValid("a@@b.com"));
        assertFalse( BankAccount.isEmailValid("a@b..com"));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}