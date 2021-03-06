package com.epam.java8.tasks.impl;

import com.epam.java8.tasks.HomeTask;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.logging.Logger;

public class HomeTaskSixImpl implements HomeTask {

    private static final Logger LOGGER = Logger.getLogger(HomeTaskSixImpl.class.getName());



//    Supplier<HomeTaskSixImpl> object = HomeTaskSixImpl::new;
//    HomeTaskSixImpl homeTaskSix = createObject();


    IntPredicate isPrime      = HomeTaskSixImpl::isPrimeOrNot;
    IntConsumer  printSquare  = HomeTaskSixImpl::print;
    IntSupplier  randomNumber = (() -> new Random().nextInt(5000));

    Consumer<Integer> printNumber = (integer -> LOGGER.info(String.valueOf(integer)));


//    private HomeTaskSixImpl createObject() {
//        return object.get();
//    }

    static boolean isPrimeOrNot(int number) {
        for (int i=2; i<= (int)Math.sqrt(number); i++) {
            if(number%2==0) {
                return false;
            }
        }
        return true;
    }

    static void print(int number) {
        LOGGER.info(String.valueOf(number*number));
    }

    public boolean isPrime(int number) {
        if(isPrime.test(number)) {
            return true;
        }
        return false;
    }

    public boolean printSqureOfNumber(int number) {
        printSquare.accept(number);
        return true;
    }

    public int getRandomNumber() {
        int asInt = randomNumber.getAsInt();
        printNumber.accept(asInt);
        return asInt;
    }

    @Override
    public void driver() {

    }
}
