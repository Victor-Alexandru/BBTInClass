package BBTInClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.StudentXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.NotaXMLService;
import Service.XMLFileService.StudentXMLService;
import Service.XMLFileService.TemaLabXMLService;
import UI.ui;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    private StudentXMLRepo rep;

    @Test
    public void addStudentsTestOne() throws ValidatorException {

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        String[] params={"1","Valentin","931","valentin@a.com","Maria Guran"};
        stsrv.add(params);
        assertEquals(stsrv.getSize(),1);
    }
    @Test
    public void addStudentsTestTwo() throws ValidatorException {
        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        String[] params={"1","Valentin","931","valentin@a.com","Maria Guran"};
        String[] paramsTwo={"2","Valentin","931","valentin@a.com","Maria Guran"};
        //
        stsrv.add(params);
        stsrv.add(params);
        stsrv.add(params);
        stsrv.add(params);
        assertEquals(stsrv.getSize(),1);
        stsrv.add(paramsTwo);
        assertEquals(stsrv.getSize(),2);
    }

}
