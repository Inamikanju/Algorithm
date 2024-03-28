package LeetCode.Easy._2660保龄球游戏的获胜者;

/**
 * ClassName: Solution
 * Description: 保龄球游戏的获胜者
 * Author Inamikanju
 * Create 2023/12/27 15:10
 * Version 1.0
 */
public class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int score1 = score(player1);
        int score2 = score(player2);
        if (score1 > score2) {
            return 1;
        } else if (score1 < score2) {
            return 2;
        } else {
            return 0;
        }
    }

    private int score(int[] player) {
        int score = 0;
        int is10 = 0;//表示前2轮是否有10
        for (int i = 0; i < player.length; i++) {
            if (is10 > 0) {
                score += 2 * player[i];
                is10--;
            } else {
                score += player[i];
            }
            if (player[i] == 10) {
                is10 = 2;
            }
        }
        return score;
    }
}
