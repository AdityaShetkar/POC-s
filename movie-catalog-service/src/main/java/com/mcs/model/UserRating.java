package com.mcs.model;

import java.util.List;

public class UserRating {

    private List<Rating> usertaings;

    public UserRating() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserRating(List<Rating> usertaings) {
        super();
        this.usertaings = usertaings;
    }

    public List<Rating> getUsertaings() {
        return usertaings;
    }

    public void setUsertaings(List<Rating> usertaings) {
        this.usertaings = usertaings;
    }

    @Override
    public String toString() {
        return "UserRating [usertaings=" + usertaings + "]";
    }


}