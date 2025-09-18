package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carString = Console.readLine();
        String[] carNames = carString.split(",");

        final int START_NUMBER = 0;
        final int END_NUMBER = 9;
        final int MOVE_NUMBER = 4;
        final int MAX_NAME = 5;

        // 이름 예외 처리
        for (String carName : carNames) {
            if (carName.length() > MAX_NAME) {
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
            }
        }

        // 시도 횟수 입력
        System.out.println("시도할 횟수를 입력하세요.");
        String input = Console.readLine();
        int rounds = 0;

        // 숫자 확인 예외 처리
        try {
            rounds = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

        // 자동차 전진 거리 저장 배열
        int[] positions = new int[carNames.length];

        System.out.println("\n실행 결과");

        // 라운드 수만큼 반복
        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < carNames.length; j++) {
                int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
                if (randomNumber >= MOVE_NUMBER) {
                    positions[j]++;
                }
            }
            // 각 라운드 결과 출력
            for (int j = 0; j < carNames.length; j++) {
                System.out.println(carNames[j] + " : " + "-".repeat(positions[j]));
            }
            System.out.println();
        }

        // 최종 우승자
        int maxPosition = 0;
        for (int nowPosition : positions) {
            if (nowPosition > maxPosition) {
                maxPosition = nowPosition;
            }
        }

        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            if (positions[i] == maxPosition) {
                winners.add(carNames[i]);
            }
        }

        String winnerString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerString);
    }
}