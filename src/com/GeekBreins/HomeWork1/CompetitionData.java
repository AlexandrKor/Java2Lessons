package com.GeekBreins.HomeWork1;

import com.GeekBreins.HomeWork1.Obstacles.Obstacles;
import com.GeekBreins.HomeWork1.Participart.Participant;

import java.util.ArrayList;


public class CompetitionData {

    private Obstacles[] obstacles;
    private Participant[] participants;
    private final String competitionTitle;

    private final java.util.List<Participant> lastWinners = new ArrayList<>();

    public CompetitionData(String competitionTitle) {
        this.competitionTitle = competitionTitle;
    }

    public void setObstacles(Obstacles ...obstacles) {
        this.obstacles = obstacles;
    }

    public void setParticipants(Participant ...participants) {
        this.participants = participants;
    }

    public java.util.List<Participant> getLastWinners() {
        return lastWinners;
    }

    public void startCompetition() {
        System.out.printf("Начало соревнований %s%n",this.competitionTitle);
        this.lastWinners.clear();
        for (Participant participant : this.participants) {
            boolean winner = this.passAllObstacle(participant);
            if (!winner) {
                System.out.printf("Участник %s покинул соревнование %n", participant);
            } else {
                this.lastWinners.add(participant);
            }
        }
    }

    private boolean passAllObstacle(Participant participant) {
        for (Obstacles obstacle : this.obstacles) {
            if (!obstacle.participantSelection(participant)) {
                return false;
            }
        }
        return true;
    }

}
