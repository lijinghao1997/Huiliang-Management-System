package util;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Map;

public class MapToEntityUtil {

    public static Object map2Entity(Map map,Class myClass)throws InvocationTargetException{
        try {
            Object object=myClass.newInstance();
            BeanUtils.populate(object,map);
            return object;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
