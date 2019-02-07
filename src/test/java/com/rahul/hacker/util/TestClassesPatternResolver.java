package com.rahul.hacker.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by 212578960 on 9/1/2017.
 */
public class TestClassesPatternResolver {

    private static final String CLASSPATH_CONSTANT = "classpath*:";
    private final List<Class<?>> classes = new ArrayList<Class<?>>();
    private final String basePackage;
    private final ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

    public TestClassesPatternResolver(String basePackage, List<String> includes, List<String> excludes)
            throws IOException, ClassNotFoundException {

        this.basePackage = basePackage;

        for (String pattern : includes) {
            classes.addAll(resolveClassesFromResourcePatterns(pattern));
        }

        for (String pattern : excludes) {
            classes.removeAll(resolveClassesFromResourcePatterns(pattern));
        }

    }

    public List<Class<?>> getClasses() {
        return classes;
    }

    private Collection<Class<?>> resolveClassesFromResourcePatterns(String pattern)
            throws IOException, ClassNotFoundException {
        String pathUrlPattern = CLASSPATH_CONSTANT + pattern;
        Collection<Class<?>> classes = new ArrayList<Class<?>>();

        if (ResourcePatternUtils.isUrl(pathUrlPattern)) {

            Resource[] resources = resourcePatternResolver.getResources(pathUrlPattern);

            for (Resource resource : resources) {
                URL url = resource.getURL();
                String className = resolveClassFromPath(url.toString());

                if (className != null && className.length() > 0) {
                    Class<?> klass = Class.forName(className);
                    for (Method method : klass.getDeclaredMethods()) {
                        // If at least one method is annotated with the JUnit
                        // @Test annotation, we include the class as a Test Class.
                        if (method.getAnnotation(org.junit.Test.class) != null) {
                            classes.add(klass);
                            break;
                        }
                    }
                }
            }
        }

        return classes;
    }

    private String resolveClassFromPath(String url) {
        String classUrl = ClassUtils.convertResourcePathToClassName(url);
        int begin = classUrl.indexOf(this.basePackage);
        if (begin < 0) return null;
        return classUrl.substring(begin, classUrl.lastIndexOf(".class"));
    }
}