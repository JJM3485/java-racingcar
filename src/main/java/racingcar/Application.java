package racingcar;

public class Application {
    public static void main(String[] args) {

        Car car = new Car();
        String[] carNames = car.getCarNames();
        int rounds = car.getRounds();

        Racing racing = new Racing(carNames, rounds);
        racing.startRace();

    }
}