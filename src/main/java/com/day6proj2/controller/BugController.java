package com.day6proj2.controller;
import java.util.List;
import java.util.Scanner;

import com.day6proj2.entity.Bug;
import com.day6proj2.service.BugService;

public class BugController {
     private BugService bs;

    public BugController(BugService bs) {
        this.bs = bs;
    }
    public void start(){
       System.out.println("Welcome");
       Scanner s=new Scanner(System.in);
       while(true){
        System.out.println("1.Insert Bug");
        System.out.println("2.Bug Details");
        System.out.println("3.Update Bug Status By ID");
        System.out.println("4. Delete Bug By ID");
        System.out.println("5.Exit");
        System.out.println("Enter Choice");
        int choice=s.nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter title");
                String tit=s.next();
                System.out.println("Enter Desc");
                String desc=s.next();
                System.out.println("Enter Status");
                String stat=s.next();
                Bug b=new Bug(tit,desc,stat);
                ins(b);      
                break;
            case 2:
                System.out.println("Printing the Bugs");
                List<Bug> l=bs.view();
                for(Bug ent:l){
                    System.out.println("id: "+ent.getId());
                    System.out.println("Title: "+ent.getTitle());
                    System.out.println("Description: "+ent.getDescription());
                    System.out.println("Status: "+ent.getStatus());
                     System.out.println("-----------------------------------------------------------------");
                }
                break;
            case 3:
                System.out.println("Enter Status");
                String st=s.next();
                System.out.println("Enter id");
                int id=s.nextInt();
                Bug bug=new Bug();
                bug.setStatus(st);
                bug.setId(id);
                bs.update(bug);
                break;
            case 4:
                System.out.println("Enter ID");
                int bid=s.nextInt();
                Bug bg=new Bug();
                bg.setId(bid);
                bs.delete(bg);
                break;
            case 5:
                System.out.println("Exit");
                return;
            default:
                System.out.println("Enter Correct Choice");
                break;
        }
       }
    }
    
    public void ins(Bug bgs){
        if (bgs.getTitle().isEmpty() || bgs.getDescription().isEmpty() || bgs.getStatus().isEmpty()) {
                System.out.println("Title, Description, and Status cannot be empty");
                return; 
            }    
            bs.insert(bgs);

    }
    public List<Bug> display(){
        List<Bug> l=bs.view();
            return bs.view();  
    }
    public void upd(Bug b){
        if(!b.getStatus().isEmpty()){
        bs.update(b);
        }
        else{
            System.out.println("Status cannot be empty");
        }

    }
    public void del(Bug b){
            bs.delete(b);   
    }
}
