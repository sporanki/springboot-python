package com.example.hello;

import java.io.InputStream;

import org.python.core.Py;
import org.python.core.PyObject;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.ClassPathResource;
 
 
public class HelloServiceFactory implements FactoryBean<HelloService> {
 
 @Override
 public HelloService getObject() throws Exception {
	
	//The python classpath is usually set by environment variable 
//or included in the java project classpath but it can also be set
// programmatically.  Here I hard code it just for the example.
	//This is not required if we use jython standalone JAR 
	PySystemState systemState = Py.getSystemState();
	//systemState.path.append(new PyString("C:\\jython2.7.1\\Lib"));		
 
	//Here is the actual code that interprets our python file. 
	PythonInterpreter interpreter = new PythonInterpreter();
	ClassPathResource calcPyFile = new ClassPathResource("python/HelloServicePython.py");
    InputStream inputStream = calcPyFile.getInputStream();
	interpreter.execfile(inputStream); 
	PyObject buildingObject = interpreter.get("HelloServicePython").__call__(); 
 
//Cast the created object to our Java interface 
	return (HelloService) buildingObject.__tojava__(HelloService.class);  
 }
 
 @Override
 public Class<?> getObjectType() {
 	return HelloService.class;
 }
 
}
