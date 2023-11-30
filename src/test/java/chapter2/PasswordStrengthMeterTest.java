package chapter2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordStrengthMeterTest {
    /*
    * 1. 길이가 8글자 이상
    * 2. 0부터 9사이의 숫자를 포함
    * 3. 대문자 포함
    *
    * -> 3개의 규칙 전부 -> 강함
    * -> 2개 -> 보통
    * -> 1개이하 -> 약함
    *
    * */
    @DisplayName("암호가 모든 조건을 충족하면 강도는 강함이다")
    @Test
    void meetsAllCriteria_Then_Strong() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("sumin1AB");
        assertEquals(PasswordStrength.STRONG, result);
        PasswordStrength result2 = meter.meter("abcdEf1!");
        assertEquals(PasswordStrength.STRONG, result2);
    }

    @DisplayName("다른 조건은 만족하지만 길이만 8자리 미만으로 해보자")
    @Test
    void meetsOtherCriteria_expect_for_Length_Then_Normal() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("abcdE1!");
        assertEquals(PasswordStrength.NORMAL, result);
    }

    @DisplayName("다른 조건은 만족하지만 숫자를 포함하지 않는다")
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("abcABccc");
        assertEquals(PasswordStrength.NORMAL, result);
    }
}
