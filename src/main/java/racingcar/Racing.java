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

    // 한 라운드 실행
    private void playRound() {
        for (int i = 0; i < carNames.length; i++) {
            moveCar(i);
        }
    }

    // 이동 여부 확인
    private void moveCar(int carIndex) {
        if (shouldMove()) {
            positions[carIndex]++;
        }
    }

    // 이동 여부 결정
    private boolean shouldMove() {
        final int MOVE_NUMBER = 4;
        final int START_NUMBER = 0;
        final int END_NUMBER = 9;
        int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
        return randomNumber >= MOVE_NUMBER;
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
            maxPosition = getMax(maxPosition, nowPosition);
        }

        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            addWinner(winners, carNames[i], positions[i], maxPosition);
        }

        String winnerString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerString);
    }

    // 최대값 비교
    private int getMax(int currentMax, int nowPosition) {
        return nowPosition > currentMax ? nowPosition : currentMax;
    }

    //우승자 추가
    private void addWinner(List<String> winners, String carName, int position, int maxPosition) {
        if (position == maxPosition) {
            winners.add(carName);
        }
    }
}