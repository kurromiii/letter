package com.mftplus.letter.controller.session;

import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SessionManager {
    //for seeing logged-in users

    //<username , session>
    private static final Map<String, HttpSession> sessionMap = new HashMap<>();

    public static void addHttpSession(HttpSession httpSession){
        sessionMap.put(String.valueOf(httpSession.getAttribute("username")),httpSession);
    }

    //users
    public static Set<String> getUsers(){
        return sessionMap.keySet();
    }

    //all sessions
    public static Set<HttpSession> getSession(){
        return (Set<HttpSession>) sessionMap.values();
    }
}
