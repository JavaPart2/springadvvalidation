package be.hvwebsites.validation.constraints;

import be.hvwebsites.validation.domain.Product;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class VerkoopPrijsAankoopPrijsValidator implements ConstraintValidator<VerkoopPrijsAankoopPrijs, Product> {
    @Override
    public void initialize(VerkoopPrijsAankoopPrijs constraintAnnotation) {

    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        if (product == null){
            return true;
        }
        if (product.getVerkoopPrijs() == null || product.getAankoopPrijs() == null){
            return false;
        }
        return product.getVerkoopPrijs().compareTo(product.getAankoopPrijs()) >= 0;
    }
}
