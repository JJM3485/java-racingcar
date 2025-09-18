package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class Car {
    private final int MAX_NAME = 5;

    public String[] getCarNames() {
        // 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carString = Console.readLine();
        String[] carNames = carString.split(",");

        // 이름 예외 처리
        for (String carName : carNames) {
            if (carName.length() > MAX_NAME) {
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
            }
        }
        return carNames;
    }

    public int getRounds() {
        // 시도 횟수 입력
        System.out.println("시도할 횟수를 입력하세요.");
        String input = Console.readLine();

        // 시도 횟수 예외 처리
        try {
            int rounds = Integer.parseInt(input);
            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }
}