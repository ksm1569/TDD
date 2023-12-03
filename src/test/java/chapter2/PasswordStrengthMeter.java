package chapter2;

import java.util.function.BinaryOperator;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if(s == null || s.isEmpty()) return PasswordStrength.INVALID;

        if(s.length() < 8) {
            return PasswordStrength.NORMAL;
        }
        boolean containsNumer = meetsContainingNumberCriteria(s);
        if (!containsNumer) return PasswordStrength.NORMAL;

        boolean containsUpper = meetsContainingUppercaseCriteria(s);
        if (!containsUpper) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
    }

    //숫자 포함체크
    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    // 대문자 포함체크
    private boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if(ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }
}
