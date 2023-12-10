package chapter2;

import java.util.function.BinaryOperator;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if(s == null || s.isEmpty()) return PasswordStrength.INVALID;

        boolean lengthEnough = s.length() >= 8;
        boolean containsNumer = meetsContainingNumberCriteria(s);
        boolean containsUpper = meetsContainingUppercaseCriteria(s);

        if(lengthEnough && !containsNumer && !containsUpper) return PasswordStrength.WEAK;
        if(!lengthEnough && containsNumer && !containsUpper) return PasswordStrength.WEAK;

        if (!lengthEnough) return PasswordStrength.NORMAL;
        if (!containsNumer) return PasswordStrength.NORMAL;
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
