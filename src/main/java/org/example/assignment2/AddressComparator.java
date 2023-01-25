package org.example.assignment2;

import java.util.Comparator;

public class AddressComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.address.compareTo(o2.address);
    }

}

