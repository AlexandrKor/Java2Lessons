package com.GeekBreins.HomeWork1.Obstacles;

import com.GeekBreins.HomeWork1.Participart.Participant;

public class Wall implements Obstacles {

    private final int height;

    public Wall(int height) {

        this.height = height;
    }

    @Override
    public boolean participantSelection(Participant participant) {
        if (participant.jumpHeight() >= this.height) {
            System.out.printf("Учасник %S успешно перепрыгнул через стену высотой %d%n",participant ,this.height);
            return true;
        } else {
            System.out.printf("Учасник %S не смог перепрыгнул через стену высотой %d%n",participant ,this.height);
            return false;
        }
    }
}
