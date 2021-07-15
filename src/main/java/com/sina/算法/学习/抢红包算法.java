package com.sina.算法.学习;

import java.util.*;

/**
 * The xxx class for xxx.
 *
 * @author zhangbin
 * @version 1.0, 2021-02-04
 * @since excel-test 1.0.0
 */
public class 抢红包算法 {

    /**
     * 二倍均值法
     *
     * @param totalAmount
     * @param totalPeopleNum
     * @return
     */
    List<Integer> divideRedPackage(int totalAmount, int totalPeopleNum) {
        List<Integer> results = new ArrayList<>(totalPeopleNum);
        int restAmount = totalAmount;
        int restPeopleNum = totalPeopleNum;
        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
            restAmount -= amount;
            restPeopleNum--;
            results.add(amount);
        }
        results.add(restAmount);
        return results;
    }

    /**
     * 线性拆分法
     *
     * @param money
     * @param people
     * @return
     */
    List<Integer> lineCut(int money, int people) {

        if (people < 1 || money < people) return new ArrayList<>();

        List<Integer> team = new ArrayList<>(people - 1);
        List<Integer> result = new ArrayList<>(people);

        Random random = new Random();
        while (team.size() < people - 1) {
            int randomMoney = random.nextInt(money - 1) + 1;
            if (!team.contains(randomMoney)) {
                team.add(randomMoney);
            }
        }

        Collections.sort(team);

        System.out.print("分割点：");
        System.out.println(team);

        int left = 0;
        for (int i = 0; i < team.size(); i++) {
            result.add(team.get(i) - left);
            left = team.get(i);
        }
        result.add(money - left);

        System.out.print("每人金额：");
        System.out.println(result);

        // 验证分割后的数是否是输入的总金额
        Optional<Integer> r = result.stream().reduce(Integer::sum);
        System.out.print("总金额：");
        System.out.println(r.get());
        return result;
    }

    public static void main(String[] args) {
        抢红包算法 s = new 抢红包算法();
        List<Integer> list = s.divideRedPackage(100, 10);
    }
}
