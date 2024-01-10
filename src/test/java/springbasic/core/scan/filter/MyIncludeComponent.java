package springbasic.core.scan.filter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Indexed;

/**
 * packageName    : springbasic.core.filter
 * fileName       : MyIncludeComponent
 * author         : asdfz
 * date           : 2024-01-03
 * description    :
 * ===============================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------
 * 2024-01-03        asdfz       최초 생성
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {

}
