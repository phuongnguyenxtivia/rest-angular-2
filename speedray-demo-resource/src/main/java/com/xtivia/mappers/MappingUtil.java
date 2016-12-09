package com.xtivia.mappers;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Created by ddavis on 12/6/16.
 *
 * The OSGI Classloader requires this to work with the generated files.
 *
 */
public class MappingUtil {

    public static <T> T getMapper(Class<T> clazz) {
        if (clazz != null) {
            try {
                T mapper = (T) MappingUtil.class
                        .getClassLoader()
                        .loadClass(clazz.getName() + IMPLEMENTATION_SUFFIX)
                        .newInstance();
                return mapper;
            } catch(ClassNotFoundException|InstantiationException|IllegalAccessException e) {
                log.error("Failed to instantiate implementation object", e);
            }
        }
        return null;
    }

    private static final String IMPLEMENTATION_SUFFIX = "Impl";
    private static Log log = LogFactoryUtil.getLog(MappingUtil.class);
}
