package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());

        BankAccount bankAcc1= new BankAccount("c@s.com", 75.5);
        assertEquals(75.5, bankAcc1.getBalance());

        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", -22.0));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", 22.222));;
    }

    @Test
    /**
     * amount can not be <0
     * amount can not be > balance in account
     */
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance());
        assertThrows(IllegalArgumentException.class, ()->bankAccount.withdraw(200));
        assertThrows(IllegalArgumentException.class, ()->bankAccount.withdraw(-200));
        assertThrows(IllegalArgumentException.class, ()->bankAccount.withdraw(5.255));

        bankAccount.withdraw(22.4);
        assertEquals(77.6, bankAccount.getBalance());
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
    void isAmountValidTest(){
        assertTrue(BankAccount.isAmountValid(200.0));
        assertTrue(BankAccount.isAmountValid(24.44));
        assertFalse(BankAccount.isAmountValid(25.555));
        assertFalse(BankAccount.isAmountValid(-2.0));
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