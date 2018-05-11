/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CurrencyFollow;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Omerfaruk
 */
public class CurrencyFollow {

    static double dolar = 4.0;
    static double euro = 5.0;
    static double kwd = 14.0;

    public static double randomChangeGenerator() {
        double rangeMin = -0.05f;//Change amount
        double rangeMax = 0.15f;
        Random r = new Random();
        double createdRanNum = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        return (createdRanNum);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please choose the currency which you want ; ");
        System.out.println("Press 1 for Dolar ");
        System.out.println("Press 2 for Euro");
        System.out.println("Press 3 for Kuwaiti Dinar");//User chose any currency and started to follow it.
        String chosen = in.nextLine();
        int currency = Integer.valueOf(chosen);

        double  expectedCurr = dolar + dolar * 0.05;//5% increasing is being waited
        double expectedCurr2 = euro + euro * 0.05;
        double expectedCurr3 = kwd + kwd * 0.05;

        Runnable runnable_general = () -> { // Function checks the change every second
            while (true) {
                if (currency == 1 && dolar >= expectedCurr) {
                    System.out.println("There is an increase of 5% on Dolar ");
                    break;
                } else if (currency == 2 && euro >= expectedCurr2) {
                    System.out.println("There is an increase of 5% on Euro ");
                    break;
                } else if (currency == 3 && kwd >= expectedCurr3) {
                    System.out.println("There is an increase of 5% on kwd ");
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CurrencyFollow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        Thread thread_general = new Thread(runnable_general);
        thread_general.start();

        Random rand = new Random();
        Runnable runnable = () -> {
            while (true) {
                double change = randomChangeGenerator();
                dolar += change;
                System.out.println("dolar :" + dolar);
                try {
                    int n = rand.nextInt(5) + 1;//Random wait time 5-1
                    long timeInterval = n * 1000;
                    Thread.sleep(timeInterval);
                } catch (InterruptedException e) {
                }
            }
        };

        Runnable runnable2 = () -> {
            while (true) {
                double change = randomChangeGenerator();
                euro += change;
                System.out.println("euro :" + euro);
                try {
                    int n = rand.nextInt(6) + 1;//Random wait time 6-1
                    long timeInterval = n * 1000;
                    Thread.sleep(timeInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable3 = () -> {
            while (true) {
                double change = randomChangeGenerator();
                kwd += change;
                System.out.println("kwd :" + kwd);
                try {
                    int n = rand.nextInt(9) + 1;//Random wait time 9-1
                    long timeInterval = n * 1000;
                    Thread.sleep(timeInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);

        thread.start();
        thread2.start();
        thread3.start();
    }
}
