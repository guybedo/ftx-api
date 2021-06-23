package com.akalea.ftx.domain;

public class FtxSubAccount {
    private String  nickname;
    private boolean deletable;
    private boolean editable;
    private boolean competition;

    public String getNickname() {
        return nickname;
    }

    public FtxSubAccount setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public boolean isDeletable() {
        return deletable;
    }

    public FtxSubAccount setDeletable(boolean deletable) {
        this.deletable = deletable;
        return this;
    }

    public boolean isEditable() {
        return editable;
    }

    public FtxSubAccount setEditable(boolean editable) {
        this.editable = editable;
        return this;
    }

    public boolean isCompetition() {
        return competition;
    }

    public FtxSubAccount setCompetition(boolean competition) {
        this.competition = competition;
        return this;
    }

}
