package com.infoshareacademy.finances.jee;

import javax.ejb.Stateless;

@Stateless
public class WelcomeFinances {

    public String welcome() {
        return "Tri Finences ver. -1 ;)";
    }

}
