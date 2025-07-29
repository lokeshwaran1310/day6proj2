package com.day6proj2.main;

import com.day6proj2.controller.BugController;
import com.day6proj2.repository.BugRepository;
import com.day6proj2.repository.BugRepositoryImpl;
import com.day6proj2.service.BugService;

public class Main {
    public static void main(String[] args) {
        BugRepository repo = new BugRepositoryImpl();
        BugService service = new BugService(repo);
        BugController controller = new BugController(service);
        controller.start();
    }
}
