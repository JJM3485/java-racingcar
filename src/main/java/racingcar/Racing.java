package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final String[] carNames;
    private final int rounds;
    private final int[] positions;

    public Racing(String[] carNames, int rounds) {
        this.carNames = carNames;
        this.rounds = rounds;
        this.positions = new int[carNames.length];
    }

    // 레이스 시작
    public void startRace() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < rounds; i++) {
            playRound();
            printResult();
        }
        printWinners();
    }

    // 레이스 진행
    private void playRound() {
        final int MOVE_NUMBER = 4;
        final int START_NUMBER = 0;
        final int END_NUMBER = 9;

        for (int i = 0; i < carNames.length; i++) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (randomNumber >= MOVE_NUMBER) {
                positions[i]++;
            }
        }
    }

    // 결과 출력
    private void printResult() {
        for (int i = 0; i < carNames.length; i++) {
            System.out.println(carNames[i] + " : " + "-".repeat(positions[i]));
        }
        System.out.println();
    }

    // 최종 승리자
    private void printWinners() {
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