package org.dao.doraemon.example.sensitive;

import lombok.Data;
import org.dao.doraemon.sensitive.annotation.MultipleSensitive;
import org.dao.doraemon.sensitive.annotation.SensitiveMapping;
import org.dao.doraemon.sensitive.handler.PasswordHandler;
import org.dao.doraemon.sensitive.handler.PhoneNumberHandler;

/**
 * @author sucf
 * @since 1.0
 */
@Data
@MultipleSensitive({
        @SensitiveMapping(fieldName = "password", handler = PasswordHandler.class),
        @SensitiveMapping(fieldName = "phone", handler = PhoneNumberHandler.class)
})
public class ClassMultipleVO {
    private AppleVO appleVO;
}
