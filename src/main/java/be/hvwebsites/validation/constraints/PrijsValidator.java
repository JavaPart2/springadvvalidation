package be.hvwebsites.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class PrijsValidator implements ConstraintValidator<Prijs, BigDecimal> {
    @Override
    public void initialize(Prijs constraintAnnotation) {

    }

    @Override
    public boolean isValid(BigDecimal value,ConstraintValidatorContext context){
        if (value == null) {
            return true;
        }
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }
        var string = value.toString();
        var positieVanDePunt = string.indexOf(".");
        if (positieVanDePunt == -1) {
            return string.length() <= 7;
        }
        if (positieVanDePunt > 7) {
            return false;
        }
        return string.length() - positieVanDePunt <= 3;
    }
}
