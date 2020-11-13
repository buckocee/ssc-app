//package com.silvershield.ssc.validator;
//
//import com.silvershield.ssc.auth.UserDto;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class PasswordMatchesValidator
//        implements ConstraintValidator<PasswordMatches, Object> {
//
//    @Override
//    public boolean isValid(Object obj, ConstraintValidatorContext context){
//        UserDto user = (UserDto) obj;
//        return user.getPassword().equals(user.getConfirmPassword());
//    }
//}
