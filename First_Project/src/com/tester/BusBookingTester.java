package com.tester;

import java.util.ArrayList;
import java.util.Scanner;

import com.dao.BusDAO;
import com.exception.CustomeException;
import com.validation.ValidationException;

import Project_1.Project1_Console;

public class BusBookingTester {

    public static void main(String[] args) {

        try {

            BusDAO dao = new BusDAO();

            Scanner sc = new Scanner(System.in);

            int choice;

            do {

                System.out.println("----- BUS BOOKING SYSTEM -----");
                System.out.println("1. Add Booking");
                System.out.println("2. Update Fare");
                System.out.println("3. Delete Booking");
                System.out.println( "4.View All Bookings");
                System.out.println("5. Exit");

                System.out.print(
                        "Enter Choice  ");

                choice = sc.nextInt();

                switch (choice) {

                case 1:

                    try {

                        System.out.print("Enter Bus ID  ");
                        int id = sc.nextInt();

                        System.out.print("Enter Customer Name ");
                        String name = sc.next();

                        System.out.print("Enter Pickup ");
                        String pickup = sc.next();

                        System.out.print("Enter Destination ");
                        String destination = sc.next();

                        System.out.print( "Enter Fare ");
                        double fare =
                        sc.nextDouble();

                        ValidationException.validateBusId(id);

                        ValidationException.validateCustomerName(name);

                        ValidationException.validateFare(fare);

                        Project1_Console bus =new Project1_Console(id,name,pickup,destination,fare);

                        System.out.println("Booking Added Successfully");

                    } catch (CustomeException e) {

                    	System.err.println("Error:"+e.getMessage());
                    }

                    break;

                case 2:

                    System.out.print("Enter Bus ID ");
                    int bid = sc.nextInt();

                    System.out.print("Enter New Fare ");
                    double newFare = sc.nextDouble();

                    dao.updateFare( bid,newFare);

                    int i = dao.updateFare(bid, newFare);

                    if(i > 0)
                        System.out.println("Fare Updated");
                    else
                        System.out.println("Invalid Bus ID");

                    break;

                case 3:

                    System.out.print("Enter Bus ID ");
                    int delId =sc.nextInt();

                    dao.deleteBooking(delId);

                    int j = dao.deleteBooking(delId);

                    if(j > 0)
                        System.out.println("Booking Deleted");
                    else
                        System.out.println("Invalid Bus ID");

                    break;

                case 4:

                    ArrayList<Project1_Console>
                            list = dao.getAllBookings();

                    for (Project1_Console b: list) {

                        System.out.println(b);
                    }

                    break;

                case 5:

                    System.out.println( "Thank You");
                    sc.close();
                    break;

                default:

                    System.out.println("Invalid Choice");
                }

            } while (choice != 5);

            

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}