package com.addressbook.dto;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.addressbook.dao.AddressBookSerializer;
import com.addressbook.dao.CustAnnotation;
import com.addressbook.dao.JDBCSerializer;
import com.addressbook.dao.JsonSerializer;

/**
 * PURPOSE: This Facrory class is written to return the object of either json or
 * jdbc
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 22/06/18
 */
public class AddressbookParseObject {

	  public static AddressBookSerializer objectManager(String name) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
	        List<Class> l=AddressbookParseObject.getClasses("com.addressbook.dao.serializer");
	       
	        for(int i=0;i<l.size();i++) {
	            System.out.println(l.get(i));
	            Class s=l.get(i);
	            System.out.println(s.newInstance());
	            Annotation an[]=s.getAnnotations();
	            for(Annotation aaa : an) {
	                if(aaa instanceof CustAnnotation) {
	                	CustAnnotation me=    (CustAnnotation)aaa;
	                if(me.value().equals(name)) {
	                    return (AddressBookSerializer)s.newInstance();
	                }
	            }
	        }
	           
	        }
	        return null;
	    }
	   
	   
	     private static List<Class> getClasses(String packageName)
	                throws ClassNotFoundException, IOException {
	            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	            assert classLoader != null;
	            String path = packageName.replace('.', '/');
	            Enumeration<URL> resources = classLoader.getResources(path);
	            List<File> dirs = new ArrayList<>();
	            while (resources.hasMoreElements()) {
	                URL resource = resources.nextElement();
	                dirs.add(new File(resource.getFile()));
	            }
	            List classes = new ArrayList();
	            for (File directory : dirs) {
	                classes.addAll(findClasses(directory, packageName));
	            }
	           return classes;
	        }
	        /**
	         * Recursive method used to find all classes in a given directory and subdirs.
	         *
	         * @param directory   The base directory
	         * @param packageName The package name for classes found inside the base directory
	         * @return The classes
	         * @throws ClassNotFoundException
	         */
	        private static List findClasses(File directory, String packageName) throws ClassNotFoundException {
	            List classes = new ArrayList();
	            if (!directory.exists()) {
	                return classes;
	            }
	            File[] files = directory.listFiles();
	            for (File file : files) {
	                if (file.isDirectory()) {
	                    assert !file.getName().contains(".");
	                    classes.addAll(findClasses(file, packageName + "." + file.getName()));
	                } else if (file.getName().endsWith(".class")) {
	                    classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
	                }
	            }
	            return classes;
	        }
}
