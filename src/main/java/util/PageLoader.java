package util;

import annotation.PageUrl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.AbstractPage;

public class PageLoader {

    private static final Logger logger = LoggerFactory.getLogger(PageLoader.class);

    public static String getPageUrl(String pageName) {
       return getDefaultUrl(getPageObjectClass(pageName));
    }

    private static Class<AbstractPage> getPageObjectClass(String pageObjectName) {
        try {
            return (Class<AbstractPage>) Class.forName("ui.pages." +
                    pageObjectName.replaceAll("\\s", StringUtils.EMPTY));
        } catch (ClassNotFoundException e) {
            logger.error("Couldn't find a class named " + e);
            throw new IllegalStateException("Couldn't find a class named " + e);
        }
    }

    private static String getDefaultUrl(Class<? extends AbstractPage> pageObject) {
        return pageObject.getAnnotation(PageUrl.class).url();
    }

}
