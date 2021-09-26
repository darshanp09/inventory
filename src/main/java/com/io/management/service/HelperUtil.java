package com.io.management.service;

import com.io.management.model.Product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HelperUtil {

    public static int getDayNumberOld(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static String getDayInWeek(){

        String day = "";

        switch(getDayNumberOld(new java.util.Date()))
        {
            case 1:
                day ="sunday";
                break;
            case 2:
                day = "monday";
                break;
            case 3:
                day = "tuesday";
                break;
            case 4:
                day = "wednesday";
                break;
            case 5:
                day = "thursday";
                break;
            case 6:
                day = "friday";
                break;
            case 7:
                day = "saturday";
                break;
            default:
                System.out.println("Weekend");
                break;
        }
        return day;
    }

    public static int getTotalQuantity(Product products, Product product) {

        /*products.setSunday( products.getSunday() != 0 ? + products.getSunday() + product.getSunday(): 0);
        products.setMonday( products.getMonday() != 0 ? products.getMonday() + product.getMonday() : 0);
        products.setTuesday( products.getTuesday() != 0 ? products.getTuesday() + product.getTuesday() : 0);
        products.setWednesday( products.getWednesday() != 0 ? products.getWednesday() + product.getWednesday() : 0);
        products.setThursday(products.getThursday() != 0 ? products.getThursday() + product.getThursday() : 0);
        products.setFriday( products.getFriday() != 0 ? products.getFriday() + product.getFriday() : 0);
        products.setSaturday( products.getSaturday() != 0 ? products.getSaturday() + product.getSaturday() : 0);*/
        if(product.getDayOfWeek().equals("sunday")){
            products.setSunday(products.getSunday()!=0 ? product.getQuantity()+products.getSunday() : product.getQuantity());
        }else if(product.getDayOfWeek().equals("monday")){
            products.setMonday(products.getMonday()!=0 ? product.getQuantity()+products.getMonday() : product.getMonday());
        }else if(product.getDayOfWeek().equals("tuesday")){
            products.setTuesday(products.getTuesday()!=0 ? product.getQuantity()+products.getTuesday() : product.getQuantity());
        }else if(product.getDayOfWeek().equals("wednesday")){
            products.setWednesday(products.getWednesday()!=0 ? product.getQuantity()+products.getWednesday() : product.getQuantity());
        }else if(product.getDayOfWeek().equals("thursday")){
            products.setThursday(products.getThursday()!=0 ? product.getQuantity()+products.getThursday() : product.getQuantity());
        }else if(product.getDayOfWeek().equals("friday")){
            products.setFriday(products.getFriday()!=0 ? product.getQuantity()+products.getFriday() : product.getQuantity());
        }else if(product.getDayOfWeek().equals("saturday")){
            products.setSaturday(products.getSaturday()!=0 ? product.getQuantity()+products.getSaturday() : product.getQuantity());
        }

        int one = products.getSunday();
        int two = products.getMonday();
        int three = products.getTuesday();
        int four = products.getWednesday();
        int five = products.getThursday();
        int six = products.getFriday();
        int seven = products.getSaturday();


        int calculate = one + two + three + four + five + six + seven;

        return calculate;

    }

    public static int addTotalSale(Product product, Product products) {
        int calculate = 0;

        int one = products.getSunday() - product.getQuantity();
        int two = products.getMonday();
        int three = products.getTuesday();
        int four = products.getWednesday();
        int five = products.getThursday();
        int six = products.getFriday();
        int seven = products.getSaturday();

         calculate = one + two + three + four + five + six + seven;

        /*if(product.getDayOfWeek().equals("sunday")){
            calculate +=products.getSunday();
        }else if(product.getDayOfWeek().equals("monday")){
            calculate +=products.getMonday();
        }else if(product.getDayOfWeek().equals("tuesday")){
            calculate +=products.getTuesday();
        }else if(product.getDayOfWeek().equals("wednesday")){
            calculate +=products.getWednesday();
        }else if(!product.getDayOfWeek().equals("thursday")){
            calculate +=products.getThursday();
        }else if(!product.getDayOfWeek().equals("friday")){
            calculate +=products.getFriday();
        }else if(!product.getDayOfWeek().equals("saturday")){
            calculate +=products.getSaturday();
        }*/
        return calculate;
    }
}
