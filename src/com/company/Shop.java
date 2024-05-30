package com.company;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files

public class Shop {

    String product_name;

    int product_id;

    double price;

    public Shop(int product_id, String product_name, Double price){
        this.product_id = product_id;
        this.price = price;
        this.product_name = product_name;
    }

    private void create(){

        try{
            File file = new File("product.txt");

            if(file.createNewFile()){
                System.out.println("File created " + file.getName());
            }else {
                System.out.println("File already exists.");
            }

        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void add(){

        try{
            FileWriter f = new FileWriter("product.txt");

            if (checkExist()) {
                f.write(this.product_id + " " + this.product_name + " " + this.price);
                f.close();
                System.out.println("Successfully wrote to the file.");
            } else {
                create();
                f.write(this.product_id + " " + this.product_name + " " + this.price);
                f.close();
                System.out.println("Successfully wrote to the file.");
            }
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private boolean checkExist(){
        File f = new File("product.txt");
        if(f.exists() && !f.isDirectory()){
            return true;
        }
        return false;
    }

    public void update(){

    }
}
