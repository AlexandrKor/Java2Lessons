package com.GeekBreins.HomeWork1;

/*1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
    классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).

  2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
    должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
    печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).

  3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти
    этот набор препятствий.

  4. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения
    на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он
    препятствий не идет */

import com.GeekBreins.HomeWork1.Obstacles.Obstacles;
import com.GeekBreins.HomeWork1.Obstacles.Treadmill;
import com.GeekBreins.HomeWork1.Obstacles.Wall;
import com.GeekBreins.HomeWork1.Participart.Cat;
import com.GeekBreins.HomeWork1.Participart.Human;
import com.GeekBreins.HomeWork1.Participart.Participant;
import com.GeekBreins.HomeWork1.Participart.Robot;

import java.util.List;
import java.util.Random;

public class WorkoutApp {
    public static void main(String[] args) {

        CompetitionData competition = competitionPreparation();
        competition.startCompetition();

        List<Participant> lastWinners = competition.getLastWinners();
        if (!lastWinners.isEmpty()){
            System.out.println("В соревнованиях побеждают: ");
            for (Participant lastWinner : lastWinners) {
                System.out.println(lastWinner);
            }
        }else {
            System.out.println("Участники не смогли преодолеть дистанцию.");
        }

}
private static CompetitionData competitionPreparation(){
        Participant robot = new Robot("T-1000", 12, 1000);
        Participant cat = new Cat("Барсик", 2, 600);
        Participant human = new Human ("Люк", 5, 400);

        Random random = new Random();

        Obstacles well = new Wall(random.nextInt(20));
        Obstacles treadmill = new Treadmill(random.nextInt(1100));

        CompetitionData competition = new CompetitionData("Битва существ");
        competition.setObstacles(well, treadmill);
        competition.setParticipants(robot, cat, human);
        return competition;
    }
}
