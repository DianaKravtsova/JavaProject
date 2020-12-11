package spring.security.jwt.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import spring.security.jwt.bean.DoctorDocument;
import spring.security.jwt.bean.User;
@Component
public class DoctorDocumentValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        DoctorDocument DoctorDocument =(DoctorDocument)o;
        if(DoctorDocument.getId()<0){
            errors.rejectValue("id","negative value");
        }
    }
}
