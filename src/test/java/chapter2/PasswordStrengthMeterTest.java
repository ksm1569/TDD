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
    * -> 3개의 규칙 전부 -> 강함 (STRONG)
    * -> 2개 -> 보통 (NORMAL)
    * -> 1개이하 -> 약함 (WEAK)
    *
    * */
    PasswordStrengthMeter meter = new PasswordStrengthMeter();

    @DisplayName("암호가 모든 조건을 충족하면 강도는 강함이다")
    @Test
    void meetsAllCriteria_Then_Strong() {

        extracted("sumin1AB", PasswordStrength.STRONG);
        extracted("abcdEf1!", PasswordStrength.STRONG);
    }

    private void extracted(String password, PasswordStrength expect) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expect, result);
    }

    @DisplayName("다른 조건은 만족하지만 길이만 8자리 미만으로 해보자")
    @Test
    void meetsOtherCriteria_expect_for_Length_Then_Normal() {
        extracted("abcdE1!", PasswordStrength.NORMAL);
    }

    @DisplayName("다른 조건은 만족하지만 숫자를 포함하지 않는다")
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        extracted("abcABccc", PasswordStrength.NORMAL);
    }

    @DisplayName("Null이 입력되면 Invalid를 리턴해보자")
    @Test
    void nullInput_Then_Invalid() {
        extracted(null, PasswordStrength.INVALID);
    }

    @DisplayName("빈값이 입력되면 Invalid를 리턴해보자")
    @Test
    void emptyInput_Then_Invalid() {
        extracted("", PasswordStrength.INVALID);
    }

    @DisplayName("다른 조건은 만족하지만 대문자를 포함하지 않는다")
    @Test
    void meetsOtherCriteria_expect_for_Uppercase_Then_Normal() {
        extracted("abc12345", PasswordStrength.NORMAL);
    }

    @DisplayName("8글자이상 조건만 만족시켜보자")
    @Test
    void meetsOnlyLengthCriteria_Then_Weak() {
        extracted("abcdedfg", PasswordStrength.WEAK);
    }
}
