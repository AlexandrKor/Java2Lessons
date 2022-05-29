package HomeWork1.Obstacles;

import HomeWork1.Participart.Participant;

public class Treadmill implements Obstacles {

    private final int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean participantSelection(Participant participant) {
        if (participant.runDistance() >= this.distance) {
            System.out.printf("Учасник %S успешно пробежал беговую дорожку длинной %d%n",participant ,this.distance);
            return true;
        } else {
            System.out.printf("Учасник %S не смог пробежать беговую дорожку длинной %d%n",participant ,this.distance);
            return false;
        }
    }
}
