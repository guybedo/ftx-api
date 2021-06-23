package com.akalea.ftx.domain;

public class SubAccount {
    private String  nickname;
    private boolean deletable;
    private boolean editable;
    private boolean competition;

    public String getNickname() {
        return nickname;
    }

    public SubAccount setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public boolean isDeletable() {
        return deletable;
    }

    public SubAccount setDeletable(boolean deletable) {
        this.deletable = deletable;
        return this;
    }

    public boolean isEditable() {
        return editable;
    }

    public SubAccount setEditable(boolean editable) {
        this.editable = editable;
        return this;
    }

    public boolean isCompetition() {
        return competition;
    }

    public SubAccount setCompetition(boolean competition) {
        this.competition = competition;
        return this;
    }

}
