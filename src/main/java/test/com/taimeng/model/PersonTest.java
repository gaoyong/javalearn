package test.com.taimeng.model; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
* Person Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 3, 2016</pre> 
* @version 1.0 
*/ 
public class PersonTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getId() 
* 
*/ 
@Test
public void testGetId() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setId(int id) 
* 
*/ 
@Test
public void testSetId() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getName() 
* 
*/ 
@Test
public void testGetName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setName(String name) 
* 
*/ 
@Test
public void testSetName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: toString() 
* 
*/ 
@Test
public void testToString() throws Exception { 
//TODO: Test goes here... 
}

@Test
public void testParseDateStr(){
    String dateStr = "2000-10-1 00:00:00";
    Date date = null;
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
        date = df.parse(dateStr);
        System.out.println("输出日期:" + date);
    } catch (ParseException e) {
        e.printStackTrace();
    }
}


} 
